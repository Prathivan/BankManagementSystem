package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class balanceEnquiry extends JFrame implements ActionListener {
JButton  back;
String pinnumber;
     balanceEnquiry(String pinnumber){
         this.pinnumber=pinnumber;
         setLayout(null);
         
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);

       back=new JButton("BACK");
       back.setBounds(358,480,160,30);
       back.addActionListener(this);
       image.add(back);
       cnn c=new cnn();
       int balance=0;
       try{
       ResultSet rs=c.s.executeQuery("select * from bank where pin_number='"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("deposite")){
                    balance +=Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -=Integer.parseInt(rs.getString("amount"));
                }
            }
       }catch(Exception e){
                System.out.println(e);
            }
       
       JLabel text1=new JLabel("YOUR ACCOUNT BALANCE IS");
       text1.setForeground(Color.white);
       text1.setFont(new Font("TimesNewRoman",Font.BOLD,18));
       text1.setBounds(190,300,400,20);
       image.add(text1);
       JLabel text2=new JLabel("Rs :"+balance);
       text2.setForeground(Color.white);
       text2.setFont(new Font("TimesNewRoman",Font.BOLD,18));
       text2.setBounds(250,340,400,20);
       image.add(text2);
       
       
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         setVisible(false);
         new transactions(pinnumber).setVisible(true);
     }
    
    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}

