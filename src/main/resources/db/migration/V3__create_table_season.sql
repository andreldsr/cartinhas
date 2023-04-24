CREATE TABLE seasons
(
    id      UUID    NOT NULL,
    name    VARCHAR(255),
    current BOOLEAN NOT NULL,
    CONSTRAINT pk_seasons PRIMARY KEY (id)
);