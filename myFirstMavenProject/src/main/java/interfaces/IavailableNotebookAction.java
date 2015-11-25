package interfaces;

import exceptions.ContactAddProblem;
import exceptions.ContactDeleteProblem;
import exceptions.ContactEditProblem;
import modelEntityes.Contact;

public interface IavailableNotebookAction  {
	void addContact(Contact contact) throws ContactAddProblem;
	void deleteContact(String nameContact)throws ContactDeleteProblem;
	void editContact (String name,String newName,String newNumber) throws ContactEditProblem,ContactAddProblem;
	void viewContacts();
}
