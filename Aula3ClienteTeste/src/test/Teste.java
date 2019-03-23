package test;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import CRUDMusica.MusicaDao;
import connectionfactory.ConnectionFactory;
import model.Musica;
import util.Message;

public class Teste {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, SQLException {

		Connection con = new ConnectionFactory().getConnection();
		String nome = "";
		String artista = "";
		String ano = "";
		String album = "";

		JOptionPane.showMessageDialog(null, "Bem vindo ao cadastro de músicas.");
		boolean continuar = true;
		while (continuar) {

			String opcao = JOptionPane.showInputDialog("1.Cadastrar música\n 2.Listar músicas\n 3.Pesquisar por música\n 4.Sair");
			switch (opcao) {

			case "1":
				nome = JOptionPane.showInputDialog("\nInforme o nome de sua música favorita: ");
				artista = JOptionPane.showInputDialog("Informe o nome do artista dela: ");
				ano = JOptionPane.showInputDialog(
						"Informe o ano de lançamento. Não tem problema se você não souber, pode ser qualquer data: ");
				album = JOptionPane.showInputDialog("Informe o nome do album desta música: ");
				// msgp = "Nome - " + nome;
				try {
					Musica musica = new MusicaDao(con).salva(new Musica(nome, artista, ano, album));
					
					JOptionPane.showMessageDialog(null,
							"MÚSICA INSERIDA \n" + "Chave: " + musica.getChave() + "\n" + "Nome: " + musica.getNome() + "\n" + "Artista: "
									+ musica.getArtista() + "\n" + "Ano: " + musica.getAno() + "\n" + "Album: "
									+ musica.getAlbum());
					// JOptionPane.showInputDialog("Chave: " + musica.getChave());

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "2":
				try {
					List<Musica> musicas = new MusicaDao(con).lista();
					if (musicas.size() > 0) {
						String lista = "MUSICAS CADASTRADAS \n";
						for (Musica musica : musicas) {
							lista = lista.concat("Chave: " + musica.getChave() + "   " + "Nome: " + musica.getNome() + "   "
									+ "Artista: " + musica.getArtista() + "   " + "Ano: " + musica.getAno() + "   "
									+ "Album: " + musica.getAlbum() + "\n");
						}
						JOptionPane.showMessageDialog(null, lista);
						
//						Query 
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Não ha musicas cadastradas!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continuar = true;
				break;

			case "3":
				String pesquisa = JOptionPane.showInputDialog("\nDigite referente a música desejada (Nome, artista, album, ano): ");
				List<Musica> musicas = new MusicaDao(con).find(pesquisa);
				
				if(musicas.size() > 0) {
					String lista = "RESULTADOS DA PESQUISA \n";
					for (Musica musica : musicas) {
						lista = lista.concat("Chave: " + musica.getChave() + "   " + "Nome: " + musica.getNome() + "   "
								+ "Artista: " + musica.getArtista() + "   " + "Ano: " + musica.getAno() + "   "
								+ "Album: " + musica.getAlbum() + "\n");
					}
					JOptionPane.showMessageDialog(null, lista);
				}
				else {
					JOptionPane.showMessageDialog(null,"A pesquisa realizada não trouxe resultados!");
				}
				
				break;

			case "4":
				continuar = false;
				break;

			default:
				JOptionPane.showMessageDialog(null,
						"Opção selecionada inválida. Selecione uma das opções exibidas na tela.");

			}

			System.out.println("EXECUÇÃO FINALIZADA");
		}
	}

	private static String returnMessage(List<Message> lst) {
		String valor = "";
		for (Message message : lst) {
			valor += message.getUser() + ":" + message.getMessage() + "\n";
		}
		return valor;
	}
}
