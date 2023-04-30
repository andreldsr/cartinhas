CREATE TABLE draft
(
    id      UUID NOT NULL,
    name    VARCHAR(255),
    user_id UUID,
    CONSTRAINT pk_draft PRIMARY KEY (id)
);

ALTER TABLE draft
    ADD CONSTRAINT FK_DRAFT_ON_USER FOREIGN KEY (user_id) REFERENCES "user" (id);

CREATE TABLE draft_cards
(
    draft_entity_id UUID NOT NULL,
    cards_id        UUID NOT NULL
);

ALTER TABLE draft_cards
    ADD CONSTRAINT fk_dracar_on_card_entity FOREIGN KEY (cards_id) REFERENCES cards (id);

ALTER TABLE draft_cards
    ADD CONSTRAINT fk_dracar_on_draft_entity FOREIGN KEY (draft_entity_id) REFERENCES draft (id);