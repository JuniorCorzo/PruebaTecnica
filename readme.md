# Prueba Tecnica
## Desarrollo de la api
### Descripcion
La API se desarrolló usando Spring Boot con una base de datos MongoDB. Se implementaron endpoints que permiten insertar pacientes con sus resultados y devolver todos los datos almacenados en la base de datos.

- **GET**: Este endpoint nos devuelve todos los datos almacenados en la base de datos.
    ```
    /orden-paciente/
    ```
- **POST**: Este endpoint nos permite insertar datos en la base de datos.
    ```
    /orden-paciente/insert
    ```
    
### DB diagram
Diagrama de como se almacenan los datos en MongoDB
```json5
{
  ordenPaciente: {
    _api: "ObjectId",
    nombre: "string",
    apellido: "String",
    codigoOrden: "string",
    Examenes: [
      {
        codigoExamen: "string",
        resultado: "number"
      }
    ]    
  }
}

```
### Requisitos Previos
- Java JDK 21
- MongoDB
- Maven o Gradle

### Pasos de Instalación

1. **Clonar el Repositorio**
    ```bash
    git clone https://github.com/JuniorCorzo/PruebaTecnica
    ```

2. **Configurar MongoDB**
    - Asegúrese de tener MongoDB instalado y corriendo en el puerto predeterminado (27017)
    - La base de datos se creará automáticamente al iniciar la aplicación

3. **Instalar Dependencias y Compilar**
    ```bash
    ./gradlew build #En linux
    ./gradlew.bat build #En windows
    ```

4. **Ejecutar la Aplicación**
    ```bash
    ./gradlew bootRun #En linux
    ./gradlew.bat bootRun #En windows
    ```

La API estará disponible en 
```
http://localhost:8080/orden-paciente/
```

## Aplicación de Escritorio
### Descripción
Aplicación Java que procesa mensajes HL7 y los envía a una API REST. La aplicación permite la lectura y procesamiento de archivos HL7 para su posterior envío a la base de datoa.

### Requisitos Previos
- Java JDK 21
- Gradle
- API REST ejecutándose en localhost:8080

### Tecnologías Utilizadas
- Java 21
- Gradle
- Jackson para manejo de JSON

### Instalación
1. Clonar el Repositorio
    ```bash
    git clone https://github.com/JuniorCorzo/PruebaTecnica
    ```
2. Compilar el Proyecto
    ```bash
    ./gradlew clean build #En linux
    ./gradlew.bat clean build #En windows
    ```
3. Ejecutar la Aplicación
    ```bash
        ./gradlew run #En linux
        ./gradlew.bat run #En windows
    ```
### Funcionalidades
- Lectura de archivos HL7
- Procesamiento de mensajes HL7
- Envío de datos a API REST
- Interfaz gráfica para selección de archivos

## Interfaz Web
### Descripción
Interfaz web desarrollada en React para visualizar los datos de pacientes almacenados en la base de datos.

### Requisitos Previos
- Node.js (v18 o superior)
- npm
- API REST ejecutándose en localhost:8080
### Tecnologías Utilizadas
- React + Vite
- TypeScript
### Instalación
1. Clonar el Repositorio
    ```bash
    git clone https://github.com/JuniorCorzo/PruebaTecnica
    ```
2. Instalar Dependencias
     ```bash
    npm install
    ```
3. Ejecutar en Desarrollo
    ```bash
    npm run dev
    ```
4. Construir para Producción
    ```bash
    npm run build
    ```
### Funcionalidades
- Visualización de lista de pacientes
- Detalles de resultados médicos
- Comunicación con API REST

### Notas Adicionales
- La aplicación se ejecuta en http://localhost:5173
- Requiere que la API esté en funcionamiento
