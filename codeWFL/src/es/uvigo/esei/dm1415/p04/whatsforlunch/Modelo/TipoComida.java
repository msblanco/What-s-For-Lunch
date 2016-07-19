package es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo;

import java.io.Serializable;

/**
 * Created by AliothAntonio on 30/12/2014.
 */
public class TipoComida implements Serializable {
    private Integer idTipoComida;
    private String nombreTipoComida;

    @Override
    public String toString() {
        return "TipoComida{" +
                "idTipoComida=" + idTipoComida +
                ", nombreTipoComida='" + nombreTipoComida + '\'' +
                '}';
    }

    public Integer getIdTipoComida() {
        return idTipoComida;
    }

    public void setIdTipoComida(Integer idTipoComida) {
        this.idTipoComida = idTipoComida;
    }

    public String getNombreTipoComida() {
        return nombreTipoComida;
    }

    public void setNombreTipoComida(String nombreTipoComida) {
        this.nombreTipoComida = nombreTipoComida;
    }

    public TipoComida(Integer idTipoComida, String nombreTipoComida) {

        this.idTipoComida = idTipoComida;
        this.nombreTipoComida = nombreTipoComida;
    }
}
