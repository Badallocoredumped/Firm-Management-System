CREATE DATABASE FirmManagement
CHARACTER SET utf8mb4
COLLATE utf8mb4_bin;

USE FirmManagement;

ALTER TABLE employees
MODIFY COLUMN phone_no VARCHAR(25);



CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('Manager', 'Engineer', 'Technician', 'Intern') NOT NULL,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    phone_no VARCHAR(25),
    date_of_birth DATE,
    date_of_start DATE,
    email VARCHAR(100),
    DEFAULT_PASSWORD BOOLEAN DEFAULT TRUE
);



SELECT * FROM employees;
/*We will create the database manually*/
INSERT INTO employees (username, password, role, name, surname, phone_no, date_of_birth, date_of_start, email, DEFAULT_PASSWORD)
VALUES 
('emir5757', 'manager123', 'Manager', 'Emir', 'Özen', '5551234567', '1980-01-01', '2010-05-15', 'emirozen57@hotmail.com', FALSE),
('Teca7', 'WeLoveTeca', 'Engineer', 'Ahmed Marcolino Teca', 'Kanadji', '5441234567', '1980-01-01', '2010-05-15', 'teca.kanadji@example.com', TRUE);



