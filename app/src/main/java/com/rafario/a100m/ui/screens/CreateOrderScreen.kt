package com.rafario.a100m.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.rafario.a100m.data.datasource.CatalogoDataSource
import com.rafario.a100m.data.models.Bebida
import com.rafario.a100m.data.models.LineaPedido
import com.rafario.a100m.data.models.Pedido
import com.rafario.a100m.data.models.TipoProducto
import java.time.LocalDate
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateOrderScreen(
    pedidoToEdit: Pedido? = null,
    onBackClick: () -> Unit,
    onOrderSaved: (String, List<LineaPedido>) -> Unit
) {
    val today = LocalDate.now().dayOfWeek
    val cartLines = remember(pedidoToEdit?.id) {
        mutableStateMapOf<Int, LineaPedido>().apply {
            pedidoToEdit?.lineas?.forEach { linea ->
                put(linea.productoId, linea)
            }
        }
    }
    var orderName by rememberSaveable(pedidoToEdit?.id) {
        mutableStateOf(pedidoToEdit?.nombre.orEmpty())
    }
    var showConfirmationDialog by rememberSaveable { mutableStateOf(false) }
    var montaditosExpanded by rememberSaveable { mutableStateOf(false) }
    var bebidasExpanded by rememberSaveable { mutableStateOf(false) }
    var racionesExpanded by rememberSaveable { mutableStateOf(false) }
    var aperitivosExpanded by rememberSaveable { mutableStateOf(false) }
    var ensaladasExpanded by rememberSaveable { mutableStateOf(false) }
    var montyAhorrosExpanded by rememberSaveable { mutableStateOf(false) }
    val bebidasByType = remember {
        CatalogoDataSource.bebidas
            .groupBy { it.tipoBebida }
            .toList()
    }
    val cartTotal = cartLines.values.sumOf { it.subtotal }
    val cartProductCount = cartLines.values.sumOf { it.cantidad }
    val trimmedOrderName = orderName.trim()
    val canCreateOrder = trimmedOrderName.isNotEmpty() && cartLines.isNotEmpty()

    fun addProductToCart(
        id: Int,
        name: String,
        price: Double,
        tipoProducto: TipoProducto = TipoProducto.OTRO,
        observaciones: String? = null
    ) {
        val currentLine = cartLines[id]
        cartLines[id] = currentLine?.copy(cantidad = currentLine.cantidad + 1)
            ?: LineaPedido(
                productoId = id,
                nombre = name,
                precioUnitario = price,
                cantidad = 1,
                tipoProducto = tipoProducto,
                observaciones = observaciones
            )
    }

    fun removeProductFromCart(id: Int) {
        val currentLine = cartLines[id] ?: return
        if (currentLine.cantidad <= 1) {
            cartLines.remove(id)
        } else {
            cartLines[id] = currentLine.copy(cantidad = currentLine.cantidad - 1)
        }
    }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(text = if (pedidoToEdit == null) "Nuevo pedido" else "Editar pedido")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            Icons.Default.ArrowBackIosNew,
                            contentDescription = "Volver"
                        )
                    }
                },
                actions = {
                    IconButton(
                        enabled = canCreateOrder,
                        onClick = {
                            showConfirmationDialog = true
                        }
                    ) {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = if (pedidoToEdit == null) {
                                "Crear pedido"
                            } else {
                                "Guardar cambios"
                            }
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        if (showConfirmationDialog) {
            ConfirmOrderDialog(
                orderName = trimmedOrderName,
                lines = cartLines.values.toList(),
                total = cartTotal,
                onDismiss = {
                    showConfirmationDialog = false
                },
                onConfirm = {
                    showConfirmationDialog = false
                    onOrderSaved(trimmedOrderName, cartLines.values.toList())
                }
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            item(key = "header") {
                Text(
                    text = "Elige productos",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "Pulsa en un producto para añadirlo. Puedes repetir tantas veces como quieras.",
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            item(key = "order_name") {
                OutlinedTextField(
                    value = orderName,
                    onValueChange = { orderName = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    shape = MaterialTheme.shapes.large,
                    label = {
                        Text(text = "Nombre del pedido")
                    },
                    singleLine = true,
                    supportingText = {
                        Text(text = "Obligatorio para crear el pedido")
                    },
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
                )
            }

            if (cartLines.isNotEmpty()) {
                item(key = "cart_summary") {
                    CartSummary(
                        productCount = cartProductCount,
                        total = cartTotal
                    )
                }
            }

            item(key = "section_montaditos") {
                ProductSectionHeader(
                    title = "Montaditos",
                    expanded = montaditosExpanded,
                    onToggle = { montaditosExpanded = !montaditosExpanded }
                )
            }

            if (montaditosExpanded) {
                itemsIndexed(
                    items = CatalogoDataSource.montaditos,
                    key = { _, montadito -> "montadito_${montadito.id}" }
                ) { index, montadito ->
                    val price = montadito.precioPara(today)
                    ProductRow(
                        quantity = cartLines[montadito.id]?.cantidad ?: 0,
                        name = "${formatMontaditoId(montadito.id)}. ${montadito.nombre}",
                        currentPrice = price,
                        onClick = {
                            addProductToCart(
                                id = montadito.id,
                                name = montadito.nombre,
                                price = price,
                                tipoProducto = TipoProducto.MONTADITO
                            )
                        },
                        onRemoveClick = {
                            removeProductFromCart(montadito.id)
                        }
                    )
                    SectionDivider(index, CatalogoDataSource.montaditos.lastIndex)
                }
            }

            item(key = "section_bebidas") {
                ProductSectionHeader(
                    title = "Bebidas",
                    expanded = bebidasExpanded,
                    onToggle = { bebidasExpanded = !bebidasExpanded }
                )
            }

            if (bebidasExpanded) {
                bebidasByType.forEach { (tipoBebida, bebidas) ->
                    item(key = "bebida_group_${tipoBebida.name}") {
                        ProductGroupHeader(title = tipoBebida.tipo)
                    }

                    itemsIndexed(
                        items = bebidas,
                        key = { _, bebida -> "bebida_${bebida.id}" }
                    ) { index, bebida ->
                        val price = bebida.precioPara(today)
                        val bebidaName = bebida.nombreConTamano()
                        ProductRow(
                            quantity = cartLines[bebida.id]?.cantidad ?: 0,
                            name = bebidaName,
                            currentPrice = price,
                            onClick = {
                                addProductToCart(
                                    id = bebida.id,
                                    name = bebidaName,
                                    price = price
                                )
                            },
                            onRemoveClick = {
                                removeProductFromCart(bebida.id)
                            }
                        )
                        SectionDivider(index, bebidas.lastIndex)
                    }
                }
            }

            item(key = "section_raciones") {
                ProductSectionHeader(
                    title = "Raciones",
                    expanded = racionesExpanded,
                    onToggle = { racionesExpanded = !racionesExpanded }
                )
            }

            if (racionesExpanded) {
                itemsIndexed(
                    items = CatalogoDataSource.raciones,
                    key = { _, racion -> "racion_${racion.id}" }
                ) { index, racion ->
                    val price = racion.precioPara(today)
                    ProductRow(
                        quantity = cartLines[racion.id]?.cantidad ?: 0,
                        name = racion.nombre,
                        currentPrice = price,
                        onClick = {
                            addProductToCart(
                                id = racion.id,
                                name = racion.nombre,
                                price = price
                            )
                        },
                        onRemoveClick = {
                            removeProductFromCart(racion.id)
                        }
                    )
                    SectionDivider(index, CatalogoDataSource.raciones.lastIndex)
                }
            }

            item(key = "section_aperitivos") {
                ProductSectionHeader(
                    title = "Aperitivos",
                    expanded = aperitivosExpanded,
                    onToggle = { aperitivosExpanded = !aperitivosExpanded }
                )
            }

            if (aperitivosExpanded) {
                itemsIndexed(
                    items = CatalogoDataSource.aperitivos,
                    key = { _, aperitivo -> "aperitivo_${aperitivo.id}" }
                ) { index, aperitivo ->
                    val price = aperitivo.precioPara(today)
                    ProductRow(
                        quantity = cartLines[aperitivo.id]?.cantidad ?: 0,
                        name = aperitivo.nombre,
                        supportingText = aperitivo.descripcion,
                        currentPrice = price,
                        onClick = {
                            addProductToCart(
                                id = aperitivo.id,
                                name = aperitivo.nombre,
                                price = price,
                                observaciones = aperitivo.descripcion
                            )
                        },
                        onRemoveClick = {
                            removeProductFromCart(aperitivo.id)
                        }
                    )
                    SectionDivider(index, CatalogoDataSource.aperitivos.lastIndex)
                }
            }

            item(key = "section_ensaladas") {
                ProductSectionHeader(
                    title = "Ensaladas",
                    expanded = ensaladasExpanded,
                    onToggle = { ensaladasExpanded = !ensaladasExpanded }
                )
            }

            if (ensaladasExpanded) {
                itemsIndexed(
                    items = CatalogoDataSource.ensaladas,
                    key = { _, ensalada -> "ensalada_${ensalada.id}" }
                ) { index, ensalada ->
                    val price = ensalada.precioPara(today)
                    ProductRow(
                        quantity = cartLines[ensalada.id]?.cantidad ?: 0,
                        name = ensalada.nombre,
                        supportingText = ensalada.ingredientes,
                        currentPrice = price,
                        onClick = {
                            addProductToCart(
                                id = ensalada.id,
                                name = ensalada.nombre,
                                price = price
                            )
                        },
                        onRemoveClick = {
                            removeProductFromCart(ensalada.id)
                        }
                    )
                    SectionDivider(index, CatalogoDataSource.ensaladas.lastIndex)
                }
            }

            item(key = "section_monty_ahorros") {
                ProductSectionHeader(
                    title = "Monty ahorros",
                    expanded = montyAhorrosExpanded,
                    onToggle = { montyAhorrosExpanded = !montyAhorrosExpanded }
                )
            }

            if (montyAhorrosExpanded) {
                itemsIndexed(
                    items = CatalogoDataSource.montyAhorros,
                    key = { _, montyAhorro -> "monty_ahorro_${montyAhorro.id}" }
                ) { index, montyAhorro ->
                    val price = montyAhorro.precioPara(today)
                    ProductRow(
                        quantity = cartLines[montyAhorro.id]?.cantidad ?: 0,
                        name = montyAhorro.nombre,
                        supportingItems = montyAhorro.montaditos.map {
                            "${formatMontaditoId(it.id)}. ${it.nombre}"
                        },
                        currentPrice = price,
                        onClick = {
                            addProductToCart(
                                id = montyAhorro.id,
                                name = montyAhorro.nombre,
                                price = price
                            )
                        },
                        onRemoveClick = {
                            removeProductFromCart(montyAhorro.id)
                        }
                    )
                    SectionDivider(index, CatalogoDataSource.montyAhorros.lastIndex)
                }
            }
        }
    }
}

@Composable
private fun ConfirmOrderDialog(
    orderName: String,
    lines: List<LineaPedido>,
    total: Double,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Confirmar pedido")
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = orderName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                lines.forEach { line ->
                    Text(
                        text = line.toSummaryText(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Text(
                    text = "Total: ${formatPrice(total)}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text(text = "Aceptar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Cancelar")
            }
        }
    )
}

@Composable
private fun CartSummary(
    productCount: Int,
    total: Double
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Carrito",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "$productCount productos añadidos",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Text(
                text = formatPrice(total),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
private fun ProductSectionHeader(
    title: String,
    expanded: Boolean,
    onToggle: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.55f),
                shape = MaterialTheme.shapes.medium
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onToggle)
                .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = if (expanded) "Contraer $title" else "Desplegar $title",
                modifier = Modifier.size(28.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun ProductRow(
    quantity: Int,
    name: String,
    supportingText: String? = null,
    supportingItems: List<String> = emptyList(),
    currentPrice: Double,
    onClick: () -> Unit,
    onRemoveClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.Top
    ) {
        if (quantity > 0) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = "x$quantity",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
                if (onRemoveClick != null) {
                    IconButton(
                        modifier = Modifier.size(28.dp),
                        onClick = onRemoveClick
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "Quitar una unidad",
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            if (!supportingText.isNullOrBlank()) {
                Text(
                    text = supportingText,
                    modifier = Modifier.padding(top = 2.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            if (supportingItems.isNotEmpty()) {
                Column(
                    modifier = Modifier.padding(top = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    supportingItems.forEach { item ->
                        Text(
                            text = "• $item",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        Column {
            Text(
                text = formatPrice(currentPrice),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun ProductGroupHeader(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp),
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
private fun SectionDivider(
    index: Int,
    lastIndex: Int
) {
    if (index < lastIndex) {
        HorizontalDivider(
            color = DividerDefaults.color.copy(alpha = 0.35f)
        )
    }
}

private fun formatPrice(price: Double): String {
    return String.format(Locale.forLanguageTag("es-ES"), "%.2f €", price)
}

private fun Bebida.nombreConTamano(): String {
    return tamano?.takeIf { it.isNotBlank() }?.let { "$nombre ($it)" } ?: nombre
}

private fun formatMontaditoId(id: Int): String {
    val normalizedId = if (id in 1001..1100) id - 1000 else id
    return "%03d".format(normalizedId)
}

private fun LineaPedido.toSummaryText(): String {
    val productName = if (tipoProducto == TipoProducto.MONTADITO) {
        "${formatMontaditoId(productoId)}. $nombre"
    } else {
        nombre
    }
    return "${cantidad}x $productName - ${formatPrice(subtotal)}"
}
