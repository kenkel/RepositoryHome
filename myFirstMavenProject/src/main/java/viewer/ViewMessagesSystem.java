package viewer;

public enum ViewMessagesSystem {
     // incorrectMessages :
	 IF_INCORRECT("Please enter the correct data"),
	 THIS_NUMBER_IS_ALREADY_EXIST("This number is already exist. Please enter original data..."),
	 DELETED_CRASHED("Sory,this contacts does not exist... "),
	 // greetingUserMessages :
     GREETING_MESSAGE("Hello! Well come to the project Notebook! Houpfully, you're enjoy it! "),
     STARTUP_MESSAGE("What comand do you want to execute ? "),
     // infoMessages :
     PLEASE_SET_CONTACT_TO_EDIT("Please choose contact to edit :"),
     NOTHING_TO_EDIT("Sory,contactList is empty..."),
     ADDED_SUCESFULLY("Contact added sucesfully "),
     PLEASE_ADD_NAME("Please enter the name :"),
     PLEASE_ADD_NUMBER("Please enter the number :"),
     DELETE_NUMBER("Please enter the name to delete :"),
     DELETED_SUCESFULLY("Contact deleted sucesfully "),
     SYSTEM_SEPARTOR("-------------------"),
     GOODBYE("Good bye!");
		
	
	
	private String message;
	
	private ViewMessagesSystem(String message) {
		this.message = message;
	}
	
	public void printMessage(){
		System.out.println(message);
	}

}
