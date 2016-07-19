package es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo;

import java.io.Serializable;

/**
 * Created by AliothAntonio on 30/12/2014.
 */
public class Receta implements Serializable {
    private Integer idReceta;
    private String descripcionReceta;

    public Receta(Integer idReceta, String descripcionReceta) {
        this.idReceta = idReceta;
        this.descripcionReceta = descripcionReceta;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "idReceta=" + idReceta +
                ", descripcionReceta='" + descripcionReceta + '\'' +
                '}';
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getDescripcionReceta() {
        return descripcionReceta;
    }

    public void setDescripcionReceta(String descripcionReceta) {
        this.descripcionReceta = descripcionReceta;
    }
}
