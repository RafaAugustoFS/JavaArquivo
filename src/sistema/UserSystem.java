package sistema;

import java.util.Scanner;

import service.HandleMenuUser;

public class UserSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner sc = new Scanner(System.in);
		 
		 HandleMenuUser hm = new HandleMenuUser();
		 int option = 0;
		 
		 do {
			 System.out.print("1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n5 - Listar específico\n6 - Fazer login\n7 - Alterar senha\n9 - Sair");
			 option = sc.nextInt();
			 
			 switch(option) {
			 case 1:{
				 hm.create();
				 break;
			 }
			 case 2:{
				 hm.edit();
				 break;
			 }
			 case 3:{
				 hm.delete();
				 break;
			 }
			 case 4:{
				 hm.list();
				 break;
			 }
			 case 5:{
				 hm.listEspecify();
				 break;
			 }
			 case 6:{
				 hm.login();
				 break;
			 }
			 case 7:{
				 hm.changePassword();
				 break;
			 }
			 default:
				 System.out.println("Opção inválida");
				 break;
			 }
		 } while(option != 9);
	}

}
