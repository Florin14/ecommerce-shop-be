-- CREATE TABLE IF NOT EXISTS brands
-- (
--     id   INT PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(255) NOT NULL
-- );
--
-- CREATE TABLE IF NOT EXISTS categories
-- (
--     id   INT PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(255) NOT NULL UNIQUE
-- );
--
-- CREATE TABLE IF NOT EXISTS genders
-- (
--     id          INT PRIMARY KEY AUTO_INCREMENT,
--     name        VARCHAR(255) NOT NULL UNIQUE,
--     gender_code CHAR(1)
-- );
--
-- CREATE TABLE IF NOT EXISTS products
-- (
--     id                INT PRIMARY KEY AUTO_INCREMENT,
--     name              VARCHAR(255) NOT NULL,
--     description       VARCHAR(255) NOT NULL,
--     price             DOUBLE       NOT NULL,
--     stock_quantity    INT          NOT NULL DEFAULT 0,
--     brand_id          INT          NOT NULL,
--     category_id       INT          NOT NULL,
--     gender_id         INT          NOT NULL,
--     age_group         VARCHAR(255),
--     material          VARCHAR(255),
--     season            VARCHAR(255),
--     country_of_origin VARCHAR(255),
--     sku               VARCHAR(255),
--     FOREIGN KEY (brand_id) REFERENCES brands (id),
--     FOREIGN KEY (category_id) REFERENCES categories (id),
--     FOREIGN KEY (gender_id) REFERENCES genders (id)
-- );