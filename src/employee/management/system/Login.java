package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;

    JButton login,back;

    public  Login(){

        JLabel username = new JLabel("Username"); //Any type of text if you can visible in frame then used JLabel
        username.setBounds(40,20,100,30);
        add(username);
        //
        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel password = new JLabel("Password"); //Any type of text if you can visible in frame then used JLabel
        password.setBounds(40,70,100,30);
        add(password);
        //
        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);



        //Button
        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("BLACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(650,350,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel img1 = new JLabel(i33);
        img1.setBounds(350,10,650,350);
        add(img1);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);



        setSize(600,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){

            try {

                String username = tusername.getText();
                String password = tpassword.getText();

                conn conn = new conn();

                String query = "select * from login where username = '"+ username +"' and password = '"+ password +"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
//                System.out.println(resultSet);

                if (resultSet.next()){
                    setVisible(false);
                    new Main_class();

                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        else {
            System.exit(90);

        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
