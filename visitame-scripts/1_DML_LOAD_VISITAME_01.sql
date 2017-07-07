-- PI4 - SPRINT 5 - LOGIN --
--INSERT PARAMETROS
INSERT INTO appvisitame.tvisita001_cfg_paramet (cd_parametro,nb_etiqueta,nb_glosa,tx_valor,cd_creador,tm_creacion) VALUES ('RADIO_ALCANCE_APP','PARAMETRO DE ALCANCE MAPA DEL APP VISITAME','Corresponde al radio de alcance para la busqueda en el mapa del app de visitas.','3',1,current_timestamp);

--INSERT LISTA VALORES
INSERT INTO appvisitame.tvisita002_cfg_lista (cd_lista,cd_alterno,nb_etiqueta,nb_glosa,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ( (SELECT nextval('appvisitame.seq_tvisita002_cfg_lista')) ,'PERSON_DOI_TIPO','Tipos de DOI de persona','dssd','A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita002_cfg_lista (cd_lista,cd_alterno,nb_etiqueta,nb_glosa,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ( (SELECT nextval('appvisitame.seq_tvisita002_cfg_lista')) ,'PARAMETROS_INIT','PARAMETROS INICIALES DEL APP','PARAMETROS INICIALES DEL APP','A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita002_cfg_lista (cd_lista,cd_alterno,nb_etiqueta,nb_glosa,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ( (SELECT nextval('appvisitame.seq_tvisita002_cfg_lista')) ,'PERSON_TIPO','Tipos de persona','Tipos de persona','A',1,current_timestamp,null,null);
 
--INSERT VALORES
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ( (SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')) ,null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='PERSON_DOI_TIPO'),'E','EXT','Carnet de extranjeria','E',1,'A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ( (SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')) ,null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='PERSON_DOI_TIPO'),'L','DNI','Documento Nacional de Identidad','L',1,'A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ( (SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')) ,null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='PARAMETROS_INIT'),'ZOOM_MAP_GEN','ZOOM_MAP_GEN','Zoom del mapa general','16',2,'A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ( (SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')) ,null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='PARAMETROS_INIT'),'RAD_ALCANCE','RAD_ALCANCE','Radio alcance busqueda mapa app visitame','3000',1,'A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ( (SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')) ,null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='PERSON_TIPO'),'PN','Natural','Persona natural','PN',2,'A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ( (SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')) ,null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='PERSON_TIPO'),'PJ','Jurídica','Persona jurídica','PJ',1,'A',1,current_timestamp,null,null);

-- PARAMETROS INTENTOS LOGIN
INSERT INTO appvisitame.tvisita001_cfg_paramet (cd_parametro,nb_etiqueta,nb_glosa,tx_valor,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ('NUM_MAX_INTENTO_TICKET','NUM_MAX_INTENTO_TICKET','Número máximo de intentos de generacion de tickec por dia','3',0,'2017-06-30 16:44:57.911000',null,null);
INSERT INTO appvisitame.tvisita001_cfg_paramet (cd_parametro,nb_etiqueta,nb_glosa,tx_valor,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ('HORAS_ESPERA_ULT_INTENTO','HORAS_ESPERA_ULT_INTENTO','Horas de espera para obtencion del siguiente tckect','2',0,'2017-06-30 16:46:22.006000',null,null);

-- INSERT LISTA VALORES TIPO OPERADOR CELULARES
INSERT INTO appvisitame.tvisita002_cfg_lista (cd_lista,cd_alterno,nb_etiqueta,nb_glosa,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ( (SELECT nextval('appvisitame.seq_tvisita002_cfg_lista')) ,'OPE_TIPO_CEL','Tipos de poperador celulares','Tipos de operadores de servicios moviles para celulares','A',1,current_timestamp,null,null);

-- INSERT VALORES TIPO OPERADOR CELULARES

INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ((SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')),null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='OPE_TIPO_CEL'),'CLAR','Claro','Claro',null,1,'A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ((SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')),null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='OPE_TIPO_CEL'),'TELE','Movistar','Movistar',null,2,'A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ((SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')),null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='OPE_TIPO_CEL'),'NEXT','Entel','Entel',null,3,'A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ((SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')),null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='OPE_TIPO_CEL'),'BITE','Bitel','Bitel',null,4,'A',1,current_timestamp,null,null);

												

-- PI4 - SPRINT 5 - SERVICIO DE RENIEC--
--INSERT PARAMETROS RENIEC												
INSERT INTO appvisitame.TVISITA001_CFG_PARAMET (CD_PARAMETRO, NB_ETIQUETA, NB_GLOSA, TX_VALOR, CD_CREADOR, TM_CREACION) 
VALUES ('WS_PAR_REN_CANAL','RENIEC PAR CANAL','Corresponde al parametro canal para el servicio de RENIEC','S_C_',1,now());
INSERT INTO appvisitame.TVISITA001_CFG_PARAMET (CD_PARAMETRO, NB_ETIQUETA, NB_GLOSA, TX_VALOR, CD_CREADOR, TM_CREACION) 
VALUES ('WS_PAR_REN_EMPRESA','RENIEC PAR EMPRESA','Corresponde al parametro idempresa para el servicio de RENIEC','RENI',1,now());
INSERT INTO appvisitame.TVISITA001_CFG_PARAMET (CD_PARAMETRO, NB_ETIQUETA, NB_GLOSA, TX_VALOR, CD_CREADOR, TM_CREACION) 
VALUES ('WS_PAR_REN_COD_INTERFAZ','RENIEC PAR INTERFAZ','Corresponde al parametro interfaz para el servicio de RENIEC','CPERRENXDNI',1,now());
INSERT INTO appvisitame.TVISITA001_CFG_PARAMET (CD_PARAMETRO, NB_ETIQUETA, NB_GLOSA, TX_VALOR, CD_CREADOR, TM_CREACION) 
VALUES ('WS_PAR_REN_TIP_APLICACION','RENIEC PAR','Corresponde al parametro tipo aplicacion para el servicio de RENIEC','E',1,now());
INSERT INTO appvisitame.TVISITA001_CFG_PARAMET (CD_PARAMETRO, NB_ETIQUETA, NB_GLOSA, TX_VALOR, CD_CREADOR, TM_CREACION) 
VALUES ('WS_PAR_REN_ID_CONS_DATOS','RENIEC PAR','Corresponde al parametro indicador consulta de datos para el servicio de RENIEC','S',1,now());
INSERT INTO appvisitame.TVISITA001_CFG_PARAMET (CD_PARAMETRO, NB_ETIQUETA, NB_GLOSA, TX_VALOR, CD_CREADOR, TM_CREACION) 
VALUES ('WS_PAR_REN_ID_CONS_FOTO','RENIEC PAR','Corresponde al parametro indicador consulta de foto para el servicio de RENIEC','N',1,now());
INSERT INTO appvisitame.TVISITA001_CFG_PARAMET (CD_PARAMETRO, NB_ETIQUETA, NB_GLOSA, TX_VALOR, CD_CREADOR, TM_CREACION) 
VALUES ('WS_PAR_REN_ID_CONS_FIRMA','RENIEC PAR','Corresponde al parametro indicador consulta de firma para el servicio de RENIEC','N',1,now());
INSERT INTO appvisitame.TVISITA001_CFG_PARAMET (CD_PARAMETRO, NB_ETIQUETA, NB_GLOSA, TX_VALOR, CD_CREADOR, TM_CREACION) 
VALUES ('WS_PAR_COD_APP_VISITAME','RENIEC PAR CODIGO VISITAME','Prefijo codigo aplicacion','VISITA',1,now());
INSERT INTO appvisitame.TVISITA001_CFG_PARAMET (CD_PARAMETRO, NB_ETIQUETA, NB_GLOSA, TX_VALOR, CD_CREADOR, TM_CREACION) 
VALUES ('URL_WS_RENIEC','RUTA WS RENIEC','Corresponde a la ruta soap del servicio de RENIEC','http://118.180.34.15:9080/WSIntegracionRENIEC/services/WS_PersonaReniec',1,now());
INSERT INTO appvisitame.TVISITA001_CFG_PARAMET (CD_PARAMETRO, NB_ETIQUETA, NB_GLOSA, TX_VALOR, CD_CREADOR, TM_CREACION) 
VALUES ('TO_WS_RENIEC','TIME OUT WS LDAP','Corresponde al time out para el servicio de RENIEC','5000',1,now());


--INSERT TABLA OFICINAS
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0486','SAN ISIDRO','AV. REPUBLICA DE PANAMÁ 3055',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0354','LAS BEGONIAS','AV. LAS BEGONIAS 425 - 429',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0387','CANAVAL Y MOREYRA','AV. CANAVAL Y MOREYRA 243 - 245',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0142','C.C.SAN ISIDRO','AV. RIVERA NAVARRETE N° 815',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0351','LOS GERANIOS (EX RIVERA NAVARRETE)','AV. RIVERA NAVARRETE 2801-2821, ESQ. LOS GERANIOS 304-308',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0352','LAS TIENDAS','CALLE LAS TIENDAS 209, ALT. CDRA. 7 Y 8 AV. ARAMBURU',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0191','CORPAC','CALLE 23  #273 CORPAC',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0359','AV. CENTRAL','AV. BASADRE 133',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0356','PETIT THOUARS','AV. PETIT THOUARS N° 2790 ESQ. JR. PERCY GIBSON',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0131','NICOLAS ARRIOLA 1','AV. NICOLAS ARRIOLA 607',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0187','ARAMBURU','AV. ARAMBURU N° 154-158-162- MIRAFLORES',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0161','LINCE','AV. IGNACIO MERINO 2099',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0185','TOMAS MARSANO','AV. TOMAS MARSANO N° 399',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0123','CAMINO REAL','AV. CAMINO REAL 355',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0153','C.C.RISSO','ESQ. AV. AREQUIPA CON JR. RISSO',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0364','JORGE BASADRE','JORGE BASADRE 487',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0186','C.C. SAN BORJA','AV. JAVIER PRADO ESTE N° 2010, MZ. I-2, CALLES MORELLI, CARPACCIO Y UCELLO',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0369','EL OLIVAR (Ex Conquistadores 2)','AV. CONQUISTADORES  701',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0152','SAN BORJA (Ex San Borja 1)','AV. AVIACION 2465-2467',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0355','AVIACIÓN (Ex San Borja 3)','AV. AVIACION  2801 - 2805',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0149','SURQUILLO','AV. ANGAMOS ESTE 1256',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0112','MEXICO','AV. MEXICO 568',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0508','ANGAMOS OPEN PLAZA','AV. ANGAMOS 1803. TIENDA LC-62 - SURQUILLO',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0366','CONQUISTADORES','AV. CONQUISTADORES 1095 ESQ. AV. PARDO Y ALIAGA',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0353','DOMINGO CUETO','JR. DOMINGO CUETO 150 (15 ARENALES)',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0616','ANGAMOS ESTE','Av. Angamos Este 215 - 227, esquina con Av. Petit Thouars 5091',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0124','PARINACOCHAS','AV. MEXICO 1298 ESQ. PROLONGACION PARINACOCHAS',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0189','DOS DE MAYO','CALLE LOS LAURELES 214 - OF. 210 ESQ. CON LA CUADRA 15 DE DOS DE MAYO',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0372','LOS ROBLES (Ex Dos de Mayo - Los Robles)','AV. DOS DE MAYO 1198',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0716','SANTA CRUZ','Av. Santa Cruz N° 695',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0320','ESSALUD','AV. ARENALES 1302, OF. 150',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0179','CAVENECIA','ESQ. JR. CAVENECIA CON CALLE TUDELA Y VARELA',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0180','PARQUE CASTILLA (EX MERCADO RISSO)','AV. JULIO C. TELLO 1002',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0370','LIMATAMBO','AV. AVIACIÓN N° 3328 (LOTE 6, MZ. B1). URBANIZACIÓN LAS MAGNOLIAS',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0163','APOLO','AV. MEXICO 1700',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0169','COMANDANTE ESPINAR','AV. COMANDANTE ESPINAR N° 374, 384 y 388',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0358','SAN LUIS','AV. SAN LUIS 1913',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0368','RICARDO PALMA','AV. RICARDO PALMA 296 - 298',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0197','NICOLAS ARRIOLA 2','AV. NICOLAS ARRIOLA 1799',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0615','SAN BORJA SUR','CALLE CHOPIN MZ. A-16, LT. 29, ESQUINA CON AV. SAN LUIS, URB. SAN BORJA, II ETAPA',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0659','SEBASTIÁN BARRANCA','AV. IQUITOS 795-799, ESQUINA CON SEBASTIÁN BARRANCA 209-211-213',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0147','ARENALES','AV. ARENALES 701',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0138','C.C. AURORA','CALLE ARIAS SCHEREIBER 215-217',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0156','PARDO','AV. PARDO 791 - 793 - 795',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0144','GAMARRA (Ex Mercado Mayorista)','PROLONG. UNANUE 1599',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0117','LARCO - TARATA','AV. LARCO 631',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0244','HIPOLITO UNANUE','JR HIPOLITO UNANUE 1616-1620, LOCAL 3',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0341','CANADA-LA ROSA TORO','AV. LA ROSA TORO 998',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0182','SANTA MONICA','AV. JUAN PEZET 1425',0);
INSERT INTO appvisitame.tvisita006_ofi_oficina (cd_oficina,cd_alterno,nb_oficina,nb_direccion,nu_sec_ticket) VALUES (
'BR_PE_0426','AV. DEL EJERCITO','AV. DEL EJERCITO 789 ESQUINA CALLE JOSE TORIBIO POLO 286',0);


-- PI4 - SPRINT 6 - SERVICIO DE RENIEC--
-- INSERT LISTA VALORES SATURACION DE OFICINA
INSERT INTO appvisitame.tvisita002_cfg_lista (cd_lista,cd_alterno,nb_etiqueta,nb_glosa,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) 
VALUES ( (SELECT nextval('appvisitame.seq_tvisita002_cfg_lista')) ,'SATURACION_OFI','Saturacion de oficinas','Saturacion de oficinas','A',1,current_timestamp,null,null);

-- INSERT VALORES SATURACION DE OFICINA
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ((SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')),null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='SATURACION_OFI'),'ALTA','ALTA','Saturacion Alta',15,1,'A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ((SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')),null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='SATURACION_OFI'),'MEDIA','MEDIA','Saturacion media',10,2,'A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ((SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')),null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='SATURACION_OFI'),'BAJA','BAJA','Saturacion baja',5,3,'A',1,current_timestamp,null,null);


-- INSERT LISTA VALORES ESTADO DE ENVIO DE TICKET
INSERT INTO appvisitame.tvisita002_cfg_lista (cd_lista,cd_alterno,nb_etiqueta,nb_glosa,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) 
VALUES ( (SELECT nextval('appvisitame.seq_tvisita002_cfg_lista')) ,'ESTADO_TICKET','Estado de envio de tickets','Estado de envio de tickets','A',1,current_timestamp,null,null);

-- INSERT VALORES TIPO ESTADO DE ENVIO DE TICKET
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ((SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')),null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='ESTADO_TICKET'),'COLA','ALTA','Ticket en cola','COLA',1,'A',1,current_timestamp,null,null);
INSERT INTO appvisitame.tvisita003_cfg_valor (cd_valor,cd_padre,cd_lista,cd_alterno,nb_etiqueta,nb_glosa,nb_valor,nu_orden,st_estado,cd_creador,tm_creacion,cd_editor,tm_edicion) VALUES ((SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')),null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='ESTADO_TICKET'),'ENVIADO','MEDIA','Ticket enviado','ENVIADO',2,'A',1,current_timestamp,null,null);


ALTER TABLE appvisitame.tvisita003_cfg_valor ADD COLUMN nb_icono varchar(400);

UPDATE appvisitame.tvisita003_cfg_valor SET nb_icono = 'icon_marker_naranja.png' WHERE cd_alterno='ALTA';
UPDATE appvisitame.tvisita003_cfg_valor SET nb_icono = 'icon_marker_amarillo.png' WHERE cd_alterno='MEDIA';
UPDATE appvisitame.tvisita003_cfg_valor SET nb_icono = 'icon_marker_verde.png' WHERE cd_alterno='BAJA';



COMMIT;




