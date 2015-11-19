package modelEntityes;

import exceptions.ContactAddProblem;
import viewer.ViewMessagesSystem;


public class Contact {
	
	public static final int MAX_SIZE_DATA = 50;
	public static final String EMPTY_STATE = "";
	public static final String SEPARATOR = " ";
	private String name;
	private String number;

	
	public Contact(final String name,final String number) throws ContactAddProblem{
		if(dataIsCorrect(number,name)){
		this.name = name;
		this.number = number;
		}else{
			//ViewMessagesSystem.IF_INCORRECT.printMessage();
			throw new ContactAddProblem();
		}
	}
	
	public String getName(){
		return name;
	}
	public String getNumber(){
		return number;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setNumber (String number){
		this.number = number;
	}

	private boolean dataIsCorrect (String number,String name) {

		return number != EMPTY_STATE && number!= null && number.length() <= MAX_SIZE_DATA && 
				name !=EMPTY_STATE && name !=null && name.length() <= MAX_SIZE_DATA; 
	}	

}
