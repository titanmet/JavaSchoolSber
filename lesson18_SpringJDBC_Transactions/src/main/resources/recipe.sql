set schema public;

drop table IF EXISTS INGREDIENT;
drop table IF EXISTS RECIPE;

create table RECIPE
(
    id   INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(100)                   NOT NULL
);

CREATE UNIQUE INDEX IF NOt EXISTS UNIQUE_RECIPE ON RECIPE (name);

create table INGREDIENT
(
    id        INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name      VARCHAR(100)                   NOT NULL,
    kolvo     VARCHAR(100)                   NOT NULL,
    RECIPE_ID INT
);
