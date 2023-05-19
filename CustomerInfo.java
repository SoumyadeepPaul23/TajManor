
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;



public class CustomerInfo extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;
    
    CustomerInfo(){
        getContentPane().setBackground(Color.white);
        
        
        
        table = new JTable();
        table.setBounds(10,40,1050,400);
        add(table);
        
        JLabel lb1 = new JLabel("Document Type");
        lb1.setBounds(0,10,100,20);
        add(lb1);
        
        JLabel lb2 = new JLabel("Document Number");
        lb2.setBounds(160,10,100,20);
        add(lb2);
        
        JLabel lb3 = new JLabel("Name");
        lb3.setBounds(290,10,100,20);
        add(lb3);
        
        JLabel lb4 = new JLabel("Gender");
        lb4.setBounds(400,10,100,20);
        add(lb4);
        
        JLabel lb5 = new JLabel("Country");
        lb5.setBounds(540,10,100,20);
        add(lb5);
        
        JLabel lb6 = new JLabel("Room");
        lb6.setBounds(670,10,100,20);
        add(lb6);
        
        JLabel lb7 = new JLabel("Check In Time");
        lb7.setBounds(800,10,100,20);
        add(lb7);
        
        JLabel lb8 = new JLabel("Deposit");
        lb8.setBounds(950,10,100,20);
        add(lb8);
        
    
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
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
        new CustomerInfo();
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
