SELECT m.first_name, m.last_name, d.name
FROM manager m
JOIN department d ON m.department_id=d.id
WHERE d.name = 'ACRO';