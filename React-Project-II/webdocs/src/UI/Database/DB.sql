
DROP DATABASE IF EXISTS Project_WebDocs_DB;

create DATABASE Project_WebDocs_DB;

USE Project_WebDocs_DB;

create table Patient(
Patient_Id int auto_increment primary key,
Patient_Name varchar(500),
Patient_Photo blob,
Patient_DOB	date,
Patient_Gender varchar(500),
Patient_Mobile_number varchar(500),	
Patient_Email varchar(500),
Patient_Username varchar(500),
Patient_Password varchar(500)
);

create table Category(
Category_id int auto_increment primary key,
Specialization varchar(500),
Description varchar(500)
);

create table Hospital(
Hospital_id int auto_increment primary key,
Hospital_Name varchar(500),
Hospital_Address varchar(500),
Hospital_Image blob
);

create table Doctor(
Doctor_Id	int auto_increment primary key,
Doctor_Name	varchar(500),
Doctor_Photo blob,	
Doctor_DOB	date,
Doctor_Gender varchar(500),	
Doctor_Mobile_number varchar(500),	
Doctor_Email varchar(500),
Doctor_License_Number varchar(500),
Doctor_Category_Id int NOT NULL,
FOREIGN KEY(Doctor_Category_Id) REFERENCES category(category_id),
Doctor_Hospital_Id int NOT NULL,
FOREIGN KEY(Doctor_Hospital_Id) REFERENCES Hospital(Hospital_id),
Doctor_Experience 	int,
Doctor_Fees	int,
Doctor_Username	 varchar(500),
Doctor_Password varchar(500)
);

create table Slot(
slot_id	int auto_increment primary key,
Slot_Doctor_id	int NOT NULL, 
FOREIGN KEY(Slot_Doctor_id) REFERENCES Doctor(Doctor_Id),
Slot_Patient_id	int NOT NULL,
FOREIGN KEY(Slot_Patient_id) REFERENCES Patient(Patient_Id),
Hospital_id	int NOT NULL,
FOREIGN KEY(Hospital_id) REFERENCES Hospital(Hospital_id),
Slot_Date date,
Slot_Start_Time	TIME,
Slot_End_Time TIME
);


create table Appointment(
Appointment_id	int auto_increment primary key,
Appointment_slot_id int NOT NULL,
FOREIGN KEY(Appointment_slot_id) REFERENCES Slot(Slot_id),
Appointment_Doctor_id	int NOT NULL,
FOREIGN KEY(Appointment_Doctor_id) REFERENCES Doctor(Doctor_Id),
Appointment_Patient_id	int NOT NULL,
FOREIGN KEY(Appointment_Patient_id) REFERENCES Patient(Patient_Id),
Appointment_Status BOOLEAN
);

create table Feedback(
Feedback_Id	int auto_increment primary key,
Feedback_Patient_Id	int NOT NULL,
FOREIGN KEY(Feedback_Patient_Id) REFERENCES Patient(Patient_Id),
Feedback_Doctor_Id	int NOT NULL,
FOREIGN KEY(Feedback_Doctor_Id) REFERENCES Doctor(Doctor_Id),
Feedback_Text	VARCHAR(1000),
Feedback_Rating int CHECK(Feedback_Rating between 1 AND 5)
);



