import java.awt.event.*;
import javax.swing.*;


public class login_portal extends DB_lp  implements ActionListener  {

	
	JTextField t;
    JButton b,b1;
    JLabel l,l1,l2,l3;
    JPasswordField value;
    JFrame f;
   
    public login_portal()
	{
	    f=new JFrame();
 	    
		t=new JTextField();
	    t.setBounds(200, 150 , 150 , 30);
	    l=new JLabel("User Name");
	    l.setBounds(100, 150, 150, 30);
	  
	    value = new JPasswordField(); 	  
	    value.setBounds(200, 200 , 150 , 30);
	    l1=new JLabel("Password");
	    l1.setBounds(100, 200, 150, 30);
	    
	    b=new JButton("Login");
	    b.setBounds(180, 280, 120, 30);
	    
	    b1=new JButton("SignUp");
	    b1.setBounds(180, 320, 120, 30);
	    
	    l2=new JLabel();
	    l2.setBounds(180, 240, 150, 30);
	    f.add(l2);
	    
	    l3=new JLabel();
	    l3.setBounds(120, 240, 250, 30);
	    f.add(l3);
	    
	   
	    b.addActionListener(this); 
	    b1.addActionListener(this); 
	    
	    f.add(t);f.add(value);f.add(l);f.add(l1);f.add(b);f.add(b1);
	    f.setSize(500,500);
	    f.setLayout(null);  
	    f.setVisible(true);  
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public static void main(String[] args) {
		new login_portal();	 

	}
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource()==b)
		 {   
		     String g1=new String(t.getText());
		     String g2=new String(value.getPassword());
			 int y= displayDB(g1,g2);
			 if(y==1)
			{
				 JOptionPane.showMessageDialog(f,"Password is Correct.","Alert",JOptionPane.WARNING_MESSAGE);  
				  
			}
			 else
			{
				 JOptionPane.showMessageDialog(f,"Password or User Name is incorrect !!!","Alert",JOptionPane.WARNING_MESSAGE);  
				 
			}
		 }
		 else if(e.getSource()==b1)
		 { 
			 String[] args=new String[2];
			 f.setVisible(false);  
			 signUP_page.main(args);
			    	 
		 }
	}
	
	

}
