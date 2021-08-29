CREATE TABLE book (
    id int auto_increment primary Key,
    name varchar(255) not null,
    price decimal(10,2) not null,
    status varchar(255) not null,
    customer_id int not null,
    FOREIGN KEY (customer_id) REFERENCES customer(id)

)

--  FOREIGN KEY (customer_id) REFERENCES customer(id) estou fazendo referencia do books com customer,
--  Nao posso ter livros sem usuarios, reference e o id
