CREATE TABLE IF NOT EXISTS printed_product
(
    id               bigint primary key auto_increment,
    productions_type varchar(50) not null,
    tittle           varchar,
    author           varchar,
    pages            int         not null,
    publish_date     date,
    publisher        varchar,
    serial_number    bigint      not null unique
);

insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('book', 'Idiot', 'Dostoevsky', 344, '2001-03-23', 'Piter', 335971036);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('book', 'Igrok', 'Dostoevsky', 127, '2011-02-12', 'Piter', 995200145);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('book', 'Voina I Mir', 'Tolstoy', 427, '2004-04-22', 'Eksmo', 66443145);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('book', 'Metro-2033', 'Glukhovsky', 361, '2016-07-26', 'Eksmo', 636215012);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('newspaper', 'Streets news', 'SMI', 21, '2022-01-16', 'S-Print', 332277499);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('newspaper', 'SB', 'Typography', 13, '2021-04-24', 'SMI Publisher', 658787003);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('journal', 'Fashion', 'FAQ', 22, '2019-07-14', 'MAssPublisher', 300215997);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('journal', 'Fashion Modern', 'FAQ', 12, '2017-09-10', 'MAssPublisher', 336852014);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('other', 'Calendar', 'Unknown', 1, '2019-07-22', 'Karandash Print', 665987997);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('newspaper', 'USA Today', 'USAToday', 21, '2021-07-21', 'Today Org.', 997987004);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('newspaper', 'The New York Times', 'NYT', 26, '2022-01-13', 'NY-news', 445214670);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('other', 'Happy Blank', 'Unknown', 1, '2017-02-12', 'Karandash Print', 841305784);
insert into printed_product (productions_type, tittle, author, pages, publish_date, publisher, serial_number)
VALUES ('journal', 'VOGUE', 'Vogue', 19, '2021-02-18', 'Konde-Nast', 854457930);