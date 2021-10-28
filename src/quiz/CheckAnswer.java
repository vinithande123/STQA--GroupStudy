package quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CheckAnswer implements ActionListener {
	int count=0;
    JFrame frame;
    JPanel panel;
    JLabel lscore;
    JButton bdone;
    CheckAnswer()
    {
        frame=new JFrame("Result");
        panel=new JPanel();
        lscore=new JLabel("Your Score : "+check());
        bdone=new JButton("Done");
        bdone.addActionListener(this);
        panel.add(lscore);
        panel.add(bdone);
        frame.add(panel);
        frame.setSize(250,250);
        frame.setVisible(true);
    }
    int check()
    {
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Swarali@123");
			Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from quizes");
            Statement stmt1=con.createStatement();
            ResultSet rs1=stmt1.executeQuery("select * from answers");
            String option,answer;
            System.out.println("kk");
            while(rs.next() && rs1.next())
            {
                option=rs.getString(6);
                answer=rs1.getString(1);
                System.out.println(option+" "+answer);
                //Compare Quiz Answers and selected option
                if(option.equals(answer))
                    count++;
                System.out.println(count);
                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connection Succuess ....");
        return count;
    }

    public static void main(String[] args) {
        new CheckAnswer();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bdone)
            frame.dispose();
        Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Swarali@123");
			PreparedStatement stmt=con.prepareStatement("delete from answers;");
			stmt.execute();
	        
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    }
}
