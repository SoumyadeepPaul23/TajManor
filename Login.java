
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener  {
    
    JTextField username;
    JButton login,cancel;
    JPasswordField password; 
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(500,200,600,300);
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        
        username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);
        
        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
        
        setVisible(true);
        
        addWindowListener (new WindowAdapter() {  
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        }); 
    }
    public static void main(String args[]){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login){
            String user = username.getText();
            String pass = password.getText();
            
            try{
                Conn c = new Conn(); // Step 4: writing the query and executing it.
                
                String query = "select * from login where username = '"+user+"' and password = '"+pass+"'";
                
                ResultSet rs = c.s.executeQuery(query); // Step 5: executing the query ( s is the statement class object created in Conn class)
                                                              // Step 6: Closing the connection which is not that important
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                    System.out.println("Sucessfully found");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);
                    new HotelManagementSystem();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new HotelManagementSystem();
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
