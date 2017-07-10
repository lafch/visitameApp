--drop schema appvisitame cascade;
CREATE SCHEMA appvisitame;
alter schema appvisitame OWNER TO visitamestorm;

CREATE TABLE appvisitame.TVISITA001_CFG_PARAMET (
                CD_PARAMETRO VARCHAR(30) NOT NULL,
                NB_ETIQUETA VARCHAR(50) NOT NULL,
                NB_GLOSA VARCHAR(400),
                TX_VALOR VARCHAR(800) NOT NULL,
                CD_CREADOR INTEGER NOT NULL,
                TM_CREACION TIMESTAMP NOT NULL,
                CD_EDITOR INTEGER,
                TM_EDICION TIMESTAMP,
                PRIMARY KEY (CD_PARAMETRO)
);



CREATE TABLE appvisitame.TVISITA002_CFG_LISTA (
                CD_LISTA INTEGER NOT NULL,
                CD_ALTERNO VARCHAR(15) NOT NULL,
                NB_ETIQUETA VARCHAR(100) NOT NULL,
                NB_GLOSA VARCHAR(400),
                ST_ESTADO VARCHAR(40),
                CD_CREADOR INTEGER NOT NULL,
                TM_CREACION TIMESTAMP NOT NULL,
                CD_EDITOR INTEGER,
                TM_EDICION TIMESTAMP,
                PRIMARY KEY (CD_LISTA)
);



CREATE TABLE appvisitame.TVISITA003_CFG_VALOR (
                CD_VALOR INTEGER NOT NULL,
                CD_PADRE INTEGER,
                CD_LISTA INTEGER NOT NULL,
                CD_ALTERNO VARCHAR(15) NOT NULL,
                NB_ETIQUETA VARCHAR(100) NOT NULL,
                NB_GLOSA VARCHAR(400),
                NB_VALOR VARCHAR(1000),
                NU_ORDEN INTEGER,
                ST_ESTADO VARCHAR(20) NOT NULL,
                CD_CREADOR INTEGER NOT NULL,
                TM_CREACION TIMESTAMP NOT NULL,
                CD_EDITOR INTEGER,
                TM_EDICION TIMESTAMP,
                PRIMARY KEY (CD_VALOR)
);


ALTER TABLE appvisitame.TVISITA003_CFG_VALOR ADD CONSTRAINT r0040031
FOREIGN KEY (CD_LISTA)
REFERENCES appvisitame.TVISITA002_CFG_LISTA (CD_LISTA)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE appvisitame.TVISITA003_CFG_VALOR ADD CONSTRAINT r0030031
FOREIGN KEY (CD_PADRE)
REFERENCES appvisitame.TVISITA003_CFG_VALOR (CD_VALOR)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

    
-- Crear Tablas de Login e Intentos
CREATE TABLE appvisitame.tvisita004_per_persona
(
   CD_PERSONA           INTEGER NOT NULL,
   CD_ALTERNO           INTEGER,
   CD_TIPO_DOI          INTEGER,
   NB_NUM_DOI           VARCHAR(15)  NOT NULL,
   CD_TIPO_PERSONA      INTEGER,
   NB_NOMBRE            VARCHAR(60) NOT NULL,
   NB_PATERNO           VARCHAR(30),
   NB_MATERNO           VARCHAR(30),
   NB_EMAIL             VARCHAR(40),
   NB_TELEFONO          VARCHAR(9),
   CD_CREADOR 		    INTEGER NOT NULL,
   TM_CREACION          TIMESTAMP NOT NULL,
   CD_EDITOR            INTEGER,
   TM_EDICION           TIMESTAMP,
   PRIMARY KEY (CD_PERSONA)
);

CREATE TABLE appvisitame.tvisita005_seg_intento_logueo
(
   CD_INTENTO           INTEGER NOT NULL,
   NB_NUM_DOI           VARCHAR(15)  NOT NULL,
   NB_LOGIN             VARCHAR(30),
   CD_TIPO_DOI          INTEGER,
   TM_HORA_LOGIN        TIMESTAMP,
   NB_IP                VARCHAR(30),
   NB_ID_DISPOSITIVO    VARCHAR(30),
   NB_RESULTADO         VARCHAR(30),
   CD_CREADOR 		    INTEGER NOT NULL,
   TM_CREACION 	    TIMESTAMP NOT NULL,
   CD_EDITOR 		    INTEGER,
   TM_EDICION 		    TIMESTAMP,
   PRIMARY KEY (CD_INTENTO)
);

/*Nuevos*/

CREATE TABLE appvisitame.TVISITA006_OFI_OFICINA (
    CD_OFICINA    INTEGER NOT NULL,
    CD_ALTERNO    VARCHAR(100) NOT NULL,
    NB_OFICINA    VARCHAR(400),
    NB_DIRECCION  VARCHAR(400),
    NU_SEC_TICKET INTEGER,
	PRIMARY KEY (CD_OFICINA)
);

CREATE TABLE appvisitame.TVISITA007_OFI_HISTORICO (
    CD_HISTORICO INTEGER NOT NULL,
    CD_ALTERNO   INTEGER,
	CD_PERSONA   INTEGER NOT NULL,
    NU_TELEFONO  INTEGER,
    NB_CORREO    VARCHAR(400),
	CD_TIP_OPERADOR INTEGER,
    TM_CREACION  TIMESTAMP NOT NULL,
    CD_CREADOR   INTEGER,
    TM_EDICION   TIMESTAMP,
    CD_EDITOR    INTEGER,
    CD_EST_ENVIO INTEGER NOT NULL,
    PRIMARY KEY (CD_HISTORICO)
);

ALTER TABLE appvisitame.TVISITA007_OFI_HISTORICO ADD CONSTRAINT r0040031
FOREIGN KEY (CD_EST_ENVIO)
REFERENCES appvisitame.TVISITA003_CFG_VALOR (CD_VALOR)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE appvisitame.TVISITA007_OFI_HISTORICO ADD CONSTRAINT r0040032
FOREIGN KEY (CD_TIP_OPERADOR)
REFERENCES appvisitame.TVISITA003_CFG_VALOR (CD_VALOR)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE appvisitame.TVISITA007_OFI_HISTORICO ADD CONSTRAINT r0040033
FOREIGN KEY (CD_PERSONA)
REFERENCES appvisitame.TVISITA004_PER_PERSONA(CD_PERSONA)
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE;

--SEQUENCES
CREATE SEQUENCE appvisitame.seq_tvisita002_cfg_lista;

ALTER SEQUENCE appvisitame.seq_tvisita002_cfg_lista
    OWNER TO visitamestorm;

CREATE SEQUENCE appvisitame.seq_tvisita003_cfg_valor;

ALTER SEQUENCE appvisitame.seq_tvisita003_cfg_valor
    OWNER TO visitamestorm;
    
CREATE SEQUENCE appvisitame.seq_tvisita004_per_persona;

ALTER SEQUENCE appvisitame.seq_tvisita004_per_persona
    OWNER TO visitamestorm;
    
CREATE SEQUENCE appvisitame.seq_tvisita005_seg_intento_logueo;

ALTER SEQUENCE appvisitame.seq_tvisita005_seg_intento_logueo
    OWNER TO visitamestorm;
    
/*Nuevos*/
CREATE SEQUENCE appvisitame.seq_tvisita006_ofi_oficina;

ALTER SEQUENCE appvisitame.seq_tvisita006_ofi_oficina
    OWNER TO visitamestorm;
    
CREATE SEQUENCE appvisitame.seq_tvisita007_ofi_historico;

ALTER SEQUENCE appvisitame.seq_tvisita007_ofi_historico
    OWNER TO visitamestorm;

-- CAMPOS ADICIONALES PERSONA
ALTER TABLE appvisitame.tvisita004_per_persona
ADD nb_cliente varchar(1); 
    
COMMIT;
    
    
    
    
    
    
    
    
    

    
    