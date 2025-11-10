package Product.Controller;

import Product.DTO.ProductDTO;
import Product.Service.ProductService;
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
        name = "Products REST API for CRUD Opertaion",
        description = "CREATE, READ, UPDATE, DELETE operation perform for Products"
)
@RestController // using this the return data will direct send to the HTTP server in JSON or XML formate
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    //get all pro
    @Operation(
            summary = "Fetch All Products",
            description = "REST API for fetch all products"
    )
    @GetMapping
    public List<ProductDTO> getAllProducts (){
        return productService.getAllProducts();
    }

    // get pro by id
    @Operation(
            summary = "Fetch product by product Id",
            description = "REST API for fetch product by product Id"
    )
    @GetMapping("/{id}")
    public ProductDTO getProductById (@PathVariable Long id){
        return productService.getProductById(id);
    }

    // create pro
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @ApiResponse(
            responseCode = "201",
            description = "CREATE"
    )
    @Operation(
            summary = "Create product",
            description = "REST API for Create product"
    )
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct (@RequestBody ProductDTO productDTO){
        ProductDTO productCreated = productService.createProduct(productDTO);
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }

    // update pro
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @Operation(
            summary = "Update product by product Id",
            description = "REST API for Update product by product Id"
    )
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO){
        return productService.updateProduct(id,productDTO);
    }
    // delete pro
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @Operation(
            summary = "Delete product by product Id",
            description = "REST API for Delete product by product Id"
    )
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
