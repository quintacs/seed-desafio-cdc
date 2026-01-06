package livraria.api.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import livraria.api.form.CategoriaForm;

@Table( name = "categorias")
@Entity( name = "Categoria")
public class Categoria {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String nome;
	
	@OneToMany(mappedBy = "categoria")
	private List<Livro> listLivro;
	
	public Categoria() {}

	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public Categoria(CategoriaForm categoriaForm) {
		
		this(categoriaForm.getNome());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Livro> getListLivro() {
		return listLivro;
	}

	public void setListLivro(List<Livro> listLivro) {
		this.listLivro = listLivro;
	}
}
