CREATE TABLE master.user_table
(
    user_id    UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    first_name VARCHAR(100)     NOT NULL,
    last_name  VARCHAR(100)     NOT NULL,
    email      CITEXT           NOT NULL UNIQUE,
    username   CITEXT           NOT NULL UNIQUE,
    password   TEXT             NOT NULL,
    mobile_no  VARCHAR(15),
    version    BIGINT           NOT NULL,
    is_active  BOOLEAN          NOT NULL DEFAULT TRUE,
    created_at TIMESTAMPTZ      NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ      NOT NULL DEFAULT now()
);
CREATE INDEX idx_users_email ON master.user_table (email);
CREATE INDEX idx_users_username ON master.user_table (username);
CREATE INDEX idx_user_active ON master.user_table (is_active);


CREATE TABLE master.oauth_accounts
(
    oauth_id         UUID PRIMARY KEY      DEFAULT gen_random_uuid(),
    user_id          UUID         NOT NULL,
    provider         VARCHAR(30)  NOT NULL,
    provider_user_id VARCHAR(255) NOT NULL,
    version          BIGINT       NOT NULL,
    is_active        BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at       TIMESTAMPTZ  NOT NULL DEFAULT now(),
    updated_at       TIMESTAMPTZ  NOT NULL DEFAULT now(),
    CONSTRAINT fk_oauth_user
        FOREIGN KEY (user_id) REFERENCES master.user_table (user_id)
            ON DELETE CASCADE
);
CREATE UNIQUE INDEX idx_oauth_provider_user
    ON master.oauth_accounts (provider, provider_user_id);
CREATE INDEX idx_oauth_provider_active ON master.oauth_accounts (is_active);

CREATE TABLE master.role_table
(
    role_id     UUID PRIMARY KEY      DEFAULT gen_random_uuid(),
    role_code   CITEXT       NOT NULL UNIQUE,
    role_name   VARCHAR(250) NOT NULL,
    description TEXT,
    version     BIGINT       NOT NULL,
    is_active   BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at  TIMESTAMPTZ  NOT NULL DEFAULT now(),
    updated_at  TIMESTAMPTZ  NOT NULL DEFAULT now()
);
CREATE INDEX idx_role_table_active ON master.role_table (is_active);

INSERT INTO master.role_table (role_code, role_name, version)
VALUES ('ROLE_SUPER_ADMIN', 'Super Administrator', 1),
       ('ROLE_ADMIN', 'Administrator', 1),
       ('ROLE_TEACHER', 'Teacher', 1),
       ('ROLE_STUDENT', 'Student', 1),
       ('ROLE_ACCOUNTANT', 'Accountant', 1)
;


CREATE TABLE master.user_roles
(
    user_id     UUID        NOT NULL,
    role_id     UUID         NOT NULL,
    description TEXT,
    version     BIGINT      NOT NULL,
    is_active   BOOLEAN     NOT NULL DEFAULT TRUE,
    assigned_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at  TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at  TIMESTAMPTZ NOT NULL DEFAULT now(),
    PRIMARY KEY (user_id, role_id),

    CONSTRAINT fk_user_roles_user
        FOREIGN KEY (user_id) REFERENCES master.user_table (user_id)
            ON DELETE CASCADE,

    CONSTRAINT fk_user_roles_role
        FOREIGN KEY (role_id) REFERENCES master.role_table (role_id)
            ON DELETE CASCADE
);
CREATE INDEX idx_user_roles_active ON master.user_roles (is_active);
