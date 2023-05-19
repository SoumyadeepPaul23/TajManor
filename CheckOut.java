
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.*;
import java.awt.event.*;

public class CheckOut extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JLabel lblcheckoutime;
    JLabel tfroom = new JLabel();
    JLabel lblcheck = new JLabel();
    JButton checkout,back,check;
    
    CheckOut(){
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Check Out");
        text.setBounds(100,10,100,30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
         ResultSet rs;
        
        add(ccustomer);

        JLabel lblname = new JLabel("Room");
        lblname.setBounds(30,120,100,20);
        add(lblname);
        
        
        tfroom.setBounds(200,120,100,20);
        add(tfroom);
        
        JLabel lblcheckin = new JLabel("Check in time");
        lblcheckin.setBounds(30,160,100,20);
        add(lblcheckin);
        
        
        lblcheck.setBounds(200,160,200,20);
        add(lblcheck);
        
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
        
        
        JLabel lblcheckout = new JLabel("Check Out time");
        lblcheckout.setBounds(30,200,100,20);
        add(lblcheckout);
        
        Date date = new Date();
        lblcheckoutime = new JLabel(""+date);
        lblcheckoutime.setBounds(200,200,200,20);
        add(lblcheckoutime);
        
        
        checkout = new JButton("Check Out");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(10,280,110,30);
        checkout.addActionListener(this);
        add(checkout);
        
        check = new JButton("Check Room");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(130,280,110,30);
        check.addActionListener(this);
        add(check);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(250,280,110,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370,60,400,250);
        add(image);
        
        
        setBounds(100,100,800,400);
        setLayout(null);
        setVisible(true);
        
        addWindowListener (new WindowAdapter() {  
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        }); 
    }
    
    public static void main(String args[]){
        new CheckOut();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == checkout){
            
            Conn c = new Conn();
            
                    String id = "";
                    String number = "";
                    String name = "";
                    String gender = "";
                    String country = "";
                    String room = "";
                    String checkinTime = "";
                    String paid = "";
         
            try{
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+ccustomer.getSelectedItem()+"' ");
                while(rs.next()){
                    id = rs.getString("document");
                    number = rs.getString("number");
                    name = rs.getString("name");
                    gender = rs.getString("gender");
                    country = rs.getString("country");
                    room = rs.getString("room");
                    checkinTime = rs.getString("checkintime");
                    paid = rs.getString("deposit");
                }
                
                String query = "insert into checkedout_customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+checkinTime+"', '"+lblcheckoutime.getText()+"' , '"+paid+"' )";
                c.s.executeUpdate(query);
                
                String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"' ";
                String query2 = "update room set availablility = 'Available' where roomnumber = '"+tfroom.getText()+"'  ";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Customer Checked Out");
                
                setVisible(false);
                new Reception();
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
        
        }
        else if(ae.getSource() == check){
            
            Conn c = new Conn();
            try{
                
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+ccustomer.getSelectedItem()+"' ");
                while(rs.next()){
                    
                    tfroom.setText(rs.getString("room"));
                lblcheck.setText(rs.getString("checkintime"));
                    
                }
            
            }
            catch(Exception e ){
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Reception();
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
