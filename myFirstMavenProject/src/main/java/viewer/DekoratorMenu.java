package viewer;

import interfaces.IdekorationMenuTem;

public class DekoratorMenu implements IdekorationMenuTem {
	
	private final char systemDekoratorChar;
	private final String greetingMessage = 
	"******* Hello! Well come to the project Notebook! Houpfully, you're enjoy it! ********";
	private final String seporatorStandart = "----------";
	private int lengthGreetingMessage = greetingMessage.length();
	private final String startUpMessage = "What comand do you want to execute ? ";
	
	public DekoratorMenu(char systemDekoratorChar){
		this.systemDekoratorChar = systemDekoratorChar;
	}
	
	public void printGreetingMessage() {
		System.out.println(greetingMessage);
	}
	public void printStartUpMenuMessage(){
		System.out.println(decoratorLine(lengthGreetingMessage));
		System.out.println(startUpMessage);
	    ViewNoteBookData.viewControls();
	}
	private String decoratorLine(int length){
		if(length!=0){
			StringBuilder result = new StringBuilder();
				for(int i=0;i<length;i++){
					result.append(systemDekoratorChar);
				}
					return result.toString();
		}else{
			return seporatorStandart;
		}

	}
}
