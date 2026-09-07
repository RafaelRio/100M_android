package com.rafario.a100m.ui.screens

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.res.stringResource
import com.rafario.a100m.R
import com.rafario.a100m.ui.formatting.formatMontaditoId
import com.rafario.a100m.ui.formatting.formatPrice
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rafario.a100m.data.datasource.CatalogoDataSource
import com.rafario.a100m.data.models.LineaPedido
import com.rafario.a100m.data.models.Pedido
import com.rafario.a100m.data.models.TipoProducto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    pedidos: List<Pedido>,
    onDeleteOrderClick: (Int) -> Unit,
    onEditOrderClick: (Int) -> Unit,
    onCreateOrderClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.my_orders))
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onCreateOrderClick
            ) {
                Icon(Icons.Default.Add, contentDescription = stringResource(R.string.create_order))
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 88.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (pedidos.isEmpty()) {
                item {
                    EmptyOrdersContent()
                }
            } else {
                items(
                    count = pedidos.size,
                    key = { index -> pedidos[index].id }
                ) { index ->
                    OrderCard(
                        pedido = pedidos[index],
                        onEditClick = {
                            onEditOrderClick(pedidos[index].id)
                        },
                        onDeleteClick = {
                            onDeleteOrderClick(pedidos[index].id)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun OrderCard(
    pedido: Pedido,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    val context = LocalContext.current
    var showDeleteDialog by rememberSaveable { mutableStateOf(false) }

    if (showDeleteDialog) {
        DeleteOrderDialog(
            pedido = pedido,
            onDismiss = {
                showDeleteDialog = false
            },
            onConfirm = {
                showDeleteDialog = false
                onDeleteClick()
            }
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
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
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = pedido.nombre.takeIf { it.isNotBlank() } ?: stringResource(R.string.unnamed_order),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(R.string.order_number, pedido.id),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = formatPrice(pedido.total),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            pedido.lineas.forEach { linea ->
                OrderLine(linea = linea)
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                onClick = {
                    sharePedidoByWhatsApp(context, pedido)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Whatsapp,
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.share_whatsapp),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onEditClick
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.edit_order),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    showDeleteDialog = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.delete_order),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun DeleteOrderDialog(
    pedido: Pedido,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = stringResource(R.string.delete_order))
        },
        text = {
            Text(
                text = stringResource(R.string.delete_order_confirmation, pedido.nombre)
            )
        },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text(text = stringResource(R.string.delete))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = stringResource(R.string.cancel))
            }
        }
    )
}

@Composable
private fun OrderLine(
    linea: LineaPedido
) {
    if (linea.tipoProducto == TipoProducto.MONTADITO) {
        MontaditoOrderLine(linea = linea)
    } else {
        Column {
            Text(
                text = stringResource(R.string.product_quantity_name, linea.cantidad, linea.nombre),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            linea.descripcionAperitivo()?.let { descripcion ->
                Text(
                    text = descripcion,
                    modifier = Modifier.padding(start = 16.dp, top = 2.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun MontaditoOrderLine(
    linea: LineaPedido
) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.product_quantity, linea.cantidad),
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = stringResource(R.string.numbered_product, formatMontaditoId(linea.productoId), linea.nombre),
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

}

@Composable
private fun EmptyOrdersContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 96.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.empty_orders),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(R.string.empty_orders_hint),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

private fun sharePedidoByWhatsApp(
    context: Context,
    pedido: Pedido
) {
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, pedido.toShareText(context))
        setPackage("com.whatsapp")
    }

    try {
        context.startActivity(shareIntent)
    } catch (_: ActivityNotFoundException) {
        val fallbackIntent = Intent.createChooser(
            Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, pedido.toShareText(context))
            },
            context.getString(R.string.share_order)
        )
        context.startActivity(fallbackIntent)
    }
}

internal fun Pedido.toShareText(context: Context): String {
    return buildString {
        appendLine(context.getString(R.string.order_number, id))
        if (nombre.isNotBlank()) {
            appendLine(nombre)
        }
        appendLine()

        val montaditoIds = lineas
            .filter { it.tipoProducto == TipoProducto.MONTADITO }
            .flatMap { line ->
                List(line.cantidad) { formatMontaditoId(line.productoId) }
            }

        if (montaditoIds.isNotEmpty()) {
            appendLine(context.getString(R.string.share_montaditos, montaditoIds.joinToString(", ")))
        }

        lineas
            .filterNot { it.tipoProducto == TipoProducto.MONTADITO }
            .forEach { linea ->
                appendLine(context.getString(R.string.product_quantity_name, linea.cantidad, linea.nombre))
                linea.descripcionAperitivo()?.let { descripcion ->
                    appendLine("  $descripcion")
                }
            }

        appendLine()
        append(context.getString(R.string.order_total, formatPrice(total)))
    }
}

private fun LineaPedido.descripcionAperitivo(): String? {
    return observaciones
        ?: CatalogoDataSource.aperitivos.firstOrNull { it.id == productoId }?.descripcion
}
