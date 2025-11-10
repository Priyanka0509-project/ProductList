package Product.Controller;

import Product.DTO.CategoryDTO;

import Product.Service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Categories REST API for CRUD operations",
        description = "CREATE, READ, UPDATE, DELETE operations perform for categories"
        )
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    //get all cat
    @Operation(
            summary = "Fetch All Categories",
            description = "REST API for fetch all categories"
    )

    @GetMapping
    public List<CategoryDTO> getAllCategories(){

        return categoryService.getAllCategories();
    }

    //create cat

    @ApiResponse(
            responseCode = "201",
            description = "CREATE"
    )
    @Operation(
            summary = "Create All Categories",
            description = "REST API for Create all categories"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
//        try{
           CategoryDTO savedCategory =  categoryService.createCategory(categoryDTO);
           return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//        }catch(CategoryAlreadyExistsException ex){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
//        }
//        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
    //get cat by id
     @Operation(
            summary = "Fetch Category by category Id",
            description = "REST API for fetch category by category id"
    )

     @GetMapping("/{id}")
    public CategoryDTO getcategoryById (@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    //delete  cat

    @Operation(
            summary = "Delete Category by category Id",
            description = "REST API for delete category by category id"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){

        return  categoryService.deleteCategory(id);
    }

}
