use compagnia_aerea;

insert into SEDILE values 
('01A'),('01B'),('01C'),('01D'),('01E'),('01F'),
('02A'),('02B'),('02C'),('02D'),('02E'),('02F'),
('03A'),('03B'),('03C'),('03D'),('03E'),('03F'),
('04A'),('04B'),('04C'),('04D'),('04E'),('04F'),
('05A'),('05B'),('05C'),('05D'),('05E'),('05F'),
('06A'),('06B'),('06C'),('06D'),('06E'),('06F'),
('07A'),('07B'),('07C'),('07D'),('07E'),('07F'),
('08A'),('08B'),('08C'),('08D'),('08E'),('08F'),
('09A'),('09B'),('09C'),('09D'),('09E'),('09F'),
('10A'),('10B'),('10C'),('10D'),('10E'),('10F'),
('11A'),('11B'),('11C'),('11D'),('11E'),('11F'),
('12A'),('12B'),('12C'),('12D'),('12E'),('12F'),
('13A'),('13B'),('13C'),('13D'),('13E'),('13F'),
('14A'),('14B'),('14C'),('14D'),('14E'),('14F'),
('15A'),('15B'),('15C'),('15D'),('15E'),('15F'),
('16A'),('16B'),('16C'),('16D'),('16E'),('16F'),
('17A'),('17B'),('17C'),('17D'),('17E'),('17F'),
('18A'),('18B'),('18C'),('18D'),('18E'),('18F'),
('19A'),('19B'),('19C'),('19D'),('19E'),('19F'),
('20A'),('20B'),('20C'),('20D'),('20E'),('20F'),
('21A'),('21B'),('21C'),('21D'),('21E'),('21F'),
('22A'),('22B'),('22C'),('22D'),('22E'),('22F'),
('23A'),('23B'),('23C'),('23D'),('23E'),('23F'),
('24A'),('24B'),('24C'),('24D'),('24E'),('24F'),
('25A'),('25B'),('25C'),('25D'),('25E'),('25F'),
('26A'),('26B'),('26C'),('26D'),('26E'),('26F'),
('27A'),('27B'),('27C'),('27D'),('27E'),('27F'),
('28A'),('28B'),('28C'),('28D'),('28E'),('28F'),
('29A'),('29B'),('29C'),('29D'),('29E'),('29F'),
('30A'),('30B'),('30C'),('30D'),('30E'),('30F'),
('31A'),('31B'),('31C'),('31D'),('31E'),('31F'),
('32A'),('32B'),('32C'),('32D'),('32E'),('32F'),
('33A'),('33B'),('33C'),('33D'),('33E'),('33F'),
('34A'),('34B'),('34C'),('34D'),('34E'),('34F'),
('35A'),('35B'),('35C'),('35D'),('35E'),('35F');

insert into RUOLO values 
('Hostess', 'assistente di bordo, donna'),
('Steward', 'assistente di bordo, uomo'),
('Comandante', 'pilota di grado più elevato'),
('Primo ufficiale', 'pilota che assiste il comandante');

insert into PRODUTTORE values
('Boeing', 'industria aeronautica statunitense produttrice di velivoli sia per utilizzo civile, che militare.'),
('Airbus', 'azienda con sede nei Paesi Bassi, che opera nel settore aerospaziale e della difesa');

insert into MODELLO values
('Boeing', '737 MAX', 'modello di aeroplano a fusoliera stretta'),
('Boeing', '767', 'bimotore a getto di linea, con configurazione a fusoliera larga ed ala bassa'),
('Boeing', '777', 'aereo di linea a fusoliera larga a lungo raggio'),
('Airbus', 'A320', 'aerei a fusoliera stretta per il corto-medio raggio'),
('Airbus', 'A330', 'aereo di linea bimotore turboventola'),
('Airbus', 'A380', 'aereo di linea quadrimotore a doppio ponte');

insert into CLASSE values
('economica','una sola borsa a mano, servizio escluso, sedili con poco spazio per le gambe'),
('prima','imbarco prioritario, servizio incluso'),
('business','servizio incluso, poltrone spaziose');

insert into RAGGRUPPAMENTO values
('Boeing', '737 MAX', 'economica', 20.00),
('Boeing', '737 MAX', 'prima', 45.50),
('Boeing', '737 MAX', 'business', 100.00),
('Boeing', '767', 'economica', 25.00),
('Boeing', '767', 'prima', 50.50),
('Boeing', '767', 'business', 110.00),
('Boeing', '777', 'economica', 30.00),
('Boeing', '777', 'prima', 60.00),
('Boeing', '777', 'business', 115.00),
('Airbus', 'A320', 'economica', 15.00),
('Airbus', 'A320', 'prima', 40.00),
('Airbus', 'A320', 'business', 80.00),
('Airbus', 'A330', 'economica', 25.00),
('Airbus', 'A330', 'prima', 50.00),
('Airbus', 'A330', 'business', 105.00),
('Airbus', 'A380', 'economica', 40.00),
('Airbus', 'A380', 'prima', 65.00),
('Airbus', 'A380', 'business', 150.00);

insert into AEROPORTO values
('LIMC','MXP','Italia','Milano'),
('LIMF','TRN','Italia','Torino'),
('LIRF','FCO','Italia','Roma'),
('LIMJ','GOA','Italia','Genova'),
('LIPK','FRL','Italia','Forli'),
('LIRN','NAP','Italia','Napoli'),
('LICJ','PMO','Italia','Palermo'),
('LEMD','MAD','Spagna','Madrid'),
('LEBL','BCN','Spagna','Barcellona'),
('LFPG','CDG','Francia','Parigi'),
('LFBD','BOD','Francia','Bordeaux'),
('EGLL','LHR','Inghilterra','Londra'),
('EGBB','BHX','Inghilterra','Birmingham'),
('EDDB','BER','Germania','Berlino'),
('EDDK','CGN','Germania','Cologne'),
('EDDF','FRA','Germania','Francoforte'),
('LOWW','VIE','Austria','Vienna');

insert into AEROPLANO values
('Boeing','737 MAX', '1', true), ('Boeing','737 MAX', '2', true), ('Boeing','737 MAX', '3', false), ('Boeing','737 MAX', '4', false), ('Boeing','737 MAX', '5', true),
('Boeing','737 MAX', '6', true), ('Boeing','737 MAX', '7', true), ('Boeing','737 MAX', '8', false), ('Boeing','737 MAX', '9', false), ('Boeing','737 MAX', '10', true),
('Boeing', '767', '1', true), ('Boeing', '767', '2', true), ('Boeing', '767', '3', false), ('Boeing', '767', '4', false), ('Boeing', '767', '5', false),
('Boeing', '767', '6', true), ('Boeing', '767', '7', true), ('Boeing', '767', '8', false), ('Boeing', '767', '9', false), ('Boeing', '767', '10', false),
('Boeing', '777', '1', false), ('Boeing', '777', '2', false), ('Boeing', '777', '3', false), ('Boeing', '777', '4', false), ('Boeing', '777', '5', false),
('Boeing', '777', '6', false), ('Boeing', '777', '7', false), ('Boeing', '777', '8', false), ('Boeing', '777', '9', false), ('Boeing', '777', '10', false),
('Airbus', 'A320', '1', true), ('Airbus', 'A320', '2', true), ('Airbus', 'A320', '3', true), ('Airbus', 'A320', '4', true), ('Airbus', 'A320', '5', false),
('Airbus', 'A320', '6', true), ('Airbus', 'A320', '7', true), ('Airbus', 'A320', '8', true), ('Airbus', 'A320', '9', true), ('Airbus', 'A320', '10', false),
('Airbus', 'A330', '1', true), ('Airbus', 'A330', '2', true), ('Airbus', 'A330', '3', false), ('Airbus', 'A330', '4', true), ('Airbus', 'A330', '5', true),
('Airbus', 'A330', '6', true), ('Airbus', 'A330', '7', true), ('Airbus', 'A330', '8', false), ('Airbus', 'A330', '9', true), ('Airbus', 'A330', '10', true),
('Airbus', 'A380', '1', true), ('Airbus', 'A380', '2', false), ('Airbus', 'A380', '3', true), ('Airbus', 'A380', '4', true), ('Airbus', 'A380', '5', true),
('Airbus', 'A380', '6', true), ('Airbus', 'A380', '7', false), ('Airbus', 'A380', '8', true), ('Airbus', 'A380', '9', true), ('Airbus', 'A380', '10', true);

insert into POSTO values
( 'Boeing', '737 MAX', '01A', 5.00, 'economica'), ( 'Boeing', '737 MAX', '01B', 5.00, 'economica'), ( 'Boeing', '737 MAX', '01C', 5.00, 'economica'), ( 'Boeing', '737 MAX', '01D', 5.00, 'economica'),
( 'Boeing', '737 MAX', '02A', null, 'economica'), ( 'Boeing', '737 MAX', '02B', null, 'economica'), ( 'Boeing', '737 MAX', '02C', null, 'economica'), ( 'Boeing', '737 MAX', '02D', null, 'economica'),
( 'Boeing', '737 MAX', '03A', null, 'economica'), ( 'Boeing', '737 MAX', '03B', null, 'economica'), ( 'Boeing', '737 MAX', '03C', null, 'economica'), ( 'Boeing', '737 MAX', '03D', null, 'economica'),
( 'Boeing', '737 MAX', '04A', null, 'economica'), ( 'Boeing', '737 MAX', '04B', null, 'economica'), ( 'Boeing', '737 MAX', '04C', null, 'economica'), ( 'Boeing', '737 MAX', '04D', null, 'economica'),
( 'Boeing', '737 MAX', '05A', null, 'economica'), ( 'Boeing', '737 MAX', '05B', null, 'economica'), ( 'Boeing', '737 MAX', '05C', null, 'economica'), ( 'Boeing', '737 MAX', '05D', null, 'economica'),
( 'Boeing', '737 MAX', '06A', null, 'economica'), ( 'Boeing', '737 MAX', '06B', null, 'economica'), ( 'Boeing', '737 MAX', '06C', null, 'economica'), ( 'Boeing', '737 MAX', '06D', null, 'economica'),
( 'Boeing', '737 MAX', '07A', null, 'economica'), ( 'Boeing', '737 MAX', '07B', null, 'economica'), ( 'Boeing', '737 MAX', '07C', null, 'economica'), ( 'Boeing', '737 MAX', '07D', null, 'economica'),
( 'Boeing', '737 MAX', '08A', null, 'economica'), ( 'Boeing', '737 MAX', '08B', null, 'economica'), ( 'Boeing', '737 MAX', '08C', null, 'economica'), ( 'Boeing', '737 MAX', '08D', null, 'economica'),
( 'Boeing', '737 MAX', '09A', null, 'economica'), ( 'Boeing', '737 MAX', '09B', null, 'economica'), ( 'Boeing', '737 MAX', '09C', null, 'economica'), ( 'Boeing', '737 MAX', '09D', null, 'economica'),
( 'Boeing', '737 MAX', '10A', 2.50, 'economica'), ( 'Boeing', '737 MAX', '10B', 2.50, 'economica'), ( 'Boeing', '737 MAX', '10C', 2.50, 'economica'), ( 'Boeing', '737 MAX', '10D', 2.50, 'economica'),
( 'Boeing', '737 MAX', '11A', null, 'prima'), ( 'Boeing', '737 MAX', '11B', null, 'prima'), ( 'Boeing', '737 MAX', '11C', null, 'prima'), ( 'Boeing', '737 MAX', '11D', null, 'prima'),
( 'Boeing', '737 MAX', '12A', null, 'prima'), ( 'Boeing', '737 MAX', '12B', null, 'prima'), ( 'Boeing', '737 MAX', '12C', null, 'prima'), ( 'Boeing', '737 MAX', '12D', null, 'prima'),
( 'Boeing', '737 MAX', '13A', null, 'prima'), ( 'Boeing', '737 MAX', '13B', null, 'prima'), ( 'Boeing', '737 MAX', '13C', null, 'prima'), ( 'Boeing', '737 MAX', '13D', null, 'prima'),
( 'Boeing', '737 MAX', '14A', null, 'prima'), ( 'Boeing', '737 MAX', '14B', null, 'prima'), ( 'Boeing', '737 MAX', '14C', null, 'prima'), ( 'Boeing', '737 MAX', '14D', null, 'prima'),
( 'Boeing', '737 MAX', '15A', 9.50, 'prima'), ( 'Boeing', '737 MAX', '15B', 9.50, 'prima'), ( 'Boeing', '737 MAX', '15C', 9.50, 'prima'), ( 'Boeing', '737 MAX', '15D', 9.50, 'prima'),
( 'Boeing', '737 MAX', '16A', null, 'business'), ( 'Boeing', '737 MAX', '16B', null, 'business'), ( 'Boeing', '737 MAX', '16C', null, 'business'), ( 'Boeing', '737 MAX', '16D', null, 'business'),
( 'Boeing', '737 MAX', '17A', null, 'business'), ( 'Boeing', '737 MAX', '17B', null, 'business'), ( 'Boeing', '737 MAX', '17C', null, 'business'), ( 'Boeing', '737 MAX', '17D', null, 'business'),
( 'Boeing', '737 MAX', '18A', null, 'business'), ( 'Boeing', '737 MAX', '18B', null, 'business'), ( 'Boeing', '737 MAX', '18C', null, 'business'), ( 'Boeing', '737 MAX', '18D', null, 'business'),
( 'Boeing', '737 MAX', '19A', 25.00, 'business'), ( 'Boeing', '737 MAX', '19B', 25.00, 'business'), ( 'Boeing', '737 MAX', '19C', 25.00, 'business'), ( 'Boeing', '737 MAX', '19D', 25.00, 'business'),
( 'Boeing', '737 MAX', '20A', 50.00, 'business'), ( 'Boeing', '737 MAX', '20B', 50.00, 'business'), ( 'Boeing', '737 MAX', '20C', 50.00, 'business'), ( 'Boeing', '737 MAX', '20D', 50.00, 'business'),

-- 'Boeing', '767', 'b
-- 'Boeing', '777', 'a
-- 'Airbus', 'A320', '
-- 'Airbus', 'A330', '
-- 'Airbus', 'A380', '
