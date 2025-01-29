# 🎯 **Juego de Adivinar el Número** 🧠

Bienvenido al juego interactivo de adivinanza de números, donde debes adivinar el número aleatorio generado por el sistema en un tiempo limitado. El juego proporciona pistas sobre el número a medida que realizas tus intentos, y tienes que hacer todo esto dentro de un límite de tiempo determinado.

## 🌟 **Características del Juego**

- **3 Niveles de Dificultad**:
  - **Fácil**: Rango 1-10 con 30 segundos de límite de tiempo.
  - **Medio**: Rango 1-50 con 45 segundos de límite de tiempo.
  - **Difícil**: Rango 1-100 con 60 segundos de límite de tiempo.

- **Temporizador**: El tiempo restante para adivinar el número se muestra en pantalla. Si el tiempo se agota, el juego termina y se muestra el número correcto.

- **Pistas**: Durante el juego, recibirás varias pistas:
  - Si el número es mayor o menor que el tuyo.
  - Si el número es par o impar.
  - Si el número es primo o no.
  - Si el número está cerca de un múltiplo de 10.
  - Si el número es divisible por 3.
  - Si el número es un cuadrado perfecto.
  - El rango en el que se encuentra el número.

- **Historial de Intentos**: El juego guarda un historial con los intentos realizados en la partida.

- **Soporte para Excepciones**: Si ocurre algún error, el juego manejará las excepciones y mostrará mensajes claros para el jugador.

## 📋 **Especificaciones Técnicas**

- **Lenguaje**: El juego está escrito en **Java**.
- **Clases principales**:
  - **Game**: Controla la lógica del juego, incluyendo la generación del número aleatorio, la validación de las respuestas y las pistas.
  - **GameTimer**: Controla el temporizador del juego.
  - **TimerException**: Excepciones relacionadas con el temporizador.
  - **Main**: Contiene la lógica para interactuar con el usuario.

## 🎮 **Instrucciones para Jugar**

1. **Selecciona una dificultad**: 
   - Fácil (1-10)
   - Medio (1-50)
   - Difícil (1-100)

2. **Haz tu intento**: Elige un número dentro del rango seleccionado.

3. **Recibe pistas**: El sistema te dará pistas sobre si el número es mayor o menor, si es par, primo, etc.

4. **Tiempo limitado**: Tienes un tiempo limitado para adivinar el número. Si se acaba el tiempo, el juego termina.

5. **Ver historial**: Al finalizar, podrás ver el historial de tus intentos.

## 🛠️ **Requisitos**

Para ejecutar este proyecto, necesitarás tener instalado Java en tu máquina. Aquí te dejo los pasos para configurarlo:

- **Java 8 o superior**: Asegúrate de tener una versión compatible de Java instalada. Puedes descargar Java desde [aquí](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **IDE recomendado**: Se recomienda usar un IDE como **IntelliJ IDEA**, **Eclipse** o **NetBeans** para facilitar la ejecución del código.
  
## 🖥️ **Instalación y Ejecución**

1. **Clonar el repositorio**:
   Clona este repositorio a tu máquina local utilizando el siguiente comando:

   ```bash
   git clone	https://github.com/druiz07/NumberGuessing