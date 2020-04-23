package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
/**
 * Author : Krishna Adhikari
 * */
public class Main implements ActionListener {
    JFrame frame;
    JTextField textFieldUserName;
    JPasswordField passwordFieldPw;
    JLabel labelUserName, labelPw;
    JButton buttonLogin, buttonCancel;
    JPanel panel;

    public Main(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        frame = new JFrame("Login");
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(layout);

        frame.add(panel);

        labelUserName = new JLabel();
        labelUserName.setText("Username: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(labelUserName, gbc);

        textFieldUserName = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(textFieldUserName, gbc);

        labelPw = new JLabel();
        labelPw.setText("Password: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(labelPw, gbc);

        passwordFieldPw = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(passwordFieldPw, gbc);

        buttonLogin = new JButton("Login");
        buttonLogin.setBackground(Color.CYAN);
        buttonLogin.addActionListener(this);
        buttonLogin.setForeground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(buttonLogin,gbc);

        buttonCancel = new JButton("Cancel");
        buttonCancel.setBackground(Color.CYAN);
        buttonCancel.addActionListener(this);
        buttonCancel.setForeground(Color.DARK_GRAY);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(buttonCancel,gbc);




        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonLogin){
            try {
                Conn conn = new Conn();
                String u = textFieldUserName.getText();
                String pw = passwordFieldPw.getText();

                String query = "select * from cradentials where username = '"+u+"' and password = '"+pw+"'";

                ResultSet rs = conn.statement.executeQuery(query);

                if (rs.next()){
                    new HomePage();
                    frame.dispose();
                }else{
                    JOptionPane.showMessageDialog(frame,"Please Enter correct details.");
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }else if(e.getSource() == buttonCancel){
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
