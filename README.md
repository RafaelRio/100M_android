# 100M Android

Aplicación Android desarrollada en **Kotlin** y **Jetpack Compose** para crear, guardar y compartir pedidos basados en el catálogo de 100 Montaditos.

El proyecto permite seleccionar productos por categorías, gestionar cantidades, calcular automáticamente el importe total del pedido y mantener un histórico local de pedidos sin necesidad de backend.

> [!NOTE]
> Proyecto personal y no oficial. No está afiliado con 100 Montaditos ni con Restalia.

---

## 📱 Funcionalidades

* Crear nuevos pedidos y asignarles un nombre.
* Consultar un catálogo organizado por categorías:

  * Montaditos
  * Bebidas
  * Raciones
  * Aperitivos
  * Ensaladas
  * Monty Ahorros
* Añadir varias unidades de un mismo producto.
* Reducir o eliminar unidades del pedido.
* Consultar en tiempo real:

  * Número de productos añadidos.
  * Precio total del pedido.
* Aplicar automáticamente **precios especiales según el día de la semana** cuando están definidos en el catálogo.
* Confirmar el pedido antes de guardarlo.
* Consultar pedidos guardados.
* Editar pedidos existentes.
* Eliminar pedidos con confirmación previa.
* Mantener los pedidos almacenados localmente en el dispositivo.
* Compartir el pedido directamente por **WhatsApp**.
* Usar el selector estándar de Android para compartir si WhatsApp no está disponible.

---

## 🛠️ Stack tecnológico

| Tecnología                | Uso                                             |
| ------------------------- | ----------------------------------------------- |
| **Kotlin**                | Lenguaje principal                              |
| **Jetpack Compose**       | Desarrollo de la interfaz de usuario            |
| **Material 3**            | Componentes y diseño visual                     |
| **Navigation Compose**    | Navegación entre pantallas                      |
| **DataStore Preferences** | Persistencia local de pedidos                   |
| **Kotlin Coroutines**     | Operaciones asíncronas                          |
| **Flow**                  | Observación reactiva de los pedidos almacenados |
| **Gradle Kotlin DSL**     | Configuración del proyecto                      |

---

## 🧱 Estructura del proyecto

```text
com.rafario.a100m
│
├── data
│   ├── datasource
│   │   └── CatalogoDataSource.kt
│   │
│   ├── models
│   │   ├── Aperitivo.kt
│   │   ├── Bebida.kt
│   │   ├── Ensalada.kt
│   │   ├── Montadito.kt
│   │   ├── MontyAhorro.kt
│   │   ├── Pedido.kt
│   │   ├── PrecioEspecial.kt
│   │   └── Racion.kt
│   │
│   └── repository
│       └── PedidoRepository.kt
│
├── ui
│   ├── navigation
│   │   └── AppNavGraph.kt
│   │
│   └── screens
│       ├── SplashScreen.kt
│       ├── HomeScreen.kt
│       └── CreateOrderScreen.kt
│
└── MainActivity.kt
```

### `data/datasource`

Contiene el catálogo local utilizado por la aplicación. Los productos están definidos directamente en el proyecto, por lo que la app no depende de una API externa para mostrar la carta.

### `data/models`

Incluye los modelos que representan los diferentes productos y los pedidos.

Un pedido está formado por un identificador, un nombre y una lista de líneas de pedido:

```kotlin
data class Pedido(
    val id: Int = 0,
    val nombre: String = "",
    val lineas: List<LineaPedido> = emptyList()
)
```

Cada línea almacena información como el producto, el precio unitario y la cantidad seleccionada.

### `data/repository`

`PedidoRepository` centraliza la persistencia local y permite:

* Crear pedidos.
* Recuperar pedidos almacenados.
* Actualizar pedidos.
* Eliminar pedidos.

Los pedidos se serializan a **JSON** y se almacenan mediante **Preferences DataStore**.

### `ui`

La interfaz está construida completamente con **Jetpack Compose** y se divide en pantallas y navegación.

---

## 🧭 Navegación

La aplicación utiliza **Navigation Compose**.

```text
Splash
  │
  ▼
Home
  ├──► Nuevo pedido
  └──► Editar pedido
```

### Splash

Pantalla inicial mostrada al arrancar la aplicación antes de acceder a la pantalla principal.

### Home

Muestra los pedidos almacenados en el dispositivo.

Desde cada pedido se puede:

* Consultar sus productos.
* Consultar el precio total.
* Compartirlo.
* Editarlo.
* Eliminarlo.

### Nuevo pedido / Editar pedido

Permite construir un pedido seleccionando productos de las diferentes categorías del catálogo.

Las categorías son desplegables y cada producto puede añadirse varias veces. Durante la creación se muestra un resumen con la cantidad total de productos y el importe acumulado.

Para guardar un pedido es necesario:

1. Introducir un nombre.
2. Añadir al menos un producto.
3. Confirmar el pedido.

---

## 💾 Persistencia local

La aplicación funciona de forma **completamente local** y no necesita conexión con un servidor.

Los pedidos se guardan mediante **Android DataStore**, por lo que permanecen disponibles después de cerrar y volver a abrir la aplicación.

```text
UI
 │
 ▼
PedidoRepository
 │
 ▼
DataStore Preferences
 │
 ▼
JSON local
```

---

## 💰 Gestión de precios

Los productos pueden tener un **precio base** y precios especiales asociados a determinados días de la semana.

La aplicación consulta el día actual y utiliza automáticamente el precio correspondiente si existe una tarifa especial:

```kotlin
fun precioParaDia(
    precioBase: Double,
    preciosEspeciales: List<PrecioEspecial>,
    dia: DayOfWeek
): Double {
    return preciosEspeciales
        .firstOrNull { it.dia == dia }
        ?.precio
        ?: precioBase
}
```

El importe total del pedido se calcula a partir del subtotal de todas sus líneas:

```kotlin
val total: Double
    get() = lineas.sumOf { it.subtotal }
```

---

## 💬 Compartir pedidos

Desde la pantalla principal se puede compartir un pedido directamente mediante **WhatsApp**.

El texto generado resume su contenido y el importe total, por ejemplo:

```text
Pedido #1
Mesa 4

Montaditos: 1, 4, 7
2x Patatas
1x Coca-Cola

Total: 8,50 €
```

Si WhatsApp no está instalado, la app abre el selector estándar de Android para poder compartir el pedido mediante otra aplicación compatible.

---

## ⚙️ Requisitos

* **Android Studio**
* **Android SDK 29 o superior**
* `minSdk 29`
* `targetSdk 36`
* `compileSdk 36`
* **Java 11**

---

## 🚀 Instalación

Clona el repositorio:

```bash
git clone https://github.com/RafaelRio/100M_android.git
```

Accede al directorio:

```bash
cd 100M_android
```

Abre el proyecto en **Android Studio**, sincroniza Gradle y ejecútalo sobre un emulador o dispositivo Android.

También puedes compilar un APK de debug desde terminal:

```bash
./gradlew assembleDebug
```

El APK generado estará disponible en:

```text
app/build/outputs/apk/debug/
```

---

## 📌 Características técnicas destacadas

* Interfaz declarativa con **Jetpack Compose**.
* Navegación centralizada con **Navigation Compose**.
* Estado reactivo mediante **Flow**.
* Persistencia sin backend con **DataStore**.
* Serialización y reconstrucción de pedidos mediante **JSON**.
* Catálogo estructurado mediante modelos específicos.
* Lógica de precios dependiente del día de la semana.
* Integración con intents de Android para compartir contenido.

---

## 👨‍💻 Autor

Desarrollado por [Rafael Río](https://github.com/RafaelRio).

---

## ⚠️ Disclaimer

Este proyecto ha sido desarrollado con fines personales y educativos.

**100 Montaditos**, su nombre, logotipos y demás elementos de marca pertenecen a sus respectivos propietarios. Este proyecto no está afiliado oficialmente con **100 Montaditos** ni con **Restalia**.
