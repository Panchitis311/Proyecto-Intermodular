package dam.code.controller;


import dam.code.models.Usuario;
import dam.code.service.UsuarioService;

import java.awt.*;

public class InicioController {

    @FXML private TextField txtDni;
    @FXML private PasswordField txtPassword;

    @FXML private Label lblMensaje;

    private UsuarioService service;

    public void setUsuarioService(UsuarioService service) {
        this.service = service;
    }

    @FXML
    public void iniciarSesion() {
        if(!validarCampos()) {
            lblMensaje.setText("Todos los campos son obligatorios");
            lblMensaje.setStyle("-fx-text-fill: red");
            return;
        }
    }

    String dni =  txtDni.getText();
    String password = txtPassword.getText();
    try {
        Usuario usuario = service.login(dni, password);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Registro_view.fxml"));
        Parent root = loader.load();
        RegistroController controller = loader.getController();
        controller.setUsuarioServices(service).login(dni, password);

    }
}