CREATE TABLE users (
        id BIGSERIAL PRIMARY KEY,
        login VARCHAR NOT NULL,
        password VARCHAR NOT NULL);