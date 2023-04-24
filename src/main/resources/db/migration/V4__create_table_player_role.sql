CREATE TABLE player_roles
(
    id      UUID    NOT NULL,
    name    VARCHAR(255),
    image   TEXT,
    "order" INTEGER NOT NULL,
    CONSTRAINT pk_player_roles PRIMARY KEY (id)
);