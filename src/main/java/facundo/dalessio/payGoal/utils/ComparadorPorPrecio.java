package facundo.dalessio.payGoal.utils;

import facundo.dalessio.payGoal.models.entity.ProductoEntity;

import java.util.Comparator;

public class ComparadorPorPrecio implements Comparator<ProductoEntity> {

    /**
     * compara dos productos por precio
     * @param p1 the first object to be compared.
     * @param p2 the second object to be compared.
     * @return si devuelve 0 son iguales, si devuelve -1 el segundo es mayor y si devuelve 1 el primero es mayor
     */
    @Override
    public int compare(ProductoEntity p1, ProductoEntity p2) {
        int retAux = 0;

        if (p1.getPrecio() > p2.getPrecio()){
            return 1;
        }

        if (p1.getPrecio() < p2.getPrecio()){
            return -1;
        }

        return retAux;
    }
}
