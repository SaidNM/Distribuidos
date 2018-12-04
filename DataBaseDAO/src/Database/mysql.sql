create database PROD_CAT;
use PROD_CAT;

create table Categoria(
    idCategoria int not null auto_increment primary key,
    nombre varchar(30) not null,
    descripcion varchar(30) not null
);

create table Producto(
    idProducto int not null auto_increment primary key,
    nombre varchar(30) not null,
    precio double not null,
    idCategoria int not null,
    foreign key(idCategoria) references Categoria(idCategoria) on update cascade on delete cascade
);

delimiter $


create procedure spInsertarP(nombreProducto varchar(30), elPrecio double, idCat int)
begin
    insert into Producto(nombre,precio,idCategoria) values(nombreProducto,elPrecio,idCat);
end $

create procedure spActualizarP(nombreProducto varchar(30),elPrecio double, idCat int, idProd int)
begin
    update Producto set nombre=nombreProducto, precio=elPrecio, idCategoria=idCat where idProducto=idProd;
end $

create procedure spDeleteP(idProd int)
begin 
    delete from Producto where idProducto = idProd;
end $

create procedure spSelectOneP(idProd int)
begin
    select * from Producto where idProducto=idProd;
end $

create procedure spSelectAllP()
begin
    select * from Producto;
end $


create procedure spInsertarC(nombreCategoria varchar(30), descripcionCategoria varchar(30))
begin
    insert into Categoria(nombre,descripcion) values(nombreCategoria,descripcionCategoria);
end $

create procedure spActualizarC(nombreCategoria varchar(30), descripcionCategoria varchar(30), idCateg int)
begin
    update Categoria set nombre=nombreCategoria, descripcion=descripcionCategoria where idCategoria=idCateg;
end $

create procedure spDeleteC(idCateg int)
begin 
    delete from Categoria where idCategoria = idCateg;
end $

create procedure spSelectOneC(idCateg int)
begin
    select * from Categoria where idCategoria=idCateg;
end $

create procedure spSelectAllC()
begin
    select * from Categoria;
end $

create procedure spSelectAllProductsByCategory(idCateg int)
begin
    select * from Producto where idCategoria = idCateg;
end $

delimiter ;
