
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;



public class Department extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;
    
    Department(){
        getContentPane().setBackground(Color.white);
        
       
        table = new JTable();
        table.setBounds(0,40,700,280);
        add(table);
        
        JLabel lb1 = new JLabel("Department");
        lb1.setBounds(0,10,100,20);
        add(lb1);
        
        JLabel lb2 = new JLabel("Budget");
        lb2.setBounds(350,10,100,20);
        add(lb2);
        
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
                
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(250,350,120,30);
        back.addActionListener(this);
        add(back);
        
        
        setLayout(null);
        setBounds(100,100,700,480);
        setVisible(true);
        
        addWindowListener (new WindowAdapter() {  
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        }); 
    } 
    
    public static void main(String args[]){
        new Department();
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
