package controllers;

import exceptions.ContactAddProblem;
import interfaces.IavailableMenuActions;
import viewer.DekoratorMenu;




public class NoteBook  {
	
	
	private IavailableMenuActions menuActions;
	
	
	public static void main(String[]args) throws ContactAddProblem {
		NoteBook notebook = new NoteBook(new Menu(new NoteBookImplemenation(),new DekoratorMenu('*')));
		notebook.startAplication();
		
	}
	
	public NoteBook(IavailableMenuActions menuActions){
		this.menuActions = menuActions;
	}
	public void setNewMenu(IavailableMenuActions newMenu){
		this.menuActions = newMenu;
	}

	public void startAplication(){
		menuActions.runMenu();
	}
	public void menuOff(){
		menuActions.menuOff();
	}

	



}


	
