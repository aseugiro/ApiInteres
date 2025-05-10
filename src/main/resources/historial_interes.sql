-- Table: public.historial_interes

-- DROP TABLE IF EXISTS public.historial_interes;

CREATE TABLE IF NOT EXISTS public.historial_interes
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    anio integer NOT NULL,
    monto_simple double precision NOT NULL,
    id_bitacora integer NOT NULL,
    monto_compuesto double precision NOT NULL,
    CONSTRAINT historial_interes_simple_pkey PRIMARY KEY (id),
    CONSTRAINT id_bitacora_fk FOREIGN KEY (id_bitacora)
    REFERENCES public.bitacora (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.historial_interes
    OWNER to postgres;