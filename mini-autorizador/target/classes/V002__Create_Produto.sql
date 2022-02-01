create table Produto(
    id integer not null primary key auto_increment,
    Nome_produto varchar(255) not null,
    marca varchar(100),
    preco Number(4,2) not null,
    codigo_fabricante long not null
);