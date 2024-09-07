### Proyecto-1-PA-SIA
## Sistema de gestión de programas de becas
# Descripción del programa

Este programa esta centrado en la postulación y administración de solicitudes de diversas becas para futuros estudiantes de la educación superior, para ello, se realizo un programa el cual ayudara de manera significativa a la realización de dichas postulaciones, ademas de servir como herramienta para administrar dichas solicitudes. 

## Instrucciones de ejecución del programa.

Para correr el proyecto en netBeans, se crea un proyecto nuevo, donde, se crea un proyecto vacío (sin Main) y dentro de ese proyecto se crea un paquete llamado "paquete",
dentro de aquel paquete se copian los 4 archivos: (beca,postulantes, index1, index2). Luego en el apartado de FILES dentro del archivos pom.xml se reemplazara la linea main class con la siguiente: "<exec.mainClass>paquete.index</exec.mainClass>".
Luego en carpeta java (dentro de FILES) se creara una sub-carpeta llamada "resources" en donde se copiaran los archivos de texto.
Luego se hará click en la opción "build and clean" y finalmente ejecutamos en index.

Una vez se ejecute el programa, se mostrara un menú con distintas opciones, estas dirigidas al postulante y al administrador del programa, las cuales se podran utilizar para postular y administrar la pagina respectivamente para poder seleccionar una de las opciones, se debera ingresar el valor el digito correspondiente a dicha opción.

Estas opciones son:

-Para los postulantes:
- 1)Consultar Becas disponibles: Se mostrarán por pantalla las becas disponibles en el sistema.
- 2)Consultar Becas Postulante: Consultar las becas postuladas por el alumno.
- 3)Realizar postulación: El postulante realizará la postulación a la beca de preferencia.
- 4)Consultar estado de Beca(s): Aquí el postulante podrá ver el estado de su postulación.
- 5)Realizar Ficha/Registrarse: El postulante agrega sus datos personales para realizar la postulación.

-Para los administradores:
- 6)Gestionar solicitudes: En esta sección, el administrador podrá gestionar de manera eficiente las solicitudes de los postulantes.
- 7)Salir del programa: El programa finalizará su ejecución.


