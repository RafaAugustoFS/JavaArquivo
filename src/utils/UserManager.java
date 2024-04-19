package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.User;

public class UserManager {
	Scanner sc = new Scanner(System.in);
	private static final String FILE_NAME = "usuarios.txt";
	
	//Verfica a existncia do bd e criar caso não exista
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
	public void addUser(User user) {
		//Buffered ou FileWriter escreve em arquivos
		try (BufferedWriter bw = new BufferedWriter( new FileWriter(FILE_NAME, true))){
			bw.write(user.toString());
			bw.newLine();
			System.out.println("Usuário adicionado com sucesso!");
		}catch(IOException e){
			System.out.println("Erro ao escrever no arquivo" + e.getMessage());
		}
	}
	
	public List<User> readUser() {
		List<User> users = new ArrayList<User>();
		try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
			String linha;
			
			while((linha = br.readLine()) != null) {
				String[] partes = linha.split(";"); //divide em três espaços
				
				users.add(new User(Integer.parseInt(partes[0]),partes[1], partes[2]));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao ler arquivo" + e.getMessage());
		}
		return users;
	}
	
	public void deleteUser(int id) {
		List<User> users = readUser();
		if(users.removeIf(usuario -> usuario.getId() == id)) {
			//
			rewriteFile(users);
			System.out.println("Usuario deletado com sucesso");
		} else {
			System.out.println("Usuario não encontrado");
		}
	}
	
	public void rewriteFile(List<User> users) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))){
			for(User user : users) {
				bw.write(user.toString());
				bw.newLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocorreu um erro ao reescrever o arquivo: " + e.getMessage());
		}
	}
	
	public void listUser() {
		List<User> users = readUser();
		if(users.isEmpty()) {
			System.out.println("Nenhum usuário cadastrado");
		}else {
			System.out.println("Lista de usuarios");
			for(User user : users) {
				System.out.println("Id:" + user.getId() 
				+ ", Nome:" + user.getNome() + ", Senha:" + user.getSenha());
			}
		}
	}
	public void listUser2() {
		List<User> users = readUser();
		if(users.isEmpty()) {
			System.out.println("Nenhum usuário cadastrado");
		}else {
			System.out.println("Lista de usuarios");
			for(User user : users) {
				System.out.println("Id:" + user.getId() 
				+ ", Nome:" + user.getNome());
			}
		}
	}
	
	public void editUser(int id, String newName, String newPassword) {
		List<User> users = readUser();
		boolean encontrado = false;
		
		for(User user : users) {
			if (user.getId() == id) {
				user.setNome(newName);
				user.setSenha(newPassword);
				encontrado = true;
				break;
			}
		}
		if (encontrado) {
			rewriteFile(users);
			System.out.println("Usuario editado com sucesso");
		}else {
			System.out.println("Usuario não encontrado");
		}
	}
	
	public void listEspecify(int id) {
		List<User> users = readUser();
			for(User user : users) {
				if(user.getId() == id){
					System.out.println("Id:" + user.getId() 
					+ ", Nome:" + user.getNome() + ", Senha:" + user.getSenha());	
					break;
				}else {
					System.out.println("Usuario não encontrado");
					break;
				}
			}
		}
	public void login(String senha, String nome) {
		boolean exist = false;
		List<User> users = readUser();
		for(User user : users) {
			if( user.getNome().equals(nome) && user.getSenha().equals(senha) ){		
				exist = true;
			}
			if(exist = true) {
				System.out.println("Logou");
				break;
			}else {
				System.out.println("Nome ou senha incorreta");
				break;
			}
		}	
	}
	public void changePassword(String password, int id) {
		boolean exist = false;
		List<User> users = readUser();
		for(User user : users) {
			if(user.getId() == id && user.getSenha().equals(password)){
			
				System.out.println("Digite sua nova senha:");
				String newPassword = sc.next();
				user.setSenha(newPassword);
				exist = true;
				if(exist = true) {
					rewriteFile(users);
					System.out.println("Senha alterada com sucesso");
					break;
				}else {
					System.out.println("Nome ou senha incorreta");
					break;
				}
			}
			
		}
		
			
	}
	
}
