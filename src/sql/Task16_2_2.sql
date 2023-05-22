SELECT CONCAT(first_name,' ',last_name) AS full_name
FROM manager
WHERE phone IS NOT NULL AND email LIKE '%gmail.com';