package livraria.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import livraria.api.modelo.Livro;
import livraria.api.util.DateUtil;

public class DadosLivroDto {

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int paginas;
	private String isbn;
	private LocalDateTime dataPublicacao;
	private String dataPublicacaoFormatada;
	private Long idCategoria;
	private Long idAutor;
	 String nmCategoria;
	 String nmAutor;
	
	public DadosLivroDto() {}
	
	public DadosLivroDto(Livro livro) {
		parse(livro);
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
	public String getDataPublicacaoFormatada() {
		return dataPublicacaoFormatada;
	}
	public void setDataPublicacaoFormatada(String dataPublicacaoFormatada) {
		this.dataPublicacaoFormatada = dataPublicacaoFormatada;
	}
	public Long getIdCategoriaDto() {
		return idCategoria;
	}
	public void setCategoriaDto(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Long getIdAutorDTO() {
		return idAutor;
	}
	public void setAutorDTO(Long idAutor) {
		this.idAutor = idAutor;
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

	public String getNmCategoria() {
		return nmCategoria;
	}

	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}

	public String getNmAutor() {
		return nmAutor;
	}

	public void setNmAutor(String nmAutor) {
		this.nmAutor = nmAutor;
	}

	private void parse(Livro livro) {
		
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.dataPublicacaoFormatada = DateUtil.formatDateTimeDMY(livro.getDataPublicacao());
		this.idCategoria = livro.getCategoria().getId();
		this.idAutor = livro.getAutor().getId();
		this.nmAutor = livro.getAutor().getNome();
		this.nmCategoria = livro.getCategoria().getNome();
	}
}
