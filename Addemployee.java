/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addemployee extends JFrame implements ActionListener{
    
    JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjobs;
    
    Addemployee(){
        setLayout(null);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblname);
        
      tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblage);
        
         tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
        
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahona",Font.PLAIN,14));
        rbmale.setBackground(Color.white);
        add(rbmale);
        
         rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,130,100,30);
        rbfemale.setFont(new Font("Tahona",Font.PLAIN,14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup(); // this is used to make the radio buttons select only one option
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("Job");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lbljob);
        
        String str[] = {"Front Desk","Porters","House Keeping","Kitchen Staff","Manager","Accountant"};
         cbjobs = new JComboBox(str); // This is used for frop down menu and all the option that i want to show in the drop down menu 
                                        //we need to pass it in the form of string alon gwith the object creation
        cbjobs.setBounds(200,180,150,30);
        cbjobs.setBackground(Color.WHITE);
        add(cbjobs);
        
        
        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblsalary);
        
         tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);
        
        
        JLabel lblphone = new JLabel("Mobile No.");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblphone);
        
         tfphone = new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);
        
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblemail);
        
         tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);
        
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60,380,120,30);
        lblaadhar.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblaadhar);
        
         tfaadhar = new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);
        
         submit = new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);       
        setBounds(100,100,850,540);
        setVisible(true);
        
        addWindowListener (new WindowAdapter() {  
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        }); 
        
        
    }
    
    public static void main(String args[]){
        new Addemployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();
        
        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Name cannot be empty");
            return;
        }
        if(phone.length()>10)
        {
            JOptionPane.showMessageDialog(null,"Enter Correct Phone Number");
            return;
        }
        if(!email.contains("@")){
            JOptionPane.showMessageDialog(null,"Enter Correct Email");
            return;
        }
        if(aadhar.length()>12){
            JOptionPane.showMessageDialog(null,"Enter Correct Aadhar Number");
            return;
        }
        String gender = null;
        if(rbmale.isSelected())
        {
            gender = "Male";
        }
        else if(rbfemale.isSelected())
        {
            gender = "Female";
        }
        
        String job = (String)cbjobs.getSelectedItem(); // this function returns the selected option in the form of Object so we needed to typecast
        
        try{
            Conn c = new Conn();
            
             String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+email+"', '"+aadhar+"')";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"Employee added Successfully");
            
            setVisible(false);
            System.exit(0);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
