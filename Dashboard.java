/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Comp
 */
public class Dashboard extends JFrame implements ActionListener{
    JMenuItem reception,addemployee,addrooms,adddriver;
    
    Dashboard(){
        setBounds(0,0,1400,730);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1400, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1400,730);
        add(image);
        
        JLabel text = new JLabel("WELCOME TO THE TAJ");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahona",Font.PLAIN,45));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,5,1400,30);
        mb.setBackground(Color.WHITE);
        image.add(mb);
        
        JMenu hotel = new JMenu("Management");
        hotel.setForeground(Color.BLACK);
        mb.add(hotel);
        
        reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.BLACK);
        mb.add(admin);
        
        addemployee = new JMenuItem("Add Employee");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        addrooms = new JMenuItem("Add Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        adddriver = new JMenuItem("Add Driver");
        adddriver.addActionListener(this);
        admin.add(adddriver);
        
        setVisible(true);
        
        addWindowListener (new WindowAdapter() {  
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });    
        
    }
    public static void main(String args[]){
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("Add Employee")){
            new Addemployee();
        }
        else if(ae.getActionCommand().equals("Add Rooms"))
        {
            new Addroom();
        }
        else if(ae.getActionCommand().equals("Add Driver"))
        {
            new Adddriver();
        }
        else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }
        
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
