import javax.swing.*;
public class DisplayWindow extends JFrame{
	protected BST tree; 
	private JFrame jframe;
	private JMenuBar menuBar;
	
	DisplayWindow(){
		super("Students"); //Title of GUI
		createFileMenu();
		JTextArea a = new JTextArea();
		String x = "Please load a file through the File menu.";
		String y = "\n" + "After you load a file, you can display the students."; 
		a.append(x);
		a.append(y);
		displayFileMenu(tree, a);
		setSize(600, 400);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible(true);
	}
	
	private void createFileMenu() {
		menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fmh = new FileMenuHandler(this);
		JMenuItem item;

		item = new JMenuItem("Open"); // Open...
		item.addActionListener(fmh);
		fileMenu.add(item); 
		tree = FileMenuHandler.getTree();

		fileMenu.addSeparator(); // add a horizontal separator line

		item = new JMenuItem("Quit"); // Quit
		item.addActionListener(fmh);
		fileMenu.add(item);

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
	}
	
	private void displayFileMenu(BST p, JTextArea a) {
		JMenu editMenu = new JMenu("Display");
		JMenu searchMenu = new JMenu("Search"); 
		JMenu studentMenu = new JMenu("Students"); 
		DisplayMenuHandler emh = new DisplayMenuHandler(this, p, a);
		JMenuItem item;

		item = new JMenuItem("Unsorted");
		item.addActionListener(emh);
		editMenu.add(item);
		add(a); 

		editMenu.addSeparator();
		
		item = new JMenuItem("Sorted");
		item.addActionListener(emh);
		editMenu.add(item);
		add(a);
		
		
		item = new JMenuItem("Search by ID");
		item.addActionListener(emh);
		searchMenu.add(item);
		add(a);
		
		searchMenu.addSeparator();
		
		item = new JMenuItem("Search by Last Name");
		item.addActionListener(emh);
		searchMenu.add(item);
		add(a);
		
		item = new JMenuItem("Add Student"); 
		item.addActionListener(emh);
		studentMenu.add(item); 
		add(a); 
		
		studentMenu.addSeparator(); 
		
		item = new JMenuItem("Delete Student"); 
		item.addActionListener(emh);
		studentMenu.add(item); 
		add(a);
		
		studentMenu.addSeparator();

		item = new JMenuItem("Add Course"); 
		item.addActionListener(emh);
		studentMenu.add(item); 
		add(a); 
		
		studentMenu.addSeparator(); 
		
		item = new JMenuItem("Delete Course"); 
		item.addActionListener(emh);
		studentMenu.add(item); 
		add(a);
		
		menuBar.add(editMenu);
		menuBar.add(searchMenu);
		menuBar.add(studentMenu);  
		
	}

	public JFrame getJframe() {
		return jframe;
	}

	public void setJframe(JFrame jframe) {
		this.jframe = jframe;
	}
	
}
