package service;

import java.util.Scanner;
import models.User;
import utils.UserManager;
import java.util.List;

public class HandleMenuUser {

	Scanner sc = new Scanner(System.in);
	
	UserManager gs = new UserManager();
	
	
	public HandleMenuUser() {
		// toda vez que a classe menu, for instanciada, o nosso arquivo sera verificado
		gs.checkCreate("usuarios.txt");
	}
	
	public void create() {
		System.out.println("digite o nome");
		String name = sc.next();
		System.out.println("digite a senha");
		String password = sc.next();
		int id = getNextId();

		User u = new User(id, name, password);
		gs.addUser(u);
	}
	public void edit() {
		System.out.println("digite o ID do usuário:");
		int id = sc.nextInt();
		
		System.out.println("digite o novo nome");
		String name = sc.next();
		
		System.out.println("digite a nova senha");
		String password = sc.next();
		
		gs.editUser(id, name, password);
	}
	public void delete() {
		System.out.println("Digite o id que será deletado");
		int id = sc.nextInt();
		gs.deleteUser(id);
	}
	public void list(){
		gs.listUser();
	}
	private int getNextId() {
		List<User> users = gs.readUser();
		int maxId = 0;
		for(User user : users) {
			int id = user.getId();
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
		gs.listEspecify(id);
	}
	public void login() {
		System.out.println("Digite o nome");
		String nome = sc.next();
		
		System.out.println("Digite a senha");
		String senha = sc.next();
		
		gs.login(nome, senha);
	}
	public void changePassword() {
		gs.listUser2();
		System.out.println("Digite o id");
		int id = sc.nextInt();
		
		System.out.println("Digite a senha");
		String password = sc.next();
		
		gs.changePassword(password, id);
	}
}
