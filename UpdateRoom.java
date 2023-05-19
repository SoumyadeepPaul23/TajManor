
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfroom,tfstatus,tfavailable;
    JButton check,update,back;

    UpdateRoom(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel text = new JLabel("Update Room Status");
        text.setBounds(30,20,300,20);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,20);
    //    lblid.setFont(new Font("Tahoma",Font.PLAIN,10));
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
         ResultSet rs;
        try{
            Conn c = new Conn();
            
            rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        add(ccustomer);
        
        JLabel lblname = new JLabel("Room");
        lblname.setBounds(30,120,100,20);
       // lblname.setFont(new Font("Tahoma",Font.PLAIN,10));
        add(lblname);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,120,100,20);
        add(tfroom);
        
        JLabel lblroom = new JLabel("Availability");
        lblroom.setBounds(30,160,100,20);
   //     lblroom.setFont(new Font("Tahoma",Font.PLAIN,10));
        add(lblroom);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(200,160,100,20);
        add(tfavailable);
        
        JLabel lblcheckin = new JLabel("Cleaning Status");
        lblcheckin.setBounds(30,200,100,20);
       // lblcheckin.setFont(new Font("Tahoma",Font.PLAIN,10));
        add(lblcheckin);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(200,200,100,20);
        add(tfstatus);
        
        
        
        
        check = new JButton("Check");
        check.setBounds(30,340,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(150,340,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(270,340,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new  ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        
        
        setVisible(true);
        setBounds(100,100,980,450);
        
        addWindowListener (new WindowAdapter() {  
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        }); 
        
    }    
    
    public static void main(String args[]){
        new UpdateRoom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == check){
            
            try{
                
                Conn c = new Conn();
                String id = ccustomer.getSelectedItem();
                String query1 = "select * from customer where number = '"+id+"' ";
                ResultSet rs = c.s.executeQuery(query1);
                
                while(rs.next()){
                    
                    
                    tfroom.setText(rs.getString("room"));
                    
                    
                    }
                 String query2 = "select * from room where roomnumber = '"+tfroom.getText()+"' ";
                ResultSet r = c.s.executeQuery(query2);
                while(r.next()){
                    tfavailable.setText(r.getString("availablility"));
                    tfstatus.setText(r.getString("cleaning_status"));
                }
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == update){
            
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            
                   
            Conn c = new Conn();
            try{
                c.s.executeUpdate("update room set availablility = '"+tfavailable.getText()+"' , cleaning_status = '"+tfstatus.getText()+"' where roomnumber = '"+tfroom.getText()+"' ");
                
                JOptionPane.showMessageDialog(null,"Data Updated");
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
           
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
