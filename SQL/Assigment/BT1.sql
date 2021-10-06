
CREATE DATABASE Trainee;
USE Trainee;

CREATE TABLE  Trainee (
		TraineeID        INT PRIMARY KEY AUTO_INCREMENT ,
		Full_Name        VARCHAR(50),
        Birth_Day        DATE,
        Gender           VARCHAR(50),
        ET_IQ            INT,
        ET_Gmath         INT,
        ET_English       INT,
        Training_class   INT,
        Evaluation_Notes VARCHAR(200)
);
        