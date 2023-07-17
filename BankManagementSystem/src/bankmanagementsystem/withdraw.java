package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
public class withdraw extends JFrame implements ActionListener {
   JTextField amount;
   JButton withdrawb,back;
   String Pinnumber;
   withdraw(String pinnumber){
       this.Pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);

       JLabel text= new JLabel("ENTER THE AMOUNT YOU WANT TO Withdraw");
       text.setForeground(Color.white);
       text.setFont(new Font("TimesNewRoman",Font.BOLD,14));
       text.setBounds(170,300,400,20);
       image.add(text);
       amount=new JTextField();
       amount.setFont(new Font("TimesNewRoman",Font.BOLD,20));
       amount.setBounds(170,350,320,25);
       image.add(amount);


       withdrawb=new JButton("WITHDRAW");
       withdrawb.setBounds(370,480,150,30);
       withdrawb.addActionListener(this);
       image.add(withdrawb);
        back=new JButton("BACK");
       back.setBounds(370,515,150,30);
       back.addActionListener(this);
       image.add(back);

       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
   }
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==back){
           setVisible(false);
           new transactions(Pinnumber).setVisible(true);
       }else if(ae.getSource()==withdrawb){
           String number=amount.getText();
           Date date=new Date();
           if(number.equals("")){
               JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMMOUNT WANT TO DEPOSITE");
           }else{
               try{
                   cnn c=new cnn();
                   String query="insert into bank values('"+Pinnumber+"','"+date+"','Withdraw','"+number+"')";
                   c.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "RS :"+number+"Withdraw Sucessfully");
                   
               }catch(Exception e){
                   System.out.println(e);
               }
           }
           
       }
   }
    public static void main(String[] args) {
        new withdraw("");
    }
   
}

