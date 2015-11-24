package mainTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import controllers.NoteBook;
import modelEntityes.Contact;
import viewer.Menu;
import viewer.ViewMessagesSystem;

public class Main {
	private static ArrayList<Contact> contactsList = new ArrayList<Contact>();
	
	


	public static String readMessage(){
		final Scanner scanner = new Scanner(System.in);
		String toRead ;
		while(scanner.hasNext()){
			toRead = scanner.next();
			return toRead;
		}
		scanner.close();
		return "";
	}
	public static void deleteContact() {
	ViewMessagesSystem.DELETE_CONTACT.printMessage();
	String nameToDelete = readMessage();
	for (int i = 0;i<contactsList.size();i++){
		if(nameToDelete.equals(contactsList.get(i).getName())){
			contactsList.remove(i);
			ViewMessagesSystem.DELETED_SUCESFULLY.printMessage();
		}else{
			ViewMessagesSystem.DELETED_CRASHED.printMessage();
			return;
		}
	}
   }
	private static boolean  contanctsExist(String nameToDelete,String number) {
	for(Contact contact : contactsList ){
		
		if(nameToDelete.equals(contact.getName())&&nameToDelete.equals(contact.getNumber())){
			return true;
		}
			
	}

	return false;
}
}
