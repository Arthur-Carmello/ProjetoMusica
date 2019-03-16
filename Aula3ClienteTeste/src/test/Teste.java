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

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		Connection con = new ConnectionFactory().getConnection();
		String nome = "";
		String artista = "";
		String ano = "";
		String album = "";

		JOptionPane.showMessageDialog(null, "Bem vindo ao cadastro de m�sicas.");
		boolean continuar = true;
		while (continuar) {

			String opcao = JOptionPane.showInputDialog("1.Cadastrar m�sica\n" + "2.Listar m�sicas\n" + "3.Sair\n");
			switch (opcao) {

			case "1":
				nome = JOptionPane.showInputDialog("\nInforme o nome de sua m�sica favorita: ");
				artista = JOptionPane.showInputDialog("Informe o nome do artista dela: ");
				ano = JOptionPane.showInputDialog(
						"Informe o ano de lan�amento. N�o tem problema se voc� n�o souber, pode ser qualquer data: ");
				album = JOptionPane.showInputDialog("Informe o nome do album desta m�sica: ");
				// msgp = "Nome - " + nome;
				try {
					Musica musica = new MusicaDao(con).salva(new Musica(nome, artista, ano, album));
					// while(!msgp.equals("0")) {
					// msgp = JOptionPane.showInputDialog("Chat - " +
					// ChatIntelligence.returnMessage(msgp) + "(Entre com 0 para sair)");
					// IChatAula objChat = (IChatAula) Naming.lookup("rmi://localhost:8282/chat");
					//
					// Message msg = new Message(nome, msgp);
					// objChat.sendMessage(msg);
					// System.out.println(returnMessage(objChat.retrieveMessage()));

					JOptionPane.showMessageDialog(null,
							"M�SICA INSERIDA \n" + "Chave: " + musica.getChave() + "\n" + "Nome: " + musica.getNome() + "\n" + "Artista: "
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
					}
					else {
						JOptionPane.showMessageDialog(null,"N�o ha musicas cadastradas!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continuar = true;
				break;

			case "3":
				continuar = false;
				break;

			default:
				JOptionPane.showMessageDialog(null,
						"Op��o selecionada inv�lida. Selecione uma das op��es exibidas na tela.");

			}

			System.out.println("EXECU��O FINALIZADA");
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
