# Write your MySQL query statement below
Select firstName,lastName,city,state
From Person P left Join  Address A on P.personId = A.personId