package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import CRUDMusica.MusicaDao;
import connectionfactory.ConnectionFactory;
import model.Musica;

public class TesteSQL {
	public static void main(String[] args) {
		Musica musica = new Musica("aaaaa", "sdass", "2000", "ALBUM1");

		try (Connection con = new ConnectionFactory().getConnection()) {
			MusicaDao dao = new MusicaDao(con);
			System.out.println("inserindo musica");
			dao.salva(musica);
			

			List<Musica> musicas = dao.lista();
			for (Musica m : musicas) {
				System.out.println(m.getNome());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}