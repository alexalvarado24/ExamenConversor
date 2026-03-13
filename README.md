# Conversor de Unidades – App Android

## Descripción

Aplicación móvil Android desarrollada en **Java** que permite realizar conversiones de unidades de medida de forma sencilla e intuitiva.

La aplicación muestra un **ListView** con diferentes tipos de conversión disponibles. Cuando el usuario selecciona una opción, se abre una nueva actividad donde puede realizar la conversión en ambos sentidos entre las unidades seleccionadas.

---

## Características

* Interfaz moderna con barra azul en la parte superior.
* **ListView** con las conversiones disponibles.
* Tres tipos de conversión implementadas:

  * Metros ↔ Pies
  * Kilómetros ↔ Millas
  * Centímetros ↔ Pulgadas
* Conversión en ambos sentidos.
* Resultados con **4 decimales de precisión**.
* Validación de entradas del usuario.
* Diseño adaptable utilizando **ConstraintLayout**.

---

## Tecnologías Utilizadas

* **Lenguaje:** Java
* **IDE:** Android Studio
* **SDK mínimo:** API 35 (Android 15)
* **SDK objetivo:** API 36 (Android 16)
* **Layouts:** ConstraintLayout
* **Componentes:** ListView, EditText, Button, TextView

---

## Prerrequisitos

Antes de ejecutar el proyecto es necesario tener instalado:

* Android Studio (versión Otter o superior)
* JDK 8 o superior
* Dispositivo Android con API 35+ o un emulador configurado

---

## Instalación y Configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/tuusuario/conversor-unidades.git
```

### 2. Abrir el proyecto en Android Studio

* Ir a **File → Open**
* Seleccionar la carpeta del proyecto.

### 3. Sincronizar el proyecto

Esperar a que **Gradle** descargue y configure todas las dependencias necesarias.

### 4. Ejecutar la aplicación

* Conectar un dispositivo Android o iniciar un emulador.
* Presionar **Run** en Android Studio.

---

## Uso de la Aplicación

### Pantalla principal

* Se muestra un **ListView** con las tres conversiones disponibles.
* El usuario puede tocar cualquier opción para acceder a la pantalla de conversión.

### Pantalla de conversión

* En la parte superior se muestra el tipo de conversión seleccionado.
* El usuario puede ingresar un valor en cualquiera de los dos campos disponibles.
* Se puede elegir la dirección de conversión utilizando los botones:

  * **Convertir →**
  * **← Convertir**
* El resultado aparecerá automáticamente en el campo correspondiente.
* Un **TextView** muestra el resultado formateado con precisión.

---

## Estructura del Proyecto

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/conversorapp/
│   │   │   ├── MainActivity.java
│   │   │   └── ConversionActivity.java
│   │   └── res/
│   │       ├── layout/
│   │       │   ├── activity_main.xml
│   │       │   └── activity_conversion.xml
│   │       └── values/
│   │           ├── strings.xml
│   │           └── colors.xml
└── build.gradle
```

---

## Pruebas

La aplicación ha sido probada en:

* Dispositivo físico con **Android 15**
* Diferentes tamaños de pantalla para verificar el diseño adaptable

---

## Autor

Proyecto académico desarrollado como práctica de **desarrollo de aplicaciones móviles en Android**.
