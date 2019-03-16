package CRUDMusica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Musica;

public class MusicaDao {

	private final Connection connection;

	public MusicaDao(Connection connection) {
		this.connection = connection;
	}

	public Musica salva(Musica musica) throws SQLException {
		try (PreparedStatement stmt = connection
				.prepareStatement("insert into musica(nome, artista, ano, album) values (?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, musica.getNome());
			stmt.setString(2, musica.getArtista());
			stmt.setString(3, musica.getAno());
			stmt.setString(4, musica.getAlbum());
			stmt.execute();
//			if (executou) {
				try (ResultSet keys = stmt.getGeneratedKeys()) {
					while (keys.next()) {
						int id = Integer.parseInt(keys.getString("CHAVE"));
						musica.setChave(id);
					}

				}
//			}
		}
		return musica;
	}

	public List<Musica> lista() throws SQLException {
		String sql = "select * from musica";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.execute();
			ResultSet resultSet = stmt.getResultSet();
			ArrayList<Musica> musicas = new ArrayList<>();
			while (resultSet.next()) {
				String nome = resultSet.getString("nome");
				String artista = resultSet.getString("artista");
				String ano = resultSet.getString("ano");
				String album = resultSet.getString("album");
				int chave = resultSet.getInt("chave");
				Musica musica = new Musica(nome, artista, ano, album);
				musica.setChave(chave);
				musicas.add(musica);
			}
			return musicas;
		}
	}

}
