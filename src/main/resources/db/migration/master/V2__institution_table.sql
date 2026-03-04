CREATE TABLE master.institution_table
(
    institution_id   UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    institution_name CITEXT           NOT NULL UNIQUE,
    institution_code CITEXT           NOT NULL UNIQUE,
    description      TEXT,
    version          BIGINT           NOT NULL,
    is_active        BOOLEAN          NOT NULL DEFAULT TRUE,
    created_at       TIMESTAMPTZ      NOT NULL DEFAULT now(),
    updated_at       TIMESTAMPTZ      NOT NULL DEFAULT now()
);
