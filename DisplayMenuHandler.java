import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class DisplayMenuHandler extends JFrame implements ActionListener {
	private DisplayWindow window;
	private static BST students;  
	private static JTextArea text; 

	public DisplayMenuHandler (DisplayWindow w, BST p, JTextArea a) {
		setWindow(w);
		students = p;  
		text = a;
	}

	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Unsorted")){ 
			text.setEditable(false);
			text.setText("All Students:\n\n");
			students.preorder(text); 
		}
		if (menuName.equals("Sorted")){
			text.setEditable(false);
			text.setText("Students Sorted:\n\n");
			students.inorder(text);;
		}
		if (menuName.equals("Search by ID")){
			text.setEditable(false);
			String id = JOptionPane.showInputDialog("Please input Student's id: ");
			int ID = Integer.parseInt(id); 
			students.searchByID(ID, text); 
		}
		//DOES NOT WORK
		if (menuName.equals("Search by Last Name")){
			text.setEditable(false);
			String ln = JOptionPane.showInputDialog("Please input Student's last name: ");
			students.searchByName(ln, text); 
		}
		if (menuName.equals("Add Student")){
			text.setEditable(false);
			String idNum = JOptionPane.showInputDialog("Please input Student's id: "); 
			int IDNum = Integer.parseInt(idNum); 
			String first = JOptionPane.showInputDialog("Please input Student's first name: ");
			String last = JOptionPane.showInputDialog("Please input Student's last name: ");
			String numOfCourses = JOptionPane.showInputDialog("How many courses has this student taken?" ); 
			int numofcourses = Integer.parseInt(numOfCourses); 
			Course x[] = new Course[numofcourses]; 
			Grade n[] = new Grade[numofcourses]; 
			int totalCredits = 0; 
			for (int i = 0; i <= x.length-1; i++){
				String y = JOptionPane.showInputDialog("Please input course #"+(i+1)+": ");
				String credit = JOptionPane.showInputDialog("How many credits is this course?" );
				int credits = Integer.parseInt(credit); 
				totalCredits += credits; 
				Course k = new Course(y, credits);
				x[i] = k; 
				String grade = JOptionPane.showInputDialog("What grade did Student get in this course?" ); 
				int score = Integer.parseInt(grade); 
				Grade z = new Grade(score); 
				n[i] = z; 
			}
			float GPA = 0; 
			for (int i = 0; i<= x.length-1; i++){
				GPA += x[i].getCredit()*n[i].getGrade();
			}
			GPA = GPA/totalCredits;  
			Student s = new Student(IDNum, first, last, x, n, totalCredits, GPA);
    		students.insert(s); 
    		String p = "\n"+"Student added! Please reload display to see changes."; 
			text.append(p); 
		}
		if (menuName.equals("Delete Student")){
			text.setEditable(false);
			String idNum = JOptionPane.showInputDialog("Please input Student's id: "); 
			int IDNum = Integer.parseInt(idNum); 
			Student q = students.searchByID(IDNum); 
			students.delete(q);
			String x = "\n"+"Student deleted! Please reload display to see changes."; 
			text.append(x); 
		}
		if (menuName.equals("Add Course")){
			text.setEditable(false);
			String idNum = JOptionPane.showInputDialog("Please input Student's id: "); 
			int IDNum = Integer.parseInt(idNum); 
			Student q = students.searchByID(IDNum);
			String name = JOptionPane.showInputDialog("What is the course name? "); 
			String credit = JOptionPane.showInputDialog("How many credits is this course? "); 
			int numcred = Integer.parseInt(credit); 
			String grade = JOptionPane.showInputDialog("What did the student get? "); 
			int gradee = Integer.parseInt(grade); 
			Grade add = new Grade(gradee); 
			Course neww = new Course(name, numcred); 
			q.setNumberOfCourses(q.getNumberOfCourses()+1); 
			q.addCourse(neww);
			q.addGrade(add);
			q.calculateGPA(q.getCourses(), q.getGrade());
			String x = "\n"+"Course added! Please reload display to see changes."; 
			text.append(x); 
		}
		if (menuName.equals("Delete Course")){
			text.setEditable(false);
			String idNum = JOptionPane.showInputDialog("Please input Student's id: "); 
			int IDNum = Integer.parseInt(idNum); 
			Student q = students.searchByID(IDNum);
			String name = JOptionPane.showInputDialog("What is the course name? ");
			q.setNumberOfCourses(q.getNumberOfCourses()-1);
			Course courseName = q.findCourse(name);  
			int courseIndex = q.findCourseIndex(courseName); 
			q.dropCourse(courseName);
			q.dropGrade(courseIndex);
			q.calculateGPA(q.getCourses(), q.getGrade());
			String x = "\n"+"Course deleted! Please reload display to see changes."; 
			text.append(x); 
		}
	}

	public DisplayWindow getWindow() {
		return window;
	}

	public void setWindow(DisplayWindow window) {
		this.window = window;
	} 
}