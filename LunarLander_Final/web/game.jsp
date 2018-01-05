<%-- 
    Document   : game
    Created on : 23-nov-2017, 1:24:03
    Author     : Miquel
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Lunar Lander</title>
        <meta charset="UTF-8">
        <meta name="description" content="Minijuego Lunar Lander con html, css, y JavaScript">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel='stylesheet' media='screen and (min-width: 601px)' href='css/responsive.css'>
        <link rel='stylesheet' media='screen and (max-width: 600px)' href='css/smartphone.css'>
        <link rel="shortcut icon" href="">
        <link rel="shortcut icon" href="favicon.ico">
        <script src="js/js.js"></script>

    </head>

    <body id="contenedor">
        <!--<h2 id='out'>out</h2>-->
        <div id="nave">
            <img id ="imgNave" src="img/nave.png" alt="img nave">
            <img id ="imgMotor" src="img/motor.gif" alt="img motor">
        </div>

        <div id="izquierda">
            <div id="cpanel">
                <div class="controlesNave">Velocidad:<br><b><span id="velocidad">100</span></b> m/s</div>
                <div class="controlesNave">Fuel:<br><b><span id="fuel">100</span></b> %</div>
                <div class="controlesNave">Altura:<br><b><span id="altura">60</span></b> m</div>
                <div id="botonOn"></div>
            </div>
        </div>

        <div id="zonaAterrizaje"><img src="img/luna.png" alt="luna" id="luna"></div>

        <div id="derechaSmartphone">
            <div id="reanudaSmartphone"><p>Play</p></div>
            <div id="pausaSmartphone">Men�</div>
            <div id="reiniciaSmartphone"><p>Reiniciar</p></div>
            <div id="ayudaSmartphone"><p>Ayuda</p></div>
            <div id="botonAjustesSmartphone"><p>Ajustes</p></div>
        </div>

        <div id="derecha">
            <div id="reanudar"><p>Play</p></div>
            <div id="pausa">Pausar</div>
            <div id="reinicia"><p>Reiniciar</p></div>
            <div id="instrucciones"><p>Ayuda</p></div>
            <div id="botonAjustes"><p>Ajustes</p></div>
        </div>

        <div id="gameOver">
            <h2>���GAME OVER!!!</h2>
            �Int�ntalo de nuevo! <br>
            La velocidad de la nave no debe superar los 5 metros/segundo<br><br>
            <button id="jugarOtraVez"><h3>Probar otra vez</h3></button>
            <button id="jugarOtraVezSmartphone"><h3>Probar otra vez</h3></button>
            <br><br>
            Intentos realizados: <b><span id="intentos">0</span></b><br><br>
        </div>

        <div id="userWin">
            <h2>���ENHORABUENA!!!</h2>
            La NASA estar�a orgullosa de contar con pilotos como t�...<br><br>
            <img src="img/Enhorabuena.gif"><br>
            <button id="jugarAgain"><h3>Jugar otra vez</h3></button>
            <button id="jugarAgainSmartphone"><h3>Jugar otra vez</h3></button><br><br>
        </div>

        <div id="menuInstrucciones">
            <a href="#" onclick="ocultarInstrucciones();"><img id="close" src="img/close.png" alt="close"></a>
            <h3>INSTRUCCIONES</h3>
            <p>El juego consiste en frenar la ca�da de la nave mediante el uso del motor, utiliza la tecla <b>&nbsp;&nbsp;espacio&nbsp;&nbsp;</b> o el bot�n <b>ON</b> para la version smartphone, para que esta pueda aterrizar adecuadamente sobre la superficie lunar.<br><br>Si el jugador no frena lo suficientemente la ca�da de la nave ,a una <b>velocidad inferior a los 5 m/s</b>, esta se estrellar� y el jugador no superar� el juego.<br><br> Adem�s hay que tener en cuenta que la nave cuenta con un medidor de gasolina que se acabar� si el jugador abusa del uso del motor de la nave.</p>
            <a href="acerca.html"><button><h3>Acerca de...</h3></button></a>
        </div>

        <div id="settings">
            <a href="#" onclick="ocultarAjustes();"><img id="close" src="img/close.png" alt="close"></a>
            <h3>AJUSTES</h3>
            <p>Dificultad del juego:<br>
                (Disminuye el dep�sito de gasolina)<br>
                <button id="dificultad">F�cil</button><br><br>
                Modelo luna:<br>
                <button id="modeloLuna">Amarilla</button>
            </p>
            Modelo nave:<br>
            <button id="modeloNave">Modelo Est�ndar</button><br><br>

            <form>
                <div class="form-group">
                <select id="select"></select>
                <input id="cargar2" type="button" value="Cargar2">
                <input id="nomConfig" type="text" placeholder="Nom Configuraci�">
                <input id="guardar" type="button" value="Guardar">
                </div>
            </form>
            <form>
                <div class="form-group">
                    <p>
                    <label for="exampleFormControlFile1">Csv</label>
                    <input type="file" class="form-control-file" id="exampleFormControlFile1">
                </div>
            </form>
    </body>
</html>
