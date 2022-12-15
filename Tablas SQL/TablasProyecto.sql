-- TABLAS PARA EL PROYECTO:

-- Tabla Producto:
create table Producto(
	ID_producto integer primary key,
	NombreProducto varchar(40) not null,
	Precio float not null,
	Descripcion varchar(70),
	cantidad integer not null
);

-- Tabla Bodega:
create table Bodega(
	ID_Producto_Bod integer not null,
	NombreProducto_Bod varchar(40) not null,
	Precio_Bod float not null,
	Cantidad integer not null,
	FOREIGN KEY (ID_Producto_Bod) REFERENCES Producto (ID_Producto)
);

-- Tabla Fabricación:
create table Fabricacion(
	ID_Producto_Fab integer not null,
	Materia_Prima varchar(25) not null,
	Producto varchar(30) not null,
	FOREIGN KEY (ID_Producto_Fab) REFERENCES Producto (ID_Producto)
);

-- Tabla Usuario:
create table Usuario(
	ID_ integer not null primary key,
	Nombre varchar(40) not null,
	Direccion varchar(50) not null
);

-- Tabla Proveedor:
create table Proveedor(
	ID_Proveedor integer not null,
	NombreProveedor varchar(40) not null,
	NombreInsumo varchar(25) not null,
	CantidadInsumo integer not null,
	FOREIGN KEY (ID_Proveedor) REFERENCES Usuario (ID_)
);

-- Tabla Cliente:
create table Cliente(
	ID_Cliente integer not null unique,
	NombreCliente varchar(40) not null,
	DireccionCliente varchar(50) not null,
	Edad integer not null,
	CantidadPedido integer not null,
	FOREIGN KEY (ID_Cliente) REFERENCES Usuario (ID_)
);

-- Tabla Empleado:
create table Empleado(
	ID_Empleado integer not null unique,
	NombreEmpleado varchar(40) not null,
	NombreProducto_Emp varchar(40) not null,
	CantidadProducto integer not null,
	FOREIGN KEY (ID_Empleado) REFERENCES Usuario (ID_)
);

-- Tabla Comercialiacion
create table Comercializacion(
	NumeroFactura integer not null primary key,
	Producto_Com varchar(40) not null,
	Precio_Com float not null,
	Vendedor integer not null,
	Cantidad_Com integer not null,
	DireccionVenta varchar(80) not null,
	ID_Cliente_Com integer not null,
	FOREIGN KEY (Vendedor) REFERENCES Empleado (ID_Empleado),
	FOREIGN KEY (ID_Cliente_Com) REFERENCES Cliente (ID_Cliente)
);

-- Tabla EmpresaUnivalle:
create table EmpresaUnivalle(
	NombreEmpresa varchar(8) not null,
	Direccion varchar(80) not null,
	NombreProducto varchar(40) not null,
	NumeroFactura_Emp integer not null,
	FOREIGN KEY (NumeroFactura_Emp) REFERENCES Comercializacion (NumeroFactura)
);
