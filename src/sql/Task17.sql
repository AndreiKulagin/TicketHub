1. Select random Full name from the table on managers page and select/check information about the manager
on  Manager Tab details and Tickets Tab.

SELECT CONCAT(manager.first_name, ' ' ,manager.last_name)AS full_name, manager.phone, manager.skype, manager.email, manager.login, manager.creation_timestamp,
manager.is_admin, manager.update_timestamp, department.name AS department
FROM manager
JOIN department ON manager.department_id = department.id
JOIN ticket ON manager.id = ticket.assignee_id
JOIN company ON ticket.company_ticket_id = company.max_ticket_id
JOIN stage ON ticket.stage_id = stage.id
JOIN category ON ticket.category_id = category.id
ORDER BY RANDOM()
LIMIT 1;

2. Select random Title department from the table on Departments page and select/check information about department
on Department details Tab.

SELECT d.name AS title, d.phone, d.skype, d.website, d.email, d.country, d.city, d.street, d.building, d.room_number, d.update_timestamp,
d.creation_timestamp, CONCAT(m.first_name, ' ', m.last_name) AS Managers
FROM department d
JOIN manager m ON d.id = m.department_id
ORDER BY RANDOM()
LIMIT 1;

3.Select random category from the table on Categories page and select/check information about tickets
on categories -> Tickets Tab.


SELECT category.name, ticket.title, company.name AS company, stage.name AS stage
FROM category
JOIN ticket ON category.id = ticket.category_id
JOIN stage ON ticket.stage_id = stage.id
JOIN company ON ticket.company_ticket_id = company.max_ticket_id
ORDER BY RANDOM()
LIMIT 1;