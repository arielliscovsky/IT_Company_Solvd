USE IT_Company_ArielL;
#1
INSERT	INTO Countries (Country_name, AreaCode)
		VALUES ('Argentina',54);
#2
INSERT	INTO Countries (Country_name, AreaCode)
		VALUES ('Belarus',375);
#3        
INSERT	INTO Countries (Country_name, AreaCode)
		VALUES ('Brazil',55);
#1
INSERT	INTO Cities (City_name,ZipCode,Country)
		VALUES ('Cordoba',5000,1);
#2        
INSERT	INTO Cities (City_name,ZipCode,Country)
		VALUES ('Minsk',null,2);
#3        
INSERT	INTO Cities (City_name,ZipCode,Country)
		VALUES ('Brasilia',null,3);
#1
INSERT 	INTO Addresses (Street,Number,City)
		VALUES ('Rondeau',60,1);
#2
INSERT 	INTO Addresses (Street,Number,City)
		VALUES ('Vulica Kazlova',120,2);
#3
INSERT 	INTO Addresses (Street,Number,City)
		VALUES ('Vulica Lienina',500,2);
#4       
INSERT 	INTO Addresses (Street,Number,City)
		VALUES ('TeodoroDaSilva',1150,3);
#5       
INSERT 	INTO Addresses (Street,Number,City)
		VALUES ('RMaxwell',355,3);
#1
INSERT 	INTO Users (UserName,Password)
		VALUES ('johnCook','jc123');
#2
INSERT 	INTO Users (UserName,Password)
		VALUES ('AdamSmith','as1234');
#3
INSERT 	INTO Users (UserName,Password)
		VALUES ('HarryKane','hk1234');
#4        
INSERT 	INTO Users (UserName,Password)
		VALUES ('OliStone','os1234');
#5        
INSERT 	INTO Users (UserName,Password)
		VALUES ('JackArcher','ja1234');
#1
INSERT 	INTO Employees (Emp_name,LastName,BirthDate,HireDate,Phone,Email,User,Addres,ReportsTo)
		VALUES ('John','','1980-05-17','2000-11-12',null,'jonhCook@gmail.com',1,1,null);
#2
INSERT 	INTO Employees (Emp_name,LastName,BirthDate,HireDate,Phone,Email,User,Addres,ReportsTo)
		VALUES ('Adam','Smith','1990-01-02','2012-09-21',null,'adamSmith@gmail.com',2,2,null);
        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2700,'2020-01-27',2);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2700,'2020-02-27',2);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2700,'2020-03-27',2);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2700,'2020-04-27',2);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3000,'2020-05-27',2);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3000,'2020-06-27',2);       
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3500,'2021-01-27',2);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3500,'2021-02-27',2);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3500,'2021-03-27',2);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3500,'2021-04-27',2);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3500,'2021-05-27',2);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3600,'2021-06-27',2);
        
#3        
INSERT 	INTO Employees (Emp_name,LastName,BirthDate,HireDate,Phone,Email,User,Addres,ReportsTo)
		VALUES ('Oliver','Stone','1994-09-17','2019-11-28',null,'oliStone@gmail.com',4,3,null);
        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (900,'2020-01-27',3);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (900,'2020-02-27',3);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1100,'2020-03-27',3);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1100,'2020-04-27',3);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1100,'2020-05-27',3);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1150,'2020-06-27',3);       
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2700,'2021-01-27',3);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2700,'2021-02-27',3);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2700,'2021-03-27',3);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2700,'2021-04-27',3);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2700,'2021-05-27',3);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2700,'2021-06-27',3);
#4        
INSERT 	INTO Employees (Emp_name,LastName,BirthDate,HireDate,Phone,Email,User,Addres,ReportsTo)
		VALUES ('Jack','Archer','1980-09-17','2010-10-17',null,'jackArcher@gmail.com',5,4,null);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1600,'2020-01-27',4);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1600,'2020-02-27',4);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1600,'2020-03-27',4);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1600,'2020-04-27',4);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2100,'2020-05-27',4);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (2100,'2020-06-27',4);       
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3000,'2021-01-27',4);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3000,'2021-02-27',4);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3000,'2021-03-27',4);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3500,'2021-04-27',4);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3000,'2021-05-27',4);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (3000,'2021-06-27',4);
#5       
INSERT 	INTO Employees (Emp_name,LastName,BirthDate,HireDate,Phone,Email,User,Addres,ReportsTo)
		VALUES ('Harry','Kane','1998-09-17','2019-01-05',null,'harryKane@gmail.com',3,5,null);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1500,'2020-01-27',5);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1500,'2020-02-27',5);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1600,'2020-03-27',5);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1600,'2020-04-27',5);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1700,'2020-05-27',5);        
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1700,'2020-06-27',5);       
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1700,'2021-01-27',5);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1700,'2021-02-27',5);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1700,'2021-03-27',5);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1700,'2021-04-27',5);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1700,'2021-05-27',5);
INSERT 	INTO Salaries (Amount, PayDay, Employee)
		VALUES (1700,'2021-06-27',5);

#1        
INSERT 	INTO Products(Prod_name)
		VALUES ('Instagram');
INSERT 	INTO Versions(ReleaseDate,Description,Product)
		VALUES ('2000-05-12',null,1);
INSERT 	INTO Versions(ReleaseDate,Description,Product)
		VALUES ('2017-03-01',null,1);
#2
INSERT 	INTO Products(Prod_name)
		VALUES ('Facebook');
INSERT 	INTO Versions(ReleaseDate,Description,Product)
		VALUES ('2010-06-11',null,2);
INSERT 	INTO Versions(ReleaseDate,Description,Product)
		VALUES ('2020-08-21',null,2);
#3
INSERT 	INTO Products(Prod_name)
		VALUES ('Whatsapp');
INSERT 	INTO Versions(ReleaseDate,Description,Product)
		VALUES ('2005-09-20',null,3);
INSERT 	INTO Versions(ReleaseDate,Description,Product)
		VALUES ('2020-08-12',null,3);