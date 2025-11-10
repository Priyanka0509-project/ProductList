package Product.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)  // fetch have two options "EAGER" mtlb ani jode relation ma jetla bhi data hoy ane join kre mtlb table ma join kre jena lidhe  performance decrease thay and "LAZY" mtlb jena jode relation ma hoy data a badha ne join kre tables ma badha data ne join kre if need hoy badha data ni mtlb relation ma j data hoy jem k ama category and product chhe am to j use krvu
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
