
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;



public class SearchRoom extends JFrame implements ActionListener {
    
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("Search For Rooms");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
      
        String opt[] = {"Single Bed","Double Bed"};
        bedtype = new JComboBox(opt);
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.white);
        add(bedtype);
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.white);
        add(available);
        
        
        
        
        
        
        
        JLabel lb1 = new JLabel("Room Number");
        lb1.setBounds(50,160,100,20);
        add(lb1);
        
        JLabel lb2 = new JLabel("Availibility");
        lb2.setBounds(270,160,100,20);
        add(lb2);
        
        JLabel lb3 = new JLabel("Cleaning Status");
        lb3.setBounds(450,160,100,20);
        add(lb3);
        
        JLabel lb4 = new JLabel("Price");
        lb4.setBounds(670,160,100,20);
        add(lb4);
        
        JLabel lb5 = new JLabel("Bed Type");
        lb5.setBounds(870,160,100,20);
        add(lb5);
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
           
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setBounds(300,500,120,30);
        submit.addActionListener(this);
        add(submit);
        
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(500,500,120,30);
        back.addActionListener(this);
        add(back);
        
        
        setLayout(null);
        setBounds(100,100,1000,600);
        setVisible(true);
        
        addWindowListener (new WindowAdapter() {  
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        }); 
    }
    
    public static void main(String args[]){
        new SearchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Reception();
        }
        else{
            
            try{
                Conn c = new Conn();
                
                String query1 = "select * from room where bed_type = '"+bedtype.getSelectedItem()+"'";
                String query2 = "select * from room where availablility = 'Available' AND bed_type = '"+bedtype.getSelectedItem()+"'";
                ResultSet rs;
                if(available.isSelected())
                {
                    rs = c.s.executeQuery(query2);
                }
                else
                {
                    rs = c.s.executeQuery(query1);
                }
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
