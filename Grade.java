
public class Grade{
	protected int grade;

	public Grade(int x){
		grade = x;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	} 
	
	public void printGrade(){
		System.out.print(grade);
	}
	
}
