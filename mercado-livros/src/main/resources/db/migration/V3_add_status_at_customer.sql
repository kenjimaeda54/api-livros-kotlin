ALTER TABLE customer ADD COLUMN customerStatus varchar(100);

--  FOREIGN KEY (customer_id) REFERENCES customer(id) estou fazendo referencia do books com customer,
--  Nao posso ter livros sem usuarios, reference e o id
