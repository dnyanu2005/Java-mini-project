package DnyaneshwariNikam;

import java.awt.*;
import java.awt.event.*;

class LoginScreenAWT extends Frame {
    private TextField usernameField, passwordField;
    private Label messageLabel;
    private int attemptsLeft = 3;

    public LoginScreenAWT() {
        
        setTitle("Login Screen");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));

        
        add(new Label("Username:"));
        usernameField = new TextField();
        add(usernameField);

        add(new Label("Password:"));
        passwordField = new TextField();
        passwordField.setEchoChar('*');
        add(passwordField);

        Button loginButton = new Button("Login");
        Button clearButton = new Button("Clear");
        add(loginButton);
        add(clearButton);

        messageLabel = new Label();
        add(messageLabel);

       
        loginButton.addActionListener(e -> handleLogin());
        clearButton.addActionListener(e -> clearFields());

       
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            if (!username.equals(password)) {
                attemptsLeft--;
                if (attemptsLeft > 0) {
                    throw new Exception("Username and password do not match. Attempts left: " + attemptsLeft);
                } else {
                    throw new Exception("No attempts left! Login locked.");
                }
            }
            messageLabel.setText("Login successful!");
        } catch (Exception ex) {
            messageLabel.setText(ex.getMessage());
        }
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        messageLabel.setText("");
    }

    public static void main(String[] args) {
        LoginScreenAWT app = new LoginScreenAWT();
        app.setVisible(true);
    }
}