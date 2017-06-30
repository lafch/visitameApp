-- FUNCTION CONTAR INTENCIONES EN EL DIA
CREATE OR REPLACE FUNCTION appvisitame.sp_contar_intentos_dia(tdoi varchar , numdoc varchar , fecha DATE) RETURNS INT AS $$
    DECLARE
    v_count int; 
    BEGIN
    select count(*) into v_count from appvisitame.tvisita005_seg_intento_logueo l
    where 
        (l.tm_creacion::date) = fecha
        and l.nb_num_doi = numdoc
        and l.cd_tipo_doi = tdoi;
        
    RETURN v_count;
    END;
$$ LANGUAGE plpgsql;