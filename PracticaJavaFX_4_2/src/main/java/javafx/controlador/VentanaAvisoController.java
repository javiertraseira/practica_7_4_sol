package javafx.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.modelo.ModeloPersonas;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaAvisoController implements Initializable
{
    @javafx.fxml.FXML
    private Button b_continuar;
    @javafx.fxml.FXML
    private Button b_cancelar;
    private ModeloPersonas modelopersonas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void initModelo(ModeloPersonas modelopersonas) {
        this.modelopersonas = modelopersonas;
    }

    @javafx.fxml.FXML
    public void b_cancelar(ActionEvent actionEvent) {
        Stage ventana = (Stage) b_cancelar.getScene().getWindow();
        ventana.close();
    }

    @javafx.fxml.FXML
    public void b_continuar(ActionEvent actionEvent) {
        modelopersonas.getListadoPersonas().clear();
        Stage ventana = (Stage) b_continuar.getScene().getWindow();
        ventana.close();
    }


}