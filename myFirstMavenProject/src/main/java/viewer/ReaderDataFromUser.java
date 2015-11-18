package viewer;


import java.util.Scanner;
import controllers.NoteBook;
import modelEntityes.Contact;
import modelEntityes.Controls;

public class ReaderDataFromUser {

	private boolean MenuOff = false;
	private final NoteBook notebook = new NoteBook();
	
	
	
	
	public void runMenu () {
		
		ViewMessagesSystem.GREETING_MESSAGE.printMessage();
		
		while(!MenuOff){
			
			startUpMenuMessage();
			String comandfromUser = readData();
			
			if(Controls.add.getComand().equals(comandfromUser)){
				notebook.addContact(readContactToAdd());
				ViewMessagesSystem.ADDED_SUCESFULLY.printMessage();
				
			}else
			if(Controls.delete.getComand().equals(comandfromUser)){
				notebook.deleteContact(readContactToDelete());
				ViewMessagesSystem.DELETED_SUCESFULLY.printMessage();
			}else
			if(Controls.edit.getComand().equals(comandfromUser)){
				ViewMessagesSystem.PLEASE_SET_CONTACT_TO_EDIT.printMessage();
				String nameToEdit = readData();
				ViewMessagesSystem.PLEASE_ADD_NAME.printMessage();
				String newName = readData();
				ViewMessagesSystem.PLEASE_ADD_NUMBER.printMessage();
				String newNumber = readData();
				notebook.editContact(nameToEdit, newName, newNumber);
				ViewMessagesSystem.ADDED_SUCESFULLY.printMessage(); // if previous does not work ?
			
			}else
			if(Controls.off.getComand().equals(comandfromUser)){
				MenuOff = true;
				ViewMessagesSystem.GOODBYE.printMessage();
			}else	
			if(Controls.showAll.getComand().equals(comandfromUser)){
				ViewMessagesSystem.SYSTEM_SEPARTOR.printMessage();
				notebook.viewContacts();
			
			}
			else{
				ViewMessagesSystem.IF_INCORRECT.printMessage();
			}
			
		}
		
	}
	private String readData() {
		final Scanner scanner = new Scanner(System.in);
		String result ;
		while(scanner.hasNext()){
			result = scanner.next();
			return result;
		}
		scanner.close(); // is it correct ?? close scanner here...
		return "";
	}
	private void startUpMenuMessage () {
			ViewMessagesSystem.SYSTEM_SEPARTOR.printMessage();
			ViewMessagesSystem.STARTUP_MESSAGE.printMessage();
		    ViewNoteBookData.viewControls();
		}
	private Contact readContactToAdd (){  // working
		ViewMessagesSystem.PLEASE_ADD_NAME.printMessage();
		String name = readData();
		ViewMessagesSystem.PLEASE_ADD_NUMBER.printMessage();
		String number = readData();
		Contact contact = new Contact(name,number);
		return contact;
		
	
	}
	private String readContactToDelete()  { // working
		ViewMessagesSystem.DELETE_NUMBER.printMessage();
		String nameToDelete = readData();
		return nameToDelete;

		
		
	}


}
