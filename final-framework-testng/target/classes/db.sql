create table login(
username varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 
insert into login values("naveen", "testing@123"); 


create table Register(
     firstname varchar(50),
     lastname varchar(50),
     email varchar(50),
     telephone varchar(10),
     address1 varchar(50),
     address2 varchar(50),
     city varchar(20),
     postcode varchar(6),
     country varchar(25),
     region varchar(25),
     password varchar(25),
     passwordconfirm varchar(25));
     
insert into Register values("Neha", "B", "neha11@gmail.com", "9241835892", "4th block", "Jayanagar", "Bangalore", "560082", "India", "Karnataka", "Neha123", "Neha123");


