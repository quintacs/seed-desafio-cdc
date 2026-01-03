package livraria.api.modelo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import livraria.api.record.DadosAutor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table( name = "autores")
@Entity( name = "Autor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String nome;
	private String email; 
	private String descricao;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataCadastro;
	
	public Autor(DadosAutor dadosAutor) {
		
		this.nome = dadosAutor.nome();
		this.email = dadosAutor.email();
		this.descricao = dadosAutor.descricao();
		this.dataCadastro = dadosAutor.dataCadastro();
	}
	
	public Autor( String nome, String email, String descricao, LocalDateTime dataCadastro){
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
	}
}
