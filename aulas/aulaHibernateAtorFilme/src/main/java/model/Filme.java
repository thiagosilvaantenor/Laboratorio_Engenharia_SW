package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="filme")
public class Filme implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String titulo;
	
	private String nomeDiretor;
	
	//Usa o FetchType.EAGER para garantir que os registros serão carregados imediatamente
	@ManyToMany(fetch = FetchType.EAGER)
	//Cria tabela da associação entre filme e ator com o nome filme_ator
	@JoinTable(name ="filme_ator", joinColumns = 
	//O JoinColumn fala quem é o lado mais forte, ou "dono", da relação, nesse caso a tabela filme
	@JoinColumn(name="filme_id"),
	//Já o inverseJoinColumns diz quem é o lado mais fraco, nesse caso ator
	inverseJoinColumns = @JoinColumn(name= "ator_id"))
	
	private List<Ator> atores;
	
	public Filme() {
		atores = new ArrayList<>();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String nome) {
		this.titulo = nome;
	}
	public String getNomeDiretor() {
		return nomeDiretor;
	}
	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor = nomeDiretor;
	}
	public List<Ator> getAtores() {
		return atores;
	}
	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	
	
}
