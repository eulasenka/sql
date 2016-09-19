begin transaction work;
insert into _Address (address_id, city, street, room)
 values ('1', 'Brest', 'Moscow str.', '101'),
		('2', 'Lomza', 'Aleja Wielkopolski', '12'), 
		('3', 'Lomza', 'Narutowicza str.', '31'),
		('4', 'Brest', 'Krivosheina str.', '24'),
		('5', 'Brest', 'Soviet str.', '3'),
		('6', 'Kiev', 'Independence str.', '15'),
		('7', 'Minsk', 'Lukashenko str.', '11'),
		('8', 'Wroclaw', 'Gornickiego str.', '61'),
		('9', 'Vilnius', 'Akropolis str.', '6'),
		('10', 'Brest', 'Moscow str.', '50');
commit work;

begin transaction work;
insert into _Tourist (tourist_id, name, surame, clubcard_id, address_id)
 values ('1', 'Edward', 'Vlasenko', '1', '1'), 
		('2', 'Derdak', 'Michal', '10',  '3'),
		('3', 'Jakub', 'Garlicki', '9',  '2'),
		('4', 'Kostek', 'Podmostek', '7',  '5'),
		('5', 'Oleksandr', 'Daydenko', '6',  '6'),
		('6', 'Anton', 'Guzovski', '8',  '7'),
		('7', 'Katarzyna', 'Romaszewska', '4',  '9'),
		('8', 'Ola', 'Antoniuk', '5',  '4'),
		('9', 'Lisa', 'Klimovicz', '3',  '10'),
		('10', 'Jakub', 'Manajczuk', '2',  '8');
commit work;

begin transaction work;
insert into _Order (order_id, tourist_id, order_date, amount)
 values ('1', '2', '2016-01-20', '2'),
		('2', '2', '2016-01-20', '2'),
		('3', '1', '2016-01-21', '1'),
		('4', '3', '2016-01-22', '1'),
		('5', '5', '2016-01-23', '1'),
		('6', '6', '2016-01-24', '1'),
		('7', '9', '2016-01-25', '1'),
		('8', '10', '2016-01-26', '1'),
		('9', '7', '2016-01-27', '1'),
		('10', '8', '2016-01-28', '1'),
		('11', '4', '2016-01-28', '1');
commit work;

begin transaction work;
insert into _ClubCard (clubcard_id, tourist_id, tourist_email, discount)
 values ('1', '1', 'gmail', '20'),
		('2', '10', 'gmail', '10'),
		('3', '9', 'gmail', '10'),
		('4', '7', 'gmail', '10'),
		('5', '6', 'gmail', '10'),
		('6', '8', 'yandex', '10'),
		('7', '4', 'yandex', '10'),
		('8', '5', 'hotmail', '10'),
		('9', '3', 'yahoo', '10'),
		('10', '2', 'gmail', '10');
commit work;

begin transaction work;
insert into _Tour (tour_id, tour_name, tour_description, tour_date)
 values ('1', 'Havai', 'Very exiting journey', '2016-07-03'),
		('2', 'Monaco', 'Very exiting journey', '2016-07-04'),
		('3', 'USA', 'Very exiting journey', '2016-07-05'),
		('4', 'Cuba', 'Very exiting journey', '2016-07-03'),
		('5', 'Russia', 'Very exiting journey', '2016-07-02'),
		('6', 'UK', 'Very exiting journey', '2016-07-01'),
		('7', 'China', 'Very exiting journey', '2016-07-30'),
		('8', 'Belarus', 'Very exiting journey', '2016-07-24'),
		('9', 'Turkei', 'Very exiting journey', '2016-07-23'),
		('10', 'Poland', 'Very exiting journey', '2016-07-13');
commit work;

begin transaction work;
insert into _Tour_Order (order_id, tour_id)
 values ('1', '3'),
		('2', '5'),
		('3', '1'),
		('4', '2'),
		('5', '2'),
		('6', '3'),
		('7', '2'),
		('8', '3'),
		('9', '9'),
		('10', '10'),
		('11', '5');
commit work;