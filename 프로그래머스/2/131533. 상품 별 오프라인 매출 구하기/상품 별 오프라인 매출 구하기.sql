-- 코드를 입력하세요
SELECT product_code, sum(price * sales_amount) AS sales
FROM product p JOIN offline_sale o ON p.product_id = o.product_id
GROUP BY product_code
ORDER BY sales desc, product_code