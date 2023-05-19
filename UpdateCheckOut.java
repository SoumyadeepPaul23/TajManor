/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheckOut extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfroom,tfname,tfdue,tfpaid,tfcheckin,name;
    JButton check,update,back;

    UpdateCheckOut(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel text = new JLabel("Update Status");
        text.setBounds(90,20,300,20);
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
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,120,100,20);
       // lblname.setFont(new Font("Tahoma",Font.PLAIN,10));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,120,100,20);
        add(tfname);
        
        JLabel lblroom = new JLabel("Room");
        lblroom.setBounds(30,160,100,20);
   //     lblroom.setFont(new Font("Tahoma",Font.PLAIN,10));
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,160,100,20);
        add(tfroom);
        
        JLabel lblcheckin = new JLabel("Check in time");
        lblcheckin.setBounds(30,200,100,20);
       // lblcheckin.setFont(new Font("Tahoma",Font.PLAIN,10));
        add(lblcheckin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(200,200,100,20);
        add(tfcheckin);
        
        
        JLabel lblpaid = new JLabel("Paid");
        lblpaid.setBounds(30,240,100,20);
     //   lblpaid.setFont(new Font("Tahoma",Font.PLAIN,10));
        add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(200,240,100,20);
        add(tfpaid);
        
        
        JLabel lbldue = new JLabel("Due");
        lbldue.setBounds(30,280,100,20);
       // lbldue.setFont(new Font("Tahoma",Font.PLAIN,10));
        add(lbldue);
        
        tfdue = new JTextField();
        tfdue.setBounds(200,280,100,20);
        add(tfdue);
       
        
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        
        
        setVisible(true);
        setBounds(100,100,980,500);
        
        addWindowListener (new WindowAdapter() {  
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        }); 
        
    }    
    
    public static void main(String args[]){
        new UpdateCheckOut();
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
                    
                    tfname.setText(rs.getString("name"));
                    tfroom.setText(rs.getString("room"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                    
                    }
                 String query2 = "select * from room where roomnumber = '"+tfroom.getText()+"' ";
                ResultSet r = c.s.executeQuery(query2);
                while(r.next()){
                    int d =  Integer.valueOf(tfpaid.getText());
                    int pricedue = Integer.valueOf( r.getString("price")) - d;                  
                    tfdue.setText(""+pricedue);                  
                }
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == update){
            
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();
                    
            Conn c = new Conn();
            try{
                c.s.executeUpdate("update customer set room = '"+room+"' , name = '"+name+"' , checkintime = '"+checkin+"',deposit = '"+deposit+"' where number = '"+number+"' ");
                
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
