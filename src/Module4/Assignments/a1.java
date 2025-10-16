import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class a1 {
    public static void main(String[] args) {
        SpringApplication.run(a1.class, args);
    }
}

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello";
    }
}

