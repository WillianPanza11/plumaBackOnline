package com.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.DetalleFactura;
import com.model.Factura;

@Service
public class FacturaPdfService {
	/*
    public byte[] generarFacturaPdf(Factura factura) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        // Simulación de logo en la parte superior derecha
        document.add(new Paragraph("LOGO EMPRESA")
                .setBold()
                .setFontSize(14)
                .setTextAlignment(TextAlignment.RIGHT));

        document.add(new Paragraph("FACTURA COMERCIAL")
                .setFontSize(20)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER));

        // Datos generales de la factura
        document.add(new Paragraph("Número de Factura: " + factura.getNumeroFactura()));
        document.add(new Paragraph("Fecha de Emisión: " +
                factura.getFechaEmision().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))));
        document.add(new Paragraph("Cliente: " + factura.getPedido().getUsuario().getNombre()));
        document.add(new Paragraph("Dirección: " + factura.getPedido().getUsuario().getDireccion()));
        //document.add(new Paragraph("Método de Pago: " + factura.getPedido().getMetodoPago().getNombre()));

        document.add(new Paragraph("\n")); // Espacio

        // Tabla de productos
        Table table = new Table(4);
        table.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        table.addHeaderCell("Producto");
        table.addHeaderCell("Cantidad");
        table.addHeaderCell("Precio Unitario");
        table.addHeaderCell("Total");

        List<DetalleFactura> detalles = factura.getDetalles();
        for (DetalleFactura detalle : detalles) {
            table.addCell(detalle.getProducto().getNombreProducto());
            table.addCell(String.valueOf(detalle.getCantidad()));
            table.addCell("$" + detalle.getPrecioUnitario());
            table.addCell("$" + detalle.getTotal());
        }

        document.add(table);
        document.add(new Paragraph("\n")); // Espacio antes de los totales

        // Totales
        document.add(new Paragraph("Subtotal: $" + factura.getSubtotal()).setBold());
        document.add(new Paragraph("Impuesto (12%): $" + factura.getImpuesto()).setBold());
        document.add(new Paragraph("Total: $" + factura.getTotal()).setBold());

        document.close();
        return outputStream.toByteArray();
        
    }*/

}
