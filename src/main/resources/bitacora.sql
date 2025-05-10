-- Table: public.bitacora

-- DROP TABLE IF EXISTS public.bitacora;

CREATE TABLE IF NOT EXISTS public.bitacora
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    fecha text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT bitacora_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.bitacora
    OWNER to postgres;