package actividades.ud9.actsDiapositivas.ej1y2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {
        Frame frame = new AutoCloseFrame("Login Form");
        Panel panel = new Panel();
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField(20);
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField(20);
        Button loginButton = new Button("Login");
        Button cancelButton = new Button("Cancel");
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(cancelButton);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                openMainWindow();
                frame.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usernameField.setText(null);
                passwordField.setText(null);
            }
        });

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);

    }

    private static void openMainWindow() {
        Frame frame = new AutoCloseFrame("Main Window");
        Panel panel = new Panel();
        Label label = new Label("Welcome to the main window!");
        panel.add(label);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}