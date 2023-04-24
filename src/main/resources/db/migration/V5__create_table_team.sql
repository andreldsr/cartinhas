CREATE TABLE teams
(
    id         UUID NOT NULL,
    name       VARCHAR(255),
    image      TEXT,
    background TEXT,
    CONSTRAINT pk_teams PRIMARY KEY (id)
);