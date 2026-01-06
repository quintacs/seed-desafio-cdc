package livraria.api.form;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import livraria.api.bean.validation.ExistId;
import livraria.api.bean.validation.UniqueValue;
import livraria.api.modelo.Autor;
import livraria.api.modelo.Categoria;
import livraria.api.modelo.Livro;

public class LivroForm {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo" , message = "O titulo informado já existe no banco de dados")
	private String titulo;
	@NotBlank
	@Length(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(value = 20 , message = "O valor mínimo é de vinte reaiz")
	private BigDecimal preco;
	@Min(value = 100, message = "O numero de páginas não pode ser menor que 100")
	private int paginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn" , message = "O isbn informado já existe no banco de dados")
	private String isbn;
	@Future(message = "A data deve ser futura ")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataPublicacao;
	@Nonnull
	@ExistId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;
	@Nonnull
	@ExistId(domainClass = Autor.class, fieldName = "id")
	private Long idAutor;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getSumario() {
		return sumario;
	}
	public void setSumario(String sumario) {
		this.sumario = sumario;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public  LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(LocalDateTime dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Long getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}
}
