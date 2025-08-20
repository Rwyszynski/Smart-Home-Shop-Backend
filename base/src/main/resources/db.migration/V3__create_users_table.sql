CREATE SEQUENCE IF NOT EXISTS users_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE users
(
    user_id      BIGINT NOT NULL,
    user_name    VARCHAR(255),
    user_surname VARCHAR(255),
    email        VARCHAR(255),
    address      VARCHAR(255),
    password     VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (user_id)
);