package facundo.dalessio.payGoal.service.impl;

import facundo.dalessio.payGoal.models.entity.ProductoEntity;
import facundo.dalessio.payGoal.models.mapper.ProductoMapper;
import facundo.dalessio.payGoal.models.request.ProductoRequest;
import facundo.dalessio.payGoal.models.response.ProductoResponse;
import facundo.dalessio.payGoal.repository.ProductoRepository;
import facundo.dalessio.payGoal.service.ProductoService;
import facundo.dalessio.payGoal.utils.ComparadorPorPrecio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoMapper productoMapper;
    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    @Override
    public ProductoResponse save(ProductoRequest request) {

    }

    @Transactional
    @Override
    public ProductoResponse update(Long id, ProductoRequest request) throws Exception {
        ProductoEntity entity = productoRepository.findById(id).orElse(null);

        if (entity == null){
            throw new Exception("No se encontro un producto con ese id");
        }
        entity = productoMapper.updateEntity(entity, request);
        productoRepository.save(entity);

        return productoMapper.entityToResponse(entity);
    }

    @Override
    public List<ProductoResponse> getProductos() {
        return productoMapper.entityToListResponse(productoRepository.findAll());
    }

    @Override
    public ProductoResponse getProductoById(Long id) throws Exception{
        ProductoEntity entity = productoRepository.findById(id).orElse(null);

        if (entity == null){
            throw new Exception("No se encontro un producto con ese id");
        }

        return productoMapper.entityToResponse(entity);
    }

    @Override
    public ProductoResponse getProductoByNombre(String nombre) throws Exception {
        ProductoEntity entity = productoRepository.findByNombre(nombre).orElse(null);

        if (entity == null){
            throw new Exception("No se encontro un producto con ese nombre");
        }

        return productoMapper.entityToResponse(entity);
    }

    @Override
    public String deleteProductoById(Long id) throws Exception {
        ProductoEntity entity = productoRepository.findById(id).orElse(null);

        if (entity == null){
            throw new Exception("No se encontro un producto con ese id");
        }
        productoRepository.delete(entity);

        return "Se borro correctamente";
    }

    @Override
    public List<ProductoResponse> getProductosOrderByPrecio() {
        List<ProductoEntity> entities =  productoRepository.findAll();
        Collections.sort(entities, new ComparadorPorPrecio());
        List<ProductoResponse> responses = productoMapper.entityToListResponse(entities);
        return responses;
    }
}
