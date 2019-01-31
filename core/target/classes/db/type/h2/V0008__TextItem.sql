CREATE TABLE TextItem(
	id BIGINT NOT NULL AUTO_INCREMENT,
	modificationCounter INTEGER NOT NULL,
	creationDate TIMESTAMP,
	text VARCHAR(255) NOT NULL,
	CONSTRAINT PK_TextItem PRIMARY KEY(id)
);