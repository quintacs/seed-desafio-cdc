package livraria.api.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import livraria.api.form.PaisesForm;

@Table( name = "paises")
@Entity( name = "Paises")
public class Paises {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String nome;
	
	@OneToMany(mappedBy = "paises")
	private List<Estados> listEstados;

	public Paises() {}

	public Paises(String nome) {
		this.nome = nome;
	}
	
	public Paises(PaisesForm paisesForm) {
		
		this(paisesForm.getNome());
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
	
	public List<Estados> getListEstados() {
		return listEstados;
	}

	public void setListLivro(List<Estados> listEstados) {
		this.listEstados = listEstados;
	}
}
