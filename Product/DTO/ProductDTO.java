package Product.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
@Schema(
        name = "Product",
        description = "It holds products information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long categoryId;
}
