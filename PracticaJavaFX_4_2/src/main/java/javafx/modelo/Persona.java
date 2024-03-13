/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafx.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
    private StringProperty nombre;
    private StringProperty apellidos;
    private StringProperty apodo;
    private StringProperty curso;

    public Persona(String nombre, String apellidos, String apodo, String curso) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);;
        this.apodo = new SimpleStringProperty(apodo);;
        this.curso = new SimpleStringProperty(curso);;
    }

    public void setNombre(String nombre){
        this.nombre.set(nombre);
    }
   
    public void setApellidos(String apellidos){
        this.apellidos.set(apellidos);
    }    
   
    public void setApodo(String apodo){
        this.apodo.set(apodo);
    }    
    
    public void setGrupo(String curso){
        this.curso.set(curso);
    }

    // Métodos getter de las propiedades para permitir el enlace de datos en JavaFX

    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty apellidosProperty() {
        return apellidos;
    }

    public StringProperty apodoProperty() {
        return apodo;
    }

    public StringProperty cursosProperty() {
        return curso;
    }

    
    public String getNombre(){
        return nombre.get();
    }
    
    public String getApellidos(){
        return apellidos.get();
    }
    
    public String getApodo (){
        return apodo.get();
    }
    
    public String getCurso(){
        return curso.get();
    }
    
}
