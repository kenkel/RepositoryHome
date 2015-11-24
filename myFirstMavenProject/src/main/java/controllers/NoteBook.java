package controllers;

import java.util.ArrayList;

import exceptions.ContactAddProblem;
import exceptions.ContactDeleteProblem;
import viewer.ViewNoteBookData;
import modelEntityes.Contact;
import viewer.Menu;
import viewer.ViewMessagesSystem;


public class NoteBook {
	
	private final  ArrayList<Contact> contactsList = new ArrayList<Contact>();
	
	public static void main(String[]args) throws ContactAddProblem {
	
		Menu dataFromUser = new Menu();
		dataFromUser.runMenu();;
		
		
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
	public void editContact(final String nameContact,final String newNAme,final String newNumber){
		if(contactsExist(nameContact) && newNAme!=null && newNumber!=null ){
			for(int i = 0; i<contactsList.size();i++){
				if(contactsList.get(i).getName().equals(nameContact)){
					contactsList.get(i).setName(newNAme);
					contactsList.get(i).setNumber(newNumber);
				}
			}
		}else{
			ViewMessagesSystem.IF_INCORRECT.printMessage(); //throw new ContactCantEditException
			return;
		}
	}
	public void viewContacts(){
		ViewNoteBookData.viewContacts(contactsList);
	}
	private boolean contactsExist(final String nameToAdd) {
		if(nameToAdd!=null){
		for(Contact contact : contactsList ){
			if(nameToAdd.equals(contact.getName())){
				return true;
				}
				
			}
		}
		return false;
	}
	
	//  do not enter the separator " ";



}


	
