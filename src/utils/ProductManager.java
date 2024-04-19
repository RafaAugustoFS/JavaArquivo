package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Product;

public class ProductManager {


private static final String FILE_NAME = "produtos.txt";

public void checkCreate(String fileName) {
	File file = new File(fileName);
	if(file.exists()) {
		System.out.println("Banco funcionandoo!");
	} else {
		try {
			file.createNewFile();
			System.out.println("Arquivo criado com sucesso!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao criar o arquivo" + e.getMessage());
		}
	}
}
public void addProduct(Product product) {
	//Buffered ou FileWriter escreve em arquivos
	try (BufferedWriter bw = new BufferedWriter( new FileWriter(FILE_NAME, true))){
		bw.write(product.toString());
		bw.newLine();
		System.out.println("Usuário adicionado com sucesso!");
	}catch(IOException e){
		System.out.println("Erro ao escrever no arquivo" + e.getMessage());
	}
}
public List<Product> readProducts() {
	List<Product> products = new ArrayList<Product>();
	try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
		String linha;
		
		while((linha = br.readLine()) != null) {
			String[] partes = linha.split(";"); //divide em três espaços
			
			products.add(new Product(Long.parseLong(partes[0]),partes[1], Double.parseDouble(partes[2]) , Integer.parseInt(partes[3])));
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Erro ao ler arquivo" + e.getMessage());
	}
	return products;
}
public void deleteProduct(long id) {
	List<Product> products = readProducts();
	if(products.removeIf(produto -> produto.getId() == id)) {
		//
		reescreverArquivo(products);
		System.out.println("Usuario deletado com sucesso");
	} else {
		System.out.println("Usuario não encontrado");
	}
}
public void reescreverArquivo(List<Product> products) {
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))){
		for(Product product : products) {
			bw.write(product.toString());
			bw.newLine();
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Ocorreu um erro ao reescrever o arquivo: " + e.getMessage());
	}
}
public void listProducts() {
	List<Product> products = readProducts();
	if(products.isEmpty()) {
		System.out.println("Nenhum usuário cadastrado");
	}else {
		System.out.println("Lista de usuarios");
		for(Product product : products)
			System.out.println("Id:" + product.getId() 
			+ ", Nome:" + product.getNome() + ", Preço:" + product.getPreco() + "Quantidade:" + product.getQuantidade());
		}
	}

public void editProduct(long id, String newName, double newPrice, int newQuantity) {
	List<Product> products = readProducts();
	boolean encontrado = false;
	
	for(Product product : products) {
		if (product.getId() == id) {
			product.setNome(newName);
			product.setPreco(newPrice);
			product.setQuantidade(newQuantity);
			encontrado = true;
			break;
		}
	}
	if (encontrado) {
		reescreverArquivo(products);
		System.out.println("Usuario editado com sucesso");
	}else {
		System.out.println("Usuario não encontrado");
	}
}
public void listEspecify(int id) {
	List<Product> products = readProducts();
	for(Product product : products)  {
			if(product.getId() == id){
				System.out.println("Id:" + product.getId() 
				+ ", Nome:" + product.getNome() + ", Preço:" + product.getPreco() + "Quantidade:" + product.getQuantidade());
				break;
			}else {
				System.out.println("Usuario não encontrado");
				break;
			}
		}
	}
public void addPrice() {
	List<Product> products = readProducts();
	double soma = 0;
	for(Product product : products)  {
			
			soma += product.getPreco() * product.getQuantidade();
			
	}
	System.out.println(soma);	
}
public void addQuantity() {
	List<Product> products = readProducts();
	int soma = 0;
	for(Product product : products)  {
		
		soma += product.getQuantidade();
		
	}
	System.out.println(soma);	
}

}
