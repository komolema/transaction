DROP TABLE IF EXISTS Transaction;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;

CREATE TABLE Transaction
(
    id               uuid DEFAULT uuid_generate_v4(),
    date             TIMESTAMP NOT NULL,
    transaction_type INTEGER   NOT NULL,
    amount           DECIMAL   NOT NULL,
    account_id       uuid,
    PRIMARY KEY (id)
);