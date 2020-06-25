# operational-calculator-api
Repositorio para prueba de desarrollo de un microservicio Calculadora que realiza operaciones con dos operandos

Enunciado
=================

El objetivo de este ejercicio es implementar un microservicio "calculadora", usando maven + spring-boot

Este microservicio tiene que exponer un API que debe ser capaz, a partir de unos parámetros de entrada, de realizar operaciones aritméticas. Al ser una versión POC, sólo será capaz de realizar sumas y restas de dos elementos, aunque se prevé que en futuras versiones haya otros tipos de operaciones y de mayor complejidad. También se incluye con este enunciado un jar que contiene un API de traceo de operaciones que debe ser invocado por el microservicio para tracear el resultado de la operación.

El tiempo para hacer el ejercicio es de hasta cuatro horas a partir de la recepción del correo con este ejercicio, plazo máximo en el que debe referirse una URL de github (o similares) a la dirección de arquitecturainternet@sanitas.es para su análisis. El objeto del ejercicio NO es entregar el microservicio, sino ver cómo se plantea la solución.


Notas adicionales
=================

* Lo que se busca ver es la manera en que se afronta el problema, no la solución por si misma. En este sentido, no hay una solución correcta, es mucho más interesante el histórico de Git como hilo conductor de lo que se va haciendo. Tener un único commit con todas las actuaciones efectuadas no es aconsejable.

* Se puede usar cualquier librería / versión que se considere necesaria para llevar a cabo la tarea. Los únicos requisitos son:
  * debe ser un proyecto maven (cualquier versión de maven)
  * debe ser un microservicio spring-boot (cualquier versión de spring-boot)

* El entregable debe compilar en una instalación de maven totalmente limpia, debe indicarse en un fichero README tanto los pasos necesarios para generar el jar final como para ejecutarlo (no hace falta mucho detalle).

# Desarrollo
## Análisis

El servicio debe exponer un API que permita al usuario final indicar los valores sobre los que se requiere realizar la operación. En principio y como no se indica lo contrario en el enunciado, se considera que solo está permitido el uso de dos elementos para las operaciones.

Por otra parte, las operaciones en esta fase inicial son dos, suma y resta, sin embargo se identifica que en un futuro aumente el número de operaciones disponibles, por lo que el API debe ser extensible en el uso de operaciones.

Además, se debe validar que los elementos a los cuales se debe realizar las operaciones son correctos para cada tipo de operación, ya que estas validaciones puede ser distintas para cada tipo de operación.

## Diseño
Para realizar el proceso de diseño se seguirá un enfoque Top-Down, es decir, partiendo del diseño de las capas más altas (entendiendo por más alta como más cercana a la interacción con el usuario, vease capa web) se diseña las capas inferiores haciendo que el contrato del API modele todo el sistema llegando hasta la base de datos en ultima instancia y no al contrario. 

En el escenario actual, no disponemos de almacenamiento de información y solo tenemos una capa de negocio que es la encarga de realizar las operaciones. Por tanto a nivel de diseño por capas se define la siguiente estructura: Capa web => Capa de negocio

### Contrato del API
El API constará de un único endpoint, a pesar de no ser un API orientado al uso RESTFUL ya que no se consume un recurso como tal, se intentará seguir las buenas practicas de comunicación entre APIs, por tanto, se expone el siguiente endpoint:

 POST /calculadora
 
Donde el cuerpo de la petición tendrá el siguiente formato:

```
{
  "parametro1":10.0,
  "parametro2":15.5,
  "operacion":"SUM"
}
```
Donde la operación deberá ser un valor predeterminado de los disponible como operaciones permitidas dentro del microservicio. De esta forma, el API es extensible a la generación de nuevas operaciones sin perjudicar a los consumidores del API. Esto permitirá que el microservicio se despliegue con tecnicas como Canary Test/Canary Deployment sin que los consumidores sean afectados añadiendo de forma inmediata nuevas operaciones sin que estos tengan que cambiar el contrato del API.
Por otra parte, la inclusión de valores no permitidos en los parametros puede ocasionar excepciones controladas. Además si un consumidor indica un tipo de operación que no está incluida dentro del microservicio se indicará por medio de una excepcion que dicha operación no está disponible. Por ultimo, si una validación para una operación es erronea, se elevará una excepción para indicar al consumidor que los parametros enviados no pasan la validación para realizar la operación seleccionada. A continación se muestra una lista de los posibles errores con su respuesta HTTP correspondiente.

* Bad Request 400 -> El tipo del valor de los parametros enviados no es permitido por el API
* Unprocesable Entity 422 -> Los parametros enviados no pasaron la validación para la operación seleccionada.
* Not Implemented 501 -> La operación seleccionada no está disponible en el servicio.
