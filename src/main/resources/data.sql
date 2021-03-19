INSERT INTO AUTOR(nome, email, descricao, data_criacao) values ('Autor 1', 'email1@email.com', 'descricao autor 1', '2021-03-16');
INSERT INTO AUTOR(nome, email, descricao, data_criacao) values ('Autor 2', 'email2@email.com', 'descricao autor 2', '2021-03-17');
INSERT INTO AUTOR(nome, email, descricao, data_criacao) values ('Autor 3', 'email3@email.com', 'descricao autor 3', '2021-03-18');

INSERT INTO CATEGORIA(nome) values ('Categoria 1');
INSERT INTO CATEGORIA(nome) values ('Categoria 2');

INSERT INTO LIVRO(titulo, resumo, sumario, preco, n_paginas, isbn, data_publicacao, categoria_id, autor_id) values ('Titulo 1', 'resumo do livro 1', 'sumario do livro 1', 30, 300, 'abcdef', '2022-12-20', 1, 1);
INSERT INTO LIVRO(titulo, resumo, sumario, preco, n_paginas, isbn, data_publicacao, categoria_id, autor_id) values ('Titulo 2', 'resumo do livro 2', 'sumario do livro 2', 30, 300, 'bcdefg', '2021-12-20', 2, 2);
INSERT INTO LIVRO(titulo, resumo, sumario, preco, n_paginas, isbn, data_publicacao, categoria_id, autor_id) values ('Titulo 3', 'resumo do livro 3', 'sumario do livro 3', 30, 300, 'cdefgh', '2022-10-20', 1, 2);
INSERT INTO LIVRO(titulo, resumo, sumario, preco, n_paginas, isbn, data_publicacao, categoria_id, autor_id) values ('Titulo 4', 'resumo do livro 4', 'sumario do livro 4', 30, 300, 'defghi', '2022-12-22', 2, 3);