-- User Inserts

insert into user values (1001,sysdate(), 'ABC'); 
insert into user values (2002,sysdate(), 'Jill');
insert into user values (3003,sysdate(), 'Jack');
insert into user values (4004,sysdate(), 'Adam');

-- Posts Inserts

insert into post values (11001,'My First Post side by side', 1001);
insert into post values (11002,'My Second Post side by side', 1001);
insert into post values (11003,'My Thrird Post side by side', 2002);
insert into post values (11004,'My Fourth Post side by side', 2002);