package livraria.api.record;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record DadosAutor(String nome, 
		String email, 
		String descricao, 
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss") 
		LocalDateTime dataCadastro) {

}
