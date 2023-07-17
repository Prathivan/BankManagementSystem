package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;  //global button
    JTextField cardTextField;
    JPasswordField pinPasswordField;
    Login() {
        setTitle("AUTOMATED TELLER MACHINE"); // title displayed in outer pannel
        
        setLayout(null);   // disable default position
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));  //to get image as input
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  //rescale the image
        ImageIcon i3=new ImageIcon(i2); //i2 get error so we give ImageIcon new name
        JLabel lable=new JLabel(i3);    //set name label as i3 
        lable.setBounds(70,10,100,100);  //set the poision to display logo
        add(lable);  //comand to add img at panel
        
        JLabel text=new JLabel("Welcome to ATM "); //Heading displayed inside pannel
        text.setFont(new Font("TimesNewRoman",Font.BOLD,50)); //customize the font
        text.setBounds(250, 40, 500, 40); //Locate the font
        add(text);  //comand to add text at panel
        
        JLabel cardNo=new JLabel("Card No : "); 
        cardNo.setFont(new Font("TimesNewRoman",Font.BOLD,15)); 
        cardNo.setBounds(70, 150, 100, 40); 
        add(cardNo);
        cardTextField=new JTextField(); //insert textfield 
        cardTextField.setBounds(200, 150, 300, 40); //custommize textfield
        add(cardTextField);
        
        
        JLabel pin=new JLabel("PIN : "); 
        pin.setFont(new Font("TimesNewRoman",Font.BOLD,15)); 
        pin.setBounds(105, 200, 100, 40); 
        add(pin);
        pinPasswordField=new JPasswordField(); //insert Passwordfield 
        pinPasswordField.setBounds(200, 200, 300, 40); //custommize Passwordfield 
        add(pinPasswordField);
        
        
        login=new JButton("SIGN IN"); //add Signin button
        login.setBounds(200,300 ,100 , 50); //customize the button
        login.setForeground(Color.green); // Text colour clange
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(400,300 ,100 , 50);
        clear.setForeground(Color.red);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGNUP");
        signup.setBounds(200,370 ,300 , 50);
        signup.setBackground(Color.black); // change baground Colour
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.pink);  // change the colour of pannel  
        setSize(800,480);  // display panel size
        setVisible(true);  // comand as panel visibility
        setLocation(350,200);  // set location to open the pannel
        
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){  //ae as actionEvent,click signup button execute this line
            cnn c=new cnn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinPasswordField.getText();
            String query="select * from login where card_number='"+cardnumber+"'and pin_number='"+pinnumber+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);
            }else{
                    JOptionPane.showMessageDialog(null,"incorrect cardno or pin");
                }
                 }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==clear){
            cardTextField.setText("");
            pinPasswordField.setText("");
        }else if(ae.getSource()==signup){
           
            setVisible(false);
            new SignUpOne().setVisible(true);
            
        }
    }
    public static void main(String[] args) {

        new Login();
    }
}

  
