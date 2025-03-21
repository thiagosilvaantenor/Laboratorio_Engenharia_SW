package model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class FilmeAtor {

	@Id
	@ManyToOne
	@JoinColumn(name = "filme_ator")
	private Filme filme;
	@Id
	@ManyToOne
	@JoinColumn(name = "ator_id")
	private Ator ator;

	public FilmeAtor() {
		// TODO Auto-generated constructor stub
	}

	public FilmeAtor(Filme filme, Ator ator) {
		super();
		this.filme = filme;
		this.ator = ator;
	}

	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
