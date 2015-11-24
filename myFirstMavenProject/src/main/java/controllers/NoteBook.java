package controllers;

import java.util.ArrayList;
import exceptions.ContactAddProblem;
import exceptions.ContactDeleteProblem;
import exceptions.ContactEditProblem;
import interfaces.IavailableMenuActions;
import viewer.ViewNoteBookData;
import modelEntityes.Contact;
import viewer.Menu;
import viewer.ViewMessagesSystem;



public class NoteBook implements IavailableMenuActions{
	
	private final  ArrayList<Contact> contactsList = new ArrayList<Contact>();
	
	
	public static void main(String[]args) throws ContactAddProblem {
	
		Menu dataFromUser = new Menu(new NoteBook());
		dataFromUser.runMenu();
		
		
	}
	public void addContact (final Contact contact) throws ContactAddProblem {  // working
		if(contact!=null){
		contactsList.add(contact);
		}else{
			throw new ContactAddProblem();
		}
	}
	public void deleteContact( final String nameContact) throws ContactDeleteProblem  {
		 if(nameContact!=null){
			 for(int i = 0;i<contactsList.size();i++){
				 if(nameContact.equals(contactsList.get(i).getName())){
					 contactsList.remove(i);
				 }else{
					 throw new ContactDeleteProblem();
				 }
			 }
		 }
	}
	public void editContact(String nameContact,String newName,String newNumber) throws ContactEditProblem,ContactAddProblem{
		if(nameContact !=null 
			&& newName!=null 
			&& newNumber!=null 
			&& contactReturnForName(nameContact)!=null){
			Contact contactNew = contactReturnForName(nameContact);
			contactNew.setName(newName);
			contactNew.setNumber(newNumber);
			
		}else{
			throw new ContactEditProblem();
		}
	}
	private Contact contactReturnForName(String nameContact) throws ContactEditProblem {
		if(nameContact!=null){
			for(int i=0;i<contactsList.size();i++){
				if(nameContact.equals(contactsList.get(i).getName())){
					return contactsList.get(i);
				}else{
					ViewMessagesSystem.NOTHING_TO_EDIT.printMessage();
				}
			}
		}
	
		return null;
	
	}
	public void viewContacts(){
		ViewNoteBookData.viewContacts(contactsList);
	}
	

	



}


	
