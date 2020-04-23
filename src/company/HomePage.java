package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class HomePage implements ActionListener {
    JFrame frame;
    JTextField textFieldName, textFieldAddress, textFieldPhone;
    JLabel labelName, labelAddress, labelPhone;
    JButton buttonAdd, buttonView;
    JPanel panel;

    public HomePage(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        frame = new JFrame("Login");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(layout);

        frame.add(panel);

        labelName = new JLabel();
        labelName.setText("Name: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(labelName, gbc);

        textFieldName = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(textFieldName, gbc);

        labelAddress = new JLabel();
        labelAddress.setText("Address: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(labelAddress, gbc);

        textFieldAddress = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(textFieldAddress, gbc);

        labelPhone = new JLabel();
        labelPhone.setText("Phone: ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(labelPhone, gbc);

        textFieldPhone = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(textFieldPhone, gbc);

        buttonAdd = new JButton("Add");
        buttonAdd.setBackground(Color.CYAN);
        buttonAdd.addActionListener(this);
        buttonAdd.setForeground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(buttonAdd,gbc);

        buttonView = new JButton("View");
        buttonView.setBackground(Color.CYAN);
        buttonView.addActionListener(this);
        buttonView.setForeground(Color.DARK_GRAY);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(buttonView,gbc);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonAdd){
            try {
                Conn conn = new Conn();
                String name = textFieldName.getText();
                String address = textFieldAddress.getText();
                String phone = textFieldPhone.getText();

                String query = "insert into customers values('"+name+"','"+address+"', '"+phone+"')";

                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(frame, "Customer Added Successfully");

            }catch (Exception ex){
                ex.printStackTrace();
            }
        } else if(e.getSource() == buttonView){
            try {
                Conn conn = new Conn();
                String name = textFieldName.getText();

                String query = "select * from customers where name = '"+name+"'";

                ResultSet rs = conn.statement.executeQuery(query);

                while (rs.next()){
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");

                    textFieldAddress.setText(address);
                    textFieldPhone.setText(phone);
                }

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
