package quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ui2 implements ActionListener{
	JFrame frame;
	JPanel panel;
	JLabel fname,lname,age,address,city,state,country,gender;
	JTextField tfname,tlname,tage,tcity,tstate,tcountry;
	JButton button;
	JTextArea taddress;
	JComboBox<String> jc;
	Ui2(){
		frame=new JFrame("Registration window");
		panel=new JPanel();
		tfname=new JTextField(10);
		tlname=new JTextField(10);
		tage=new JTextField(3);
		taddress=new JTextArea(10,10);
		tcity=new JTextField(10);
		tstate=new JTextField(10);
		tcountry=new JTextField(10);
		fname=new JLabel("Enter First name:");
		lname=new JLabel("Enter Last name:");
		age=new JLabel("Enter age:");
		gender=new JLabel("Gender:");
		address=new JLabel("Enter address:");
		city=new JLabel("Enter city:");
		state=new JLabel("Enter state:");
		country=new JLabel("Enter country");
		jc=new JComboBox<>();
		jc.addItem("Male");
		jc.addItem("Female");
		jc.addItem("Other");
		button=new JButton("submit");
		button.addActionListener(this);
		panel.add(fname);
		panel.add(tfname);
		panel.add(lname);
		panel.add(tlname);
		panel.add(age);
		panel.add(tage);
		panel.add(gender);
		panel.add(jc);
		panel.add(address);
		panel.add(taddress);
		panel.add(city);
		panel.add(tcity);
		panel.add(state);
		panel.add(tstate);
		panel.add(country);
		panel.add(tcountry);
		panel.add(button);
		frame.add(panel);
		frame.setSize(250,250);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ui2();
	}
	@Override
	public void actionPerformed(ActionEvent obj) {
		String dfname="",dlname="",dage="",dgender="",daddress="",dcity="",dstate="",dcountry="";
		dfname=tfname.getText();
		dlname=tlname.getText();
		dage=tage.getText();
		dgender=(String) jc.getSelectedItem();
		daddress=taddress.getText();
		dcity=tcity.getText();
		dstate=tstate.getText();
		dcountry=tcountry.getText();
		System.out.println(dgender);
		if(obj.getSource()==button) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Swarali@123");
				PreparedStatement pr=con.prepareStatement("insert into examform values(?,?,?,?,?,?,?,?)");
				pr.setString(1, dfname);
				pr.setString(2, dlname);
				pr.setString(3,dage);
				pr.setString(4, dgender);
				pr.setString(5, daddress);
				pr.setString(6,dcity);
				pr.setString(7, dstate);
				pr.setString(8, dcountry);
				pr.execute();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			frame.dispose();
		}
	}

    public static boolean registration(String firstName, String lastName, String age, String gender,String address, String city, String state, String country) {

    	try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Swarali@123");    
            Statement s =c.createStatement();  
            String query = "Select * from examform where dfname = '"+firstName+"' and dlname = '"+lastName+"' and dage = '"+ age+"'and dgender ='"+gender+"'and daddress = '"+ address+"'and dcity ='"+city+"'and dstate = '"+ state+"'and dcountry ='"+country+"'";
        		ResultSet rs = s.executeQuery(query);
        		if(rs.next())
        			return true; 	
        	
        }catch(Exception e){ 
            System.out.println(e);
        } 
    	return false;   
    }
}
