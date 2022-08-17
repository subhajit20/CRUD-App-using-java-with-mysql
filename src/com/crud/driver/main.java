package com.crud.driver;
import com.crud.crudfunctions.CrudFunction;
import java.util.Scanner;;
public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CrudFunction cd = new CrudFunction();
		
		boolean flag = true;
		int option;
		try{
			while(flag){
				System.out.println("****************WELLCOME TO CRUD APPLICATION*************");
				System.out.println("<----------------PLEASE CHOOSE ANY OPTION YOU WANT---------------->");
				System.out.println("Option 1 :: CREATE NEW DATA ------->");
				System.out.println("Option 2 :: READ ALL DATA ------->");
				System.out.println("Option 3 :: UPDATE A DATA ------->");
				System.out.println("Option 4 :: DELETE A DATA ------->");
				System.out.print("ENTER YOUR OPTION :: ");
				option = sc.nextInt();
				System.out.println("YOUR OPTION IS :: "+option);
				if(option == 1){
					
					System.out.print("ENTER A UNIQUE ID :: ");
					int id = sc.nextInt();
					
					System.out.print("ENTER A NAME :: ");
					String name = sc.next();
					cd.Create(id, name);
					
				}
				else if(option == 2){
					cd.Read();
				}else if(option == 3){
					System.out.println("SEARCH BY ID :: ");
					int id = sc.nextInt();
					
					System.out.print("ENTER UPDATED NAME :: ");
					String name = sc.next();
					cd.Update(id,name);
					
				}else if(option == 4){
					System.out.println("SEARCH BY ID :: ");
					int id = sc.nextInt();
					
					cd.Delete(id);
					
				}else if(option == 0){
					System.out.println("You have Stopped !! THANK YOU :)");
					flag = false;
					break;
				}else{
					System.out.println("Please Choose a correct option..");
					throw new Exception("You have press wrong key!!");
				}
				
			}
		}catch(Exception e){
			System.out.println("Somethong went wrong...");
			System.out.println("Please Restart or stopped here");
			
		}
		
		
		
	}

}
