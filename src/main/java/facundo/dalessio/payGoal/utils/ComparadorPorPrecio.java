package facundo.dalessio.payGoal.utils;

import facundo.dalessio.payGoal.models.entity.ProductoEntity;

import java.util.Comparator;

public class ComparadorPorPrecio implements Comparator<ProductoEntity> {

    @Override
    public int compare(ProductoEntity p1, ProductoEntity p2) {
        int retAux = 0;

        if (p1.getPrecio() - p2.getPrecio() > 0){
            return 1;
        }

        if (p1.getPrecio() - p2.getPrecio() < 0){
            return -1;
        }

        return retAux;
    }
}
