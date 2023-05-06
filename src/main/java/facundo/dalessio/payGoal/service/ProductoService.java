package facundo.dalessio.payGoal.service;

import facundo.dalessio.payGoal.models.request.ProductoRequest;
import facundo.dalessio.payGoal.models.response.ProductoResponse;

import java.util.List;

public interface ProductoService {

    /**
     * Metodo que recive una request con los datos del producto, lo convierte a una entidad, lo guardo y por ultimo lo convierte en una response para retornar
     * @param request request con los datos del producto a guardar
     * @return retorna una response del producto guardado
     */
    public ProductoResponse save(ProductoRequest request);

    /**
     * se busca un producto y se actualiza
     * @param id id por el cual se busca al producto a actualizar
     * @param request variable donde estan los datos para actualizar el producto
     * @return retorna una response con los datos del producto
     * @throws Exception tira una excepcion si no encuentra un producto con el id pasado
     */
    public ProductoResponse update(Long id, ProductoRequest request) throws Exception;

    /**
     * busca y retorna una lista con todos los productos
     * @return una lista con todos los productos
     */
    public List<ProductoResponse> getProductos();

    /**
     * busca y retorna un producto con el id pasado
     * @param id id por el cual se va a buscar el producto
     * @return retorna un response con los datos del producto encontrado
     * @throws Exception tira una excepcion si no encuentra un producto con el id pasado
     */
    public ProductoResponse getProductoById(Long id) throws Exception;

    /**
     * busca y retorna un producto con el nombre pasado
     * @param nombre nombre por el cual se va a buscar el producto
     * @return retorna un response con los datos del producto encontrado
     * @throws Exception tira una excepcion si no encuentra un producto con el nombre pasado
     */
    public ProductoResponse getProductoByNombre(String nombre) throws Exception;

    /**
     * busca y borra un producto por el id pasado
     * @param id id por el cual se va a buscar y borrar el producto
     * @return retorna una cadena dicienco que se pudo borrar correctamente
     * @throws Exception tira una excepcion si no encuentra un producto con el id pasado
     */
    public String deleteProductoById(Long id) throws Exception;

    /**
     * busca y retorna una lista con todos los productos ordenados por precio
     * @return una lista con todos los productos ordenados por precio
     */
    public List<ProductoResponse> getProductosOrderByPrecio();
}
