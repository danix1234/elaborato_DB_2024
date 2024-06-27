package db2024.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db2024.Queries;

public class LoginTopLevel extends TopLevel {
    private final JPanel panel = new JPanel();
    private final JButton reset = new JButton("resetta");
    private final JLabel info = new JLabel("inserisci email e password");
    private final JTextField email = new JTextField("email");
    private final JTextField password = new JTextField("password");
    private final JButton conferm = new JButton("Accedi");

    public LoginTopLevel() {
        super("login", 400, 300);
        reset.setHorizontalAlignment(JLabel.CENTER);
        info.setHorizontalAlignment(JLabel.CENTER);
        email.setHorizontalAlignment(JLabel.CENTER);
        password.setHorizontalAlignment(JLabel.CENTER);
        reset.addActionListener(e -> {
            info.setText("inserisci email e password");
            email.setText("email");
            password.setText("password");
        });
        conferm.addActionListener(e -> {
            if (email.getText().equals("admin") && password.getText().equals("admin")) {
                close();
                TopLevelManager.ADMIN.show();
            }
            if (Queries.controllaAccountEsiste(email.getText(), password.getText())) {
                close();
                TopLevelManager.USER.setCurrentUserEmail(email.getText());
                TopLevelManager.USER.show();
            } else {
                info.setText("email o password non valida");
            }
        });
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.add(reset);
        panel.add(info);
        panel.add(email);
        panel.add(password);
        panel.add(conferm);
        frame.add(panel);
    }

}
