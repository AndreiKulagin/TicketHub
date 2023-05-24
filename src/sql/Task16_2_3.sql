SELECT t.id
FROM ticket t
JOIN category c ON t.category_id = c.id
WHERE t.creation_timestamp BETWEEN '2018-04-19' AND '2018-05-03'
AND c.name = 'Финансы';