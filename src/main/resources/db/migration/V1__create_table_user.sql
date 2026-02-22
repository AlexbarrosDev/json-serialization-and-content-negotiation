CREATE TABLE tb_user (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(80) NOT NULL ,
    email VARCHAR(80)NOT NULL ,
    password VARCHAR(20)NOT NULL ,
    birth_day DATE
);