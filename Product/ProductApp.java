package Product;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;




@OpenAPIDefinition(
        info = @Info(
                    title = "Product Service REST API Documentation",
                    description = "Product service REST API",
                    version = "v1",
                    contact = @Contact(
                            name = "Priyanka Gajera",
                            email = "priyankagajera@gamil.com"
                    )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Product Service API",
                url = "example.com"
        )
)

@SpringBootApplication
@Slf4j
public class ProductApp {

//    private static final Logger log = LoggerFactory.getLogger(ProductApp.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProductApp.class, args);

        String str = "test";
        log.info("This is info message {}", str);
//        log.error("This is error message");
//        log.warn("This is warn message");
//        log.debug("This is debug message");
//        log.trace("This is Trace Message");

    }
}
