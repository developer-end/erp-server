CREATE TABLE master.school_table
(
    school_id      UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    institution_id UUID             NOT NULL,
    school_name    CITEXT           NOT NULL UNIQUE,
    version        BIGINT           NOT NULL,
    is_active      BOOLEAN          NOT NULL DEFAULT TRUE,
    created_at     TIMESTAMPTZ      NOT NULL DEFAULT now(),
    updated_at     TIMESTAMPTZ      NOT NULL DEFAULT now(),

    CONSTRAINT fk_school_table FOREIGN KEY (institution_id)
        REFERENCES master.institution_table (institution_id) ON UPDATE CASCADE ON DELETE RESTRICT
);
CREATE INDEX idx_school_table_active ON master.school_table (is_active);



CREATE TABLE master.tenant_table
(
    tenant_id   UUID PRIMARY KEY NOT NULL,
    tenant_name CITEXT           NOT NULL UNIQUE,
    description TEXT,
    version     BIGINT           NOT NULL,
    is_active   BOOLEAN          NOT NULL DEFAULT TRUE,
    created_at  TIMESTAMPTZ      NOT NULL DEFAULT now(),
    updated_at  TIMESTAMPTZ      NOT NULL DEFAULT now()
);
CREATE INDEX idx_tenant_table_active ON master.tenant_table (is_active);


CREATE TABLE master.tenant_school
(
    school_id   UUID        NOT NULL,
    tenant_id   UUID        NOT NULL,
    description TEXT,
    version     BIGINT      NOT NULL,
    is_active   BOOLEAN     NOT NULL DEFAULT TRUE,
    created_at  TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at  TIMESTAMPTZ NOT NULL DEFAULT now(),

    PRIMARY KEY (school_id, tenant_id),

    CONSTRAINT fk_tenant_school_school
        FOREIGN KEY (school_id) REFERENCES master.school_table (school_id)
            ON UPDATE CASCADE
            ON DELETE RESTRICT,

    CONSTRAINT uq_tenant_school_tenant
        FOREIGN KEY (tenant_id) REFERENCES master.tenant_table (tenant_id)
            ON UPDATE CASCADE
            ON DELETE RESTRICT
);
CREATE INDEX idx_tenant_school_active ON master.tenant_school (is_active);
