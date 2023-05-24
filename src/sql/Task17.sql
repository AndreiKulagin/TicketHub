1. Select random Full name from the table on managers page and select/check information about the manager
on  Manager Tab details and Tickets Tab.


SELECT CONCAT(m.first_name, ' ' ,m.last_name)AS full_name, m.phone, m.skype, m.email, m.login, m.creation_timestamp,
m.is_admin, m.update_timestamp, d.name AS department
FROM manager m
JOIN department d ON m.department_id = d.id
ORDER BY random()
LIMIT 1;


SELECT manager.first_name, manager.last_name, ticket.title, company.name, stage.name, category.name
FROM manager
JOIN ticket
ON manager.id = ticket.assignee_id
JOIN company ON company.id = ticket.company_ticket_id
JOIN stage ON ticket.stage_id = stage.id
JOIN category ON ticket.category_id = category.id
WHERE manager.first_name = 'wert' AND manager.last_name = 'wert';


2. Select random Title department from the table on Departments page and select/check information about department
on Department details Tab.

SELECT name AS title FROM department
ORDER BY RANDOM()
LIMIT 1;


SELECT d.name, d.phone, d.skype, d.website, d.email, d.country, d.city, d.street, d.building, d.room_number, d.update_timestamp,
d.creation_timestamp, CONCAT(m.first_name, ' ', m.last_name) AS Managers
FROM department d
JOIN manager m ON d.id = m.department_id
WHERE d.name = 'WEB_TEST_VOID'
ORDER BY m.first_name, m.last_name;


3.Select random category from the table on Categories page and select/check information about tickets
on categories -> Tickets Tab.


SELECT name FROM category
ORDER BY random()
LIMIT 1;


SELECT c.name, t.title, com.name, s.name
FROM category c
JOIN ticket t ON c.id = t.category_id
JOIN stage s ON t.stage_id = s.id
JOIN company com ON t.company_ticket_id = com.id
WHERE c.name = 'YouTube' AND (s.name = 'OPEN' OR s.name = 'IN PROGRESS');
