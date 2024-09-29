package ucv.app_inventory.proveedores.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucv.app_inventory.proveedores.application.ProveedorService;
import ucv.app_inventory.proveedores.domain.Proveedor;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<Proveedor> agregarProveedor(@RequestBody Proveedor proveedor) {
        Proveedor nuevoProveedor = proveedorService.agregarProveedor(proveedor);
        return ResponseEntity.ok(nuevoProveedor);
    }
}
