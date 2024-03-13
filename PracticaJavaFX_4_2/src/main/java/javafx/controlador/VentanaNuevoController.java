package javafx.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.modelo.ModeloPersonas;
import javafx.modelo.Persona;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaNuevoController implements Initializable
{

    private ModeloPersonas modelopersonas;
    @javafx.fxml.FXML
    private TextField campo_apellidos;
    @javafx.fxml.FXML
    private Text campo_error_nombre;
    @javafx.fxml.FXML
    private Button boton_agregar;
    @javafx.fxml.FXML
    private Text campo_error_apellido;
    @javafx.fxml.FXML
    private Text campo_error_curso;
    @javafx.fxml.FXML
    private Text campo_error_apodo;
    @javafx.fxml.FXML
    private TextField campo_nombre;
    @javafx.fxml.FXML
    private TextField campo_apodo;
    @javafx.fxml.FXML
    private TextField campo_curso;
    @javafx.fxml.FXML
    private Button b_volver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setModelo(ModeloPersonas modelopersonas) {
        this.modelopersonas = modelopersonas;
    }

    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) {
        Stage stage = (Stage) this.b_volver.getScene().getWindow();
        stage.close();
    }

    // validaciones al dar al botón agregar y después se agrega al modelo
    @javafx.fxml.FXML
    public void agregar(ActionEvent actionEvent) {
        campo_error_nombre.setOpacity(0);
        campo_error_apellido.setOpacity(0);
        campo_error_apodo.setOpacity(0);
        campo_error_curso.setOpacity(0);
        if (this.campo_nombre.getText().isEmpty()) {
            campo_error_nombre.setOpacity(1.0);  }
        else if (this.campo_apellidos.getText().isEmpty()) {
            campo_error_apellido.setOpacity(1.0);  }
        else if (this.campo_apodo.getText().isEmpty()) {
            campo_error_apodo.setOpacity(1.0);  }
        else {
            Persona nuevapersona = new Persona(campo_nombre.getText(), campo_apellidos.getText(), campo_apodo.getText(), campo_curso.getText());
            modelopersonas.getListadoPersonas().add(nuevapersona);
            Stage stage = (Stage) this.boton_agregar.getScene().getWindow();
            stage.close();
        }
    }
}