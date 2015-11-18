package exceptions;

public class ContactAddProblem extends NoteBookExceptions {
	private final String contactProblem = "Contact set problem , please chek data ";
	
	public String showProblemMessage(){
		return contactProblem;
	}
}
