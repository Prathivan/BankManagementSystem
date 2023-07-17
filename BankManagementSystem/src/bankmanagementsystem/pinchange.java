
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener{
    JTextField t1,t2;
    JButton j1,j2;
    String pinnumber;
 pinchange(String pinnumber){
     this.pinnumber=pinnumber;
    setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text1=new JLabel("CHANGE YOUR PIN");
       text1.setFont(new Font("TimesNewRoman",Font.BOLD,20));
       text1.setForeground(Color.white);
       text1.setBounds(250,300,300,20);
       image.add(text1);
       
       
        JLabel text2=new JLabel("ENTER NEW PIN :");
       text2.setFont(new Font("TimesNewRoman",Font.BOLD,15));
       text2.setForeground(Color.white);
       text2.setBounds(155,350,150,20);
       image.add(text2);
       t1=new JTextField();
       t1.setBounds(300,350,200,20);
       image.add(t1);
       
       
       JLabel text3=new JLabel("RE-ENTER PIN :");
       text3.setFont(new Font("TimesNewRoman",Font.BOLD,15));
       text3.setForeground(Color.white);
       text3.setBounds(155,400,150,20);
       image.add(text3);
       t2=new JTextField();
       t2.setBounds(300,400,200,20);
       image.add(t2);
       
         j1=new JButton("SUBMIT");
       j1.setFont(new Font("TimesNewRoman",Font.BOLD,13));
       j1.setBounds(350,450,150,40);
       j1.addActionListener(this);
       image.add(j1);
         j2=new JButton("CANCEL");
       j2.setFont(new Font("TimesNewRoman",Font.BOLD,13));
       j2.setBounds(350,500,150,40);
       j2.addActionListener(this);
       image.add(j2);
       
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
       
}   
  
 public void actionPerformed(ActionEvent ae){
     
     if(ae.getSource()==j1){
 
    try{
        String npin=t1.getText();
        String rpin=t2.getText();
        
        if(npin.equals("")){
            JOptionPane.showMessageDialog(null, "PLEASE ENTER NEW PIN");
            return;
        }
        if(rpin.equals("")){
            JOptionPane.showMessageDialog(null, "PLEASE ENTER RE-ENTER PIN");
            return;
        }
        if(!npin.equals(rpin)){
            JOptionPane.showMessageDialog(null, "ENTERED PIN DOES't MATCH");
            return;
        }
        
        cnn c=new cnn();
        String query1="update bank set pin_number='"+rpin+"' where pin_number='"+pinnumber+"'";
        String query2="update login set pin_number='"+rpin+"' where pin_number='"+pinnumber+"'";
        String query3="update signupthree set pin_number='"+rpin+"' where pin_number='"+pinnumber+"'";
        
        c.s.executeUpdate(query1);
        c.s.executeUpdate(query2);
        c.s.executeUpdate(query3);
        JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY");
        
        setVisible(false);
        new transactions(pinnumber).setVisible(true);
        
    }catch(Exception e){
        System.out.println(e);
    }
}else {
         setVisible(false);
         new transactions(pinnumber).setVisible(true);
     }
 }
    public static void main(String[] args) {
        new pinchange("");
    }
}
