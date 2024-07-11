insert into artist(name,genre) values ('Leonardo da Vinci','Renaissance');
insert into artist(name,genre) values ('Vincent van Gogh','Post-Impressionism');
insert into artist(name,genre) values ('Pablo Picass','Cubism');
insert into artist(name,genre) values ('Edward Hopper','American Modernism');

insert into art(title,theme,artistId) values ('The Flight Study','Studies of Bird Wings',1);
insert into art(title,theme,artistId) values ('Mona Lisa 2.0','Renaissance Portrait',1);
insert into art(title,theme,artistId) values ('Starry Countryside','Night Landscape',2);
insert into art(title,theme,artistId) values ('Sunflower Impressions','Floral',2);
insert into art(title,theme,artistId) values ('Cubist Self-Portrait','Abstract Portrait',3);
insert into art(title,theme,artistId) values ('Barcelona Abstracted','City Landscape',3);
insert into art(title,theme,artistId) values ('Downtown Solitude','Urban Scene',4);
insert into art(title,theme,artistId) values ('Night Cafe Redux','Modernist Interior',4);



insert into gallery(name,location) values ('Louvre Museum','Paris');
insert into gallery(name,location) values ('Van Gogh Museum','Amsterdam');
insert into gallery(name,location) values ('Museo Picasso','Barcelona');
insert into gallery(name,location) values ('Whitney Museum of American Art','New York');

insert into artist_gallery(artistId,galleryId) values (1,1);
insert into artist_gallery(artistId,galleryId) values (1,2);
insert into artist_gallery(artistId,galleryId) values (2,2);
insert into artist_gallery(artistId,galleryId) values (3,3);
insert into artist_gallery(artistId,galleryId) values (3,4);
insert into artist_gallery(artistId,galleryId) values (4,4);




