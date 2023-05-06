package facundo.dalessio.payGoal.service;

import facundo.dalessio.payGoal.models.request.ProductoRequest;
import facundo.dalessio.payGoal.models.response.ProductoResponse;

import java.util.List;

public interface ProductoService {

    public ProductoResponse save(ProductoRequest request);
    public ProductoResponse update(Long id, ProductoRequest request) throws Exception;
    public List<ProductoResponse> getProductos();
    public ProductoResponse getProductoById(Long id) throws Exception;
    public ProductoResponse getProductoByNombre(String nombre) throws Exception;
    public String deleteProductoById(Long id) throws Exception;
    public List<ProductoResponse> getProductosOrderByPrecio();
}
