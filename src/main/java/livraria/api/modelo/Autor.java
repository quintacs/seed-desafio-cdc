package livraria.api.modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import livraria.api.form.AutorForm;
import livraria.api.util.DateUtil;

@Table( name = "autores")
@Entity( name = "Autor")
public class Autor {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String nome;
	private String email; 
	private String descricao;
	private LocalDateTime dataCadastro;
	@OneToMany(mappedBy = "autor")
	private List<Livro> listLivro;
	
	public Autor( String nome, String email, String descricao, LocalDateTime dataCadastro){
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
	}
	
	public Autor() {}

	public Autor(AutorForm autorForm) {
		
		this(autorForm.getNome(),autorForm.getEmail(),autorForm.getDescricao(),DateUtil.parsetDateTimeDMYHHMMSS(autorForm.getDataCadastro()));
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Livro> getListLivro() {
		return listLivro;
	}

	public void setListLivro(List<Livro> listLivro) {
		this.listLivro = listLivro;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", dataCadastro=" + dataCadastro + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCadastro, descricao, email, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
}
