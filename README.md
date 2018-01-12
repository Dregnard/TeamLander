# TeamLander

Lunar-Lander
## Version 0.0

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
Head

Descripción: Descripción incluida en el meta.
Google fonts: Incorporación de Fuentes para poderlos utilizar en el CSS.
Body
Divs de navegación por el menú: Cuando el usuario utilice el menú superior aparecen una serie de divs (Pausa, Instrucciones, Opciones y About).
Divs con Eventos Especiales: Creados exclusivamente para mostrarse cuando el jugador inicia el juego por primera vez, y cuando el jugador gana o pierde la partida.
Aportaciones al CSS:
Discriminación entre PC y móvil: Grcias a unas clases definidas en el HTML y display:none, podemos elegir que elementos se muestran en cada dispositivo. (Por ejemplo, en el ordenador nos pone que usemos "la barra espaciadora" mientras que en el móvil solo nos muestra "tocar la pantalla" en el menú instrucciones)
Estilos menús (Pausa, Instrucciones, Opciones y About): En el móvil, ocupan un 100% de la pantalla, en el ordenador aparecen centrados en el centro.
Aportaciones al JS:
Eventos:
Cambios al cargar la página: Antes: empezaba a jugar directamente. Ahora: muestra mensaje de bienvenida.
Eliminación de "clic" para mover nave: Antes al hacer clic en el ratón se activaba la nave. Ahora ya no.
Sistema de juego:
Móvil: La nave se mueve al poner el dedo en la pantalla (ontouch).
PC: La nave se mueve SOLO al pulsar la barra espaciadora (no funciona con ninguna otra tecla). Además al pulsar la tecla P nos lleva al menú de pausa.
Mostrar/Ocultar los divs de los elementos del menú (instrucciones, opciones, about...):
Móvil: Al estar en el menú principal y clicar sobre los botones nos lleva a los divs correspondientes. Cada div contiene un botón "Volver" que nos permite volver al menú principal.
PC: Cada vez que se da clic en un elemento del menú superior, se cierran los otros y se abre el nuevo que queremos ver. Si volvemos a hacer clic sobre el botón de un menú que tenemos abierto, el div se cierra y el juego continúa.
Menu pausa
Móvil: En el movil, el menú principal hace las funciones del menú de pausa del ordenador. Tiene un botón para reiniciar
PC: Para el juego y nos muestra dos opciones: continuar o reiniciar.
Menu instrucciones: Muestra las instrucciones
Menu opciones: Muestra las opciones y permite cambiarlas.
Nivel dificultad: Fácil, Medio y Difícil (Un texto nos muestra las características de cada nivel de dificultad)
Imagen Nave: Cambiar entre la imagen por defecto y otra.
Lugar Aterrizaje: Cambiar entre la Luna y Marte.
Menu about: Muestra el About
Botón "Volver" (solo movil): En el móvil hay un botón que pone "Volver" en los menús de Instrucciones, Opciones y About que nos permite volver al menú principal.
####Funciones Se han añadido varias funciones para que los eventos anteriores funciones.

###Otros

Si la nave sube mucho, también acaba el juego.
En el movil se han añadido unos scrolls en el menú de Bienvenida, Instrucciones y Opciones, por si no cabe todo en alguna pantalla.
En el ordenador tenemos hover para cuando se pasa el ratón por algún botón para hacer clic, en el móvil el hover no he considerado necesario ponerlo ya que cuando tocas con el dedo directamente te envía al sitio que quieres.
Las opciones elegidas en el menú de opciones (por ejemplo, "Difícil", "Nave" y "Luna") se diferencian con un subrayado.
Cambio de color en el panel de control en la gasolina (si se está acabando va cambiando a naranja y luego a rojo) y en el de la velocidad (si la velocidad es muy alta y nos vamos a estrellar sale en naranja o rojo si se va muy rápido).
Cuando se cambien las opciones de dificultad el juego se reinicia, si se cambia el tipo de nave o el lugar de aterrizaje no.
