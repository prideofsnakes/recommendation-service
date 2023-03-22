DROP TABLE IF EXISTS CRYPTOCURRENCY;
CREATE TABLE CRYPTOCURRENCY (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      symbol VARCHAR(10) NOT NULL,
                      price decimal(19,2) NOT NULL,
                      evaluated_at timestamp not null
);