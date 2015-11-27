package modelEntityes;

import java.util.Arrays;

public enum Controls {
	add("add"),delete("delete"),edit("edit"),off("off"),showAll("showAll");
	
	private String comand;
	
	Controls(String comand) {
		this.comand = comand;
	}
	public String getComand() {
		return comand;
	}
	public String getAllControls(){
		return Arrays.toString(Controls.values());
	}


}