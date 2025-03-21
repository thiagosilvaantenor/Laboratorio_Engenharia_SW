package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ator")
public class Ator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String pais;


	/* Como ator é o lado mais fraco, ele recebe o mappedBy
	 * O lado mais fraco só tem a função de mostrar quais atores estão no filme
	 * Ele não tem poder sobre a entidade mais forte Filme
	 * */
	@ManyToMany(mappedBy = "atores")
	private List<Filme> filmes;
	
	public Ator() {
		super();
	}

	public Ator(long id, String nome, String pais, List<Filme> filmes) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
		this.filmes = filmes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}


}
