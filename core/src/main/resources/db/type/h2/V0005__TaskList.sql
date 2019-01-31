CREATE TABLE TaskList(
	id BIGINT NOT NULL AUTO_INCREMENT,
	modificationCounter INTEGER NOT NULL,
	name VARCHAR(255) NOT NULL,
	creationDate TIMESTAMP,
	CONSTRAINT PK_TaskList PRIMARY KEY(id),
);