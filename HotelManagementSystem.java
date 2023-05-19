
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem(){
        setSize(1366,565);
        setLocation(10,100);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000 ,50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150,450 , 150, 50);
        next.setBackground(Color.WHITE);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,24));
        image.add(next);
             
        setVisible(true);
        
        addWindowListener (new WindowAdapter() {  
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        }); 
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
         setVisible(false);
         new Login();
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    public static void main(String[] args) {
       
        new HotelManagementSystem();
    }
   
}
