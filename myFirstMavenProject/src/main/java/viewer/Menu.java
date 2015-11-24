package viewer;


import java.util.Scanner;
import controllers.NoteBook;
import exceptions.ContactAddProblem;
import exceptions.ContactDeleteProblem;
import exceptions.ContactEditProblem;
import interfaces.IavailableMenuActions;
import modelEntityes.Contact;
import modelEntityes.Controls;

public class Menu {
	
	private boolean MenuOff = false;
	//private final NoteBook notebook = new NoteBook();  if you architecture is bad
	private IavailableMenuActions menuActions;
	
	
	
	public Menu(IavailableMenuActions menuActions){
		this.menuActions = menuActions;
	}
	public void runMenu () {
		
		ViewMessagesSystem.GREETING_MESSAGE.printMessage();
		
		while(!MenuOff){
			
			startUpMenuMessage();
			String comandfromUser = readData();
			
			if(Controls.add.getComand().equals(comandfromUser)){
				try{
						menuActions.addContact(readContactToAdd());
					 //	if you architecture is bad notebook.addContact(readContactToAdd());
						ViewMessagesSystem.ADDED_SUCESFULLY.printMessage();
					}catch(ContactAddProblem e){
						e.showProblemMessage();
						continue;
					}
			
			}else
				if(Controls.delete.getComand().equals(comandfromUser)){
					try{
							menuActions.deleteContact(readContactToDelete());
							//if you architecture is bad notebook.deleteContact(readContactToDelete());
							ViewMessagesSystem.DELETED_SUCESFULLY.printMessage();
						}catch (ContactDeleteProblem e){
							e.showProblemMessage();
							continue;
						}
			}else
				if(Controls.edit.getComand().equals(comandfromUser)){
					
					ViewMessagesSystem.PLEASE_SET_CONTACT_TO_EDIT.printMessage();
					String nameToEdit = readData();
					ViewMessagesSystem.PLEASE_ADD_NAME.printMessage();
					String newName = readData();
					ViewMessagesSystem.PLEASE_ADD_NUMBER.printMessage();
					String newNumber = readData();
					try{
						menuActions.editContact(nameToEdit,newName,newNumber);
					//	notebook.editContact(nameToEdit, newName, newNumber);
						ViewMessagesSystem.ADDED_SUCESFULLY.printMessage(); // if previous does not work ?
					}catch (ContactEditProblem e){
						e.showProblemMessage();
						continue;
					}catch (ContactAddProblem e) {
						 e.showProblemMessage();
						e.printStackTrace();
					}
			
			}else
				if(Controls.off.getComand().equals(comandfromUser)){
				 //	menuActions.menuOff();
					MenuOff = true;
					ViewMessagesSystem.GOODBYE.printMessage();
			}else	
				if(Controls.showAll.getComand().equals(comandfromUser)){
					ViewMessagesSystem.SYSTEM_SEPARTOR.printMessage();
					menuActions.viewContacts();
			
			}
			else{
				ViewMessagesSystem.IF_INCORRECT.printMessage();
			}
			
		}
		
	}
	public void setMenuOff(boolean a){
		this.MenuOff = a;
	}
	private String readData() {
		final Scanner scanner = new Scanner(System.in);
		String res = scanner.next();
		return res;
	}
	private void startUpMenuMessage () {
			ViewMessagesSystem.SYSTEM_SEPARTOR.printMessage();
			ViewMessagesSystem.STARTUP_MESSAGE.printMessage();
		    ViewNoteBookData.viewControls();
		}
	private Contact readContactToAdd () throws ContactAddProblem{  // working
		ViewMessagesSystem.PLEASE_ADD_NAME.printMessage();
		String name = readData();
		ViewMessagesSystem.PLEASE_ADD_NUMBER.printMessage();
		String number = readData();
		Contact contact = new Contact(name,number);
		return contact;
		
	
	}
	private String readContactToDelete()  { // working
		ViewMessagesSystem.DELETE_CONTACT.printMessage();
		String nameToDelete = readData();
		return nameToDelete;

		
		
	}


}
