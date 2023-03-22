DROP TABLE IF EXISTS cryptocurrency;
CREATE TABLE cryptocurrency (
                      id bigint auto_increment  primary key,
                      symbol varchar(10) not null,
                      price decimal(19,2) not null,
                      evaluated_at timestamp not null
);