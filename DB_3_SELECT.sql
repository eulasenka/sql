select * from _Address;
select * from _ClubCard;
select * from _Order;
select * from _Tour;
select * from _Tourist;
select * from _Tour_Order;

select city, street from _Address where city like 'B%'
select tour_name, tour_date from _Tour where tour_name like 'U%' 

select _Tourist.surame, _Order.order_id from _Tourist
join _Order on _Tourist.tourist_id=_Order.tourist_id

select tourist_id from _ClubCard where discount=(select max(discount) from _ClubCard)

select Earlest_tour=min(tour_date), Latest_tour=max(tour_date) from _Tour
select Lives_inBrest=count(city) from _Address where city like 'Brest'
