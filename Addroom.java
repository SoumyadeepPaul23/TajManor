
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addroom extends JFrame implements ActionListener {
        
        JTextField tfroom,tfprice;
        JComboBox availablecombo,cleancombo,typecombo;
        JButton add,cancel;
    
    Addroom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
         JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Room Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);
        
        String availableoptions[] ={"Available","Occupied"};
        availablecombo = new JComboBox(availableoptions);
        availablecombo.setBackground(Color.WHITE);
        availablecombo.setBounds(200,130,150,30);
        add(availablecombo);
        
        
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);
        
        String cleanoptions[] ={"Clean","Dirty"};
        cleancombo = new JComboBox(cleanoptions);
        cleancombo.setBackground(Color.WHITE);
        cleancombo.setBounds(200,180,150,30);
        add(cleancombo);
        
        
        JLabel lblprice = new JLabel("Room Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        
        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);
        
        String typeoptions[] ={"Single Bed","Double Bed"};
        typecombo = new JComboBox(typeoptions);
        typecombo.setBackground(Color.WHITE);
        typecombo.setBounds(200,280,150,30);
        add(typecombo);
        
        add = new JButton("Add Room");
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        setBounds(100,100,940,470);
        setVisible(true);
        
        addWindowListener (new WindowAdapter() {  
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        }); 
        
    }
    
    public static void main(String args[]){
        new Addroom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == add){
            
            String roomnumber = tfroom.getText();
            String price = tfprice.getText();
            String availability = (String)availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String type = (String) typecombo.getSelectedItem();
            
            try{
                Conn c = new Conn();
                
                String str = "INSERT INTO room values( '"+roomnumber+"', '"+availability+"', '"+status+"','"+price+"', '"+type+"')";
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New room added successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
