CREATE TABLE Item(
	id BIGINT NOT NULL AUTO_INCREMENT,
	modificationCounter INTEGER NOT NULL,
	creationDate TIMESTAMP,
	ordinal INTEGER NOT NULL,
	idList BIGINT NOT NULL,
	idFile BIGINT,
	idText BIGINT,
	CONSTRAINT PK_Item PRIMARY KEY(id),
	CONSTRAINT FK_Item_idList FOREIGN KEY(idList) REFERENCES List(id),
	CONSTRAINT FK_Item_idFile FOREIGN KEY(idFile) REFERENCES FileItem(id),
	CONSTRAINT FK_Item_idText FOREIGN KEY(idText) REFERENCES TextItem(id)
);