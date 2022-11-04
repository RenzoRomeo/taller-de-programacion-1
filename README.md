# taller-de-programacion-1

# Integrantes

- Camila Cacace
- Lucas de Lellis
- Teo Ramos kees
- Renzo Romeo

# TODO

- Flujo de inicio:
  - Se inicia el programa.
  - Se intenta cargar el sistema desde el archivo.
    - Si no existe, aparece la vista de crear sistema. Esta vista te lleva a la vista de crear sistema para poner el
      nombre del sistema y luego te lleva a la vista para establecer la contraseña del admin.
    - Si ya existe, aparece la vista de iniciar sesion.
  - Se muestra la vista correspondiente: operario o administrador.

# Preguntas

- ~~Como verificar que exista una unica instancia de administrador? SINGLETON?~~
- ~~Hay que validar las postcondiciones dentro de los constructores? SI~~
- Como se chequean las fechas? DEPENDE. SE PUEDE USAR UN STRING FECHA Y VALIDAR CON ESO.
- ~~"Al menos dos productos deberan estar promocionados" EN TODO MOMENTO~~
- ~~Revisar Javadoc del constructor de administrador.~~
- ~~Las pres y post de metodos sobreescritos hay que escribirlas de vuelta? NO~~
- ~~Como asegurar que solo el admin pueda crear nuevo operarios por ejemplo? ALMACENAR OPERARIO LOGUEADO, BOOLEAN MODO
  EN SISTEMA~~
- ~~Esta bien que el operario genere la comanda? OPERARIO~~
- Esta bien la solucion del booleano modo que se asigna al iniciar sesion?