public class Student {
	private String firstname; 
	private String lastname; 
	private int id; 
	private Course[] courses;
	private Grade[] grades; 
	private int totalCredits; 
	private float currentGPA;
	private int numberOfCourses; 
	
	public Student(int number, String fn, String ln, Course[] course, Grade[] grade, int totalCreds, float gpa){
		id = number;
		firstname = fn; 
		lastname = ln;  
		courses = course; 
		grades = grade; 
		totalCredits = totalCreds; 
		currentGPA = gpa; 
		numberOfCourses = course.length; 
	}
	
	public int getNumberOfCourses(){
		return numberOfCourses;  
	}
	
	public void setNumberOfCourses(int number){
		numberOfCourses = number;   
	}
	
	public void addCourse(Course x){
		Course[] temp = new Course[courses.length+1];
		for (int i=0; i<=temp.length-2; i++){
			temp[i]=courses[i]; 
		}
		temp[courses.length] = x; 
		courses = temp; 
	}
	
	public void addGrade(Grade x){
		Grade[] temp = new Grade[grades.length+1];
		for (int i=0; i<=temp.length-2; i++){
			temp[i]=grades[i]; 
		}
		temp[grades.length] = x; 
		grades = temp; 
	}
	
	public Course findCourse(String x){
		for (int i = 0; i<=courses.length; i++){ 
			if (x.equalsIgnoreCase(courses[i].getCourseName())){
				return courses[i]; 
			}
		}
		return null; 
	}
	
	public int findCourseIndex(Course x){
		for (int i = 0; i<=courses.length; i++){ 
			if (courses[i]==x){
				return i; 
			}
		}
		return -1; 
	}
	
	public void dropGrade(int x){
		Grade[] temp = grades;
		Grade[] temp2 = new Grade[grades.length-1]; 
		for (int j = x; j<=temp.length-2; j++){
			temp[j]=grades[j+1];
		}
		for (int k=0; k<=temp2.length-1; k++){
			temp2[k]=temp[k]; 
		}
		grades = temp2; 
	}
	
	public void dropCourse(Course x){
		int n = 0;
		Course[] temp = courses;
		Course[] temp2 = new Course[courses.length-1]; 
		for (int i=0; i<=courses.length-1; i++){
			if (courses[i] == x){
				n = i; 
			}
		}
		for (int j = n; j<=temp.length-2; j++){
			temp[j]=courses[j+1];
		}
		for (int k=0; k<=temp2.length-1; k++){
			temp2[k]=temp[k]; 
		}
		courses = temp2; 
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		if (id<100000||id>999999){
			throw new IllegalArgumentException("Not a valid ID number."); 
		}
		this.id = id;
	}
	
	public Course[] getCourses() {
		return courses;
	}
	
	public Course getCourse(int courseNumber){
		return courses[courseNumber]; 
	}
	
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
	
	public Grade[] getGrade(){
		return grades; 
	}
	
	public Grade getGrade(int courseNumber){
		return grades[courseNumber]; 
	}
	
	public int getTotalCredits() { 
		return totalCredits;
	}
	
	
	public float getCurrentGPA() {
		return currentGPA;
	}
	
	public void setCurrentGPA(float currentGPA) {
		this.currentGPA = currentGPA;
	}

	public void calculateGPA(Course[] x, Grade[] y){
		currentGPA = 0; 
		for (int i = 0; i<= x.length-1; i++){
			currentGPA += x[i].getCredit()*y[i].getGrade();
		}
		currentGPA = (currentGPA/totalCredits); 
	}
}
