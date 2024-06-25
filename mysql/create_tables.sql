-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.2              
-- * Generator date: Sep 20 2021              
-- * Generation date: Mon Jun 24 23:14:31 2024 
-- * LUN file: dbmain/ELABORATO_DB_2024.lun 
-- * Schema: compagnia_aerea/1.2 
-- ********************************************* 


-- Database Section
-- ________________ 
-- drop database compagnia_aerea;
drop database if exists compagnia_aerea;
create database if not exists compagnia_aerea;
use compagnia_aerea;


-- Tables Section
-- _____________ 

create table AEROPLANO (
     produttore varchar(100) not null,
     modello varchar(100) not null,
     codiceSeriale int not null,
     noleggio bool not null,
     constraint IDAEROPLANO primary key (produttore, modello, codiceSeriale));

create table AEROPORTO (
     codiceICAO char(4) not null,
     codiceIATA char(3) not null,
     stato varchar(100) not null,
     città varchar(100) not null,
     constraint IDAEROPORTO primary key (codiceICAO),
     constraint IDAEROPORTO_1 unique (codiceIATA));

create table BIGLIETTO (
     codiceVolo int not null,
     passeggeroCF varchar(100) not null,
     codiceSedile char(3) not null,
     costoTotale float not null,
     constraint IDBIGLIETTO primary key (passeggeroCF, codiceVolo));

create table CLASSE (
     nome varchar(100) not null,
     descrizione varchar(100) not null,
     constraint IDCLASSE primary key (nome));

create table LAVORATORE (
     personaleCF varchar(100) not null,
     codiceVolo int not null,
     constraint IDLAVORATORE primary key (codiceVolo, personaleCF));

create table MODELLO (
     produttore varchar(100) not null,
     nome varchar(100) not null,
     descrizione varchar(100) not null,
     constraint IDMODELLO primary key (produttore, nome));

create table PASSEGGERO (
     nome varchar(100) not null,
     cognome varchar(100) not null,
     codiceFiscale varchar(100) not null,
     email varchar(100) not null,
     password varchar(100) not null,
     constraint IDPASSEGGERO primary key (codiceFiscale),
     constraint IDPASSEGGERO_1 unique (email));

create table PERSONALE (
     nome varchar(100) not null,
     cognome varchar(100) not null,
     codiceFiscale varchar(100) not null,
     dataNascita date not null,
     dataAssunzione date not null,
     ruolo varchar(100) not null,
     constraint IDPERSONALE primary key (codiceFiscale));

create table POSTO (
     produttore varchar(100) not null,
     modello varchar(100) not null,
     codiceSedile char(3) not null,
     sovrapprezzo float,
     classe varchar(100) not null,
     constraint IDPOSTO primary key (produttore, modello, codiceSedile));

create table PRODUTTORE (
     nome varchar(100) not null,
     descrizione varchar(100) not null,
     constraint IDPRODUTTORE primary key (nome));

create table RAGGRUPPAMENTO (
     produttore varchar(100) not null,
     modello varchar(100) not null,
     classe varchar(100) not null,
     prezzoBase float not null,
     constraint IDRAGGRUPPAMENTO primary key (produttore, modello, classe));

create table RUOLO (
     nomeRuolo varchar(100) not null,
     descrizione varchar(100) not null,
     constraint IDRUOLO primary key (nomeRuolo));

create table SEDILE (
     codice char(3) not null,
     constraint IDSEDILE primary key (codice));

create table VOLO (
     codiceVolo int not null auto_increment,
     dataPartenza date not null,
     oraPartenza time not null,
     partenza char(4) not null,
     destinazione char(4) not null,
     dataArrivo date not null,
     oraArrivo time not null,
     produttore varchar(100) not null,
     modello varchar(100) not null,
     codiceAeroplano int not null,
     constraint IDVOLO primary key (codiceVolo),
     constraint IDVOLO_1 unique (destinazione, partenza, dataPartenza, oraPartenza));


-- Constraints Section
-- ___________________ 

alter table AEROPLANO add constraint FKTIPOLOGIA
     foreign key (produttore, modello)
     references MODELLO (produttore, nome);

alter table BIGLIETTO add constraint FKSCELTA
     foreign key (codiceSedile)
     references SEDILE (codice);

alter table BIGLIETTO add constraint FKPRENOTAZIONE
     foreign key (passeggeroCF)
     references PASSEGGERO (codiceFiscale);

alter table BIGLIETTO add constraint FKRIFERIMENTO
     foreign key (codiceVolo)
     references VOLO (codiceVolo);

alter table LAVORATORE add constraint FKLAV_VOL
     foreign key (codiceVolo)
     references VOLO (codiceVolo);

alter table LAVORATORE add constraint FKLAV_PER
     foreign key (personaleCF)
     references PERSONALE (codiceFiscale);

alter table MODELLO add constraint FKASSEMBLAGGIO
     foreign key (produttore)
     references PRODUTTORE (nome);

alter table PERSONALE add constraint FKSVOLGERE
     foreign key (ruolo)
     references RUOLO (nomeRuolo);

alter table POSTO add constraint FKSERVIZIO
     foreign key (classe)
     references CLASSE (nome);

alter table POSTO add constraint FKPRESENZA
     foreign key (codiceSedile)
     references SEDILE (codice);

alter table POSTO add constraint FKDISPONIBILE
     foreign key (produttore, modello)
     references MODELLO (produttore, nome);

alter table RAGGRUPPAMENTO add constraint FKRAG_CLA
     foreign key (classe)
     references CLASSE (nome);

alter table RAGGRUPPAMENTO add constraint FKRAG_MOD
     foreign key (produttore, modello)
     references MODELLO (produttore, nome);

alter table VOLO add constraint FKPARTENZA
     foreign key (partenza)
     references AEROPORTO (codiceICAO);

alter table VOLO add constraint FKDESTINAZIONE
     foreign key (destinazione)
     references AEROPORTO (codiceICAO);

alter table VOLO add constraint FKEFFETTUAZIONE
     foreign key (produttore, modello, codiceAeroplano)
     references AEROPLANO (produttore, modello, codiceSeriale);


-- Index Section
-- _____________ 

