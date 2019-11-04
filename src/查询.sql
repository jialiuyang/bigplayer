SELECT * FROM `doublecolor` where  doubleday >="2019-01-01" and  doubleday <="2019-12-01" 
select * from 
 (select  red01 from doublecolor ) a  left join 
 (select  red02 from doublecolor) b  on a.red01=b.red02
 select  red03 from doublecolor
 select  red04 from doublecolor
 select  red05 from doublecolor
 select  red06 from doublecolor
 
257	3
104	3
  7	3

select IFNULL(a.num1 ,0) +IFNULL(b.num2 ,0) +IFNULL(c.num3 ,0)+IFNULL(d.num4 ,0)+IFNULL(e.num5 ,0)+IFNULL(f.num6 ,0) nums, a.red01,b.red02,f.red06 from (
select IFNULL(count(*) ,0) num1 , red01 from `doublecolor` GROUP BY red01 ) a  
left join (select IFNULL(count(*) ,0) num2 , red02 from `doublecolor` GROUP BY red02) b on a.red01=b.red02

left join (select IFNULL(count(*) ,0) num3 , red03 from `doublecolor` GROUP BY red03) c on a.red01=c.red03

left join (select IFNULL(count(*) ,0) num4 , red04 from `doublecolor` GROUP BY red04) d on a.red01=d.red04

left join (select IFNULL(count(*) ,0) num5 , red05 from `doublecolor` GROUP BY red05) e on a.red01=e.red05

left join (select IFNULL(count(*) ,0) num6 , red06 from `doublecolor` GROUP BY red06) f on a.red01=f.red06
 

