--manter atualizado as versoes do banco
--as versoes sao utis quando desejamos atualizar ou fazer upgrade do banco
CREATE TABLE customer (
    id int auto_increment primary Key,
    name varchar(255) not null,
    email varchar(255) not null unique

)
