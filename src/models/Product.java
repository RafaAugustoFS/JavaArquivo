package models;

public class Product {

		private long id;
		private String nome;
		private double preco;
		private int quantidade;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Product(long id, String nome, double preco, int quantidade) {
			super();
			this.id = id;
			this.nome = nome;
			this.preco = preco;
			this.quantidade = quantidade;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public double getPreco() {
			return preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		@Override
		public String toString() {
			return id + ";" + nome + ";" + preco + ";" + quantidade;
		}
		
}
