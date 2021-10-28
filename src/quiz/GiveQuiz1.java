package quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GiveQuiz1 implements ActionListener {
    static JFrame frame;
    JPanel panel;
    JLabel lquestion;
    JRadioButton ra,rb,rc,rd;
    ButtonGroup bg;
    JButton bnext;
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    int count=0;
    
    GiveQuiz1() throws SQLException {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Swarali@123");
			System.out.println("Connection Succuess ....");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
          
            ResultSet rs1=stmt.executeQuery("select count(*) from quizes;");rs1.next();
            count=Integer.parseInt(rs1.getString(1));
            System.out.println(count+" count000000000");
            rs = stmt.executeQuery("select * from quizes");
                frame = new JFrame("Give Quiz");
                panel = new JPanel();
                lquestion = new JLabel();
                ra = new JRadioButton();
                rb = new JRadioButton();
                rc = new JRadioButton();
                rd = new JRadioButton();
                bg = new ButtonGroup();
                rs.next();
                lquestion.setText(rs.getString(1));
                ra.setText(rs.getString(2));
                rb.setText(rs.getString(3));
                rc.setText(rs.getString(4));
                rd.setText(rs.getString(5));
                bnext = new JButton("Next");
                bnext.addActionListener(this);
                bg.add(ra);
                bg.add(rb);
                bg.add(rc);
                bg.add(rd);
                panel.add(lquestion);
                panel.add(ra);
                panel.add(rb);
                panel.add(rc);
                panel.add(rd);
                panel.add(bnext);
                frame.add(panel);
                frame.setSize(450, 250);
                frame.setVisible(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    	
        new GiveQuiz1();
    }
    public void actionPerformed(ActionEvent e)
    {
    	
        if(e.getSource()==bnext)
        {
        	System.out.println(count+"count");
            if(count>0) {
            	System.out.println(count+"count2222");
                String ans = " ";
                if (ra.isSelected())
                    ans = "A";
                if (rb.isSelected())
                    ans = "B";
                if (rc.isSelected())
                    ans = "C";
                if (rd.isSelected())
                    ans = "D";
                System.out.println("after"+ans);
                PreparedStatement pst;
                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Swarali@123");
                    pst = con.prepareStatement("insert into answers values (?);");
                    pst.setString(1, ans);
                    pst.execute();
                    pst = null;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
            try {
            	//while(rs.next())
                if(rs.next())
                {
                    count--;
                    lquestion.setText(rs.getString(1));
                    ra.setText(rs.getString(2));
                    rb.setText(rs.getString(3));
                    rc.setText(rs.getString(4));
                    rd.setText(rs.getString(5));
                    System.out.println("Next Question");
                    
                }
                else
                {
                    System.out.println("Frame Diposed");
                    frame.dispose();
                    new CheckAnswer();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
      
    }

}