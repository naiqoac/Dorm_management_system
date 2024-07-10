
DROP TABLE IF EXISTS reports;
DROP TABLE IF EXISTS visitRecord;
DROP TABLE IF EXISTS guests;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS rooms;

CREATE TABLE rooms  (
  room_number int NOT NULL,
  room_state varchar(50) ,
  PRIMARY KEY (room_number) 
);
CREATE TABLE admin  (
  admin_account char(50) NOT NULL ,
  admin_name char(50) ,
  admin_password varchar(255) ,
  PRIMARY KEY (admin_account) 
);
CREATE TABLE students  (
  student_number int NOT NULL ,
  student_password varchar(255) ,
  student_name varchar(50),
  rent_time date,
  room_number int NOT NULL,
  PRIMARY KEY (student_number) ,
  FOREIGN KEY(room_number)REFERENCES rooms (room_number)
);
CREATE TABLE guests  (
  guest_ID varchar(250) NOT NULL ,
  guest_name varchar(50),
  PRIMARY KEY (guest_ID) 
);
CREATE TABLE reports  (
  report_number int NOT NULL,
  student_number int,
  admin_account varchar(50),
  report_time date,
  FOREIGN KEY(student_number) REFERENCES students (student_number),
  FOREIGN KEY(admin_account) REFERENCES admin (admin_account),
  describtion varchar(250) ,
  PRIMARY KEY (report_number) 
);
create table visitRecord(
  guest_ID varchar(50) NOT NULL,
  hostStudent_number int NOT NULL,
  FOREIGN KEY(guest_ID) REFERENCES guests (guest_ID),
  FOREIGN KEY(hostStudent_number) REFERENCES students (student_number),
  checkInDate date,
  checkOutDate date,
  primary key(guest_ID,hostStudent_number)
);