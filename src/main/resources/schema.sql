create table artist(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    genre varchar(255)   
);


create table art(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title varchar(255),
    theme varchar(255),
    artistId INT,
    FOREIGN KEY(artistId) REFERENCES artist(id)
);


create table gallery(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    location varchar(255)
);

create table artist_gallery(
    artistId INT,
    galleryId INT,
    PRIMARY KEY(artistId,galleryId),
    FOREIGN KEY(artistId) REFERENCES artist(id),
    FOREIGN KEY(galleryId) REFERENCES gallery(id)
);