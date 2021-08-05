#Amount of employees for each rol
SELECT R.idRol, R.RolName, COUNT(*) FROM Roles R JOIN Employees_Roles ER ON (R.idRol =ER.Rol) GROUP BY R.idRol;

#Avarage salary for each employee
SELECT E.IdEmployee, AVG(S.Amount) FROM Employees E JOIN Salaries S ON (E.Salary = S.IdSalary) GROUP BY E.IdEmployee;

#Amount of products for each area
SELECT A.idArea, A.Area_Name, COUNT(*) FROM Area A JOIN Products_Areas PA ON (A.idArea = PA.Area) GROUP BY A.idArea;



