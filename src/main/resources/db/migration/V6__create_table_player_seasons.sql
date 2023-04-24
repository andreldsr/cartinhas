CREATE TABLE player_seasons
(
    id             UUID NOT NULL,
    player_id      UUID,
    season_id      UUID,
    team_id        UUID,
    player_role_id UUID,
    image          TEXT,
    CONSTRAINT pk_player_seasons PRIMARY KEY (id)
);

ALTER TABLE player_seasons
    ADD CONSTRAINT FK_PLAYER_SEASONS_ON_PLAYER FOREIGN KEY (player_id) REFERENCES players (id);

ALTER TABLE player_seasons
    ADD CONSTRAINT FK_PLAYER_SEASONS_ON_PLAYERROLE FOREIGN KEY (player_role_id) REFERENCES player_roles (id);

ALTER TABLE player_seasons
    ADD CONSTRAINT FK_PLAYER_SEASONS_ON_SEASON FOREIGN KEY (season_id) REFERENCES seasons (id);

ALTER TABLE player_seasons
    ADD CONSTRAINT FK_PLAYER_SEASONS_ON_TEAM FOREIGN KEY (team_id) REFERENCES teams (id);