### DB diagram
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