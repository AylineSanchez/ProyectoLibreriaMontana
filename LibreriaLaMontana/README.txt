1.- El programa ocupa el sistema gestor de bases de datos postgreSQL 
2.- Se debe crear la base de datos "libreria"
3.- Se debe cargar el contenido del archivo scriptCREATE.txt a nuestro sistema gestor postgresql (script para la creacion de nuestra base de datos libreria)
4.- Luego se debe cargar el contenido del archivo scriptINSERT.txt a postgresql (script para la inserción de datos a nuestra base de datos libreria)
5.- El programa incluye en el directorio principal un archivo conexion.txt
	La primera linea se deja intacta (si nombramos "libreria" nuestra base de datos)
	La segunda linea es el usuario (Se deja intacta si nuestro usuario es postgres)
	La tercera linea es la contraseña (Se debe modificar con nuestra contraseña de postgresql)
6.- Si la conexión es realizada con exito el programa dirá: Probando conexión con la base de datos - OK
	De lo contrario dará un mensaje de error

*Se utiliza la api jdbc incluida en el programa
