CREATE USER visitamestorm WITH
	LOGIN
	SUPERUSER
	CREATEDB
	CREATEROLE
	INHERIT
	NOREPLICATION
	CONNECTION LIMIT -1
	PASSWORD '$t0rm4ppV1s1tam3';

--drop database visitamedb
CREATE DATABASE t_visitame
    WITH 
    OWNER = visitamestorm
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
	
