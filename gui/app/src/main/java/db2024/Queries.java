package db2024;

public class Queries {
    public static final String INSERIMENTO_VOLO = """
            INSERT INTO VOLO (codiceVolo, dataPartenza, oraPartenza, partenza, destinazione, dataArrivo,
                oraArrivo, produttore, modello, codiceAeroplano)
            VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                            """;
    public static final String CANCELLAZIONE_VOLO = """
            DELETE FROM VOLO
            WHERE codiceVolo = ?
                """;
    public static final String INSERIMENTO_PERSONALE = """
            INSERT INTO PERSONALE (nome, cognome, codiceFiscale, dataNascita, dataAssunzione, ruolo)
            VALUES (?, ?, ?, ?, ?, ?)
                """;
    public static final String INSERIMENTO_LAVORATORE = """
            INSERT INTO LAVORATORE (personaleCF, codiceVolo)
            VALUES (?, ?)
                    """;
    public static final String INSERIMENTO_AEROPLANO = """
            INSERT INTO AEROPLANO (produttore, modello, codiceSeriale, noleggio)
            VALUES (?, ?)
                """;
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
                WHERE (dataPartenza between ? and ?)
                    and partenza > destinazione) as TRATTE(partenza, destinazione)
            GROUP BY TRATTE.partenza, TRATTE.destinazione
            ORDER BY count(*) desc;
                """;
    public static final String INSERIMENTO_PASSEGGERO = """
            INSERT INTO PASSEGGERO (nome, cognome, codiceFiscale, email, password)
            VALUES (?, ?, ?, ?, ?)
                """;
    public static final String CONTROLLA_ACCOUNT_ESISTE = """
            SELECT count(*)
            FROM PASSEGGERO
            WHERE email = 'Gaia.Bianchi@outlook.com' and `password` = 'eczfdawa';
            """;
    public static final String RICERCA_VOLO = """
            SELECT V.codiceVolo, V.dataPartenza, V.oraPartenza, V.dataArrivo, V.oraArrivo, P.codiceIATA,
                P.stato, P.città, D.codiceIATA, D.stato, D.città, V.produttore, V.modello
            FROM VOLO V, AEROPORTO P, AEROPORTO D
            WHERE V.partenza = P.codiceICAO and V.destinazione = D.codiceICAO
                and dataPartenza = ? and P.codiceIATA = ? and D.codiceIATA = ?
            """;
    public static final String RICERCA_POSTI_DISPONIBILI = """
            SELECT codiceSedile
            FROM POSTO P, VOLO V
            WHERE P.produttore = V.produttore and P.modello = V.modello and V.codiceVolo = ?
            EXCEPT
            SELECT codiceSedile
            FROM BIGLIETTO
            WHERE codiceVolo = ?; 
            """;
    public static final String INSERIMENTO_BIGLIETTO = """
            INSERT INTO BIGLIETTO (codiceVolo, passeggeroCF, codiceSedile, costoTotale)
            VALUES (? ,? ,? , (select coalesce(P.sovrapprezzo,0) + R.prezzoBase
            FROM VOLO V, POSTO P, RAGGRUPPAMENTO R
            WHERE codiceSedile = ? and codiceVolo = ?
                and V.produttore = P.produttore and V.modello = P.modello
                and V.produttore = R.produttore and V.modello = R.modello and R.classe = P.classe)); 
            """;
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
}
