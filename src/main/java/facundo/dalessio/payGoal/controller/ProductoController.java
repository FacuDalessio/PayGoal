package facundo.dalessio.payGoal.controller;

import facundo.dalessio.payGoal.models.request.ProductoRequest;
import facundo.dalessio.payGoal.models.response.ProductoResponse;
import facundo.dalessio.payGoal.service.ProductoService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoResponse> save(@RequestBody @Valid ProductoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id")@Valid @NonNull Long id, @Valid @RequestBody ProductoRequest request){
        ProductoResponse response;
        try {
            response = productoService.update(id, request);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping()
    public ResponseEntity<List<ProductoResponse>> getProductos(){
        return ResponseEntity.ok(productoService.getProductos());
    }
    @GetMapping("/ordenados")
    public ResponseEntity<List<ProductoResponse>> getProductosOrdenados(){
        return ResponseEntity.ok(productoService.getProductosOrderByPrecio());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductoById(@PathVariable("id")@Valid @NonNull Long id){
        try {
            return ResponseEntity.ok(productoService.getProductoById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Object> getProductoByNombre(@PathVariable("nombre")@Valid @NonNull String nombre){
        try {
            return ResponseEntity.ok(productoService.getProductoByNombre(nombre));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteProductoById(@PathVariable("id")@Valid @NonNull Long id){
        try {
            return ResponseEntity.ok(productoService.deleteProductoById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
