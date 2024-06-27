package db2024.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db2024.Queries;

public class LoginTopLevel extends TopLevel {
    private final JPanel panel = new JPanel();
    private final JTextField info = new JTextField("inserisci email e password");
    private final JTextField email = new JTextField("email");
    private final JTextField password = new JTextField("password");
    private final JButton conferm = new JButton("Accedi");

    public LoginTopLevel() {
        super("login", 400, 300);
        info.setEditable(false);
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
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.add(info);
        panel.add(email);
        panel.add(password);
        panel.add(conferm);
        frame.add(panel);
    }

}
