CREATE TABLE footballers (

    id INT PRIMARY KEY,
    first_name VARCHAR( 50 ) NOT NULL,
    last_name VARCHAR( 50 ) NOT NULL,
    height INT NOT NULL,
    weight INT NOT NULL,
    contract_expiration_date DATE NOT NULL,
    weekly_wage DOUBLE PRECISION NOT NULL,
    club VARCHAR( 50 ) NOT NULL
)