package livraria.api.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import livraria.api.form.LivroForm;

@Table( name = "livro")
@Entity( name = "Livro")
public class Livro {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int paginas;
	private String isbn;
	private LocalDateTime dataPublicacao;
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name = "autores_id")
	private Autor autor;
	
	public Livro() {}
	
	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, int paginas, String isbn,
			LocalDateTime dataPublicacao, Categoria categoria, Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	public Livro (LivroForm livroForm) {
		
		this.categoria = new Categoria();
		this.categoria.setId(livroForm.getIdCategoria());
		this.autor = new Autor();
		this.autor.setId(livroForm.getIdAutor());
		
		this.titulo = livroForm.getTitulo();
		this.resumo = livroForm.getResumo();
		this.sumario = livroForm.getResumo();
		this.preco = livroForm.getPreco();
		this.paginas = livroForm.getPaginas();
		this.isbn = livroForm.getIsbn();
		this.dataPublicacao = livroForm.getDataPublicacao();;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDateTime dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
}
