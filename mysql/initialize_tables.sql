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
('Boeing', '737 MAX', 'economica', 20.0),
('Boeing', '737 MAX', 'prima', 45.5),
('Boeing', '737 MAX', 'business', 100.0),
('Boeing', '767', 'economica', 25.0),
('Boeing', '767', 'prima', 50.5),
('Boeing', '767', 'business', 110.0),
('Boeing', '777', 'economica', 30.0),
('Boeing', '777', 'prima', 60.0),
('Boeing', '777', 'business', 115.0),
('Airbus', 'A320', 'economica', 15.0),
('Airbus', 'A320', 'prima', 40.0),
('Airbus', 'A320', 'business', 80.0),
('Airbus', 'A330', 'economica', 25.0),
('Airbus', 'A330', 'prima', 50),
('Airbus', 'A330', 'business', 105.0),
('Airbus', 'A380', 'economica', 40.0),
('Airbus', 'A380', 'prima', 65.0),
('Airbus', 'A380', 'business', 150.0);

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
