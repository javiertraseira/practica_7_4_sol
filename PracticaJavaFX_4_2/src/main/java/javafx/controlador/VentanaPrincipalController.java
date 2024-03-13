/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafx.controlador;

import javafx.application.Platform;
import javafx.modelo.ModeloPersonas;
import javafx.modelo.Persona;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class VentanaPrincipalController implements Initializable {

    @FXML
    private TableView<Persona> Vistaelementos;
    @FXML
    private Button b_nuevo;
    @FXML
    private CheckBox check_item1;
    @FXML
    private CheckBox check_item2;
    private ModeloPersonas modelopersonas;
    @FXML
    private TableColumn<Persona, String> c_nombre;
    @FXML
    private TableColumn<Persona, String> c_apellidos;
    @FXML
    private TableColumn<Persona, String> c_apodo;
    @FXML
    private TableColumn<Persona, String> c_curso;

    ObservableList<Persona> personas;
    @FXML
    private Text linea_borrada;
    @FXML
    private MenuItem menu_guardar;
    @FXML
    private MenuItem menu_ayuda;
    @FXML
    private MenuItem menu_borrar;
    @FXML
    private MenuItem menu_salir;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelopersonas = new ModeloPersonas();
        // Mapear las propiedades de las columnas mediante setCellValueFactory
        c_nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        c_apellidos.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        c_apodo.setCellValueFactory(cellData -> cellData.getValue().apodoProperty());
        c_curso.setCellValueFactory(cellData -> cellData.getValue().cursosProperty());

        menu_borrar.setDisable(true);
        // recuperar los valores de las personas almacenadas en el modelo y guardarlo en la tabla
        actualizar_tableview();
    }  
    
   public void setModeloPersonas(ModeloPersonas modelopersonas) {
        this.check_item1.setSelected(this.modelopersonas.getCheck1()); 
        this.check_item2.setSelected(this.modelopersonas.getCheck2());        
    }    

    @FXML
    private void nueva_ventana(ActionEvent event) throws IOException {
        //carga una nueva vista
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx/vista/VentanaSecundaria.fxml"));
        //carga la vista en el panel raiz
        Pane root = (Pane) loader.load();
         //los datos se pasan a la ventana a través de la clase ModeloPersonas   
        VentanaSecundariaController controlador = loader.getController();
        controlador.setModeloPersonas(modelopersonas);
        
        Scene scene = new Scene(root);
        //Se crea un nuevo stage
        Stage stageWindow = new Stage();
        stageWindow.setTitle("Ventana Secundaria");
        //stageWindow.initModality(Modality.APPLICATION_MODAL);
        stageWindow.setScene(scene);
        
        // hacer que espere para que le lleguen los datos de la ventana hija
        stageWindow.showAndWait();
        
        //aquí voy a repoblar los valores de los checks desde la ventana hija
        actualizar_tableview();
        this.check_item1.setSelected(this.modelopersonas.getCheck1()); 
        this.check_item2.setSelected(this.modelopersonas.getCheck2());
    }


    // actualizar los datos del tableview
    private void actualizar_tableview() {
        Vistaelementos.getItems().clear();
        personas = modelopersonas.getListadoPersonas();
        for (Persona persona : personas) {
            Vistaelementos.getItems().add(persona);
        }
    }

    @FXML
    private void item1_changed(ActionEvent event) {
         this.modelopersonas.setCheck1(this.check_item1.isSelected());
         if (check_item1.isSelected()) Vistaelementos.getSortOrder().add(c_nombre);
          else Vistaelementos.getSortOrder().remove(c_nombre);
    }

    @FXML
    private void item2_changed(ActionEvent event) {
        this.modelopersonas.setCheck2(this.check_item2.isSelected());
        if (check_item2.isSelected()) Vistaelementos.getSortOrder().add(c_apellidos);
         else Vistaelementos.getSortOrder().remove(c_apellidos);
    }

    @FXML
    public void menu_ayuda(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText("Aplicación versión 0.2b");
        alert.showAndWait();
    }

    @FXML
    public void salir(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void menu_borrar(ActionEvent actionEvent) {
    }

    @FXML
    public void menu_guardar(ActionEvent actionEvent) {
        FileChooser fchooser = new FileChooser();
        fchooser.setTitle("Guardar fichero");
        File ficheroseleccionado = fchooser.showSaveDialog(new Stage());
    }
}
