package controllers;

import java.util.ArrayList;



import exceptions.ContactAddProblem;
import exceptions.ContactDeleteProblem;
import exceptions.ContactEditProblem;
import interfaces.IavailableNotebookAction;
import modelEntityes.Contact;
import viewer.ViewMessagesSystem;
import viewer.ViewNoteBookData;

public class NoteBookImplemenation implements IavailableNotebookAction {
	
	
	private final  ArrayList<Contact> contactsList = new ArrayList<Contact>();
	//private IavailableMenuActions menuActions;
	
	
	public void addContact (final Contact contact) throws ContactAddProblem {  // working
		if(contact!=null){
		contactsList.add(contact);
		}else{
			throw new ContactAddProblem();
		}
	}
	public void deleteContact( String nameContact) throws ContactDeleteProblem  {
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
	public void viewContacts(){
		ViewNoteBookData.viewContacts(contactsList);
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
	
}
