INSERT INTO TaskList(id,modificationCounter, name, creationDate) values (0, 1, 'Tareas de Casa', CURRENT_TIMESTAMP);
INSERT INTO TaskList(id,modificationCounter, name, creationDate) values (1, 1, 'Tareas de la oficina', CURRENT_TIMESTAMP);

INSERT INTO List(id, modificationCounter, name, creationDate, active, orderList, id_listas) values(0,1,'Primera lista de tareas', CURRENT_TIMESTAMP, 1, 1, 0);
INSERT INTO List(id, modificationCounter, name, creationDate, active, orderList, id_listas) values(1,1,'Segunda lista de tareas', CURRENT_TIMESTAMP, 1, 2, 0);
INSERT INTO List(id, modificationCounter, name, creationDate, active, orderList, id_listas) values(2,1,'Tercera lista de tareas', CURRENT_TIMESTAMP, 1, 1, 1);
INSERT INTO List(id, modificationCounter, name, creationDate, active, orderList, id_listas) values(3,1,'Cuarta lista de tareas', CURRENT_TIMESTAMP, 1, 2, 1);

INSERT INTO TextItem(id, modificationCounter, creationDate, text) values (0, 1, CURRENT_TIMESTAMP, 'Primer item de la lista');
INSERT INTO TextItem(id, modificationCounter, creationDate, text) values (1, 1, CURRENT_TIMESTAMP, 'Segundo item de la lista');
INSERT INTO TextItem(id, modificationCounter, creationDate, text) values (2, 1, CURRENT_TIMESTAMP, 'tercer item de la lista');
INSERT INTO TextItem(id, modificationCounter, creationDate, text) values (3, 1, CURRENT_TIMESTAMP, 'Cuarto item de la lista');

INSERT INTO FileItem(id, modificationCounter, creationDate, file) values(0, 1, CURRENT_TIMESTAMP, STRINGTOUTF8('Primero'));
INSERT INTO FileItem(id, modificationCounter, creationDate, file) values(1, 1, CURRENT_TIMESTAMP, STRINGTOUTF8('Segundo'));
INSERT INTO FileItem(id, modificationCounter, creationDate, file) values(2, 1, CURRENT_TIMESTAMP, STRINGTOUTF8('Tercero'));
INSERT INTO FileItem(id, modificationCounter, creationDate, file) values(3, 1, CURRENT_TIMESTAMP, STRINGTOUTF8('Cuarto'));

INSERT INTO Item(id, modificationCounter, creationDate, ordinal, idList, idFile, idText) values (0, 1,CURRENT_TIMESTAMP, 1, 0, 0, 0);
INSERT INTO Item(id, modificationCounter, creationDate, ordinal, idList, idFile, idText) values (1, 1,CURRENT_TIMESTAMP, 2, 0, null, 0);
INSERT INTO Item(id, modificationCounter, creationDate, ordinal, idList, idFile, idText) values (2, 1,CURRENT_TIMESTAMP, 1, 1, 1, null);
INSERT INTO Item(id, modificationCounter, creationDate, ordinal, idList, idFile, idText) values (3, 1,CURRENT_TIMESTAMP, 2, 1, null, 1);
INSERT INTO Item(id, modificationCounter, creationDate, ordinal, idList, idFile, idText) values (4, 1,CURRENT_TIMESTAMP, 1, 2, 2, null);
INSERT INTO Item(id, modificationCounter, creationDate, ordinal, idList, idFile, idText) values (5, 1,CURRENT_TIMESTAMP, 2, 2, null, 2);
INSERT INTO Item(id, modificationCounter, creationDate, ordinal, idList, idFile, idText) values (6, 1,CURRENT_TIMESTAMP, 1, 3, 3, null);
INSERT INTO Item(id, modificationCounter, creationDate, ordinal, idList, idFile, idText) values (7, 1,CURRENT_TIMESTAMP, 2, 3, null, 3);