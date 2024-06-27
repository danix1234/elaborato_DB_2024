package db2024;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.IllegalStateException;

public class Queries {
    public static final String INSERIMENTO_VOLO = """
            INSERT INTO VOLO (codiceVolo, dataPartenza, oraPartenza, partenza, destinazione, dataArrivo,
                oraArrivo, produttore, modello, codiceAeroplano)
            VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                            """;

    public static int inserisciVolo(int codiceVolo, String dataPartenza, String oraPartenza, String partenzaICAO,
            String destinazioneICAO, String dataArrivo, String oraArrivo, String produttore, String modello,
            int codiceAeroplano) {
        return DBConnection.executeUpdate(INSERIMENTO_VOLO, codiceVolo, dataPartenza, oraPartenza, partenzaICAO,
                destinazioneICAO, dataArrivo, oraArrivo, produttore, modello, codiceAeroplano);
    }

    public static final String CANCELLAZIONE_VOLO = """
            DELETE FROM VOLO
            WHERE codiceVolo = ?
                """;

    public static int cancellaVolo(int codiceVolo) {
        return DBConnection.executeUpdate(CANCELLAZIONE_VOLO, codiceVolo);
    }

    public static final String INSERIMENTO_PERSONALE = """
            INSERT INTO PERSONALE (nome, cognome, codiceFiscale, dataNascita, dataAssunzione, ruolo)
            VALUES (?, ?, ?, ?, ?, ?)
                """;

    public static int inserisciPersonale(String nome, String cognome, String codiceFiscale, String dataNascita,
            String dataAssunzione, String ruolo) {
        return DBConnection.executeUpdate(INSERIMENTO_PERSONALE, nome, cognome, codiceFiscale, dataNascita,
                dataAssunzione, ruolo);
    }

    public static final String INSERIMENTO_LAVORATORE = """
            INSERT INTO LAVORATORE (personaleCF, codiceVolo)
            VALUES (?, ?)
                    """;

    public static int inserisciLavoratore(String personaleCF, String codiceVolo) {
        return DBConnection.executeUpdate(INSERIMENTO_LAVORATORE, personaleCF, codiceVolo);
    }

    public static final String INSERIMENTO_AEROPLANO = """
            INSERT INTO AEROPLANO (produttore, modello, codiceSeriale, noleggio)
            VALUES (?, ?, ?, ?)
                """;

    public static int inserisciAeroplano(String produttore, String modello, int codiceSeriale, boolean noleggio) {
        return DBConnection.executeUpdate(INSERIMENTO_LAVORATORE, produttore, modello, codiceSeriale, noleggio);
    }

    public static final String VISUALIZZA_PROFITTO_MEDIO = """
            SELECT AVG(B1.profittiPerVolo)
            FROM (
                SELECT SUM(B.costoTotale)
                FROM VOLO V, BIGLIETTO B
                WHERE V.codiceVolo = B.codiceVolo
                    and (partenza = ? and destinazione = ? or partenza = ? and destinazione = ?)
                    and (dataPartenza between ? and ?)
                GROUP BY V.codiceVolo ) as B1(profittiPerVolo);
                """;

    public static ResultSet visualizzaProfittoMedio(String partenzaICAO, String destinazioneICAO, String dataInizio,
            String dataFine) {
        return DBConnection.executeQuery(VISUALIZZA_PROFITTO_MEDIO, partenzaICAO, destinazioneICAO, destinazioneICAO,
                partenzaICAO, dataInizio, dataFine);
    }

    public static final String VISUALIZZA_TRATTE_TRAFFICATE = """
            SELECT TRATTE.partenza, TRATTE.destinazione, count(*)
            FROM (
                SELECT V.partenza as partenza, V.destinazione as destinazione
                FROM VOLO V
                WHERE dataPartenza between ? and ?
                    and partenza < destinazione
                UNION ALL
                SELECT V.destinazione as partenza, V.partenza as destinazione
                FROM VOLO V
                WHERE dataPartenza between ? and ?
                    and partenza > destinazione) as TRATTE(partenza, destinazione)
            GROUP BY TRATTE.partenza, TRATTE.destinazione
            ORDER BY 3 desc;
                """;

    public static ResultSet visualizzaTratteTrafficate(String dataInizio, String dataFine) {
        return DBConnection.executeQuery(VISUALIZZA_TRATTE_TRAFFICATE, dataInizio, dataFine, dataInizio, dataFine);
    }

    public static final String INSERIMENTO_PASSEGGERO = """
            INSERT INTO PASSEGGERO (nome, cognome, codiceFiscale, email, password)
            VALUES (?, ?, ?, ?, ?)
                """;

    public static int inserisciPasseggero(String nome, String cognome, String codiceFiscale, String email,
            String password) {
        return DBConnection.executeUpdate(INSERIMENTO_PASSEGGERO, nome, cognome, codiceFiscale, email, password);
    }

    public static final String CONTROLLA_ACCOUNT_ESISTE = """
            SELECT count(*)
            FROM PASSEGGERO
            WHERE email = ? and `password` = ?;
            """;

    public static boolean controllaAccountEsiste(String email, String password) {
        var res = DBConnection.executeQuery(CONTROLLA_ACCOUNT_ESISTE, email, password);
        try {
            res.next();
            int found = res.getInt(1);
            if (found > 1) {
                throw new IllegalStateException("BUG: multipli account con stessa email e password");
            }
            return found == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("could not check if account exists");
        }
    }

    public static final String RICERCA_VOLO = """
            SELECT V.codiceVolo, V.dataPartenza, V.oraPartenza, V.dataArrivo, V.oraArrivo, P.codiceIATA,
                P.stato, P.città, D.codiceIATA, D.stato, D.città, V.produttore, V.modello
            FROM VOLO V, AEROPORTO P, AEROPORTO D
            WHERE V.partenza = P.codiceICAO and V.destinazione = D.codiceICAO
                and dataPartenza = ? and P.codiceIATA = ? and D.codiceIATA = ?
            """;

    public static ResultSet ricercaVolo(String data, String partenzaIATA, String destinazioneIATA) {
        return DBConnection.executeQuery(RICERCA_VOLO, data, partenzaIATA, destinazioneIATA);
    }

    public static final String RICERCA_POSTI_DISPONIBILI = """
            SELECT codiceSedile
            FROM POSTO P, VOLO V
            WHERE P.produttore = V.produttore and P.modello = V.modello and V.codiceVolo = ?
            EXCEPT
            SELECT codiceSedile
            FROM BIGLIETTO
            WHERE codiceVolo = ?;
            """;

    public static ResultSet ricercaPostiDisponibili(int codiceVolo) {
        return DBConnection.executeQuery(RICERCA_POSTI_DISPONIBILI, codiceVolo, codiceVolo);
    }

    public static final String INSERIMENTO_BIGLIETTO = """
            INSERT INTO BIGLIETTO (codiceVolo, passeggeroCF, codiceSedile, costoTotale)
            VALUES (? ,? ,? , (select coalesce(P.sovrapprezzo,0) + R.prezzoBase
            FROM VOLO V, POSTO P, RAGGRUPPAMENTO R
            WHERE codiceSedile = ? and codiceVolo = ?
                and V.produttore = P.produttore and V.modello = P.modello
                and V.produttore = R.produttore and V.modello = R.modello and R.classe = P.classe));
            """;

    public static int inserisciBiglietto(String codiceVolo, String passeggeroCF, String codiceSedile) {
        return DBConnection.executeUpdate(INSERIMENTO_BIGLIETTO, codiceVolo, passeggeroCF, codiceSedile, codiceSedile,
                codiceVolo);
    }

    public static final String VISUALIZZA_LISTA_BIGLIETTI = """
            SELECT P.nome, P.cognome, P.codiceFiscale, AP.codiceIATA, AP.stato, AP.città, AD.codiceIATA,
                AD.stato, AD.città, V.destinazione, V.dataPartenza, V.oraPartenza, V.dataArrivo, V.oraArrivo,
                B.codiceSedile, PO.classe, B.costoTotale
            FROM PASSEGGERO P, BIGLIETTO B, VOLO V, AEROPORTO AP, AEROPORTO AD, POSTO PO
            WHERE P.codiceFiscale = B.passeggeroCF and B.codiceVolo = V.codiceVolo
                and AP.codiceICAO = V.partenza and AD.codiceICAO = V.destinazione
                and PO.produttore = V.produttore and PO.modello = V.modello
                and PO.codiceSedile = B.codiceSedile and P.codiceFiscale = ?;
            """;

    public static ResultSet visualizzaListaBiglietti(String passeggeroCF) {
        return DBConnection.executeQuery(VISUALIZZA_LISTA_BIGLIETTI, passeggeroCF);
    }
}
