CREATE DATABASE FirmManagement;

USE FirmManagement;

ALTER DATABASE your_database_name
CHARACTER SET utf8mb4
COLLATE utf8mb4_turkish_bin;

ALTER TABLE your_table_name
CONVERT TO CHARACTER SET utf8mb4
COLLATE utf8mb4_turkish_bin;


CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('Manager', 'Engineer', 'Technician', 'Intern') NOT NULL,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    phone_no VARCHAR(15),
    date_of_birth DATE,
    date_of_start DATE,
    email VARCHAR(100),
    DEFAULT_PASSWORD BOOLEAN DEFAULT TRUE
);



SELECT * FROM employees;

INSERT INTO employees (username, password, role, name, surname, phone_no, date_of_birth, date_of_start, email, DEFAULT_PASSWORD)
VALUES 
('emir5757', 'manager123', 'Manager', 'Emir', 'Özen', '5551234567', '1980-01-01', '2010-05-15', 'ahmet.yilmaz@example.com', TRUE),
('manager2', 'manager234', 'Manager', 'Mehmet', 'Demir', '5556781234', '1978-04-10', '2008-03-20', 'mehmet.demir@example.com', TRUE),
('engineer1', 'engineer123', 'Engineer', 'Ayşe', 'Kaya', '5552345678', '1990-02-12', '2015-08-22', 'ayse.kaya@example.com', TRUE),
('engineer2', 'engineer234', 'Engineer', 'Fatma', 'Yıldız', '5557892345', '1985-06-15', '2012-07-01', 'fatma.yildiz@example.com', TRUE),
('technician1', 'tech123', 'Technician', 'Ali', 'Çelik', '5553456789', '1995-03-10', '2018-09-10', 'ali.celik@example.com', TRUE),
('technician2', 'tech234', 'Technician', 'Hakan', 'Kara', '5554567890', '1993-11-05', '2016-02-25', 'hakan.kara@example.com', TRUE),
('intern1', 'intern123', 'Intern', 'Emre', 'Akdoğan', '5555678901', '1999-04-17', '2021-05-01', 'emre.akdogan@example.com', TRUE),
('intern2', 'intern234', 'Intern', 'Selin', 'Güzel', '5556789012', '2000-06-25', '2022-03-14', 'selin.guzel@example.com', TRUE),
('manager3', 'manager345', 'Manager', 'Yusuf', 'Demirtaş', '5557890123', '1983-08-13', '2011-10-30', 'yusuf.demirtas@example.com', TRUE),
('manager4', 'manager456', 'Manager', 'Zeynep', 'Yılmaz', '5558901234', '1979-02-09', '2007-04-22', 'zeynep.yilmaz@example.com', TRUE),
('engineer3', 'engineer345', 'Engineer', 'Burak', 'Öztürk', '5559012345', '1992-11-11', '2016-01-18', 'burak.ozturk@example.com', TRUE),
('engineer4', 'engineer456', 'Engineer', 'Derya', 'Büyük', '5550123456', '1993-07-07', '2017-05-29', 'derya.buyuk@example.com', TRUE),
('technician3', 'tech345', 'Technician', 'Furkan', 'Akdemir', '5551234567', '1994-09-22', '2019-10-15', 'furkan.akdemir@example.com', TRUE),
('technician4', 'tech456', 'Technician', 'Murat', 'Karaca', '5552345678', '1992-03-03', '2020-04-10', 'murat.karaca@example.com', TRUE),
('intern3', 'intern345', 'Intern', 'Berk', 'Balkır', '5553456789', '2001-05-18', '2023-06-22', 'berk.balkir@example.com', TRUE),
('intern4', 'intern456', 'Intern', 'Zeynep', 'Arslan', '5554567890', '2000-11-29', '2023-01-25', 'zeynep.arslan@example.com', TRUE),
('manager5', 'manager567', 'Manager', 'Ali', 'Koç', '5555678901', '1980-12-01', '2012-02-10', 'ali.koc@example.com', TRUE),
('engineer5', 'engineer567', 'Engineer', 'Can', 'Aydın', '5556789012', '1990-04-10', '2014-03-22', 'can.aydin@example.com', TRUE),
('technician5', 'tech567', 'Technician', 'Mert', 'Çalışkan', '5557890123', '1995-10-15', '2017-06-02', 'mert.caliskan@example.com', TRUE),
('intern5', 'intern567', 'Intern', 'Deniz', 'Kuş', '5558901234', '2001-01-30', '2023-08-18', 'deniz.kus@example.com', TRUE);



