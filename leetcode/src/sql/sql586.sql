/*
586. Customer Placing the Largest Number of Orders
Easy
884
65
Companies
SQL Schema
Pandas Schema
Table: Orders

+-----------------+----------+
| Column Name     | Type     |
+-----------------+----------+
| order_number    | int      |
| customer_number | int      |
+-----------------+----------+
order_number is the primary key (column with unique values) for this table.
This table contains information about the order ID and the customer ID.

Write a solution to find the customer_number for the customer who has placed the largest number of orders.

The test cases are generated so that exactly one customer will have placed more orders than any other customer.
The result format is in the following example.



Example 1:

Input:
Orders table:
+--------------+-----------------+
| order_number | customer_number |
+--------------+-----------------+
| 1            | 1               |
| 2            | 2               |
| 3            | 3               |
| 4            | 3               |
+--------------+-----------------+
Output:
+-----------------+
| customer_number |
+-----------------+
| 3               |
+-----------------+
Explanation:
The customer with number 3 has two orders, which is greater than either customer 1 or 2 because each of them only has one order.
So the result is customer_number 3.


Follow up: What if more than one customer has the largest number of orders, can you find all the customer_number in this case?
*/




-- https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/

create table Orders(
    order_number int,
    customer_number int
);

insert into Orders (order_number, customer_number) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 3);

select customer_number from (
select count(1) cnt, customer_number from Orders group by customer_number order by cnt desc )  a limit 1

-- SELECT customer_number
-- FROM Orders
-- GROUP BY customer_number
-- ORDER BY count(*) DESC
--     LIMIT 1;


-- select customer_number
-- from Orders
-- group by customer_number
-- having count(customer_number) >= 2;

