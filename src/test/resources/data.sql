insert into perfis(id, nome)
values (1, 'ROLE_ADMIN');
insert into perfis(id, nome)
values (2, 'ROLE_USER');
insert into usuarios(id, nome, sobrenome, email, senha, is_confirmado)
values (1, 'Admin', 'do Sistema', 'admin@email.com', '$2a$10$HKveMsPlst41Ie2LQgpijO691lUtZ8cLfcliAO1DD9TtZxEpaEoJe',true);
 insert into usuarios(id, nome, sobrenome, email, senha, is_confirmado)
 values (2, 'Usuario', 'do Sistema', 'user@email.com', '$2a$10$HKveMsPlst41Ie2LQgpijO691lUtZ8cLfcliAO1DD9TtZxEpaEoJe',
         true);

 insert into usuarios_perfis(usuarios_id, perfis_id)
 values (1, 1);
 insert into usuarios_perfis(usuarios_id, perfis_id)
 values (2, 2);

--  insert into token_confirmacao_email(id, data_de_criacao, token, usuario_id) value (1,'2024-05-02 10:00','aecc73b7-dae5-4011-925d-e07633d9993f',1);

INSERT INTO dias (id, data, usuario_id)
VALUES (1, '2025-01-26', 1),
       (2, '2025-01-27', 1);

INSERT INTO anotacaos (id, titulo, conteudo, dia_id)
VALUES (1, 'meu sonho de hoje', 'sonhei com elefantes e cobras', 1),
       (2, 'lista de comprsa', 'arroz sabao em po feijao cafe balinha azedinha', 2),
       (3, 'reuniao de hoje', 'chata demais lembrar de pedir emissao', 1),
       (4, 'receita de bolo', 'farinha açucar ovo leite margarina fermento e forno ta pronto', 2),
       (5, 'list de convidados', 'por enquanto ninguem', 1);

