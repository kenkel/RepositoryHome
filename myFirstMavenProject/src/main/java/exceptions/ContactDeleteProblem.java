package exceptions;

public class ContactDeleteProblem extends AbstractNoteBookExceptions {
	final private String problemMessage = "contact not found,plz check data...";
	
	public void showProblemMessage() {
		System.out.println(problemMessage);
	}
			
}
