select  b.stock_name, s.price - b.price as capital_gain_loss from
    (
        select stock_name, sum(price) price from Stocks where operation = 'Buy' group by stock_name) b
        join
    (select stock_name, sum(price) price from Stocks where operation = 'Sell' group by stock_name) s
    on b.stock_name = s.stock_name;