# Write your MySQL query statement below

SELECT p.project_id, 
    Round(avg(e.experience_years),2) as average_years
FROM project p
JOIN employee e
    ON p.employee_id=e.employee_id
GROUP BY p.project_id #GROUP BY is essential because it's what allows us to calculate separate averages for each project rather than one overall average across all projects.