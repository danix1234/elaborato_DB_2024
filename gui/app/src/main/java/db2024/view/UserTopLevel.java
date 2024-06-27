package db2024.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import db2024.DBUtils;
import db2024.Queries;

public class UserTopLevel extends TopLevel {
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
            ResultSet flights = null;
            try {
                flights = Queries.ricercaVolo(dateFlight.getText(), fromFlight.getText(), toFlight.getText());
            } catch (Throwable t) {
                resultStatus.setText("ricerca voli fallita");
                results.setModel(DBUtils.emptyTable());
                return;
            } finally {
                dateFlight.setText("data");
                fromFlight.setText("partenza (IATA)");
                toFlight.setText("destinazione (IATA)");
            }
            resultStatus.setText("la ricerca dei voli è andata a buon fine");
            results.setModel(DBUtils.createTable(flights));

        });
        listSeats.addActionListener(e -> {
            ResultSet seats = null;
            try {
                seats = Queries.ricercaPostiDisponibili(Integer.parseInt(codeFlight1.getText()));
            } catch (Throwable t) {
                resultStatus.setText("ricerca sedili fallita");
                results.setModel(DBUtils.emptyTable());
                return;
            } finally {
                codeFlight1.setText("codice volo");
            }
            resultStatus.setText("la ricerca dei sedili è andata a buon fine");
            results.setModel(DBUtils.createTable(seats));
        });
        buyTicket.addActionListener(e -> {
            try {
                if (Queries.inserisciBiglietto(codeFlight2.getText(), codiceFiscale, codeSeat.getText()) != 1){
                    throw new IllegalStateException("could not buy ticket");
                }
            } catch (Throwable t) {
                resultStatus.setText("ci sono stati problemi nell'effettuare l'acquisto");
                results.setModel(DBUtils.emptyTable());
                return;
            } finally {
                codeFlight2.setText("codice volo");
                codeSeat.setText("sedile");
            }
            resultStatus.setText("il biglietto è stato acquistato");
            results.setModel(DBUtils.emptyTable());
        });
        showTickets.addActionListener(e -> {
            ResultSet tickets = null;
            try {
                tickets = Queries.visualizzaListaBiglietti(codiceFiscale);
            } catch (Throwable t) {
                resultStatus.setText("ci sono stati problemi nel trovare i tuoi biglietti");
                results.setModel(DBUtils.emptyTable());
                return;
            }
            resultStatus.setText("ecco la lista dei tuoi biglietti");
            results.setModel(DBUtils.createTable(tickets));
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
        this.codiceFiscale = Queries.ottieniCodiceFiscaleDaEmail(email);
    }

}
