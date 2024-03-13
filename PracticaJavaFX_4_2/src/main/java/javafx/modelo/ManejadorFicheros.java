/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafx.modelo;

import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// clase auxiliar para el manejo de ficheros
public class ManejadorFicheros {
    
    private File fichero;
    private BufferedWriter writer ;

    public ManejadorFicheros() {
       
    }
    
    public boolean existe_fichero(File fichero) {
       this.fichero = fichero;
       if (fichero.exists()) return true;
       return false;
    }


    public void escribir_fichero(File ficheroseleccionado, ObservableList<String> personas) throws IOException {

        if (ficheroseleccionado != null) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroseleccionado));
            for (String persona : personas) {
                writer.write(persona);
                writer.newLine(); // Agregar nueva línea después de cada elemento
            }
        }
    }


}
    
