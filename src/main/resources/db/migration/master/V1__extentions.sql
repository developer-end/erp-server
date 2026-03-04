-- pgcrypto is a PostgreSQL extension that provides:
-- Cryptographic functions
-- Hashing functions
-- Secure random byte generation
-- Random UUID generation (gen_random_uuid())
-- It is commonly used for:
-- UUID primary keys
-- Password hashing
-- Data encryption
-- Digital signatures
CREATE
EXTENSION IF NOT EXISTS pgcrypto;

-- The citext (Case-Insensitive Text) extension provides a case-insensitive character string type.
-- It behaves like TEXT, but comparisons and uniqueness checks are performed case-insensitively.
-- This is useful for:
-- Usernames
-- Email addresses
-- School names
-- Codes that must be unique regardless of case
-- citext is uses for CITEXT type using in table creation for column type
-- it will act as a unique lower casse index
-- implicit of
-- Case-insensitive username uniqueness
-- CREATE UNIQUE INDEX uq_school_name_lower ON master.school_table (LOWER(school_name));
CREATE
EXTENSION IF NOT EXISTS citext;
