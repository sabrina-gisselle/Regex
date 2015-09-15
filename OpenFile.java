import java.util.Scanner;

import javax.swing.JFileChooser;


public class OpenFile {
	
	//Declare Variable
	JFileChooser fileChooser = new JFileChooser();
	StringBuilder sb = new StringBuilder();
	RegEx myReg = new RegEx();
	String regexInput;
	
	public void PickMe() throws Exception{
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			
			//get the file
			java.io.File file = fileChooser.getSelectedFile();
			
			//create a scanner for the file
			Scanner input = new Scanner(file);
			
			//read text from file
			while(input.hasNext()){
				regexInput = input.nextLine();
				myReg.testRegEx(regexInput);
				sb.append(regexInput);
				sb.append("\n");
			}
			
			input.close();
		}
		else{
			sb.append("No file was selected");
		}
	}
}
