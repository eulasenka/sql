create trigger Trigger1
	on _ClubCard
	after update
as
begin
	print 'Record changed'
end
go

create trigger Trigger2
	on _ClubCard
	after insert
as
begin
	print 'Record inserted'
end
go


/*Check triggers*/
select * from _ClubCard;

update _ClubCard
set tourist_email ='new_email@gmail.com' where tourist_email ='yahoo'

insert into _ClubCard (clubcard_id, tourist_id, tourist_email, discount)
values ('11', '1', 'smail', '20');

select * from _ClubCard;