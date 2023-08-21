package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginUI() {
        super("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        loginPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel(""));
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginPanel.add(loginButton);

        getContentPane().add(loginPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // TODO: call your login API with the username and password

        // If the login is successful, close the login window
        dispose();
    }

    public static void main(String[] args) {
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true);
    }
}
