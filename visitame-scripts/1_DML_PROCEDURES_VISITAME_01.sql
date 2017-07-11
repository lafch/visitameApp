-- FUNCTION CONTAR INTENCIONES EN EL DIA
 CREATE OR REPLACE FUNCTION appvisitame.sp_contar_intentos_dia(tdoi int , numdoc varchar , fecha varchar) RETURNS INT AS $$
        DECLARE
        v_count int; 
        BEGIN
        select count(*) into v_count from appvisitame.tvisita005_seg_intento_logueo l
        where 
            to_char(l.tm_creacion::date,'YYYY-MM-DD') = fecha
            and l.nb_num_doi = numdoc
            and l.cd_tipo_doi = tdoi;
        RETURN v_count;
        END;
    $$ LANGUAGE plpgsql;
    
 -- FUNCTION OBTENER LAS HORAS TRASCURRIDAS DESDE EL ULTIMO INTENTO REALIZADO
CREATE OR REPLACE FUNCTION appvisitame.sp_horas_ultimo_intento(tdoi int , numdoc varchar) RETURNS INT AS $$
        DECLARE
        v_count int; 
        BEGIN
        select 
        (DATE_PART('day',current_timestamp - l.tm_creacion) * 24 + 
                      DATE_PART('hour',current_timestamp - l.tm_creacion)) into v_count
        from appvisitame.tvisita005_seg_intento_logueo l
        where 
            l.tm_creacion::date = current_date
            and l.nb_num_doi = numdoc
            and l.cd_tipo_doi = tdoi
        order by l.tm_creacion desc
        limit 1;
        RETURN v_count;
        END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION appvisitame.sp_minutos_ultimo_intento(tdoi int , numdoc varchar) RETURNS INT AS $$
        DECLARE
        v_count int; 
        BEGIN
        select 
        (
	       	DATE_PART('day', current_timestamp - l.tm_creacion) * 24 + 
	               DATE_PART('hour', current_timestamp - l.tm_creacion) * 60 +
	               DATE_PART('minute', current_timestamp - l.tm_creacion)                                   
        ) 
        into v_count
        from appvisitame.tvisita005_seg_intento_logueo l
        where 
            l.tm_creacion::date = current_date
            and l.nb_num_doi = numdoc
            and l.cd_tipo_doi = tdoi
        order by l.tm_creacion desc
        limit 1;
        RETURN v_count;
        END;
$$ LANGUAGE plpgsql;

-- FUNCTION GENERAR TICKET Y ACTUALIZAR  10/07/2017 
CREATE OR REPLACE FUNCTION appvisitame.sp_generar_ticket_oficina(codOficinas varchar) RETURNS INT AS $$
        DECLARE
        v_ticket int; 
        BEGIN
        SELECT max (nu_sec_ticket) + 1 into v_ticket
        FROM appvisitame.tvisita006_ofi_oficina 
        where appvisitame.tvisita006_ofi_oficina.cd_alterno = codOficinas;

		UPDATE appvisitame.tvisita006_ofi_oficina
        SET  nu_sec_ticket = v_ticket
        WHERE appvisitame.tvisita006_ofi_oficina.cd_alterno = codOficinas;
        
        RETURN v_ticket;
        END;
$$ LANGUAGE plpgsql;