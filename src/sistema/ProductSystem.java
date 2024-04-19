package sistema;

import java.util.Scanner;

import service.HandleMenuProduct;

public class ProductSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 
		 HandleMenuProduct hmp = new HandleMenuProduct();
		 int option = 0;
		 
		 do {
			 System.out.print("\n1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar "
			 		+ "\n5 - Listar específico \n6 - Somar preços \n7 - Somar quantidade\n9 - Sair");
			 option = sc.nextInt();
			 
			 switch(option) {
			 case 1:{
				 hmp.create();
				 break;
			 }
			 case 2:{
				 hmp.edit();
				 break;
			 }
			 case 3:{
				 hmp.delete();
				 break;
			 }
			 case 4:{
				 hmp.list();
				 break;
			 }
			 case 5:{
				 hmp.listEspecify();
				 break;
			 }
			 case 6:{
				 hmp.addPrice();
				 break;
			 }
			 case 7:{
				 hmp.addQuantity();
				 break;
			 }
			 default:
				 System.out.println("Opção inválida");
				 break;
			 }
		 } while(option != 9);
	}
}
