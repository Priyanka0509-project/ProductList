package Product.Service;

import Product.DTO.ProductDTO;
import Product.Entity.Category;
import Product.Entity.Product;
import Product.Exception.CategoryNotFoundException;
import Product.Mapper.ProductMapper;
import Product.Repository.CategoryRepository;
import Product.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    //create
    public ProductDTO createProduct (ProductDTO productDTO){

       Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category : " + productDTO.getCategoryId() + " not found"));

       //DTO -> Entity
       Product product =  ProductMapper.toProductEntity(productDTO, category);
       product = productRepository.save(product);
       //Entity -> DTO
       return ProductMapper.toProductDTO(product);
    }

    //get all Product
    public List<ProductDTO> getAllProducts (){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    //get Product bt id
    public ProductDTO getProductById (Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product was not found!"));
       return ProductMapper.toProductDTO(product);
    }

    //update the product
    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
       Product product =  productRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Product not found!"));
       Category category = categoryRepository.findById(productDTO.getCategoryId())
               .orElseThrow(() -> new RuntimeException("Category not found!"));

       product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    //delete product
    public String deleteProduct (Long id){
        productRepository.deleteById(id);
        return "Product " + id + " was deleted";
    }
}
