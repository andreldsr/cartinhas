CREATE TABLE players
(
    id             UUID NOT NULL,
    name           VARCHAR(255),
    nationality_id UUID,
    CONSTRAINT pk_players PRIMARY KEY (id)
);

ALTER TABLE players
    ADD CONSTRAINT FK_PLAYERS_ON_NATIONALITY FOREIGN KEY (nationality_id) REFERENCES nationalities (id);