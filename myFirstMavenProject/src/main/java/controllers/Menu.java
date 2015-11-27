package controllers;


import java.util.Scanner;
import exceptions.ContactAddProblem;
import exceptions.ContactDeleteProblem;
import exceptions.ContactEditProblem;
import interfaces.IavailableMenuActions;
import interfaces.IavailableNotebookAction;
import interfaces.IdekorationMenuTem;
import modelEntityes.Contact;
import modelEntityes.Controls;
import viewer.ViewMessagesSystem;
import viewer.ViewNoteBookData;

	public class Menu implements IavailableMenuActions {
		
		private boolean MenuOff = false;
		private IavailableNotebookAction noteBookAction;	
		private IdekorationMenuTem dekorationMenu;
	
	
	public Menu(IavailableNotebookAction noteBookAction,IdekorationMenuTem dekorationMenu){
		notebookImplementation(noteBookAction);
		this.dekorationMenu = dekorationMenu;
	}
	/*
	 *  is it correct ? 
	 */
	public void notebookImplementation(IavailableNotebookAction menuActions){
		this.noteBookAction = menuActions;
	}
	public void runMenu () {

		
		dekorationMenu.printGreetingMessage();
		
		while(!MenuOff){
			
			dekorationMenu.printStartUpMenuMessage();
			String comandfromUser = readData();
			
			if(Controls.add.getComand().equals(comandfromUser)){
				try{
						//notebook.addContact(readContactToAdd());
						noteBookAction.addContact(readContactToAdd());
						ViewMessagesSystem.ADDED_SUCESFULLY.printMessage();
					}catch(ContactAddProblem e){
						e.showProblemMessage();
						continue;
					}
			
			}else
				if(Controls.delete.getComand().equals(comandfromUser)){
					try{
						//notebook.deleteContact(readContactToDelete());
						noteBookAction.deleteContact(readContactToDelete());
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
						//	notebook.editContact(nameToEdit, newName, newNumber);
						noteBookAction.editContact(nameToEdit, newName, newNumber);
						ViewMessagesSystem.ADDED_SUCESFULLY.printMessage(); 
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
					//notebook.viewContacts();
					noteBookAction.viewContacts();
			}
			else{
				ViewMessagesSystem.IF_INCORRECT.printMessage();
			}
			
		}
		
	}
	public void menuOff(){

		this.MenuOff = true;
	}
	
	
	private String readData() {
		final Scanner scanner = new Scanner(System.in);
		String res = scanner.next();
		return res;
	}
	
	 
	// try to reorganize downstairs methods : 
	 
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
