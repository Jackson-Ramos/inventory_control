CREATE TABLE person_permission
(
    person_id     INTEGER NOT NULL,
    permission_id BIGINT  NOT NULL,
    PRIMARY KEY (person_id, permission_id),
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    FOREIGN KEY (permission_id) REFERENCES permission (permission_id)
);
