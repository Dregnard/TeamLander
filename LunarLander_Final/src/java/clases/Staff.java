package clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miquel
 */
public class Staff {

    
    private String nombre;
    private String dificultad;
    private String modeloLuna;
    private String modeloNave;

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public void setModeloLuna(String modeloLuna) {
        this.modeloLuna = modeloLuna;
    }

    public void setModeloNave(String modeloNave) {
        this.modeloNave = modeloNave;
    }

    public String getDificultad() {
        return dificultad;
    }

    public String getModeloLuna() {
        return modeloLuna;
    }

    public String getModeloNave() {
        return modeloNave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Staff() {
    }

    @Override
    public String toString() {
        return dificultad + " - " + modeloLuna + " - " + modeloNave;
    }

}
