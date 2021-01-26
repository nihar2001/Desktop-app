import java.awt.Color;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class Main_page  extends Main_page_db implements ActionListener {
	
	JTextField t;
    JButton b;
    JLabel l,l1,l2,l3,l4;
    JPasswordField value;
    JFrame f,f1;
    ButtonGroup bg1;
    Date date;
    JComboBox<String> cb2,cb,cb1;
    JDateChooser dc,dc1;
       
    Main_page(){
    	f=new JFrame();
    	
    	l=new JLabel("Book a Flight");
    	l.setBounds(100, 70, 100, 50);
     
           
    	l1=new JLabel("From");
    	l1.setBounds(150, 150, 100, 20);
    
          String country[]={"DELHI","CHENNAI","MUMBAI","HYDERABAD","PUNE"};        
           cb=new JComboBox<String>(country);    
          cb.setBounds(150, 175,190,50);    
          f.add(cb); 
    
      	l2=new JLabel("To");
    	l2.setBounds(350, 150, 100, 20);
    
          String country1[]={"HYDERABAD","PUNE","DELHI","CHENNAI","MUMBAI"};
           cb1=new JComboBox<String>(country1);    
          cb1.setBounds(350, 175,190,50);    
          f.add(cb1); 
         
          
            date=java.util.Calendar.getInstance().getTime();
		    dc=new JDateChooser(date);
  	        dc.setBounds(150, 240,190,50);
            dc1=new JDateChooser();
  	  	    dc1.setBounds(350, 240,190,50);
  	     	
  	  	    l3=new JLabel("No Of Passenger(s)");
    	    l3.setBounds(150, 320,190,30);
      	    t=new JTextField();
  	  	    t.setBounds(150, 360,190,50);
  	  	    

  	  	    l4=new JLabel("Pay In (currency)");
    	    l4.setBounds(350, 320,190,30);
  	  	  String currency[]={"INDIAN RUPEES","US DOLLARS","THILAND BHAT","NEPALESE RUPEE","EURO","BRITISH POUNDS","QATARIRIYAL","BANGLADESHI TAKA"};        
           cb2=new JComboBox<String>(currency);    
          cb2.setBounds(350, 360,190,50);    
          f.add(cb2); 
  	  	    
        bg1=new ButtonGroup();  
      	JRadioButton r4=new JRadioButton(" Armed Forces");    
    	JRadioButton r5=new JRadioButton(" Senior citizen");   
    	JRadioButton r6=new JRadioButton(" Family & Friends");
    	JRadioButton r7=new JRadioButton(" Students");    
    	JRadioButton r8=new JRadioButton(" Minor");   
    	JRadioButton r9=new JRadioButton(" Doctors & Nurses");
    	r4.setBounds(150, 420,140,60);    
    	r5.setBounds(300,420,140,60);    
    	r6.setBounds(450,420,140,60); 
    	r7.setBounds(150,460,140,60);    
    	r8.setBounds(300,460,140,60);    
    	r9.setBounds(450,460,140,60); 
    	
    	b=new JButton("Search");
    	b.setBounds(450,530, 140, 40);
        f.add(b);
        
	    b.addActionListener(this); 
	
    bg1.add(r9);bg1.add(r4);bg1.add(r5);bg1.add(r6);bg1.add(r7);bg1.add(r8);
    	f.add(l);f.add(r4);f.add(r5);f.add(r6);f.add(r7);f.add(r8);f.add(r9);	
    	f.add(l1);f.add(l2);f.add(dc);f.add(dc1);
    	f.add(t);f.add(l3);f.add(l4);f.add(t);
    	
    	f.setLocation(180, 80);
    	f.setSize(750,650);
    	f.setLayout(null);
    	f.setVisible(true);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    

    }
    
    public static void main(String args [])
    {
    	new Main_page();
    }

 public void a()
 {    
     f.setVisible(false);
	 JFrame f1;    
 JTable jt;
 int row=10;
 String[][] data =  new String[row][5];
String[] cname = {"Flight_NO","DEPARTURE","ARRIVAL","ORIGIN","DESTINATION"};
    f1=new JFrame();    
     
    String s,s1;
    s=cb.getSelectedItem().toString();
    s1=cb1.getSelectedItem().toString();
    int counter = 0;
    
 	 Main_page_db.displayDB(s,s1,data);
 	 
 	 for(int i = 0;i < 4; i++) {
 		 if(data[i][0]==null)
 			 break;
 			 counter++;
          }

 	 String  data2[][]=new String[counter][5];
 	 for(int i = 0;i < counter; i++) {
		 for(int k=0;k<5;k++)
			 {

				 data2[i][k]=data[i][k];
			 }
		 
		 }

 	 f1.setLocation(180, 80);
     f1.setSize(500,500); 
     jt=new JTable(data2,cname);    
     jt.setBounds(60,40,380,400);   
     
     
     jt.setGridColor(Color.orange);
     JScrollPane sp=new JScrollPane(jt);    
     f1.add(sp);         
 	 f1.setVisible(true);
 }
    
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==b)
		 {     String g1=new String(t.getText()); 
		
		 String s,s1;
		    s=cb.getSelectedItem().toString();
		    s1=cb1.getSelectedItem().toString();
		    Date d=dc1.getDate();
		   if(d.before(date))
		   {
			   JOptionPane.showMessageDialog(f,"This is not possible","Alert",JOptionPane.WARNING_MESSAGE);
		   }
		   else if(s.equals(s1))
		    {

				 JOptionPane.showMessageDialog(f,"Origin and Destination Is Same","Alert",JOptionPane.WARNING_MESSAGE);  
				
		    }
		   else if(g1.isEmpty())
			 {
				 JOptionPane.showMessageDialog(f,"FIELD IS EMPTY!!!","Alert",JOptionPane.WARNING_MESSAGE);  
			 }
			 else
			 a();		
		 }
		
	}
}
