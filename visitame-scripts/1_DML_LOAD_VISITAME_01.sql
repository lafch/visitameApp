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

COMMIT;