-- Create the click_and_buy database
CREATE DATABASE click_and_buy;
-- Connect to the click_and_buy database
\ c click_and_buy;
-- Create the user table
CREATE TABLE user_table (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(45) NOT NULL,
    user_email VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(15),
    reward_points INTEGER DEFAULT 0
);
-- Insert sample data
INSERT INTO user_table (
        username,
        user_email,
        first_name,
        last_name,
        phone_number,
        reward_points
    )
VALUES (
        'johndoe',
        'john.doe@email.com',
        'John',
        'Doe',
        '555-0101',
        14320
    ),
    (
        'janedoe',
        'jane.doe@email.com',
        'Jane',
        'Doe',
        '555-0102',
        12850
    ),
    (
        'msmith',
        'michael.smith@email.com',
        'Michael',
        'Smith',
        '555-0103',
        11340
    ),
    (
        'ejones',
        'emily.jones@email.com',
        'Emily',
        'Jones',
        '555-0104',
        9800
    ),
    (
        'dlee',
        'david.lee@email.com',
        'David',
        'Lee',
        '555-0105',
        15430
    ),
    (
        'lbrown',
        'linda.brown@email.com',
        'Linda',
        'Brown',
        '555-0106',
        10230
    ),
    (
        'jjohnson',
        'james.johnson@email.com',
        'James',
        'Johnson',
        '555-0107',
        17320
    ),
    (
        'pmiller',
        'patricia.miller@email.com',
        'Patricia',
        'Miller',
        '555-0108',
        15740
    ),
    (
        'rwilson',
        'robert.wilson@email.com',
        'Robert',
        'Wilson',
        '555-0109',
        13490
    ),
    (
        'bmoore',
        'barbara.moore@email.com',
        'Barbara',
        'Moore',
        '555-0110',
        16250
    ),
    (
        'ctaylor',
        'charles.taylor@email.com',
        'Charles',
        'Taylor',
        '555-0111',
        11890
    ),
    (
        'jthomas',
        'joseph.thomas@email.com',
        'Joseph',
        'Thomas',
        '555-0112',
        10760
    ),
    (
        'sanderson',
        'susan.anderson@email.com',
        'Susan',
        'Anderson',
        '555-0113',
        14560
    ),
    (
        'kmartin',
        'karen.martin@email.com',
        'Karen',
        'Martin',
        '555-0114',
        13840
    );
-- Create indexes for better performance
CREATE INDEX idx_user_email ON user_table(user_email);
CREATE INDEX idx_user_name ON user_table(first_name, last_name);
CREATE INDEX idx_reward_points ON user_table(reward_points);
-- Display the created table structure
\ d user_table -- Display all inserted data
SELECT *
FROM user_table
ORDER BY user_id;