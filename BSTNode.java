public class BSTNode {
	BSTNode left, right;
    Student data;

    public BSTNode()
    {
        left = null;
        right = null;
        data = null;
    }

    public BSTNode(Student n)
    {
        left = null;
        right = null;
        data = n;
    }
    
    public String printNode(BSTNode n){
    	int id = n.getData().getId(); 
    	String fn = n.getData().getFirstname(); 
    	String ln = n.getData().getLastname();
    	int p = n.getData().getNumberOfCourses(); 
    	String courses[] = new String[p]; 
    	int credits[] = new int[p]; 
    	int grades[] = new int[p];
    	String h = ""; 
    	String j = ""; 
    	String d = ""; 
    	for (int e = 0; e<= courses.length-1; e++){
    		courses[e] = n.getData().getCourse(e).getCourseName(); 
    		String zzz = courses[e]; 
    		h = h +" "+zzz+","; 
    		
    	}
    	for (int e = 0; e<= credits.length-1; e++){
    		credits[e] = n.getData().getCourse(e).getCredit(); 
    		int zzz = credits[e]; 
    		j = j +" "+zzz+",";
    	}
    	for (int e = 0; e<= grades.length-1; e++){
    		grades[e] = n.getData().getGrade(e).getGrade(); 
    		int zzz = grades[e]; 
    		d = d +" "+zzz+",";
    	}
    	float gpa = n.getData().getCurrentGPA();
    	String x = (id + " "+fn+" "+ln+":");
    	String y = h + j + d; 
    	String z = (" "+gpa+"\n"); 
    	String xyz = x+y+z; 
    	return xyz; 
    }
    
    public void setLeft(BSTNode n)
    {
        left = n;
    }

    public void setRight(BSTNode n)
    {
        right = n;
    }

    public BSTNode getLeft()
    {
        return left;
    }

    public BSTNode getRight()
    {
        return right;
    }

    public void setData(Student d)
    {
        data = d;
    }

    public Student getData()
    {
        return data;
    }     
}
