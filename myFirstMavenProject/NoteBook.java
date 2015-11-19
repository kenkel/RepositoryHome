package controllers;

import java.util.ArrayList;
import viewer.ViewNoteBookData;
import modelEntityes.Contact;
import viewer.ReaderDataFromUser;
import viewer.ViewMessagesSystem;

public class NoteBook {
	
	private final  ArrayList<Contact> contactsList = new ArrayList<Contact>();
	
	public static void main(String[]args) {
	
		ReaderDataFromUser dataFromUser = new ReaderDataFromUser();
		dataFromUser.readData();
		dataFromUser.readContactToAdd();
		
	}
	public void addContact (final Contact contact) {  // working
		if(contact!=null){
		contactsList.add(contact);
		}else{
			ViewMessagesSystem.IF_INCORRECT.printMessage(); // throw new ContactCantAddedException
		}
	}
	public void deleteContact( final String nameContact)  {
		 if(nameContact!=null){
			 for(int i = 0;i<contactsList.size();i++){
				 if(nameContact.equals(contactsList.get(i).getName())){
					 contactsList.remove(i);
				 }
			 }
		 }else{
			 ViewMessagesSystem.DELETED_CRASHED.printMessage(); //throw new ContactIsNotExistException 
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


	
