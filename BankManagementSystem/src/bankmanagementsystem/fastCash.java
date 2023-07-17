package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class fastCash extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,exit;
    String pinnumber;
    fastCash(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
        
          JLabel text=new JLabel("SELECT WITHDRAW AMOUNT");
        text.setBounds(220,300,400,15);
        text.setForeground(Color.white);
        text.setFont(new Font("TimesNewRoman",Font.BOLD,15));
        img.add(text);
          b1=new JButton("RS 100");
        b1.setBounds(156,420,160,30);
        b1.addActionListener(this);
        img.add(b1);
          b2=new JButton("RS 500");
        b2.setBounds(156,450,160,30);
        b2.addActionListener(this);
        img.add(b2);
          b3=new JButton("RS 1000");
        b3.setBounds(156,480,160,30);
        b3.addActionListener(this);
        img.add(b3);
          b4=new JButton("RS 2000");
        b4.setBounds(358,420,160,30);
        b4.addActionListener(this);
        img.add(b4); 
        b5=new JButton("RS 5000");
        b5.setBounds(358,450,160,30);
        b5.addActionListener(this);
        img.add(b5);
          b6=new JButton("RS 10000");
        b6.setBounds(358,480,160,30);
        b6.addActionListener(this);
        img.add(b6);
          exit=new JButton("EXIT");
        exit.setBounds(358,510,160,30);
        exit.addActionListener(this);
        img.add(exit);
        
        setSize(900,900);
        setLocation(300,10);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
              setVisible(false);
            new transactions(pinnumber).setVisible(true);        
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            cnn c=new cnn(); 
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin_number='"+pinnumber+"'");
            int balance=0;
            while(rs.next()){
                if(rs.getString("type").equals("deposite")){
                    balance +=Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -=Integer.parseInt(rs.getString("amount"));
                }
            }
            
            if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
            JOptionPane.showMessageDialog(null, "INUSUFFICIENT BALANCE");
            return;}
            Date date=new Date();
            String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs."+amount+"Debit Sucessfully");
                setVisible(false);
                new transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }   
   
    }
    
    public static void main(String args[]) {
        new fastCash("");
    }
}

