import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.awt.event.*;

public class FileMenuHandler implements ActionListener {
	DisplayWindow window;
	static BufferedReader br = null; 
	static BST tree = new BST();  

	public FileMenuHandler(DisplayWindow x) {
		window = x;
	}

	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Open")){
			JFileChooser fd = new JFileChooser();
			fd.showOpenDialog(null);
			File myFile = fd.getSelectedFile();
			try {
				fileReader(myFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		else if (menuName.equals("Quit"))
			System.exit(0);
	} 
	
	public static void fileReader (File fileName) throws IOException{ 
		br = new BufferedReader(new FileReader(fileName)); 
		String line = br.readLine();
		while (line!= null){
			StringTokenizer myTokens = new StringTokenizer(line, ","); 
	    	myTokens = new StringTokenizer(line,",");	
	    	while (myTokens.hasMoreTokens()) {
	    		Course courses[] = new Course[4]; 
	    		String courseNames[] = new String[4]; 
	    		int credit[] = new int[4]; 
	    		int grades[] = new int[4]; 
	    		Grade courseGrade[] = new Grade[4];
	    		int id = Integer.parseInt(myTokens.nextToken()); 
	    		if (id<100000||id>999999){
	    			throw new IllegalArgumentException("Not a valid ID number."); 
	    		}
	    		String firstName = myTokens.nextToken(); 
	    		String lastName = myTokens.nextToken(); 
	    		courseNames[0] = myTokens.nextToken();
	    		Course a = new Course(courseNames[0]);
	    		courseNames[1] = myTokens.nextToken();
	    		Course b = new Course(courseNames[1]); 
	    		courseNames[2] = myTokens.nextToken();
	    		Course c = new Course(courseNames[2]);
	    		courseNames[3] = myTokens.nextToken();
	    		Course d = new Course(courseNames[3]); 
	    		credit[0] = Integer.parseInt(myTokens.nextToken());
	    		a.setCredit(credit[0]);
	    		courses[0] = a;
	    		credit[1] = Integer.parseInt(myTokens.nextToken());
	    		b.setCredit(credit[1]);
	    		courses[1] = b;
	    		credit[2] = Integer.parseInt(myTokens.nextToken());
	    		c.setCredit(credit[2]);
	    		courses[2] = c;
	    		credit[3] = Integer.parseInt(myTokens.nextToken());
	    		d.setCredit(credit[3]); 
	    		courses[3] = d;
	    		int totalCredits = credit[0]+credit[1]+credit[2]+credit[3]; 
	    		grades[0] = Integer.parseInt(myTokens.nextToken());
	    		courseGrade[0] = new Grade(grades[0]); 
	    		grades[1] = Integer.parseInt(myTokens.nextToken());
	    		courseGrade[1] = new Grade(grades[1]); 
	    		grades[2] = Integer.parseInt(myTokens.nextToken());
	    		courseGrade[2] = new Grade(grades[2]); 
	    		grades[3] = Integer.parseInt(myTokens.nextToken());
	    		courseGrade[3] = new Grade(grades[3]); 
	    		float gpa = 0; 
				for (int i = 0; i<= courses.length-1; i++){
					gpa += courses[i].getCredit()*courseGrade[i].getGrade();
				}
				gpa = gpa/totalCredits; 
	    		Student s = new Student(id, firstName, lastName, courses, courseGrade, totalCredits, gpa);
	    		tree.insert(s);
	    	}
	    	line = br.readLine();						
	    }
	    return; 
	}
	
	public static BST getTree(){
		return tree; 
	}
	
}
