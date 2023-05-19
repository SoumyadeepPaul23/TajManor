
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;



public class Room extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;
    
    Room(){
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        table = new JTable();
        table.setBounds(10,40,500,400);
        add(table);
        
        JLabel lb1 = new JLabel("Room Number");
        lb1.setBounds(10,10,100,20);
        add(lb1);
        
        JLabel lb2 = new JLabel("Availibility");
        lb2.setBounds(120,10,100,20);
        add(lb2);
        
        JLabel lb3 = new JLabel("Cleaning Status");
        lb3.setBounds(210,10,100,20);
        add(lb3);
        
        JLabel lb4 = new JLabel("Price");
        lb4.setBounds(310,10,100,20);
        add(lb4);
        
        JLabel lb5 = new JLabel("Bed Type");
        lb5.setBounds(410,10,100,20);
        add(lb5);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
                
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        add(back);
        
        
        setLayout(null);
        setBounds(100,100,1050,600);
        setVisible(true);
        
        addWindowListener (new WindowAdapter() {  
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        }); 
    }
    
    public static void main(String args[]){
        new Room();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Reception();
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
