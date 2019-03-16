package model;

public class Musica {

	private Integer chave;
	private String nome;
	private String artista;
	private String ano;
	private String album;

	public Musica(String nome, String artista, String ano, String album) {
		super();
		this.nome = nome;
		this.artista = artista;
		this.ano = ano;
		this.album = album;
	}
	
	public Musica() {
		
	}

	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

}
