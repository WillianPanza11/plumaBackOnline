package com.security.enums;

public enum EstadoCarrito {
    ACTIVO,      // Usuario puede agregar o eliminar productos
    PENDIENTE,   // Usuario está en proceso de compra (checkout)
    COMPLETADO,  // Compra finalizada y pagada
    CANCELADO,   // Pedido cancelado
    ABANDONADO   // Carrito sin actividad por un tiempo determinados
}
