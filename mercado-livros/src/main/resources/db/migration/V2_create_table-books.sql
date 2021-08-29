CREATE TABLE books (
    id int auto_increment primary Key,
    name varchar(255) not null,
    price decimal(10,2) not null,
    status varchar(255) not null,
    customer_id int not null,
    FOREIGN KEY (customer_id) REFERENCES customer(id)

--    price decimal(10,2)--> estou dizendo que no maximo sao 10 casas e duas casas decimais,exemplo 100000,00
--     FOREIGN KEY (customer_id) REFERENCES customer(id)-- estou dizendo que meu customer_id e uma chave
--     estrangeira que tem referencia ao id do customer,ou seja so posso ter um books se possuir customer
)
