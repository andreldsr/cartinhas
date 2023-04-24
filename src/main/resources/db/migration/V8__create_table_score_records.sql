CREATE TABLE score_records
(
    id      UUID    NOT NULL,
    card_id UUID,
    score   INTEGER NOT NULL,
    date    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_score_record PRIMARY KEY (id)
);

ALTER TABLE score_records
    ADD CONSTRAINT FK_SCORE_RECORD_ON_CARD FOREIGN KEY (card_id) REFERENCES cards (id);