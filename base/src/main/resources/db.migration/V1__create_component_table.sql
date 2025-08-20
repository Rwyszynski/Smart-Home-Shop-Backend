CREATE SEQUENCE IF NOT EXISTS component_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE component
(
    component_id BIGINT           NOT NULL,
    brand        VARCHAR(255),
    model        VARCHAR(255),
    voltage      INTEGER          NOT NULL,
    power        INTEGER          NOT NULL,
    protocol     VARCHAR(255),
    current      INTEGER          NOT NULL,
    price        DOUBLE PRECISION NOT NULL,
    url          VARCHAR(255),
    type         VARCHAR(255),
    CONSTRAINT pk_component PRIMARY KEY (component_id)
    );