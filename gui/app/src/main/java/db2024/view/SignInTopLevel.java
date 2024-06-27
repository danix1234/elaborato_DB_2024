package db2024.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db2024.Queries;

public class SignInTopLevel extends TopLevel {
    JPanel panel = new JPanel();
    private final JButton reset = new JButton("resetta");
    private final JLabel info = new JLabel("inserisci dati personali");
    private final JTextField nome = new JTextField("nome");
    private final JTextField cognome = new JTextField("cognome");
    private final JTextField codiceFiscale = new JTextField("codice fiscale");
    private final JTextField email = new JTextField("email");
    private final JTextField password = new JTextField("password");
    private final JButton conferm = new JButton("Registrati e Accedi");

    public SignInTopLevel() {
        super("Choise", 400, 300);
        reset.setHorizontalAlignment(JLabel.CENTER);
        info.setHorizontalAlignment(JLabel.CENTER);
        nome.setHorizontalAlignment(JLabel.CENTER);
        cognome.setHorizontalAlignment(JLabel.CENTER);
        codiceFiscale.setHorizontalAlignment(JLabel.CENTER);
        email.setHorizontalAlignment(JLabel.CENTER);
        password.setHorizontalAlignment(JLabel.CENTER);
        reset.addActionListener(e -> {
            info.setText("inserisci dati personali");
            nome .setText("nome");
            cognome.setText("cognome");
            codiceFiscale.setText("codice fiscale");
            email.setText("email");
            password.setText("password");
        });
        conferm.addActionListener(e -> {
            if (!email.getText().contains("@")) {
                info.setText("l'email non è valida");
            }
            int lineChanged = 0;
            try {
                lineChanged = Queries.inserisciPasseggero(nome.getText(), cognome.getText(), codiceFiscale.getText(),
                        email.getText(),
                        password.getText());
                if (lineChanged == 0) {
                    throw new Exception("registrazione passeggero non ha inserito nessuna nuova riga");
                } else if (lineChanged != 1) {
                    throw new IllegalStateException("BUG: registrazione passeggero ha inserito multiple righe");
                }
                close();
                TopLevelManager.USER.setCurrentUserEmail(email.getText());
                TopLevelManager.USER.show();
            } catch (Throwable t) {
                info.setText("L'utente è già registrato");
            }
        });
        panel.setLayout(new GridLayout(8, 1, 10, 10));
        panel.add(reset);
        panel.add(info);
        panel.add(nome);
        panel.add(cognome);
        panel.add(codiceFiscale);
        panel.add(email);
        panel.add(password);
        panel.add(conferm);
        frame.add(panel);
    }

}
