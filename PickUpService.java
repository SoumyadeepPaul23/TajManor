
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;



public class PickUpService extends JFrame implements ActionListener {
    
    JTable table;
    JButton back,submit;
    Choice cartype;
    JCheckBox available;
    PickUpService(){
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("Pick Up Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Car Type");
        lblbed.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
      
        
        cartype = new Choice();
        cartype.setBounds(150,100,150,25);
        cartype.setBackground(Color.white);
        
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                cartype.add(rs.getString("brand"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        add(cartype);
        
        
        
        
        
        
        
        
        
        JLabel lb1 = new JLabel("Name");
        lb1.setBounds(20,160,100,20);
        add(lb1);
        
        JLabel lb2 = new JLabel("Age");
        lb2.setBounds(200,160,100,20);
        add(lb2);
        
        JLabel lb3 = new JLabel("Gender");
        lb3.setBounds(330,160,100,20);
        add(lb3);
        
        JLabel lb4 = new JLabel("Company");
        lb4.setBounds(460,160,100,20);
        add(lb4);
        
        JLabel lb5 = new JLabel("Brand");
        lb5.setBounds(630,160,100,20);
        add(lb5);
        
        JLabel lb6 = new JLabel("Availablity");
        lb6.setBounds(740,160,100,20);
        add(lb6);
        
        JLabel lb7 = new JLabel("Location");
        lb7.setBounds(890,160,100,20);
        add(lb7);
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
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
        new PickUpService();
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
                
                String query1 = "select * from driver where brand = '"+cartype.getSelectedItem()+"'";
                ResultSet rs;
                
                rs = c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
