create table cliente (telefone varchar primary key, nome varchar, endereco varchar);
create table cardapio (nome_pizza varchar primary key, ingredientes varchar, preco varchar);

create table pedido (
	id serial,
	telefone varchar, 
	data_hora timestamp, 
	constraint pk_pedido primary key (id), 
	constraint fk_cliente foreign key (telefone) references cliente (telefone));

create table item (
	id serial,
	nome_pizza varchar,
	quantidade int,
	pedido_id int,
	constraint pk_item primary key (id), 
	constraint fk_cardapio foreign key (nome_pizza) references cardapio(nome_pizza),
	constraint fk_pedido foreign key (pedido_id) references pedido(id));
