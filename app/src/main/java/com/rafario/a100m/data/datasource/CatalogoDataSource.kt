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
            id = 1,
            nombre = "Jamón gran reserva con aceite de oliva",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 2,
            nombre = "Tortilla de patatas y tomate",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 3,
            nombre = "Pulled pork BBQ",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 4,
            nombre = "Pollo y salsa alioli",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 5,
            nombre = "Carrillera al vino tinto",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 6,
            nombre = "Calamarcitos y mayonesa",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 7,
            nombre = "Pollo kebab y salsa BBQ",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 8,
            nombre = "Bacon ahumado y queso madurado",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 9,
            nombre = "Torreznos y salsa brava",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 10,
            nombre = "Lomo al ajillo y salsa 100M",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 11,
            nombre = "Tortilla de patatas y queso madurado",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 12,
            nombre = "Tortilla de patatas, bacon ahumado y salsa alioli",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 13,
            nombre = "Tortilla de patatas, tomate y mayonesa",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 14,
            nombre = "Tortilla de patatas y mojo picón",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 15,
            nombre = "Tortilla de patatas, patatas paja y salsa 100M",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 16,
            nombre = "Tortilla de patatas, cebolla crujiente y salsa BBQ",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 17,
            nombre = "Pollo y queso madurado",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 18,
            nombre = "Pollo, tomate y mojo picón",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 19,
            nombre = "Pollo, patatas paja y salsa de mostaza y miel",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 20,
            nombre = "Pollo, bacon ahumado y mayonesa",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 21,
            nombre = "Pollo, patatas paja y salsa BBQ",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 22,
            nombre = "Pollo kebab y tomate",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 23,
            nombre = "Pollo kebab y salsa cheddar",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 24,
            nombre = "Pollo kebab, tomate y salsa 100M",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 25,
            nombre = "Pollo kebab, patatas paja y salsa BBQ",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 26,
            nombre = "Pollo kebab, bacon ahumado y mayonesa",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 27,
            nombre = "Pulled pork BBQ y salsa cheddar",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 28,
            nombre = "Pulled pork BBQ y bacon ahumado",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 29,
            nombre = "Pulled pork BBQ y salsa brava",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 30,
            nombre = "Pulled pork BBQ y patatas paja",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 31,
            nombre = "Pulled pork BBQ y cebolla crujiente",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 32,
            nombre = "Lomo al ajillo y queso madurado",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 33,
            nombre = "Lomo al ajillo y queso gorgonzola",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 34,
            nombre = "Lomo al ajillo y mojo picón",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 35,
            nombre = "Lomo al ajillo, tomate y patatas paja",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 36,
            nombre = "Lomo al ajillo, tomate y mayonesa",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 37,
            nombre = "Lomo al ajillo, bacon ahumado y salsa alioli",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 38,
            nombre = "Calamarcitos y salsa alioli",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 39,
            nombre = "Calamarcitos y salsa 100M",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 40,
            nombre = "Calamarcitos y guacamole",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 41,
            nombre = "Calamarcitos, salsa brava y mayonesa",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 42,
            nombre = "Calamarcitos, tomate y mayonesa",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 43,
            nombre = "Bacon ahumado, tomate y mayonesa",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 44,
            nombre = "Bacon ahumado, cebolla crujiente y salsa 100M",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 45,
            nombre = "Bacon ahumado, tomate y queso gorgonzola",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 46,
            nombre = "Bacon ahumado, patatas paja y mayonesa",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 47,
            nombre = "Bacon ahumado, tomate y queso madurado",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 48,
            nombre = "Jamón Gran Reserva y mantequilla",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 49,
            nombre = "Jamón Gran Reserva y tomate",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 50,
            nombre = "Jamón Gran Reserva, tomate y patatas paja",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 51,
            nombre = "Jamón Gran Reserva y tortilla de patatas",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 52,
            nombre = "Carrillera al vino tinto y salsa alioli",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 53,
            nombre = "Carrillera al vino tinto y patatas paja",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 54,
            nombre = "Carrillera al vino tinto y tomate",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 55,
            nombre = "Carrillera al vino tinto y cebolla crujiente",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 56,
            nombre = "Carrillera al vino tinto y bacon ahumado",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 57,
            nombre = "Torreznos y mayonesa",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 58,
            nombre = "Torreznos y salsa alioli",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 59,
            nombre = "Torreznos y salsa 100M",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 60,
            nombre = "Salmón ahumado y queso gorgonzola",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 61,
            nombre = "Salmón ahumado y tomate",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 62,
            nombre = "Salmón ahumado y salsa de mostaza y miel",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 63,
            nombre = "Salmón ahumado y guacamole",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 64,
            nombre = "Chorizo parrillero y salsa brava",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 65,
            nombre = "Chorizo parrillero y queso gorgonzola",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 66,
            nombre = "Chorizo parrillero y salsa BBQ",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 67,
            nombre = "Chorizo parrillero y guacamole",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 68,
            nombre = "Montycookie doble chocolate y sirope de caramelo toffee",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 69,
            nombre = "Montycookie chocolate y sirope de pistacho",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 70,
            nombre = "Montycookie chocolate y sirope de chocolate",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 71,
            nombre = "Piadina de jamón cocido y queso mozzarella",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 72,
            nombre = "Piadina de pepperoni y queso mozzarella",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 73,
            nombre = "Piadina de pollo, tomate, queso mozzarella y orégano",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 74,
            nombre = "Piadina de jamón Gran Reserva, queso mozzarella y orégano",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 75,
            nombre = "Piadina de jamón cocido, queso madurado y tomate",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 76,
            nombre = "Hot dog, kétchup y mayonesa",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 77,
            nombre = "Hot dog, cebolla crujiente y mojo picón",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 78,
            nombre = "Hot dog, guacamole y salsa cheddar",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 79,
            nombre = "Hot dog, patatas paja y salsa alioli",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 80,
            nombre = "Hot dog, cebolla crujiente y salsa 100M",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 81,
            nombre = "Burger, queso madurado, tomate y mayonesa",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 82,
            nombre = "Burger, queso madurado y mojo picón",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 83,
            nombre = "Burger, guacamole y bacon ahumado",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 84,
            nombre = "Burger, bacon ahumado y salsa cheddar",
            precio = 2.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 85,
            nombre = "Burger, queso madurado y pepperoni",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 86,
            nombre = "BBQ: bacon ahumado, queso mozzarella, cebolla crujiente y salsa BBQ",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 87,
            nombre = "Pollo: pollo kebab, queso mozzarella, salsa pizza y orégano",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 88,
            nombre = "3 Quesos: queso madurado, queso mozzarella, queso gorgonzola y orégano",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 89,
            nombre = "Pulled Pork: pulled pork BBQ, queso mozzarella, cebolla crujiente y salsa BBQ",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 90,
            nombre = "Pepperoni: pepperoni, queso mozzarella, salsa pizza y orégano",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 91,
            nombre = "Tortilla de patatas, tomate y mayonesa",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 92,
            nombre = "Salmón ahumado y huevo hilado",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 93,
            nombre = "Salmón ahumado y pintxo donostiarra",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 94,
            nombre = "Pintxo donostiarra y atún",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 95,
            nombre = "Pintxo donostiarra y huevo hilado",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 96,
            nombre = "Jamón cocido, queso madurado y mantequilla",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 97,
            nombre = "Jamón cocido, queso madurado, tomate y mayonesa",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 98,
            nombre = "Atún, tomate y mayonesa",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 99,
            nombre = "Atún, huevo hilado y mayonesa",
            precio = 2.00,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        ),
        Montadito(
            id = 100,
            nombre = "Jamón Gran Reserva y mantequilla",
            precio = 1.50,
            preciosEspeciales = listOf(
                PrecioEspecial(DayOfWeek.WEDNESDAY, 1.00),
                PrecioEspecial(DayOfWeek.SUNDAY, 1.00),
            )
        )
    )

    val bebidas = listOf(
        //region CERVEZAS EN JARRA Y PREMIUM
        Bebida(
            id = 2001,
            nombre = "Jarra Quijote de Cruzcampo Especial",
            tamano = "250 ml",
            tipoBebida = TipoBebida.CERVEZA,
            precio = 1.50
        ),
        Bebida(
            id = 2001,
            nombre = "Jarra Quijote de Ladrón de Verano",
            tamano = "250 ml",
            tipoBebida = TipoBebida.TINTO_DE_VERANO,
            precio = 1.50
        ),
        Bebida(
            id = 2003,
            nombre = "Jarra Sancho de Cruzcampo Especial",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CERVEZA,
            precio = 2.50
        ),
        Bebida(
            id = 2004,
            nombre = "Jarra Sancho de Ladrón de Verano",
            tamano = "500 ml",
            tipoBebida = TipoBebida.TINTO_DE_VERANO,
            precio = 2.50
        ),
        Bebida(
            id = 2005,
            nombre = "Jarra Quijote de Cruzcampo Radler",
            tamano = "250 ml",
            tipoBebida = TipoBebida.CERVEZA_PREMIUM,
            precio = 1.50
        ),
        Bebida(
            id = 2006,
            nombre = "Jarra Quijote de Ladrón de Manzana",
            tamano = "250 ml",
            tipoBebida = TipoBebida.CERVEZA_PREMIUM,
            precio = 1.50
        ),
        Bebida(
            id = 2007,
            nombre = "Jarra Quijote de Heineken",
            tamano = "250 ml",
            tipoBebida = TipoBebida.CERVEZA_PREMIUM,
            precio = 1.50
        ),
        Bebida(
            id = 2008,
            nombre = "Jarra Quijote de El Águila Dorada",
            tamano = "250 ml",
            tipoBebida = TipoBebida.CERVEZA_PREMIUM,
            precio = 1.50
        ),
        Bebida(
            id = 2009,
            nombre = "Jarra Sancho de Cruzcampo Radler",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CERVEZA_PREMIUM,
            precio = 2.50
        ),
        Bebida(
            id = 2010,
            nombre = "Jarra Sancho de Ladrón de Manzanas",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CERVEZA_PREMIUM,
            precio = 2.50
        ),
        Bebida(
            id = 2011,
            nombre = "Jarra Sancho de Heineken",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CERVEZA_PREMIUM,
            precio = 2.50
        ),
        Bebida(
            id = 2012,
            nombre = "Jarra Sancho de El Águila Dorada",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CERVEZA_PREMIUM,
            precio = 2.50
        ),
        //endregion

        //region CERVEZAS EN BOTELLA
        Bebida(
            id = 2013,
            nombre = "Cruzcampo sin gluten (tercio)",
            tamano = "250 ml",
            tipoBebida = TipoBebida.CERVEZA_BOTELLA,
            precio = 1.50
        ),
        Bebida(
            id = 2014,
            nombre = "Heineken 0,0 (tercio)",
            tamano = "250 ml",
            tipoBebida = TipoBebida.CERVEZA_BOTELLA,
            precio = 1.50
        ),
        Bebida(
            id = 2015,
            nombre = "Desperados (tercio)",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CERVEZA_BOTELLA,
            precio = 2.50
        ),
        Bebida(
            id = 2016,
            nombre = "Paulaner (media)",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CERVEZA_BOTELLA,
            precio = 2.50
        ),
        //endregion

        //region TARDEO PREMIUM
        Bebida(
            id = 2017,
            nombre = "Ron Havana Club Origen",
            tamano = "250 ml",
            tipoBebida = TipoBebida.TARDEO_PREMIUM,
            precio = 1.50
        ),
        Bebida(
            id = 2018,
            nombre = "Ginebra Beefeater",
            tamano = "250 ml",
            tipoBebida = TipoBebida.TARDEO_PREMIUM,
            precio = 1.50
        ),
        Bebida(
            id = 2019,
            nombre = "Beefeater 0,0",
            tamano = "250 ml",
            tipoBebida = TipoBebida.TARDEO_PREMIUM,
            precio = 1.50
        ),
        Bebida(
            id = 2020,
            nombre = "Whisky Ballantine´s",
            tamano = "250 ml",
            tipoBebida = TipoBebida.TARDEO_PREMIUM,
            precio = 1.50
        ),
        Bebida(
            id = 2021,
            nombre = "Vodka Absolut",
            tamano = "500 ml",
            tipoBebida = TipoBebida.TARDEO_PREMIUM,
            precio = 2.50
        ),
        Bebida(
            id = 2022,
            nombre = "Petroni Spritz",
            tamano = "500 ml",
            tipoBebida = TipoBebida.TARDEO_PREMIUM,
            precio = 2.50
        ),
        Bebida(
            id = 2023,
            nombre = "Crema Ruavieja",
            tamano = "500 ml",
            tipoBebida = TipoBebida.TARDEO_PREMIUM,
            precio = 2.50
        ),
        //endregion

        //region TARDEO CHILL
        Bebida(
            id = 2024,
            nombre = "Absolut & Sprite",
            tamano = "500 ml",
            tipoBebida = TipoBebida.TARDEO_CHILL,
            precio = 2.50
        ),
        Bebida(
            id = 2025,
            nombre = "Bacardi & Coke",
            tamano = "500 ml",
            tipoBebida = TipoBebida.TARDEO_CHILL,
            precio = 2.50
        ),
        Bebida(
            id = 2026,
            nombre = "Jack & Coke",
            tamano = "500 ml",
            tipoBebida = TipoBebida.TARDEO_CHILL,
            precio = 2.50
        ),
        //endregion

        //region CLASICAS
        Bebida(
            id = 2027,
            nombre = "Coca-Cola",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CLASICAS,
            precio = 2.00
        ),
        Bebida(
            id = 2028,
            nombre = "Coca-Cola Zero",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CLASICAS,
            precio = 2.00
        ),
        Bebida(
            id = 2029,
            nombre = "Fanta",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CLASICAS,
            precio = 2.00
        ),
        Bebida(
            id = 2027,
            nombre = "Sprite",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CLASICAS,
            precio = 2.00
        ),
        Bebida(
            id = 2028,
            nombre = "Fuze Tea",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CLASICAS,
            precio = 2.00
        ),
        Bebida(
            id = 2029,
            nombre = "Aquarius",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CLASICAS,
            precio = 2.00
        ),
        Bebida(
            id = 2030,
            nombre = "Appletiser",
            tamano = "500 ml",
            tipoBebida = TipoBebida.CLASICAS,
            precio = 2.00
        ),
        //endregion

        //region ENERGETICAS
        Bebida(
            id = 2031,
            nombre = "Monster Green",
            tamano = "500 ml",
            tipoBebida = TipoBebida.ENERGETICAS,
            precio = 2.00
        ),
        Bebida(
            id = 2032,
            nombre = "Monster Mango Loco",
            tamano = "500 ml",
            tipoBebida = TipoBebida.ENERGETICAS,
            precio = 2.00
        ),
        Bebida(
            id = 2033,
            nombre = "Monster Ultra White",
            tamano = "500 ml",
            tipoBebida = TipoBebida.ENERGETICAS,
            precio = 2.00
        ),
        //endregion

        //region VINO
        Bebida(
            id = 2034,
            nombre = "Buenos Días Ribera de Duero",
            tamano = "10,70 cl",
            tipoBebida = TipoBebida.VINO,
            precio = 2.00
        ),
        Bebida(
            id = 2035,
            nombre = "Cune rosado Navarra",
            tamano = "10,70 cl",
            tipoBebida = TipoBebida.VINO,
            precio = 2.00
        ),
        Bebida(
            id = 2036,
            nombre = "Cune blanco Verdejo",
            tamano = "10,70 cl",
            tipoBebida = TipoBebida.VINO,
            precio = 2.00
        ),
        Bebida(
            id = 2037,
            nombre = "Cune tinto Crianza Rioja",
            tamano = "10,70 cl",
            tipoBebida = TipoBebida.VINO,
            precio = 2.00
        ),
        //endregion

        //region CAFE E INFUSIONES

        Bebida(
            id = 2038,
            nombre = "Café natural",
            tamano = "10,70 cl",
            tipoBebida = TipoBebida.CAFE_INFUSIONES,
            precio = 2.00
        ),
        Bebida(
            id = 2039,
            nombre = "Infusiones",
            tamano = "10,70 cl",
            tipoBebida = TipoBebida.CAFE_INFUSIONES,
            precio = 2.00
        ),
        Bebida(
            id = 2040,
            nombre = "Batidos",
            tamano = "10,70 cl",
            tipoBebida = TipoBebida.CAFE_INFUSIONES,
            precio = 2.00
        ),
        Bebida(
            id = 2041,
            nombre = "Zumo",
            tamano = "10,70 cl",
            tipoBebida = TipoBebida.CAFE_INFUSIONES,
            precio = 2.00
        ),
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
