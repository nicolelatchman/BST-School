public class Course{
	protected String courseName; 
	protected int credit; 
	
	public Course(String x){
		courseName = x; 
	}
	
	public Course(int numberOfCredit){ 
		credit = numberOfCredit; 
	}
	
	public Course(String x, int numberOfCredit){ 
		credit = numberOfCredit; 
		courseName = x; 
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	
	public int getCredit() {
		return credit;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public String toString(){
		return courseName;
	}
	
}
