SELECT CONCAT(m.first_name,' ',m.last_name) AS Full_name
FROM manager m
JOIN department d ON m.department_id = d.id
WHERE d.name = 'Комната добра';