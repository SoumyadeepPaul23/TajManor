
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener {

    JButton newcustomer,rooms,department,allemployee,customer,manager,checkout,update,roomstatus,pickup,searchroom,logout;
    
    Reception(){
            
        getContentPane().setBackground(Color.WHITE);
        
        newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(10, 30, 200, 30);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.setBackground(Color.black);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setForeground(Color.WHITE);
        rooms.setBackground(Color.black);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setForeground(Color.WHITE);
        department.setBackground(Color.black);
        department.addActionListener(this);
        add(department);
        
        allemployee = new JButton("All Employee");
        allemployee.setBounds(10, 150, 200, 30);
        allemployee.setForeground(Color.WHITE);
        allemployee.setBackground(Color.black);
        allemployee.addActionListener(this);
        add(allemployee);
        
        
        customer = new JButton("Customer Info");
        customer.setBounds(10, 190, 200, 30);
        customer.setForeground(Color.WHITE);
        customer.setBackground(Color.black);
        customer.addActionListener(this);
        add(customer);
        
        manager = new JButton("Manager");
        manager.setBounds(10, 230, 200, 30);
        manager.setForeground(Color.WHITE);
        manager.setBackground(Color.black);
        manager.addActionListener(this);
        add(manager);
        
        checkout = new JButton("Check out");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.black);
        checkout.addActionListener(this);
        add(checkout);
        
        update = new JButton("Update");
        update.setBounds(10, 310, 200, 30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.black);
        update.addActionListener(this);
        add(update);
        
        
        roomstatus = new JButton("Update Room Status");
        roomstatus.setBounds(10, 350, 200, 30);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.setBackground(Color.black);
        roomstatus.addActionListener(this);
        add(roomstatus);
        
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setForeground(Color.WHITE);
        pickup.setBackground(Color.black);
        pickup.addActionListener(this);
        add(pickup);
        
        searchroom = new JButton("Search Rooms");
        searchroom.setBounds(10, 430, 200, 30);
        searchroom.setForeground(Color.WHITE);
        searchroom.setBackground(Color.black);
        searchroom.addActionListener(this);
        add(searchroom);
        
        logout = new JButton("Logout");
        logout.setBounds(10, 470, 200, 30);
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.black);
        logout.addActionListener(this);
        add(logout);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        
        setBounds(100,100,800,570);
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
        new Reception();
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == newcustomer)
        {
            setVisible(false);
            new Addcustomer();
        }
        else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource() == department){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == allemployee){
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource() == manager){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource() == customer){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource() == searchroom){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new UpdateCheckOut();
        }
         else if(ae.getSource() == roomstatus){
            setVisible(false);
            new UpdateRoom();
        }
         else if(ae.getSource() == pickup){
            setVisible(false);
            new PickUpService();
        }
        else if(ae.getSource() == checkout){
            setVisible(false);
            new CheckOut();
        }
        else if(ae.getSource() == logout){
            setVisible(false);
            System.exit(0);
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
