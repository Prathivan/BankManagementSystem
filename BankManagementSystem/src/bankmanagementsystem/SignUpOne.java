package bankmanagementsystem;

import javax.swing.*;  // for JFrame
import java.awt.*;  // for colour
import java.util.*; // for random numbers
import java.awt.event.*;  // for action listener

public class SignUpOne extends JFrame implements ActionListener{
long random;
JTextField nameTextField,fnameTextField,dobTextField,mailTextField,addressField,cityTextField,stateTextField,pincodeTextField;
JButton next;
JRadioButton male,female,single,married;
   SignUpOne()  {
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(95, 0, 100, 100);
        add(l14);
       
       Random ran=new Random();
       random=Math.abs(ran.nextLong()%9000L)+1000L;
                                                                    /*
                                                                    Math.abs - for +values(-value convert to positive)
                                                                    ran.nextLong() - Generate random numbers 
                                                                    %9000L)+1000L - for get 4 digit or get small values
                                                                     */
       JLabel formNo=new JLabel("Application No "+random);
       formNo.setFont(new Font("Raleyway",Font.BOLD,35));
       formNo.setBounds(220,10,600,40);
       add(formNo);
       
       JLabel personalDetails=new JLabel("Page.1 PERSONAL DETAILS ");
       personalDetails.setFont(new Font("Raleway",Font.BOLD,20));
       personalDetails.setBounds(250,50,500,30);
       add(personalDetails);
       
       JLabel name=new JLabel("Name :");
       name.setFont(new Font("raleway",Font.BOLD,20));
       name.setBounds(100,100,100,20);
       add(name);
        nameTextField=new JTextField();
       nameTextField.setFont(new Font("Raleway",Font.BOLD,18));
       nameTextField.setBounds(300,100,400,25);
       add(nameTextField);
       
       
       JLabel fname=new JLabel("Father Name :");
       fname.setFont(new Font("Raleway",Font.BOLD,20));
       fname.setBounds(100,150,200,20);
       add(fname);
        fnameTextField=new JTextField();
       fnameTextField.setFont(new Font("Raleway",Font.BOLD,18));
       fnameTextField.setBounds(300,150,400,25);
       add(fnameTextField);
       
       
       JLabel dob=new JLabel("Date Of Birth :");
       dob.setFont(new Font("Raleway",Font.BOLD,20));
       dob.setBounds(100,200,200,20);
       add(dob);
        dobTextField=new JTextField();
       dobTextField.setFont(new Font("Raleway",Font.BOLD,18));
       dobTextField.setBounds(300,200,400,25);
       add(dobTextField);
       
       
       
       JLabel gender=new JLabel("Gender :");
       gender.setFont(new Font("Raleway",Font.BOLD,20));
       gender.setBounds(100,250,200,20);
       add(gender);
        male=new JRadioButton("Male");   // set jradio button
       male.setBounds(300,250,60,30);
       male.setBackground(Color.white);  // set match bgcolour as table bg colour
       add(male);
        female=new JRadioButton("Female");
       female.setBounds(500,250,80,30);
       female.setBackground(Color.white);
       add(female);
       ButtonGroup genderButton=new ButtonGroup(); // buttonGroup for select any one option
       genderButton.add(male);
       genderButton.add(female);
       
       
       
       JLabel mail=new JLabel("Email :");
       mail.setFont(new Font("Raleway",Font.BOLD,20));
       mail.setBounds(100,300,200,20);
       add(mail);
        mailTextField=new JTextField();
       mailTextField.setFont(new Font("Raleway",Font.BOLD,18));
       mailTextField.setBounds(300,300,400,25);
       add(mailTextField);
       
       
       JLabel mstatus=new JLabel("Marital Status :");
       mstatus.setFont(new Font("Raleway",Font.BOLD,20));
       mstatus.setBounds(100,350,200,20);
       add(mstatus);
        single=new JRadioButton("Single");
       single.setBounds(300,345,100,40);
       single.setBackground(Color.white);
       add(single);
        married=new JRadioButton("Married");
       married.setBounds(500,345,100,40);
       married.setBackground(Color.white);
       add(married);
       ButtonGroup marital=new ButtonGroup();
       marital.add(married);
       marital.add(single);
       
       
       JLabel address=new JLabel("Address :");
       address.setFont(new Font("Raleway",Font.BOLD,20));
       address.setBounds(100,400,200,20);
       add(address);
        addressField=new JTextField();
       addressField.setBounds(300,400,400,65);
       add(addressField);
       
       
       JLabel city=new JLabel("City :");
       city.setFont(new Font("Raleway",Font.BOLD,20));
       city.setBounds(100,470,200,20);
       add(city);
         cityTextField=new JTextField();
       cityTextField.setFont(new Font("Raleway",Font.BOLD,18));
       cityTextField.setBounds(300,470,400,25);
       add(cityTextField);
       
       
       JLabel state=new JLabel("State :");
       state.setFont(new Font("Raleway",Font.BOLD,20));
       state.setBounds(100,520,200,20);
       add(state);
        stateTextField=new JTextField();
       stateTextField.setFont(new Font("Raleway",Font.BOLD,18));
       stateTextField.setBounds(300,520,400,25);
       add(stateTextField);
       
       JLabel pincode=new JLabel("Pincode :");
       pincode.setFont(new Font("Raleway",Font.BOLD,20));
       pincode.setBounds(100,570,200,20);
       add(pincode);
         pincodeTextField=new JTextField();
       pincodeTextField.setFont(new Font("Raleway",Font.BOLD,18));
       pincodeTextField.setBounds(300,570,400,25);
       add(pincodeTextField);
       
        next=new JButton("Next");
       next.setFont(new Font("TimesNewRoman",Font.BOLD,20));
       next.setBackground(Color.black);
       next.setForeground(Color.white);
       next.setBounds(600,620,100,50);
       next.addActionListener(this);
       add(next);
                                                                 
       
       getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae){
       String formNo=""+random;// for long
       String name=nameTextField.getText();
       String fname=fnameTextField.getText();
       String dob=dobTextField.getText();
       String gender=null;
       if(male.isSelected()){
           gender="Male";
       }else if(female.isSelected()){
           gender="Female";
       }
       String mail=mailTextField.getText();
       String mstatus=null;
       if(single.isSelected()){
           mstatus="Single";
       }else if(married.isSelected()){
           mstatus="Married";
       }
       String address=addressField.getText();
       String city=cityTextField.getText();
       String state=stateTextField.getText();
       String pincode=pincodeTextField.getText();
       
       try{
           if(name.equals("")){
               JOptionPane.showMessageDialog(null,"Name is Mandatory");
           }else{
               cnn c=new cnn();  // create connection 
               String query="insert into signup values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+mail+"','"+mstatus+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                                                        /*
                                                        ('" , "')these two symbol denoted by String
                                                        query to save value in table
                                                        */
               c.s.executeUpdate(query); //
               
               setVisible(false);
               new signUpTwo(formNo).setVisible(true);
               
         }
       }catch(Exception e){
           System.out.println(e);
           
       }
   }
    
    
    public static void main(String[] args) {
        new SignUpOne();
    }

}
