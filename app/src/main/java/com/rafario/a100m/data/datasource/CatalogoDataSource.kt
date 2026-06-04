package com.rafario.a100m.data.datasource

import com.rafario.a100m.data.models.Aperitivo
import com.rafario.a100m.data.models.Bebida
import com.rafario.a100m.data.models.Ensalada
import com.rafario.a100m.data.models.Montadito
import com.rafario.a100m.data.models.MontyAhorro
import com.rafario.a100m.data.models.PrecioEspecial
import com.rafario.a100m.data.models.Racion
import com.rafario.a100m.data.models.TipoBebida
import java.time.DayOfWeek

object CatalogoDataSource {

    val montaditos = listOf(
        Montadito(
            id = 1001,
            nombre = "Jamón gran reserva con aceite de oliva",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00)
            )
        ),
        Montadito(
            id = 1002,
            nombre = "Tortilla de patatas con alioli",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00)
            )
        ),
        Montadito(
            id = 1003,
            nombre = "Pollo kebab con salsa brava",
            precio = 2.00
        ),
        Montadito(
            id = 1004,
            nombre = "Lomo al ajillo con queso",
            precio = 2.00
        ),
        Montadito(
            id = 1005,
            nombre = "Salmón ahumado con crema de queso",
            precio = 2.50
        ),
        Montadito(
            id = 1006,
            nombre = "Carrillera con salsa de la casa",
            precio = 2.50
        ),
        Montadito(
            id = 1007,
            nombre = "Pulled pork con cheddar",
            precio = 2.50
        ),
        Montadito(
            id = 1008,
            nombre = "Queso de cabra con cebolla caramelizada",
            precio = 2.00
        )
    )

    val bebidas = listOf(
        Bebida(
            id = 2001,
            nombre = "Jarra de cerveza",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CERVEZA,
            precio = 1.80
        ),
        Bebida(
            id = 2002,
            nombre = "Caña",
            tamano = "250 ml",
            tipoBebida = TipoBebida.CERVEZA,
            precio = 1.20,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.THURSDAY, 1.00)
            )
        ),
        Bebida(
            id = 2003,
            nombre = "Jarra de tinto de verano",
            tamano = "500 ml",
            tipoBebida = TipoBebida.TINTO_DE_VERANO,
            precio = 1.80
        ),
        Bebida(
            id = 2004,
            nombre = "Agua mineral",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CLASICAS,
            precio = 1.50
        ),
        Bebida(
            id = 2005,
            nombre = "Refresco de cola",
            tamano = "330 ml",
            tipoBebida = TipoBebida.CLASICAS,
            precio = 1.90
        ),
        Bebida(
            id = 2006,
            nombre = "Café solo",
            tamano = "Taza",
            tipoBebida = TipoBebida.CAFE_INFUSIONES,
            precio = 1.20
        )
    )

    val raciones = listOf(
        Racion(
            id = 3001,
            nombre = "Patatas bravas",
            precio = 4.50
        ),
        Racion(
            id = 3002,
            nombre = "Alitas de pollo BBQ",
            precio = 5.50
        ),
        Racion(
            id = 3003,
            nombre = "Lágrimas de pollo",
            precio = 5.00
        ),
        Racion(
            id = 3004,
            nombre = "Nachos con cheddar y pulled pork",
            precio = 6.50
        )
    )

    val aperitivos = listOf(
        Aperitivo(
            id = 4001,
            nombre = "Aceitunas aliñadas",
            descripcion = "Cuenco pequeño para compartir.",
            precio = 1.50
        ),
        Aperitivo(
            id = 4002,
            nombre = "Chips de patata",
            descripcion = null,
            precio = 1.20
        ),
        Aperitivo(
            id = 4003,
            nombre = "Torreznos crujientes",
            descripcion = "Aperitivo caliente con salsa suave.",
            precio = 3.00
        )
    )

    val ensaladas = listOf(
        Ensalada(
            id = 5001,
            nombre = "Ensalada César",
            precio = 6.50
        ),
        Ensalada(
            id = 5002,
            nombre = "Ensalada de queso de cabra",
            precio = 6.90
        ),
        Ensalada(
            id = 5003,
            nombre = "Ensalada mediterránea",
            precio = 5.90
        )
    )

    val montyAhorros = listOf(
        MontyAhorro(
            id = 6001,
            nombre = "Monty ahorro clásico",
            montaditos = listOf(montaditos[0], montaditos[1], montaditos[3]),
            precio = 4.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.MONDAY, 3.50)
            )
        ),
        MontyAhorro(
            id = 6002,
            nombre = "Monty ahorro especial",
            montaditos = listOf(montaditos[2], montaditos[5], montaditos[6]),
            precio = 6.50
        ),
        MontyAhorro(
            id = 6003,
            nombre = "Monty ahorro veggie",
            montaditos = listOf(montaditos[1], montaditos[7], montaditos[4]),
            precio = 5.50
        )
    )
}
