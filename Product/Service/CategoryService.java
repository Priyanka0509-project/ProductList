package Product.Service;

import Product.DTO.CategoryDTO;
import Product.Entity.Category;
import Product.Exception.CategoryAlreadyExistsException;
import Product.Mapper.CategoryMapper;
import Product.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    //create cat
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
        if(optionalCategory.isPresent()){
            throw  new CategoryAlreadyExistsException("category " + categoryDTO.getName() + " already exists");
        }
       Category category =  CategoryMapper.toCategoryEntity(categoryDTO);
       category =  categoryRepository.save(category);
       return CategoryMapper.toCategoryDTO(category);
    }

    //getAllCategories
    public List<CategoryDTO> getAllCategories(){
       return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    //getCatById
    public CategoryDTO getCategoryById (Long id){
       Category category =  categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
       return CategoryMapper.toCategoryDTO(category);
    }

    //delete category
    public String deleteCategory (Long id){
        categoryRepository.deleteById(id);
        return"Your category " + id + " has been deleted!";
    }
}
