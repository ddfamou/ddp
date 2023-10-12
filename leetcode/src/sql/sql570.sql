/*570. Managers with at Least 5 Direct Reports
Medium
737
72
Companies
SQL Schema
Pandas Schema
Table: Employee

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| department  | varchar |
| managerId   | int     |
+-------------+---------+
id is the primary key (column with unique values) for this table.
Each row of this table indicates the name of an employee, their department, and the id of their manager.
If managerId is null, then the employee does not have a manager.
No employee will be the manager of themself.


Write a solution to find managers with at least five direct reports.

Return the result table in any order.

The result format is in the following example.



Example 1:

Input:
Employee table:
+-----+-------+------------+-----------+
| id  | name  | department | managerId |
+-----+-------+------------+-----------+
| 101 | John  | A          | None      |
| 102 | Dan   | A          | 101       |
| 103 | James | A          | 101       |
| 104 | Amy   | A          | 101       |
| 105 | Anne  | A          | 101       |
| 106 | Ron   | B          | 101       |
+-----+-------+------------+-----------+
Output:
+------+
| name |
+------+
| John |
+------+*/

--
CREATE TABLE Employee (
    id INT,
    name VARCHAR(255),
    department VARCHAR(255),
    managerId INT
);

INSERT INTO Employee (id, name, department, managerId)
VALUES
    (101, 'John', 'HR', null),
    (102, 'Jane Smith', 'Finance', 101),
    (103, 'Jane Smith', 'Finance', 101),
    (104, 'Jane Smith', 'Finance', 101),
    (105, 'Jane Smith', 'Finance', 101),
    (106, 'Jane Smith', 'Finance', 101);


select name
from Employee e
         inner join
 (
     select count(1) cnt, managerId from Employee where managerId is not null  group by managerId
 ) a on e.id = a.managerId
            where a.cnt >= 5;

select
    e.name
    from (
        select
            count(1) cnt,
            managerId
        from Employee
        where managerId is not null
        group by managerId
    ) c
             inner join Employee e
    on e.id = c.managerId
    where c.cnt >= 5
;


SELECT e2.name
from Employee e1
         INNER JOIN Employee e2
ON e1.managerId = e2.id
GROUP BY e1.managerId
HAVING COUNT(e1.id) >= 5