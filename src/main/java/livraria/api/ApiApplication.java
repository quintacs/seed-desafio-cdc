package livraria.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiApplication {

	//http://localhost:8080/swagger-ui/index.html#/compra-controller/cadastrar_3
	//http://localhost:8080/livraria-api
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
