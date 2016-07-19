package es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by AliothAntonio on 30/12/2014.
 */
public class Ingrediente implements Serializable {
    private Integer idIgrediente;
    private String nombreIngrediente;
    private Integer fotoIngrediente;

    public Ingrediente(Integer idIgrediente, String nombreIngrediente, Integer fotoIngrediente) {
        this.idIgrediente = idIgrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.fotoIngrediente = fotoIngrediente;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "idIgrediente=" + idIgrediente +
                ", nombreIngrediente='" + nombreIngrediente + '\'' +
                ", fotoIngrediente=" + fotoIngrediente +
                '}';
    }

    public Integer getIdIgrediente() {
        return idIgrediente;
    }

    public void setIdIgrediente(Integer idIgrediente) {
        this.idIgrediente = idIgrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public Integer getFotoIngrediente() {
        return fotoIngrediente;
    }

    public void setFotoIngrediente(Integer fotoIngrediente) {
        this.fotoIngrediente = fotoIngrediente;
    }
}
