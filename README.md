# PayGoal
---------------------------

##Producto

### POST (creación de entidad)
	http://localhost:8080/productos

Ejemplo:

    {
        "nombre": "auriculares",
        "descripcion": "Auriculares razen pro",
        "precio": 200,
        "cantidad": 10
    }

### PUT (actualización de entidad)

	http://localhost:8080/productos/{id}

Ejemplo:

Path:

    http://localhost:8080/productos/1


Body:

    {
        "nombre": "Auriculares",
        "descripcion": "Auriculares redragon blancos con rosa",
        "precio": 233,
        "cantidad": 1
    }

### DELETE (eliminación de entidad)

	http://localhost:8080/productos/{id}

Ejemplo:

    http://localhost:8080/productos/1

### GET (consulta de una entidad por id)

	http://localhost:8080/productos/id/{id}

Ejemplo:

    http://localhost:8080/productos/id/1

### GET (listado de entidades)

	http://localhost:8080/productos

### GET (listado de entidades ordenadas por precio)

	http://localhost:8080/productos/ordenados
  
  Ejemplo:

    http://localhost:8080/productos/ordenados
---------------------------
