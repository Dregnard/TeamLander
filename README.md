# TeamLander

Lunar-Lander
## Version 0.0
enlace: https://github.com/urbinapro/lunar-landing-javascript

La version 0.0 del videojuego hace referencia a todo el codigo desde que partimos para el desarrollo de la aplicacion.
Este código consta de varios de archivos:
 
 Documentos HTML:
  
     index.html : es la página principal del juego y contiene todos los objetos que lo conforman.
    
  Documentos CSS:
  
 	    d.css: es la hoja de estilo importada al archivo index.html siempre y cuando el ancho de la pantalla del ordenador supere los           961pxpx.
      
      m.css: es la hoja de estilo importada al archivo index.html siempre y cuando el ancho de la pantalla del ordenador esté por debajo de los 960px.
   Documento javascript:
      
      La funcion del archivo de javascript dar la animacion correspondiente a la nave en funcion de la velocidad y la altura



## Versión 1.0

Tareas a desarrollar:

* Incorporar las diferentes imágenes al proyecto: Naves, Luna, fondo y las diferentes herramientas de menu.
* Dificultad del juego: Diferentes modos de juego.
* Menú: Diferentes menus según las pantallas.
* Instrucciones del juego


## Aportaciones al HTML:
* UTF-8
* Head: descripción incluida en el meta. En la instancia al CSS,  
* Body
* Menu instrucciones: Muestra las instrucciones
* Menu opciones: Muestra las opciones y permite cambiarlas.
* Menu about: Muestra el About

## Aportaciones al CSS
* Discriminación entre PC y móvil según el tamaño de la pantalla.
* Estilos menús (Pausa, Instrucciones, Opciones y About): En el móvil, ocupan un 100% de la pantalla, en el ordenador aparecen centrados en el centro.

## Aportaciones al JS:
* Version Móvil: La nave se mueve al poner el dedo en la pantalla (ontouch).
* Version PC: La nave se mueve SOLO al pulsar la barra espaciadora (no funciona con ninguna otra tecla).
* Mostrar/Ocultar los divs de los elementos del menú (instrucciones, opciones, about...):
* Móvil: Al estar en el menú principal y clicar sobre los botones nos lleva a los divs correspondientes. Cada div contiene un botón "Volver" que nos permite volver al menú principal.
* PC: Cada vez que se da clic en un elemento del menú superior, se cierran los otros y se abre el nuevo que queremos ver. 
* El Menu pausa el juego
* Nivel dificultad: Fácil, Medio y Difícil.
* Imagen Nave: La nave expulsará fuego de los motores cuando aceleremos y explotará si no aterrizamos adecuadamente.
* Lugar Aterrizaje: La Luna.


