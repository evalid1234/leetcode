--A country is big if:
--
--    it has an area of at least three million (i.e., 3000000 km2), or
--    it has a population of at least twenty-five million (i.e., 25000000).
--
--Write a solution to find the name, population, and area of the big countries.
--
--Return the result table in any order.


SELECT name, population, area
FROM World as w
WHERE w.area > 2999999 OR w.population > 24999999


--Create table If Not Exists World (name varchar(255), continent varchar(255), area int, population int, gdp bigint)
--Truncate table World
--insert into World (name, continent, area, population, gdp) values ('Afghanistan', 'Asia', '652230', '25500100', '20343000000')
--insert into World (name, continent, area, population, gdp) values ('Albania', 'Europe', '28748', '2831741', '12960000000')
--insert into World (name, continent, area, population, gdp) values ('Algeria', 'Africa', '2381741', '37100000', '188681000000')
--insert into World (name, continent, area, population, gdp) values ('Andorra', 'Europe', '468', '78115', '3712000000')
--insert into World (name, continent, area, population, gdp) values ('Angola', 'Africa', '1246700', '20609294', '100990000000')