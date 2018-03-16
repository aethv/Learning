CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username varchar(100) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) DEFAULT NULL
)