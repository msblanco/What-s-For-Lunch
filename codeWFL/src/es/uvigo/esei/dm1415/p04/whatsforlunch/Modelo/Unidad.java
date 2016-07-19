package es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo;

import java.io.Serializable;

/**
 * Created by AliothAntonio on 30/12/2014.
 */
public class Unidad implements Serializable {
    private Integer idUnidad;
    private String nombreunidad;

    public Unidad(Integer idUnidad, String nombreunidad) {
        this.idUnidad = idUnidad;
        this.nombreunidad = nombreunidad;
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "idUnidad=" + idUnidad +
                ", nombreunidad='" + nombreunidad + '\'' +
                '}';
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombreunidad() {
        return nombreunidad;
    }

    public void setNombreunidad(String nombreunidad) {
        this.nombreunidad = nombreunidad;
    }
}
