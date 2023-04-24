CREATE TABLE nationalities
(
    id   UUID NOT NULL,
    name VARCHAR(255),
    flag TEXT,
    CONSTRAINT pk_nationalities PRIMARY KEY (id)
);