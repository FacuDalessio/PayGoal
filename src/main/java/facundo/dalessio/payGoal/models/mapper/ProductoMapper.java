package facundo.dalessio.payGoal.models.mapper;

import facundo.dalessio.payGoal.models.entity.ProductoEntity;
import facundo.dalessio.payGoal.models.request.ProductoRequest;
import facundo.dalessio.payGoal.models.response.ProductoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoMapper {

    public ProductoEntity requestToEntity(ProductoRequest request){
        ProductoEntity entity  = new ProductoEntity();

        entity.setNombre(request.getNombre());
        entity.setCantidad(request.getCantidad());
        entity.setDescripcion(request.getDescripcion());
        entity.setPrecio(request.getPrecio());

        return entity;
    }

    public ProductoResponse entityToResponse(ProductoEntity entity){
        ProductoResponse response = new ProductoResponse();

        response.setNombre(entity.getNombre());
        response.setCantidad(entity.getCantidad());
        response.setDescripcion(entity.getDescripcion());
        response.setPrecio(entity.getPrecio());

        return response;
    }

    public ProductoEntity updateEntity(ProductoEntity entity, ProductoRequest request){
        if (request.getNombre() != null && !request.getNombre().isEmpty()){
            entity.setNombre(request.getNombre());
        }

        if (request.getDescripcion() != null && !request.getDescripcion().isEmpty()){
            entity.setDescripcion(request.getDescripcion());
        }

        if (request.getPrecio() != null){
            entity.setPrecio(request.getPrecio());
        }

        if (request.getCantidad() != null){
            entity.setCantidad(request.getCantidad());
        }

        return entity;
    }

    public List<ProductoResponse> entityToListResponse(List<ProductoEntity> entities){
        List<ProductoResponse> responses = new ArrayList<>(entities.size());

        for (ProductoEntity entity: entities) {
            responses.add(entityToResponse(entity));
        }

        return responses;
    }
}
