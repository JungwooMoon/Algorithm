-- 코드를 입력하세요
SELECT o.animal_id, o.animal_type, o.name
from animal_ins i join animal_outs o 
on i.animal_id = o.animal_id
where i.sex_upon_intake like 'Intact%' and
(o.sex_upon_outcome Like 'Neutered%' or o.sex_upon_outcome Like 'Spayed%') 
order by o.animal_id