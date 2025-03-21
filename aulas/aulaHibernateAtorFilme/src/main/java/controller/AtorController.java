package controller;

import java.util.List;

import dao.AtorDao;
import model.Ator;

public class AtorController {
	
	private AtorDao atorDao = new AtorDao();
	
	
	//TODO: FAZER LISTAR TODOS
	
	public void inserirAtor(Ator ator) {
		atorDao.inserir(ator);
	}
	
	public List<Ator> pesquisarTodos(){
		return atorDao.lista();
	}
	
	public List<Ator> pesquisarUmAtor(String nome) {
		return atorDao.apenasUmAtor(nome);
	}
	
	public void apagar(long id) {
		atorDao.remover(id);
	}
	
	public void atualizar(Ator ator) {
		atorDao.atualizar(ator);
	}

}
