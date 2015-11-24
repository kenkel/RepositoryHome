package exceptions;

import controllers.NoteBook;

public class ContactEditProblem extends AbstractNoteBookExceptions{
	private final String editPtoblem = "cant edit,plz check data";
	
	public void showProblemMessage() {
		System.out.println(editPtoblem);
	}
}
