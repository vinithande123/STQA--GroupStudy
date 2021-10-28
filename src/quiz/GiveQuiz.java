package quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GiveQuiz implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel lquestion;
    JRadioButton ra,rb,rc,rd;
    ButtonGroup bg;
    JButton bnext;

    GiveQuiz(String que,String A,String B,String C,String D)
    {
        frame=new JFrame("Start Quiz");
        panel=new JPanel();
        lquestion=new JLabel(que);
        ra=new JRadioButton(A);
        rb=new JRadioButton(B);
        rc=new JRadioButton(C);
        rd=new JRadioButton(D);
        bg=new ButtonGroup();
        bnext=new JButton("Next");
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
        frame.setSize(450,250);
        frame.setVisible(true);
        bnext.setText("next");

    }
    GiveQuiz(){
    	
    }
    GiveQuiz(String que,String A,String B,String C,String D,int a)
    {
        this(que,A,B,C,D);
        System.out.println(a);
        bnext.setText("Finish");
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       //new GiveQuiz();
    	
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	 
        String ans=" ";
        if(ra.isSelected())
            ans="A";
        if(rb.isSelected())
            ans="B";
        if(rc.isSelected())
            ans="C";
        if(rd.isSelected())
            ans="D";
        System.out.println("Your Answer : "+ans);
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Swarali@123");
			System.out.println("Connection Succuess ....");
            PreparedStatement pst=con.prepareStatement("insert into answers values (?)");
            pst.setString(1,ans);
            pst.execute();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(e.getSource()==bnext)
        {
            frame.dispose();
        }
    }
}
