package service;

import java.util.List;
import java.util.Scanner;
import models.Product;
import utils.ProductManager;

public class HandleMenuProduct {

	Scanner sc = new Scanner(System.in);
	
	ProductManager gp = new ProductManager();
	
	public HandleMenuProduct() {
		gp.checkCreate("produtos.txt");
	}
	
	public void create() {
		System.out.println("digite o nome");
		String name = sc.next();
		System.out.println("digite o preço");
		double price = sc.nextDouble();
		System.out.println("digite a quantidade");
		int quantity = sc.nextInt();
		long id = getNextId();
		Product p = new Product(id, name, price, quantity);
		gp.addProduct(p);
	}
	public void edit() {
		System.out.println("digite o Id do produto");
		int id = sc.nextInt();
		
		System.out.println("digite o novo nome");
		String name = sc.next();
		
		System.out.println("digite o novo preço");
		Double price = sc.nextDouble();
		
		System.out.println("digite a nova quantidade");
		int quantity = sc.nextInt();
		
		gp.editProduct(id, name, price, quantity);
	}
	public void delete() {
		System.out.println("digite o id que será deletado");
		int id = sc.nextInt();
		gp.deleteProduct(id);
	}
	public void list(){
		gp.listProducts();
	}
	private long getNextId() {
		List<Product> products = gp.readProducts();
		long maxId = 0;
		for(Product product : products) {
			long id = product.getId();
			if (id > maxId) {
				//descobrir ultimo id
				maxId = id;
			}
		}
		return maxId + 1;
	}
	public void listEspecify() {
		System.out.println("Digite o id que deseja listar");
		int id = sc.nextInt();
		gp.listEspecify(id);
	}
	public void addPrice() {
		System.out.print("O total de valores em estoque é: R$");
		gp.addPrice();
		
	}
	public void addQuantity() {
		System.out.print("O total de produtos é:");
		gp.addQuantity();
		
	}
	
}
