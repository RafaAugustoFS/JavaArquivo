package models;

public class User {

	private int id;
	private String nome;
	private String senha;
	
	public User(int id, String nome, String senha) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return id + ";" + nome + ";" + senha;
	}
}
