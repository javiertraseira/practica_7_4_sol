/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafx.controlador;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.modelo.ModeloPersonas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.modelo.Persona;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaSecundariaController implements Initializable {

    @FXML
    private TableView<Persona> Vistaelementos;
    @FXML
    private Button b_volver;
    @FXML
    private CheckBox check_item1;
    @FXML
    private CheckBox check_item2;    
    @FXML
    private Button b_cerrar;
    
    //variables internas
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
    private Button b_añadir;
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

    public void setModeloPersonas(ModeloPersonas modelopersonas) {
        this.modelopersonas = modelopersonas;
        // Mapear las propiedades de las columnas mediante setCellValueFactory
        c_nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        c_apellidos.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        c_apodo.setCellValueFactory(cellData -> cellData.getValue().apodoProperty());
        c_curso.setCellValueFactory(cellData -> cellData.getValue().cursosProperty());

        actualizar_tableview();

        this.check_item1.setSelected(this.modelopersonas.getCheck1()); 
        this.check_item2.setSelected(this.modelopersonas.getCheck2());        
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        linea_borrada.setVisible(false);
        menu_salir.setDisable(true);
    }    


    @FXML
    private void borrar(ActionEvent event) {
        modelopersonas.borrarPersona(Vistaelementos.getSelectionModel().getSelectedItem());
        Vistaelementos.getItems().remove(Vistaelementos.getSelectionModel().getSelectedItem());
        linea_borrada.setVisible(true);
    }

    @FXML
    private void item1_changed(ActionEvent event) {
        this.modelopersonas.setCheck1(this.check_item1.isSelected());
        if (check_item1.isSelected()) Vistaelementos.getSortOrder().add(c_nombre);
        else Vistaelementos.getSortOrder().remove(c_nombre);
    }

    @FXML
    private void item2_changed(ActionEvent event) {
        this.modelopersonas.setCheck2(this.check_item1.isSelected());
        this.modelopersonas.setCheck2(this.check_item2.isSelected());
        if (check_item2.isSelected()) Vistaelementos.getSortOrder().add(c_apellidos);
        else Vistaelementos.getSortOrder().remove(c_apellidos);
    }

    @FXML
    private void cerrar_ventana(ActionEvent event) {
        Stage stage = (Stage) this.b_cerrar.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void añadir(ActionEvent actionEvent) throws IOException {
        //carga una nueva vista
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx/vista/VentanaNuevo.fxml"));
        //carga la vista en el panel raiz
        Pane root = (Pane) loader.load();
        //los datos se pasan a la ventana a través de la clase ModeloPersonas
        VentanaNuevoController controlador = loader.getController();
        controlador.setModelo(modelopersonas);

        Scene scene = new Scene(root);
        //Se crea un nuevo stage
        Stage stageWindow = new Stage();
        stageWindow.setTitle("Agregar nuevo");
        stageWindow.initModality(Modality.APPLICATION_MODAL);
        stageWindow.setScene(scene);

        // hacer que espere para que le lleguen los datos de la ventana hija
        stageWindow.showAndWait();
        // Repoblar datos recibidos
        actualizar_tableview();
        linea_borrada.setVisible(false);
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
    public void menu_ayuda(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText("Aplicación versión 0.2b");
        alert.showAndWait();
    }

    @FXML
    public void salir(ActionEvent actionEvent) {
    }

    @FXML
    public void menu_borrar(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx/vista/VentanaAviso.fxml"));
        Pane root = (Pane) loader.load();
        // Pasar el modelo a la ventana secundaria a traves de un método
        VentanaAvisoController controlador = loader.getController();
        controlador.initModelo(modelopersonas);

        Scene scene = new Scene(root);
        //Se crea un nuevo stage
        Stage stageWindow = new Stage();
        stageWindow.setTitle("Borrar todos");
        stageWindow.initModality(Modality.APPLICATION_MODAL);
        stageWindow.setScene(scene);
        stageWindow.showAndWait();

        Vistaelementos.getItems().clear();

    }

    @FXML
    public void menu_guardar(ActionEvent actionEvent) {
    }
}
