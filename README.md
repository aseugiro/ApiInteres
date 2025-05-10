# Servicio REST de Cálculo de Interés Simple y Compuesto

Este es un servicio RESTful que permite calcular el interés simple y compuesto a partir de los datos proporcionados por el cliente. Los cálculos realizados se registran en una base de datos para su posterior consulta.

## Funcionalidades

El servicio ofrece las siguientes funcionalidades a través de sus endpoints:

### `POST /calcular-interes`

* **Descripción:** Permite calcular el interés simple y compuesto basado en los datos proporcionados y guarda un registro del cálculo en la base de datos.
* **Método:** `POST`
* **Endpoint:** `/calcular-interes`
  * **Cuerpo de la Solicitud (JSON):**
      ```json
      {
      "montoInicial": 5000,
      "tasaInteres": 3,
      "anios": 5
      }
      ```
      * `capital_inicial`: (Número) El capital inicial para el cálculo.
      * `anios`: (Número entero) El número de años para el cálculo.
      * `tasa_interes`: (Número decimal) La tasa de interés anual (ej. 0.05 para 5%).
* **Comportamiento:**
    1.  Recibe los datos del cálculo en el cuerpo de la solicitud.
    2.  Calcula el interés simple: $\text{Capital Inicial} \times \text{Tasa de Interés} \times \text{Años}$
    3.  Calcula el valor final con interés simple: $\text{Capital Inicial} + \text{Interés Simple}$
    4.  Calcula el valor final con interés compuesto: $\text{Capital Inicial} \times (1 + \text{Tasa de Interés})^{\text{Años}}$
    5. Guarda un registro general del cálculo en la tabla maestra `Bitacora`.
    6. Guarda los detalles específicos del cálculo (incluyendo los resultados y la referencia al registro en `Bitacora`) en la tabla detalle `historial_interes`.
* **Respuesta (JSON):**
    ```json
    {
    "id": 56,
    "fecha": "Fri May 09 22:16:47 CST 2025",
    "interes_simple": [
        {
            "monto": "5150.00",
            "anio": 1
        },
        {
            "monto": "5300.00",
            "anio": 2
        },
        {
            "monto": "5450.00",
            "anio": 3
        },
        {
            "monto": "5600.00",
            "anio": 4
        },
        {
            "monto": "5750.00",
            "anio": 5
        }
    ],
    "interes_compuesto": [
        {
            "monto": "5150.00",
            "anio": 1
        },
        {
            "monto": "5304.50",
            "anio": 2
        },
        {
            "monto": "5463.64",
            "anio": 3
        },
        {
            "monto": "5627.54",
            "anio": 4
        },
        {
            "monto": "5796.37",
            "anio": 5
        }
    ]
}
    ```
    * `interes_simple`: El interés simple calculado.
    * `interes_compuesto`: El interés compuesto calculado.
    * `id_bitacora`: El ID del registro guardado en la tabla `Bitacora`.

### `GET /historial-calculos`

* **Descripción:** Permite obtener una lista de los cálculos de interés realizados previamente.
* **Método:** `GET`
* **Endpoint:** `/historial-calculos`
* **Comportamiento:**
    1.  Consulta la base de datos para recuperar todos los registros de los cálculos de interés almacenados en la tabla `historial_interes`, posiblemente incluyendo información de la tabla `Bitacora` (como la fecha del cálculo).
    2.  Formatea los resultados como una lista de objetos JSON.
* **Respuesta (JSON):**
    ```json
   {
    "id": 56,
    "fecha": "Fri May 09 22:16:47 CST 2025",
    "interes_simple": [
        {
            "monto": "5150.00",
            "anio": 1
        },
        {
            "monto": "5300.00",
            "anio": 2
        },
        {
            "monto": "5450.00",
            "anio": 3
        },
        {
            "monto": "5600.00",
            "anio": 4
        },
        {
            "monto": "5750.00",
            "anio": 5
        }
    ],
    "interes_compuesto": [
        {
            "monto": "5150.00",
            "anio": 1
        },
        {
            "monto": "5304.50",
            "anio": 2
        },
        {
            "monto": "5463.64",
            "anio": 3
        },
        {
            "monto": "5627.54",
            "anio": 4
        },
        {
            "monto": "5796.37",
            "anio": 5
        }
    ]
}
    ```
  
## Esquema de la Base de Datos 

* **Tabla: `Bitacora` (Master)**: Contiene información general sobre cada solicitud de cálculo.
    * `id_bitacora` (INT, PRIMARY KEY, AUTO_INCREMENT)
    * `fecha_calculo` (TIMESTAMP)
* **Tabla: `historial_interes` (Detalle)**: Contiene los detalles específicos de cada cálculo de interés.
    * `id_calculo` (INT, PRIMARY KEY, AUTO_INCREMENT)
    * `id_bitacora` (INT, FOREIGN KEY referencing `Bitacora.id_bitacora`)
    * `interes_simple` (DECIMAL)
    * `interes_compuesto` (DECIMAL)
    * `anio` (INT)

## Tecnologías Utilizadas

* Kotlin con Spring Boot
* PostgreSQL (Script para crear las tablas src/main/resource)

## Cómo Utilizar

Para interactuar con este servicio REST, puedes utilizar cualquier cliente HTTP (como `curl`, Postman, Insomnia o una biblioteca HTTP en tu lenguaje de programación).

1.  **Calcular Interés:** Envía una petición `POST` al endpoint `/calcular-interes` con un cuerpo JSON que contenga los datos `capital_inicial`, `anios` y `tasa_interes`.
2.  **Obtener Historial de Cálculos:** Envía una petición `GET` al endpoint `/historial-calculos` para obtener una lista de todos los cálculos realizados previamente.