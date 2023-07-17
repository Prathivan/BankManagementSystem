package bankmanagementsystem;

import javax.swing.*;    
import java.awt.*;  
import java.awt.event.*;

public class signUpTwo extends JFrame implements ActionListener{

    JTextField panTextField,adarTextField;
JButton next;
JRadioButton syes,sno,eyes,eno;
String formNo;
JComboBox religionjc,incomejc,qualificationjc,occupatiojc;  //jcombo & dropdownbutton are same

   signUpTwo(String formNo)  {
       this.formNo=formNo;
       setLayout(null);
       
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(120, 0, 100, 100);
        add(l14);
       
       JLabel AdditionalDetails=new JLabel("Page.2 ADDITIONAL DETAILS ");
       AdditionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
       AdditionalDetails.setBounds(250,40,500,30);
       add(AdditionalDetails);
       JLabel form1=new JLabel("Form No.");
       form1.setFont(new Font("Raleway",Font.BOLD,20));
       form1.setBounds(600,10,100,30);
       add(form1);
         JLabel form2=new JLabel(formNo);
       form2.setFont(new Font("Raleway",Font.BOLD,20));
       form2.setBounds(690,10,100,30);
       add(form2);
       
       JLabel religion=new JLabel("Religion :");
       religion.setFont(new Font("raleway",Font.BOLD,20));
       religion.setBounds(100,100,100,20);
       add(religion);   
       String ValReligion[]={"HINDU","MUSLIM","CRISTIAN","OTHER"};//content show in drop down button
        religionjc=new JComboBox(ValReligion);  //set dropdown button
       religionjc.setBounds(300,100,420,25);
       religionjc.setBackground(Color.white);
       add(religionjc); 
       
       JLabel income=new JLabel("Income :");
       income.setFont(new Font("Raleway",Font.BOLD,20));
       income.setBounds(100,150,200,20);
       add(income);
       String Valincome[]={"SALARIED","self","STUDENT","OTHER"};
        incomejc=new JComboBox(Valincome);
       incomejc.setBounds(300,150,420,25);
       incomejc.setBackground(Color.white);
       add(incomejc); 
       
       
          JLabel qualification1=new JLabel("Educational");
       qualification1.setFont(new Font("Raleway",Font.BOLD,20));
       qualification1.setBounds(100,200,200,20);
       add(qualification1);
          JLabel qualification2=new JLabel(" Qualification :");
       qualification2.setFont(new Font("Raleway",Font.BOLD,20));
       qualification2.setBounds(110,225,200,20);
       add(qualification2);
        String ValQualification[]={"PG","UG","DIPLAMO","OTHER"};
        qualificationjc=new JComboBox(ValQualification);
       qualificationjc.setBounds(300,210,420,25);
       qualificationjc.setBackground(Color.white);
       add(qualificationjc); 
      
       
       JLabel occupation=new JLabel("Occupation :");
       occupation.setFont(new Font("Raleway",Font.BOLD,20));
       occupation.setBounds(100,320,200,20);
       add(occupation);
       String Valoccupation[]={"FARMER","BUSINESS","EMPLOYEE","OTHER"};
        occupatiojc=new JComboBox(Valoccupation);
       occupatiojc.setBounds(300,320,420,25);
       occupatiojc.setBackground(Color.white);
       add(occupatiojc); 
       
       
        JLabel pan=new JLabel("Pan Number :");
       pan.setFont(new Font("Raleway",Font.BOLD,20));
       pan.setBounds(100,420,200,20);
       add(pan);
         panTextField=new JTextField();
       panTextField.setFont(new Font("Raleway",Font.BOLD,18));
       panTextField.setBounds(300,420,400,25);
       add(panTextField);
       
       
       JLabel adar=new JLabel("Adar :");
       adar.setFont(new Font("Raleway",Font.BOLD,20));
       adar.setBounds(100,470,200,20);
       add(adar);
        adarTextField=new JTextField();
       adarTextField.setFont(new Font("Raleway",Font.BOLD,18));
       adarTextField.setBounds(300,470,400,25);
       add(adarTextField);
       
       JLabel seniorcitizen=new JLabel("Senior Citizen :");
       seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
       seniorcitizen.setBounds(100,270,200,20);
       add(seniorcitizen);
        syes=new JRadioButton("Yes");   // set jradio button
       syes.setBounds(300,270,60,30);
       syes.setBackground(Color.white);  // set match bgcolour as table bg colour
       add(syes);
        sno=new JRadioButton("No");
       sno.setBounds(500,270,80,30);
       sno.setBackground(Color.white);
       add(sno);
       ButtonGroup genderButton=new ButtonGroup(); // buttonGroup for select any one option
       genderButton.add(syes);
       genderButton.add(sno);
       
       
       JLabel exacc=new JLabel("Existing Account  :");
       exacc.setFont(new Font("Raleway",Font.BOLD,20));
       exacc.setBounds(100,370,200,20);
       add(exacc);
        eyes=new JRadioButton("yes");
       eyes.setBounds(300,365,100,40);
       eyes.setBackground(Color.white);
       add(eyes);
        eno=new JRadioButton("No");
       eno.setBounds(500,365,100,40);
       eno.setBackground(Color.white);
       add(eno);
       ButtonGroup marital=new ButtonGroup();
       marital.add(eyes);
       marital.add(eno);
       
       
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
       String religion=(String) religionjc.getSelectedItem();
       String income=(String)incomejc.getSelectedItem();
       String qualification=(String)qualificationjc.getSelectedItem();
        String occupation=(String)occupatiojc.getSelectedItem();
       String pan=panTextField.getText();
       String adar=adarTextField.getText();
       String seniorcitizen=null;
       if(syes.isSelected()){
           seniorcitizen="Yes";
       }else if(sno.isSelected()){
           seniorcitizen="No";
       }
       String exacc=null;
       if(eyes.isSelected()){
           exacc="Yes";
       }else if(eno.isSelected()){
           exacc="No";
       }
      
       
       try{
           if(pan.equals("")){
               JOptionPane.showMessageDialog(null," pan is Mandatory");
           }else{
               cnn c=new cnn();
               String query="insert into signuptwo values('"+formNo+"','"+religion+"','"+income+"','"+qualification+"','"+occupation+"','"+pan+"','"+adar+"','"+seniorcitizen+"','"+exacc+"')";
               c.s.executeUpdate(query);
               
             setVisible(false);
             new SignUpThree(formNo).setVisible(true);
           }
           
       }catch(Exception e){
           System.out.println(e);
           
       }
   }
    
    
    public static void main(String[] args) {
        new signUpTwo("");
    }
}

