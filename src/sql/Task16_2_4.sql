SELECT t.title
FROM ticket t
JOIN contact c ON t.assignee_id = c.id
WHERE t.priority = 'P4' AND first_name = 'Татьяна' AND last_name = 'Алимова';