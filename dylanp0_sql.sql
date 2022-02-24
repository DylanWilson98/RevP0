create table game_store (
game_id int Identity(1,1) Primary Key,
title varchar(60) not null,
rating int,

);


insert into game_store 
values
('Genshin Impact', 0),
( 'The Last of Us Part II', 0),
( 'Final Fantasy VII Remake', 0),
( 'Sekiro: Shadows Die Twice', 0),
( 'Detroit: Become Human', 0),
( 'Ghost of Tsushima', 0),
( 'Mafia III', 0),
( 'Spider-Man', 0),
('Horizon Zero Dawn', 0),
('Kingdom Hearts III', 0),
( 'Hitman III', 0),
( 'Dark Souls III', 0),
('Demon Souls', 0),
('GTA V', 0),
('GTA San Andreas', 0),
('Spider-Man: Miles Morales', 0),
('Horizon Zero Dawn Forbidden West', 0),
('Forespoken', 0),
('Elden Ring', 0),
('Assassins Creed Valhalla', 0),
('No Mans Sky', 0);
--('', null),


select * from game_store;

drop table game_store;


create table users (
user_id int Identity(1,1) Primary key,
username  varchar(40) ,
password  varchar(40) 


);

insert into users 
values 
('dylan', 'wilson'),
('player1','wins'),
('player2','loses');

select * from users;`

drop table users;




create table game_collection (
--collection_id int not null,
user_id int not null,
game_id int not null,
Foreign key (user_id) references users(user_id) On Delete Cascade,
Foreign key (game_id) references game_store(game_id) On Delete Cascade


);

insert into game_collection 
values 
(1,1),
(1,20),
(1,11),
(1,10),
(1,14),
(2,4);

select * from game_collection;

drop table game_collection;


--join for collection
select gc.game_id, gs.title from game_collection as gc inner join game_store gs on gc.game_id = gs.game_id where gc.user_id = 1 ;





--except for adding game to collection from store (1 is a placeholder here is really user_id of current user)
select game_id  from game_store gs 
except
select game_id from game_collection gc where gc.user_id = 1;




































