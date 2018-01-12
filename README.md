# TeamLander

Lunar-Lander


##Versión 0.1

Esta versión contiene la implementación con HTML y CSS de los elementos básicos del juego Lunar Lander. Todavía no hay movimiento, por lo que todos los elementos están estáticos.

En esta versión se incluyen los siguientes elementos:

Elementos del entorno lunar:
Fondo estrellado: Una imagen repetida en el fondo del body del HTML para simular el fondo estrellado.
Luna: Imagen fija (y repetida) en la parte baja de la pantalla, que corresponde al lugar de aterrizaje de la nave.
Alienígena: Elemento decorativo sobre la Luna.
Elementos relacionados con la nave:
Nave
Nave con propulsión (Oculto): Cuando el juego funcione y se utilicen los motores se mostrará esta imagen.
Explosión (Oculto): Cuando el juego funcione, si la nave colisiona contra la luna se mostrará esta imagen.
Elementos de control
Panel de control: Cuando el juego funcione incluirá información sobre Gasolina, Velocidad y Altitud
Pergamino del menú: Cuando el juego funcione, nos llevará al menú al pulsarlo y pondrá el juego en pausa.
Menús
Menú principal (Oculto):
Reanudar (no implementado): Nos devolvería al juego.
Opciones (no implementado): Conducirá al "Menú instrucciones" (ver más abajo)
Reinciar: Nos devuelve a index.html
About (Link externo): Nos lleva a about.html
Menú instrucciones (Oculto): Incluye instrucciones de juego y elección de idioma.
About
Página externa con la información de las personas que han trabajado en el proyecto. Al hacer click en "Volver" nos devuelve a index.html
Cambios realizados respecto al material original
Luna: La imagen se redujo de tamaño (de 400x133 a 306x133 en la versión horizontal y de 200x67 a 153x67 en la versión vertical), para que al repetirse la imagen se viese la superficie lunar de manera continua, sin que se notase el límite entre imágenes.
Nave: Para poder trabajar correctamente con la nave, tuvimos que hacer nuevas versiones de la nave a partir del material recibido. Las nuevas versiones de las imágenes (148x188 para la versión horizontal y 100x127 para la versión vertical), en las que se incluían dos versiones de la imagen (una de la nave normal, y otra con la propulsión).
Panel de control: Para facilitar que el código fuese responsive, se decidió no utilizar la imagen de fondo del panel propuesta y crearla nosotros con CSS. Se mantuvio la paleta de colores original.
Menu principal: Se nos entregó una imagen para el menú, pero se recreó el menú a partir de CSS (manteniendo colores y fuentes de texto originales) para facilitar su adaptación a los diferentes dispositivos.
Menu horizontal/vertical (ELIMINADO): En la versión original del proyecto había un menu auxiliar que permitía cambiar el formato vertical/horizontal. Como el código es responsive y se adapata al dispositivo no se consideró necesasrio incluirlo.
Menu instrucciones: No se especificaron que instrucciones se debían incluir, por lo que se crearon basándonos en el material recibido. En este mismo menú se eliminaron las "Banderas" para la selección de idiomas y se utilizó texto, al no disponer de las imágenes adecuadas para implementarlo.
About: No estaba incluido en el material original.
Otra información
El código es responsive para adaptarse a los diferentes tamaños de pantallas.
