import javax.swing.JTextArea;

public class BST {
	private BSTNode root;
	private static JTextArea text; 
	private Student bst[]; 
	 
    public BST()
    {
        root = null;
    }
    
    public BSTNode getRoot(){
    	return root; 
    }
    
    public void insert(Student data)
    {
        root = insert(root, data);
    }

    private BSTNode insert(BSTNode node, Student data)
    {
        if (node == null)
            node = new BSTNode(data);
        else
        {
            if (data.getId() <= node.getData().getId())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    public void delete(Student k){
            root = delete(root, k);
    }
    private BSTNode delete(BSTNode root, Student k){
        BSTNode p, p2, n;
        if (root.getData() == k)
        {
            BSTNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                p = rt;
                return p;
            }
            else if (rt == null)
            {
                p = lt;
                return p;
            }
            else
            {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k.getId() < root.getData().getId())
        {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else
        {
            n = delete(root.getRight(), k);
            root.setRight(n);             
        }
        return root;
    }
    

	public void searchByName(String ln, JTextArea area){
		searchByName(root, ln, area);
	}
	
	private void searchByName(BSTNode node, String x, JTextArea area){ 
		if (node != null){
			if (x.compareTo(node.data.getLastname()) == 0){
				area.setText(node.printNode(node)); 
			}
			if (x.compareTo(node.getData().getLastname()) < 0){
				searchByName(node.getLeft(), x, area); 
			}
			if (x.compareTo(node.getData().getLastname()) > 0){
				searchByName(node.getRight(), x, area); 
			}
		}
		else if (node == null){
			area.setText("Student not found.");  
		}
	}
	
	public void searchByID(int id, JTextArea area){
		searchById(root, id, area);
	}
	
	private void searchById(BSTNode node, int id, JTextArea area){
		if (node != null){
			if (node.data.getId() == id){
				area.setText(node.printNode(node));  
			}
			if (node.data.getId() < id){
				searchById(node.getRight(), id, area); 
			}
			if (node.data.getId() > id){
				searchById(node.getLeft(), id, area); 
			}
		}
		else if (node == null){
			area.setText("Student not found.");  
		}
	}
	
	public Student searchByID(int id){
		return searchById(root, id);
	}
	
	private Student searchById(BSTNode node, int id){
		if (node != null){
			if (node.data.getId() == id){
				return node.data;  
			}
			if (node.data.getId() < id){
				return searchById(node.getRight(), id); 
			}
			if (node.data.getId() > id){
				return searchById(node.getLeft(), id); 
			}
		}
		return null;  
	}
	
    public void inorder(JTextArea text)
    {
        inorder(root, text);
    }
    private void inorder(BSTNode r, JTextArea text)
    {
        if (r != null)
        {
            inorder(r.getLeft(), text);
            String x = r.printNode(r);
            text.append(x);
            inorder(r.getRight(), text);
        }
    }

    public void preorder(JTextArea text)
    {
        preorder(root, text);
    }
    private void preorder(BSTNode r, JTextArea text)
    {
        if (r != null)
        {
        	String x = r.printNode(r); 
        	text.append(x);
            preorder(r.getLeft(), text);             
            preorder(r.getRight(), text);
        }
    }
    
    public void postorder(JTextArea text)
    {
        postorder(root, text);
    }
    private void postorder(BSTNode r, JTextArea text)
    {
        if (r != null)
        {
            postorder(r.getLeft(), text);             
            postorder(r.getRight(), text);
            String x = r.printNode(r); 
            text.append(x);
        }
    }

	public static JTextArea getText() {
		return text;
	}

	public static void setText(JTextArea text) {
		BST.text = text;
	}

	public Student[] getBst() {
		return bst;
	}

	public void setBst(Student bst[]) {
		this.bst = bst;
	}     
}
