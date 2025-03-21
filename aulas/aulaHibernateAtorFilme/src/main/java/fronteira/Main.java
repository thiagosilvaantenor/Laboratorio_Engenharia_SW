package fronteira;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.AtorController;
import controller.FilmeController;
import model.Ator;
import model.Filme;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String nomeFilme = null;
		Filme f1 = new Filme();
		FilmeController fControl = new FilmeController();
		Ator a1 = new Ator();
		AtorController aControl = new AtorController();
		int escolha;
		boolean continuar;
		List<Ator> atoresCadastrados;

		do {
			System.out.println("Menu:");
			System.out.println("1. Inserir Filme");
			System.out.println("2. Pequisar um Filme");
			System.out.println("3. Listar Todos");
			System.out.println("4. Atualizar um Filme");
			System.out.println("5. Apagar um Filme");
			System.out.println("=======================");
			System.out.println("6. Inserir Ator");
			System.out.println("7. Pequisar um Ator");
			System.out.println("8. Apagar um Ator");
			System.out.println("9. Atualizar um Ator");
			System.out.println("10. Listar todos os atores");
			System.out.println("=======================");
			System.out.println("11. Participação Ator no Filme");
			System.out.println("12. Sair");

			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();
			// Garante que o buffer do scanner vai estar limpo
			scanner.nextLine();

			switch (escolha) {
			// INSERIR FILME
			case 1:
				System.out.println("Inserir Filme");
				f1.setId(0);

				System.out.println("Informe o titulo do filme: ");
				String titulo = scanner.nextLine();
				f1.setTitulo(titulo);

				System.out.println("Agora informe o nome do/a diretor/a: ");
				String diretor = scanner.nextLine();
				f1.setNomeDiretor(diretor);

				continuar = true;

				atoresCadastrados = aControl.pesquisarTodos();
				// Enquanto o usuário quiser adicionar atores E enquanto a lista ainda tiver
				// atores
				while (continuar && !(atoresCadastrados.isEmpty())) {
					System.out.println("Listando atores disponíveis: ");

					for (int i = 0; i < atoresCadastrados.size(); i++) {
						Ator atorAtual = atoresCadastrados.get(i);
						System.out.println(i + " - " + atorAtual.getNome());
					}

					System.out.println("Escolha o ator desejado informando o número dele: ");
					int numAtor = scanner.nextInt();

					// Verifica se o numero informado é valido como indice
					if (numAtor >= 0 && numAtor < atoresCadastrados.size()) {
						Ator atorEscolhido = atoresCadastrados.get(escolha);
						f1.getAtores().add(atorEscolhido);
						System.out.println("Foi adicionado o ator: " + atorEscolhido.getNome());
						// Tira da lista temporária, impedindo que o mesmo ator esteja repetidamente no
						// mesmo filme
						atoresCadastrados.remove(atorEscolhido);
					}
					// Verifica se o usuário quer adicionar mais atores
					scanner.nextLine();
					System.out.println("Quer adicionar mais um ator? Responda 1 se sim, se nao use 0");
					int addAtor = scanner.nextInt();
					if (addAtor == 0)
						continuar = false;
				}

				fControl.inserirFilme(f1);
				break;

			case 2:
				// LISTAR 1 FILME
				System.out.println("Pesquisar um filme = ");
				nomeFilme = scanner.next();
				List<Filme> filmes = fControl.pesquisarUmFilme(nomeFilme);
				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes) {
						System.out.println("Nome: " + filme.getTitulo() + " Id= " + filme.getId() + " Diretor: "
								+ filme.getNomeDiretor());
						System.out.println("Atores do filme: " + filme.getTitulo());
						// Percorre a lista de atores e exibe cada ator do filme
						for (Ator a : filme.getAtores()) {
							System.out.println("Id= " + a.getId() + ", Nome do ator = " + a.getNome());
						}
					}
				} else
					System.out.println("Não encontrou o Filme");
				break;

			case 3:
				// LISTAR FILMES
				System.out.println("Listando Todos os Filmes");
				filmes = fControl.pesquisarTodos();
				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes) {
						System.out.println("Id= " + filme.getId() + " Nome: " + filme.getTitulo() + ", Diretor: "
								+ filme.getNomeDiretor());
						System.out.println("Atores: ");
						// Percorre a lista de atores e exibe somente o nome do filme
						for (Ator a : filme.getAtores()) {
							System.out.println("Id= " + a.getId() + "Nome do ator = " + a.getNome());
						}
					}

				} else
					System.out.println("Não encontrou o Filme");
				break;

			case 4:
				// ATUALIZAR O FILME
				System.out.println("Escolha um filme para atualizar ");
				f1.setId(0);
				System.out.println("Inserir Filme");
				f1.setId(0);

				System.out.println("Informe o titulo do filme: ");
				titulo = scanner.nextLine();
				f1.setTitulo(titulo);

				System.out.println("Agora informe o nome do/a diretor/a: ");
				diretor = scanner.nextLine();
				f1.setNomeDiretor(diretor);

				continuar = true;

				atoresCadastrados = aControl.pesquisarTodos();
				// Enquanto o usuário quiser adicionar atores E enquanto a lista ainda tiver
				// atores
				while (continuar && !(atoresCadastrados.isEmpty())) {
					System.out.println("Listando atores disponíveis: ");

					for (int i = 0; i < atoresCadastrados.size(); i++) {
						Ator atorAtual = atoresCadastrados.get(i);
						System.out.println(i + " - " + atorAtual.getNome());
					}

					System.out.println("Escolha o ator desejado informando o número dele: ");
					int numAtor = scanner.nextInt();

					// Verifica se o numero informado é valido como indice
					if (numAtor >= 0 && numAtor < atoresCadastrados.size()) {
						Ator atorEscolhido = atoresCadastrados.get(escolha);
						f1.getAtores().add(atorEscolhido);
						System.out.println("Foi adicionado o ator: " + atorEscolhido.getNome());
						// Tira da lista temporária, impedindo que o mesmo ator esteja repetidamente no
						// mesmo filme
						atoresCadastrados.remove(atorEscolhido);
					}
					// Verifica se o usuário quer adicionar mais atores
					scanner.nextLine();
					System.out.println("Quer adicionar mais um ator? Responda 1 se sim, se nao use 0");
					int addAtor = scanner.nextInt();
					if (addAtor == 0)
						continuar = false;
				}
				fControl.atualizar(f1);
				break;
			case 5:
				// DELETAR FILME
				System.out.println("Escolha um filme para apagar ");
				nomeFilme = scanner.nextLine();
				filmes = fControl.pesquisarUmFilme(nomeFilme);
				// Após buscar o filme desejado, verifica se a lista de filmes é vazia
				if (!(filmes.isEmpty())) {
					// Caso a lista não esteja vazia deleta o primeiro registro
					fControl.apagar(filmes.get(0).getId());
				} else {
					System.err.println("Nenhum filme com este nome foi encontrado!");
				}
				break;
			case 6:
				// Inserir Ator
				System.out.println("Inserir ator ");
				a1.setId(0);

				System.out.println("Informe o nome do ator: ");
				String nomeAtor = scanner.nextLine();
				a1.setNome(nomeAtor);

				System.out.println("Agora informe o pais do ator: ");
				String paisAtor = scanner.nextLine();
				a1.setPais(paisAtor);

				aControl.inserirAtor(a1);
				break;

			case 7:
				// Pesquisar 1 ATOR
				System.out.println("Pesquisar um ator = ");
				nomeAtor = scanner.nextLine();
				List<Ator> atores = aControl.pesquisarUmAtor(nomeAtor);
				if (!(atores.isEmpty())) {
					for (Ator ator : atores) {
						System.out.println(
								"Id: " + ator.getId() + ", Nome: " + ator.getNome() + ", Pais: " + ator.getPais());
						// Percorre a lista de filmes e exibe somente o titulo do filme
						for (Filme f : ator.getFilmes()) {
							System.out.println("Titulos dos Filmes em que atua: " + f.getTitulo());
						}
					}
				} else {
					System.out.println("Não encontrou o Ator");
				}
				break;

			case 8:
				// DELETAR ATOR
				System.out.println("Escolha um ator para apagar ");
				nomeAtor = scanner.nextLine();
				// Busca atores com o nome informado
				atores = aControl.pesquisarUmAtor(nomeAtor);
				if (!(atores.isEmpty())) {
					// Se a lista não estiver vazia apaga o primeiro registro
					aControl.apagar(atores.get(0).getId());
				} else {
					System.err.println("Nenhum ator encontrado com este nome");
				}
				break;
			case 9:
				// Atualizar ator
				System.out.println("Escolha um ator para atualizar");
				System.out.println("Informe o nome do ator: ");
				nomeAtor = scanner.nextLine();
				atores = aControl.pesquisarUmAtor(nomeAtor);
				a1.setId(atores.get(0).getId());
				// CASO o scanner pular a linha tire esse comentario e deixe:
				// scanner.nextLine();

				System.out.println("Informe o nome do ator");
				nomeAtor = scanner.nextLine();
				a1.setNome(nomeAtor);
				System.out.println("Informe o nome do pais");
				paisAtor = scanner.nextLine();
				a1.setPais(paisAtor);

				aControl.atualizar(a1);
				break;
			case 10:
				// Listar todos os atores
				System.out.println("Listando Todos os Atores");
				atores = aControl.pesquisarTodos();
				if (!(atores.isEmpty())) {
					for (Ator ator : atores) {
						System.out.println(
								"Id= " + ator.getId() + " Nome: " + ator.getNome() + ", Pais: " + ator.getPais());
					}
				} else
					System.out.println("Nenhum ator cadastrado");
				break;

			case 11:
				System.out.println("Saindo do menu.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (escolha != 12);

		scanner.close();
	}
}
