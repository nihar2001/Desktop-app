import java.awt.event.*;
import javax.swing.*;

public class signUP_page extends DB_lp implements ActionListener {

     JFrame f ;
    
     
    JButton b;
    JTextField t,t1,t2,t3,t4;
    JLabel l,l1,l2,l3,l4,l5;
  
	public signUP_page() {
		
		f=new JFrame();
        l=new JLabel ("First Name");
        l.setBounds(100, 100, 150, 20);
        l1=new JLabel ("Last Name");
        l1.setBounds(100, 150, 150, 20);
        l2=new JLabel ("User Name");
        l2.setBounds(100, 200, 150, 20);
        l3=new JLabel ("Password");
        l3.setBounds(100, 250, 150, 20);
        l4=new JLabel ("Re-enter Password ");
        l4.setBounds(100, 300, 150, 20);
        
        t=new JTextField();
        t.setBounds(240, 100, 150, 20);
        t1=new JTextField();
        t1.setBounds(240, 150, 150, 20);
        t2=new JTextField();
        t2.setBounds(240, 200, 150, 20);
        t3=new JTextField();
        t3.setBounds(240, 250, 150, 20);
        t4=new JTextField();
        t4.setBounds(240, 300, 150, 20);
        l5=new JLabel();
	    l5.setBounds(170, 390, 160, 30);
	    f.add(l5);
	    
        b=new JButton("Submit");
        b.setBounds(170, 340, 160, 30);
        
        b.addActionListener(this); 
        
		f.add(l);f.add(l1);f.add(l2);f.add(l3);f.add(l4);
		f.add(t);f.add(t1);f.add(t2);f.add(t3);f.add(t4);
		f.add(b);
		f.setSize(500,500);
		f.setLayout(null);  
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String args [])
	{
		new signUP_page();
	}



	
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==b)
		 {   String g=new String(t.getText());
		     String g1=new String(t1.getText());
		     String g2=new String(t2.getText());
		     String g3=new String(t3.getText());
		     String g4=new String(t4.getText());
		 
			 if(!(g.isEmpty()))
			 {
                if(g4.equals(g3))
                {
				 insertDB(g,g1,g2,g3);
				 JOptionPane.showMessageDialog(f,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);  	
			  String[] args=new String[2];
				 f.setVisible(false);  
				 login_portal.main(args);
                }
                else
                {
                	 l5.setText("Password Does't Match");  	

                }
			 }
			 else
			 {
				 l5.setText("Empty Field");  	
			 }
		 }
	}
	

}
