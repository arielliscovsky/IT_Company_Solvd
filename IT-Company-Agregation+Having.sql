#Employees whose avarage salary this year is higher than the 8% of the last year avarage salary
SELECT E.idEmployee, E.Emp_name FROM Employees E JOIN Salaries S ON (E.idEmployee = S.Employee)
	WHERE YEAR(S.PayDay) = YEAR(CURDATE()) 
    GROUP BY E.idEmployee
    HAVING AVG(S.Amount) > (SELECT (AVG(SA.Amount) *1.8)
							FROM Employees EM JOIN Salaries SA ON (EM.idEmployee = SA.Employee)
							WHERE YEAR(SA.PayDay) = YEAR(CURDATE()-1)
                            AND E.idEmployee = EM.idEmployee
							GROUP BY EM.idEmployee);

#Employee with the highest avarage salary this year
SELECT E.idEmployee, E.Emp_name, AVG(S.Amount) AS SalaryAmount
	FROM Employees E JOIN Salaries S ON (E.idEmployee = S.Employee)
    WHERE YEAR(S.PayDay) = YEAR(CURDATE())
    GROUP BY E.idEmployee
    HAVING AVG(S.Amount) > ALL(SELECT AVG(SA.Amount)
							FROM Employees EM JOIN Salaries SA ON (EM.idEmployee = SA.Employee)
							WHERE YEAR(SA.PayDay) = YEAR(CURDATE()) 
							GROUP BY EM.idEmployee);


#Employees whose min salary this year is grater than USD1700
SELECT E.idEmployee, E.Emp_name
	FROM Employees E JOIN Salaries S ON (E.idEmployee = S.Employee)
    WHERE YEAR(S.PayDay) = YEAR(CURDATE())
    GROUP BY E.idEmployee
    HAVING MIN(S.Amount) > 1700;