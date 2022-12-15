
-- Tabla Usuario
CREATE TABLE usuario(
 id integer NOT NULL, 
 nombre  varchar(100) NOT NULL, 
 direccion varchar(1255) NOT NULL, 
 PRIMARY KEY (id)
);

-- Tabla vendedor
CREATE TABLE vendedor(
 idVendedor integer NOT NULL, 
 nombre  varchar(100) NOT NULL, 
 direccion varchar(1255) NOT NULL, 
 cantidad_Productos integer NOT NULL,
 numero_Venta integer NOT NULL,
 PRIMARY KEY (idVendedor)
);

-- Tabla proveedor
CREATE TABLE proveedor(
 idProveedor integer NOT NULL, 
 nombre  varchar(100) NOT NULL, 
 direccion varchar(1255) NOT NULL, 
 nombre_Insumo varchar(155) NOT NULL,
 numero_Venta integer NOT NULL,
 PRIMARY KEY (idProveedor)
);

-- Tabla cliente
CREATE TABLE cliente(
 idCliente integer NOT NULL, 
 nombre  varchar(100) NOT NULL, 
 direccion varchar(1255) NOT NULL, 
 edad integer NOT NULL,
 cantidadPedido integer NOT NULL,
 tipoPago varchar(155) NOT NULL,
 PRIMARY KEY (idCliente)
);

-- Tabla Producto
create table producto(
	idProductos integer,
	NombreProducto varchar(40) not null,
	Precio float not null,
	Descripcion varchar(70),
	cantidad integer not null,
	PRIMARY KEY(idProductos)
);

-- Tabla Bodega:
create table Bodega(
	idProducto_Bod integer not null,
	NombreProducto_Bod varchar(40) not null,
	Precio_Bod float not null,
	Cantidad integer not null,
	FOREIGN KEY (idProducto_Bod) REFERENCES Producto (idProductos)
);


-- Tabla Fabricación:
create table Fabricacion(
	idProducto_Fab integer not null,
	Materia_Prima varchar(25) not null,
	Producto varchar(30) not null,
	FOREIGN KEY (idProducto_Fab) REFERENCES Producto (idProductos)
);



-- Tabla Comercialiacion
create table Comercializacion(
	idCliente_Com integer not null,
	Producto_Com varchar(40) not null,
	Precio_Com float not null,
	Vendedor integer not null,
	NumeroFactura integer not null primary key,
	Cantidad_Com integer not null,
	DireccionVenta varchar(80) not null,
	FOREIGN KEY (Vendedor) REFERENCES vendedor (idVendedor),
	FOREIGN KEY (idCliente_Com) REFERENCES cliente (idCliente)
);

-- Tabla EmpresaUnivalle:
create table EmpresaUnivalle(
	NombreEmpresa varchar(8) not null,
	Direccion varchar(80) not null,
	NombreProducto varchar(40) not null,
	NumeroFactura_Emp integer not null,
	FOREIGN KEY (NumeroFactura_Emp) REFERENCES Comercializacion (NumeroFactura)
);
