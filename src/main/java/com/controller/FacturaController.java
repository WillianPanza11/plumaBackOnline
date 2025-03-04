package com.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Factura;
import com.repository.FacturaRepository;
import com.services.FacturaPdfService;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private final FacturaRepository facturaRepository;
    private final FacturaPdfService facturaPdfService;

    public FacturaController(FacturaRepository facturaRepository, FacturaPdfService facturaPdfService) {
        this.facturaRepository = facturaRepository;
        this.facturaPdfService = facturaPdfService;
    }

    /*
    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> descargarFacturaPdf(@PathVariable Long id) {
        Factura factura = facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        try {
            byte[] pdf = facturaPdfService.generarFacturaPdf(factura);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=factura-" + factura.getNumeroFactura() + ".pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdf);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
         */
}
