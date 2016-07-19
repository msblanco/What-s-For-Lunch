package es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo;

import java.io.Serializable;

/**
 * Created by AliothAntonio on 30/12/2014.
 */
public class RecetaIngrediente implements Serializable {
    private Receta receta;
    private Ingrediente ingrediente;
    private Integer cantidad;
    private Unidad unidad;

    public RecetaIngrediente(Receta receta, Ingrediente ingrediente, Integer cantidad, Unidad unidad) {
        this.receta = receta;
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "RecetaIngrediente{" +
                "receta=" + receta.toString() +
                ", ingrediente=" + ingrediente.toString() +
                ", cantidad=" + cantidad +
                ", unidad=" + unidad.toString() +
                '}';
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
