Drop table user;
CREATE TABLE user (ID INT, NAME VARCHAR(50),password VARCHAR(50), address VARCHAR(100));

CREATE TABLE pet (pet_id INT, user_id INT,pet_name VARCHAR(50),description VARCHAR(500), age VARCHAR(100),breed VARCHAR(50),gender VARCHAR(10));

CREATE TABLE veterinary (ID INT, branch_name VARCHAR(50), address VARCHAR(100),doctor INT);

CREATE TABLE appointment (ID INT, date DATETIME,start_time DATETIME, end_time DATETIME,doctor_name VARCHAR(50),status INT,price BIGINT,pet_id INT,branch_id INT);

CREATE table schedule(schedule_id INT,user_id INT,appointment_id INT,status VARCHAR(10))