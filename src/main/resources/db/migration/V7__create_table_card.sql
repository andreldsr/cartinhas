CREATE TABLE cards
(
    id               UUID    NOT NULL,
    player_season_id UUID,
    image            TEXT,
    last_score       INTEGER,
    last_diff        INTEGER,
    highest_score    INTEGER,
    bagres           INTEGER NOT NULL,
    craques          INTEGER NOT NULL,
    CONSTRAINT pk_cards PRIMARY KEY (id)
);

ALTER TABLE cards
    ADD CONSTRAINT FK_CARDS_ON_PLAYERSEASON FOREIGN KEY (player_season_id) REFERENCES player_seasons (id);