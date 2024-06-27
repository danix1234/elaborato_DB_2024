package db2024.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoiseTopLevel extends TopLevel {
    private final JPanel panel = new JPanel();
    private final JButton loginButton = new JButton("Accedi");
    private final JButton signInButton = new JButton("Registrati");

    public ChoiseTopLevel() {
        super("Choise", 400, 300);
        loginButton.addActionListener(e -> {
            close();
            TopLevelManager.LOGIN.show();
        });
        signInButton.addActionListener(e -> {
            close();
            TopLevelManager.SIGNIN.show();
        });
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        panel.add(loginButton);
        panel.add(signInButton);
        frame.add(panel);
    }

}
