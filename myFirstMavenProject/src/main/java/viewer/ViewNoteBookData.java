package viewer;

import java.util.Arrays;
import java.util.List;
import modelEntityes.Contact;
import modelEntityes.Controls;

public class ViewNoteBookData {
	
	
	
	public static void viewContacts(List <Contact> contactsList){
		for (Contact contact : contactsList){
			System.out.println(contact.getName() + Contact.SEPARATOR + contact.getNumber());
		}
	}
	public static void viewControls(){
		System.out.println(Arrays.toString(Controls.values()));
	}

}
