package livraria.api.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import livraria.api.form.EstadosForm;

@Table( name = "estados")
@Entity( name = "Estados")
public class Estados {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String nome;
	@ManyToOne
	@JoinColumn(name = "paises_id")
	private Paises paises;
	
	public Estados() {}

	public Estados(Long id, String nome, Paises paises) {
		super();
		this.id = id;
		this.nome = nome;
		this.paises = paises;
	}

	public Estados(EstadosForm estadosForm) {
		super();
		
		this.nome = estadosForm.getNome();
		paises = new Paises();
		this.paises.setId(estadosForm.getIdPaises());;
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
	public Paises getPaises() {
		return paises;
	}
	public void setPaises(Paises paises) {
		this.paises = paises;
	}
	
}
