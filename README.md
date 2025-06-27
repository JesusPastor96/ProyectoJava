# 🗃️ Proyecto de Gestión de Clientes con JDBC y Ficheros

Este proyecto en Java permite gestionar una base de datos de clientes utilizando JDBC para la conexión con MySQL, e incorpora funcionalidades de importación y exportación de datos mediante ficheros de texto.

## 🧩 Funcionalidades principales

- Alta de nuevos clientes en la base de datos.
- Búsqueda y listado de clientes existentes.
- Exportación de clientes a fichero de texto.
- Importación de clientes desde fichero a la base de datos.
- Validaciones básicas de los datos introducidos.

## 🛠️ Tecnologías utilizadas

- **Lenguaje:** Java
- **Base de datos:** MySQL
- **Conexión a BBDD:** JDBC
- **Entorno de desarrollo:** IntelliJ IDEA
- **Gestión de versiones:** Git + GitHub

## 🗄️ Estructura del proyecto

src/
├── modelo/
│ └── Cliente.java
├── dao/
│ └── ClienteDAO.java
├── utilidades/
│ └── GestorFicheros.java
├── main/
│ └── Principal.java
└── resources/
└── clientes.txt


## ⚙️ Configuración y uso

1. **Base de datos:**
   - Crear la base de datos y tabla de clientes.
   - Configurar los parámetros de conexión en el código.

2. **Compilación y ejecución:**
   - Compilar el proyecto con tu IDE o desde terminal.
   - Ejecutar la clase `Principal.java` para comenzar.

3. **Fichero de datos:**
   - El fichero `clientes.txt` sirve para importar/exportar los registros.
   - El formato es CSV con delimitador `,`.

## 🎓 Proyecto académico

Este proyecto ha sido desarrollado como parte de la **Unidad JDBC y Ficheros** del ciclo de **Desarrollo de Aplicaciones Web (DAW)**.

## 🙋 Autor

**Jesús Pastor Ricoy**
📍 Cádiz · Londres · Pamplona
📧 [jesus.pastor.ricoy@gmail.com](mailto:jesus.pastor.ricoy@gmail.com)


