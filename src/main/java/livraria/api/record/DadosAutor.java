package livraria.api.record;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosAutor(
		@NotBlank
		String nome, 
		@NotBlank
		@Email
		String email, 
		@NotBlank
		@Size(max = 400)
		String descricao, 
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss") 
		LocalDateTime dataCadastro) {

}
