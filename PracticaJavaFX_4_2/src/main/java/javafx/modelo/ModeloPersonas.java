/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafx.modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModeloPersonas {
    private ObservableList<Persona> personas;
    private boolean check1;
    private boolean check2;
    
    
    public ModeloPersonas() {
        this.personas = FXCollections.observableArrayList();
        Persona Javier = new Persona("Javier", "Traseira", "Traveseira", "DAM");
        Persona Ivan = new Persona("Ivan", "Lim", "Fast Lim", "DAM");
        Persona Ruben = new Persona("Ruben", "Bautista", "Rubentura", "DAM");       
        Persona Jesus = new Persona("Jesus", "Belmonte", "Belmonter", "DAM");       
        Persona Patricia = new Persona("Patricia", "Conde", "PatriCon", "DAM");  
        personas.add(Javier);
        personas.add(Ivan);
        personas.add(Ruben);
        personas.add(Jesus);  
        personas.add(Patricia);        
    }


    public ObservableList<Persona> getListadoPersonas() {
        return personas;
    }

    public void borrarPersona(Persona persona_borrar) {
        personas.remove(persona_borrar);
    }

    public boolean getCheck1() {
        return check1;
    }

    public boolean getCheck2() {
        return check2;
    }


    public void setCheck1(boolean check1) {
        this.check1 = check1;
    }

    public void setCheck2(boolean check2) {
        this.check2 = check2;
    }
    
    
    
    
    
}
