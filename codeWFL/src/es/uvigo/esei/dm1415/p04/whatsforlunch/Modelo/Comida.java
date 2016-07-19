package es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by AliothAntonio on 30/12/2014.
 */
public class Comida implements Serializable{
    private Integer idComida;
    private String nombre;
    private Integer foto;
    private Receta receta;
    private TipoComida tipoComida;

    public Comida(Integer idComida, String nombre, Integer foto, Receta receta, TipoComida tipoComida) {
        this.idComida = idComida;
        this.nombre = nombre;
        this.foto = foto;
        this.receta = receta;
        this.tipoComida = tipoComida;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "idComida=" + idComida +
                ", nombre='" + nombre + '\'' +
                ", foto=" + foto +
                ", receta=" + receta.toString() +
                ", tipoComida=" + tipoComida.toString() +
                '}';
    }

    public Integer getIdComida() {
        return idComida;
    }

    public void setIdComida(Integer idComida) {
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public TipoComida getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }
}
