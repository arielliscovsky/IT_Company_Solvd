#Amount of employees hired this year
SELECT COUNT(*) FROM Employee WHERE YEAR(HireDate) = YEAR(CURDATE());
#Oldest Employee birthdate
SELECT  MIN(BirthDate) FROM Employee;
#Avarage age between the employees
SELECT AVG(YEAR(CURDATE())-YEAR(BirthDate)) AS AvarageAge FROM Employees;
#Amount of Employees from Brasilia
SELECT COUNT(*) FROM Employees E JOIN Addresses A ON (E.Addres = A.idAddress) JOIN Cities Cit ON (A.City  = Cit.idCity) WHERE Cit.City_name = 'Brasilia';
#Last releaseDate of a product
SELECT  MAX(ReleaseDate) FROM Versions V JOIN Products P ON (P.idProduct = V.Product) WHERE P.Prod_name = 'Instagram'
