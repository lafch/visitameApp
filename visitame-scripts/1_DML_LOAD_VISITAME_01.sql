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

INSERT INTO appvisitame.tvisita003_cfg_valor (
												cd_valor , cd_padre , cd_lista 
												,cd_alterno , nb_etiqueta , nb_glosa , nb_valor , nu_orden , st_estado , cd_creador , tm_creacion , cd_editor,tm_edicion ) 
												VALUES ( 
												(SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')) ,null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='OPE_TIPO_CEL'),
												,'CLAR','Claro','Claro',1,'A',1,current_timestamp,null,null);
												
INSERT INTO appvisitame.tvisita003_cfg_valor (
												cd_valor , cd_padre , cd_lista 
												,cd_alterno , nb_etiqueta , nb_glosa , nb_valor , nu_orden , st_estado , cd_creador , tm_creacion , cd_editor,tm_edicion ) 
												VALUES ( 
												(SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')) ,null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='OPE_TIPO_CEL'),
												,'TELE','Movistar','Movistar',1,'A',1,current_timestamp,null,null);
												
INSERT INTO appvisitame.tvisita003_cfg_valor (
												cd_valor , cd_padre , cd_lista 
												,cd_alterno , nb_etiqueta , nb_glosa , nb_valor , nu_orden , st_estado , cd_creador , tm_creacion , cd_editor,tm_edicion ) 
												VALUES ( 
												(SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')) ,null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='OPE_TIPO_CEL'),
												,'NEXT','Entel','Entel',1,'A',1,current_timestamp,null,null);
												
INSERT INTO appvisitame.tvisita003_cfg_valor (
												cd_valor , cd_padre , cd_lista 
												,cd_alterno , nb_etiqueta , nb_glosa , nb_valor , nu_orden , st_estado , cd_creador , tm_creacion , cd_editor,tm_edicion ) 
												VALUES ( 
												(SELECT nextval('appvisitame.seq_tvisita003_cfg_valor')) ,null,(SELECT CD_LISTA FROM appvisitame.tvisita002_cfg_lista WHERE CD_ALTERNO='OPE_TIPO_CEL'),
												,'BITE','Bitel','Bitel',1,'A',1,current_timestamp,null,null);

												

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



COMMIT;




