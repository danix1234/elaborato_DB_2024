package db2024.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import db2024.DBUtils;
import db2024.Queries;

public class AdminTopLevel extends TopLevel {
    private final JPanel panel = new JPanel();
    private final JPanel north = new JPanel();
    private final JPanel west = new JPanel();
    private final JPanel center = new JPanel();
    private final JPanel east = new JPanel();
    private final JPanel south = new JPanel();
    private final JButton reset = new JButton("resetta");
    private final JTextField west1 = new JTextField("data partenza");
    private final JTextField west2 = new JTextField("ora partenza");
    private final JTextField west3 = new JTextField("partenza (ICAO)");
    private final JTextField west4 = new JTextField("destinazione (ICAO)");
    private final JTextField west5 = new JTextField("data arrivo");
    private final JTextField west6 = new JTextField("ora arrivo");
    private final JTextField west7 = new JTextField("produttore aeroplano");
    private final JTextField west8 = new JTextField("modello aeroplano");
    private final JTextField west9 = new JTextField("codice seriale aeroplano");
    private final JButton west10 = new JButton("inserisci volo");
    private final JTextField west11 = new JTextField("codice volo");
    private final JButton west12 = new JButton("cancella volo");
    private final JTextField center1 = new JTextField("nome");
    private final JTextField center2 = new JTextField("cognome");
    private final JTextField center3 = new JTextField("codice fiscale");
    private final JTextField center4 = new JTextField("data nascita");
    private final JTextField center5 = new JTextField("data assunziones");
    private final JTextField center6 = new JTextField("ruolo");
    private final JButton center7 = new JButton("inserisci personale");
    private final JTextField center8 = new JTextField("produttore");
    private final JTextField center9 = new JTextField("modello");
    private final JTextField center10 = new JTextField("codice seriale");
    private final JTextField center11 = new JTextField("noleggio");
    private final JButton center12 = new JButton("inserisci aeroplano");
    private final JTextField east1 = new JTextField("codice fiscale personale");
    private final JTextField east2 = new JTextField("codice volo");
    private final JButton east3 = new JButton("inserisci lavoratore");
    private final JTextField east4 = new JTextField("partenza (ICAO)");
    private final JTextField east5 = new JTextField("destinazione (ICAO)");
    private final JTextField east6 = new JTextField("data di inizio");
    private final JTextField east7 = new JTextField("data di fine");
    private final JButton east8 = new JButton("visualizza il profitto medio");
    private final JTextField east9 = new JTextField("data di inizio");
    private final JTextField east10 = new JTextField("data di fine");
    private final JButton east11 = new JButton("visualizza le tratte più trafficate");
    private final JLabel resultStatus = new JLabel("i risultati delle query verrano mostrati qua sotto");
    private final JTable results = new JTable();
    private final JScrollPane scrollableResults = new JScrollPane(results);

    public AdminTopLevel() {
        super("Amministratore", 1220, 810);
        west10.addActionListener(e -> {
            try {
                if (Queries.inserisciVolo(west1.getText(), west2.getText(), west3.getText(), west4.getText(),
                        west5.getText(), west6.getText(), west7.getText(), west8.getText(),
                        Integer.parseInt(west9.getText())) != 1) {
                    throw new IllegalStateException("could not add flight");
                }
            } catch (Throwable t) {
                resultStatus.setText("ci sono stati problemi nell'inserire il volo");
                results.setModel(DBUtils.emptyTable());
                return;
            }
            resultStatus.setText("il volo è stato aggiunto");
            results.setModel(DBUtils.emptyTable());
        });
        west12.addActionListener(e -> {
            try {
                if (Queries.cancellaVolo(Integer.parseInt(west11.getText())) != 1) {
                    throw new IllegalStateException("could not delete flight");
                }
            } catch (Throwable t) {
                resultStatus.setText("ci sono stati problemi nel cancellare il volo");
                results.setModel(DBUtils.emptyTable());
                return;
            }
            resultStatus.setText("il volo è stato cancellato");
            results.setModel(DBUtils.emptyTable());
        });
        center7.addActionListener(e -> {
            try {
                if (Queries.inserisciPersonale(center1.getText(), center2.getText(), center3.getText(),
                        center4.getText(), center5.getText(), center6.getText()) != 1) {
                    throw new IllegalStateException("could not add workers");
                }
            } catch (Throwable t) {
                resultStatus.setText("ci sono stati problemi nell'inserire il personale");
                results.setModel(DBUtils.emptyTable());
                return;
            }
            resultStatus.setText("il personale è stato inserito");
            results.setModel(DBUtils.emptyTable());
        });
        center12.addActionListener(e -> {
            try {
                if (Queries.inserisciAeroplano(center8.getText(), center9.getText(),
                        Integer.parseInt(center10.getText()), Boolean.parseBoolean(center11.getText())) != 1) {
                    throw new IllegalStateException("could not add airplanes");
                }
            } catch (Throwable t) {
                resultStatus.setText("ci sono stati problemi nell'inserire l'aeroplano");
                results.setModel(DBUtils.emptyTable());
                return;
            }
            resultStatus.setText("il personale è stato inserito");
            results.setModel(DBUtils.emptyTable());
        });
        east3.addActionListener(e -> {
            try {
                if (Queries.inserisciLavoratore(east1.getText(), east2.getText()) != 1) {
                    throw new IllegalStateException("could not assign worker to flight");
                }
            } catch (Throwable t) {
                resultStatus.setText("ci sono stati problemi nell'assegnare il lavoratore al volo");
                results.setModel(DBUtils.emptyTable());
                return;
            }
            resultStatus.setText("il personale è stato assegnato al volo");
            results.setModel(DBUtils.emptyTable());
        });
        east8.addActionListener(e -> {
            ResultSet profitti = null;
            try {
                profitti = Queries.visualizzaProfittoMedio(east4.getText(), east5.getText(), east6.getText(), east7.getText());
            } catch (Throwable t) {
                resultStatus.setText("non è stato possibile calcolare il profitto medio");
                results.setModel(DBUtils.emptyTable());
                return;
            }
            resultStatus.setText("il calcolo del profitto medio è andato a buon fine");
            results.setModel(DBUtils.createTable(profitti));
        });
        east11.addActionListener(e -> {
            ResultSet tratte = null;
            try {
                tratte = Queries.visualizzaTratteTrafficate(east9.getText(), east10.getText());
            } catch (Throwable t) {
                resultStatus.setText("non è stato possibile calcolare le tratte più trafficate");
                results.setModel(DBUtils.emptyTable());
                return;
            }
            resultStatus.setText("il calcolo delle tratte più trafficate è andato a buon fine");
            DBUtils.updateTable(results, tratte);
        });
        reset.addActionListener(e -> {
            west1.setText("data partenza");
            west2.setText("ora partenza");
            west3.setText("partenza (ICAO)");
            west4.setText("destinazione (ICAO)");
            west5.setText("data arrivo");
            west6.setText("ora arrivo");
            west7.setText("produttore aeroplano");
            west8.setText("modello aeroplano");
            west9.setText("codice seriale aeroplano");
            west11.setText("codice volo");
            center1.setText("nome");
            center2.setText("cognome");
            center3.setText("codice fiscale");
            center4.setText("data nascita");
            center5.setText("data assunziones");
            center6.setText("ruolo");
            center8.setText("produttore");
            center9.setText("modello");
            center10.setText("codice seriale");
            center11.setText("noleggio");
            east1.setText("codice fiscale personale");
            east2.setText("codice volo");
            east4.setText("partenza (ICAO)");
            east5.setText("destinazione (ICAO)");
            east6.setText("data di inizio");
            east7.setText("data di fine");
            east9.setText("data di inizio");
            east10.setText("data di fine");
            resultStatus.setText("i risultati delle query verrano mostrati qua sotto");
            results.setModel(DBUtils.emptyTable());
        });
        reset.setHorizontalAlignment(JTextField.CENTER);
        west1.setHorizontalAlignment(JTextField.CENTER);
        west2.setHorizontalAlignment(JTextField.CENTER);
        west3.setHorizontalAlignment(JTextField.CENTER);
        west4.setHorizontalAlignment(JTextField.CENTER);
        west5.setHorizontalAlignment(JTextField.CENTER);
        west6.setHorizontalAlignment(JTextField.CENTER);
        west7.setHorizontalAlignment(JTextField.CENTER);
        west8.setHorizontalAlignment(JTextField.CENTER);
        west9.setHorizontalAlignment(JTextField.CENTER);
        west10.setHorizontalAlignment(JTextField.CENTER);
        west11.setHorizontalAlignment(JTextField.CENTER);
        west12.setHorizontalAlignment(JTextField.CENTER);
        center1.setHorizontalAlignment(JTextField.CENTER);
        center2.setHorizontalAlignment(JTextField.CENTER);
        center3.setHorizontalAlignment(JTextField.CENTER);
        center4.setHorizontalAlignment(JTextField.CENTER);
        center5.setHorizontalAlignment(JTextField.CENTER);
        center6.setHorizontalAlignment(JTextField.CENTER);
        center7.setHorizontalAlignment(JTextField.CENTER);
        center8.setHorizontalAlignment(JTextField.CENTER);
        center9.setHorizontalAlignment(JTextField.CENTER);
        center10.setHorizontalAlignment(JTextField.CENTER);
        center11.setHorizontalAlignment(JTextField.CENTER);
        center12.setHorizontalAlignment(JTextField.CENTER);
        east1.setHorizontalAlignment(JTextField.CENTER);
        east2.setHorizontalAlignment(JTextField.CENTER);
        east3.setHorizontalAlignment(JTextField.CENTER);
        east4.setHorizontalAlignment(JTextField.CENTER);
        east5.setHorizontalAlignment(JTextField.CENTER);
        east6.setHorizontalAlignment(JTextField.CENTER);
        east7.setHorizontalAlignment(JTextField.CENTER);
        east8.setHorizontalAlignment(JTextField.CENTER);
        east9.setHorizontalAlignment(JTextField.CENTER);
        east10.setHorizontalAlignment(JTextField.CENTER);
        east11.setHorizontalAlignment(JTextField.CENTER);
        resultStatus.setHorizontalAlignment(JTextField.CENTER);
        panel.setLayout(new BorderLayout(10, 10));
        north.setLayout(new GridLayout(1, 1, 0, 0));
        north.setPreferredSize(new Dimension(400, 30));
        west.setLayout(new GridLayout(12, 1, 0, 0));
        west.setPreferredSize(new Dimension(400, 500));
        center.setLayout(new GridLayout(12, 1, 0, 0));
        center.setPreferredSize(new Dimension(400, 500));
        east.setLayout(new GridLayout(12, 1, 0, 0));
        east.setPreferredSize(new Dimension(400, 500));
        south.setLayout(new BorderLayout(0, 0));
        south.setPreferredSize(new Dimension(1220, 300));
        north.add(reset);
        west.add(west1);
        west.add(west2);
        west.add(west3);
        west.add(west4);
        west.add(west5);
        west.add(west6);
        west.add(west7);
        west.add(west8);
        west.add(west9);
        west.add(west10);
        west.add(west11);
        west.add(west12);
        center.add(center1);
        center.add(center2);
        center.add(center3);
        center.add(center4);
        center.add(center5);
        center.add(center6);
        center.add(center7);
        center.add(center8);
        center.add(center9);
        center.add(center10);
        center.add(center11);
        center.add(center12);
        east.add(east1);
        east.add(east2);
        east.add(east3);
        east.add(east4);
        east.add(east5);
        east.add(east6);
        east.add(east7);
        east.add(east8);
        east.add(east9);
        east.add(east10);
        east.add(east11);
        south.add(resultStatus, BorderLayout.NORTH);
        south.add(scrollableResults, BorderLayout.CENTER);
        panel.add(north, BorderLayout.NORTH);
        panel.add(west, BorderLayout.WEST);
        panel.add(center, BorderLayout.CENTER);
        panel.add(east, BorderLayout.EAST);
        panel.add(south, BorderLayout.SOUTH);
        frame.add(panel);
    }

}
