package db2024.view;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import db2024.Queries;

public class UserTopLevel extends TopLevel {
    private String email;
    private String codiceFiscale;
    private final JPanel panel = new JPanel();
    private final JPanel west = new JPanel();
    private final JPanel center = new JPanel();
    private final JPanel east = new JPanel();
    private final JPanel south = new JPanel();
    private final JTextField dateFlight = new JTextField("data");
    private final JTextField fromFlight = new JTextField("partenza (IATA)");
    private final JTextField toFlight = new JTextField("destinazione (IATA)");
    private final JButton searchFlight = new JButton("ricerca");
    private final JTextField codeFlight1 = new JTextField("codice volo");
    private final JButton listSeats = new JButton("mostra posti disponibili");
    private final JTextField codeFlight2 = new JTextField("codice volo");
    private final JTextField codeSeat = new JTextField("sedile");
    private final JButton buyTicket = new JButton("compra biglietto");
    private final JButton showTickets = new JButton("mostra tutti i biglietti");
    private final JTextField resultStatus = new JTextField("i risultati delle query verrano mostrati qua sotto");
    private final JTable results = new JTable();
    private final JScrollPane scrollableResults = new JScrollPane(results);

    public UserTopLevel() {
        super("Utente", 1220, 810);
        searchFlight.addActionListener(e -> {
            dateFlight.setText("data");
            fromFlight.setText("partenza (IATA)");
            toFlight.setText("destinazione (IATA)");
            // TODO: put results in south panel
            // Queries.ricercaVolo(dateFlight.getText(), fromFlight.getText(),
            // toFlight.getText());
        });
        listSeats.addActionListener(e -> {
            codeFlight1.setText("codice volo");
            // TODO: put results in south panel
        });
        buyTicket.addActionListener(e -> {
            codeFlight2.setText("codice volo");
            codeSeat.setText("sedile");
            // TODO: put results in south panel
        });
        showTickets.addActionListener(e -> {
            // TODO: show tickets in south panel
        });
        resultStatus.setEditable(false);
        resultStatus.setHorizontalAlignment(JTextField.CENTER);
        panel.setLayout(new BorderLayout(10, 10));
        west.setLayout(new GridLayout(4, 1, 0, 0));
        west.setPreferredSize(new Dimension(400, 500));
        center.setLayout(new GridLayout(5, 1, 0, 0));
        center.setPreferredSize(new Dimension(400, 500));
        east.setLayout(new GridLayout(1, 1, 0, 0));
        east.setPreferredSize(new Dimension(400, 500));
        south.setLayout(new BorderLayout(0, 0));
        south.setPreferredSize(new Dimension(1220, 300));
        west.add(dateFlight);
        west.add(fromFlight);
        west.add(toFlight);
        west.add(searchFlight);
        center.add(codeFlight1);
        center.add(listSeats);
        center.add(codeFlight2);
        center.add(codeSeat);
        center.add(buyTicket);
        east.add(showTickets);
        south.add(resultStatus, BorderLayout.NORTH);
        south.add(scrollableResults, BorderLayout.CENTER);
        panel.add(west, BorderLayout.WEST);
        panel.add(center, BorderLayout.CENTER);
        panel.add(east, BorderLayout.EAST);
        panel.add(south, BorderLayout.SOUTH);
        frame.add(panel);
    }

    public void setCurrentUserEmail(String email) {
        this.email = email;
        this.codiceFiscale = Queries.ottieniCodiceFiscaleDaEmail(email);
    }

}
