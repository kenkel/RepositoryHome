package interfaces;


import exceptions.ContactAddProblem;
import exceptions.ContactDeleteProblem;
import exceptions.ContactEditProblem;
import modelEntityes.Contact;

public interface IavailableMenuActions {
	void addContact(Contact contact) throws ContactAddProblem;
	void deleteContact(String contactName) throws ContactDeleteProblem;
	void editContact(String nameContactExist,String newName,String newNumber) 
			throws ContactEditProblem,ContactAddProblem;
	void viewContacts();
	
	
}
