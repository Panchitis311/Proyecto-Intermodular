package dam.code.controller;

import dam.code.exceptions.ProductoException;
import dam.code.models.Producto;
import dam.code.models.Usuario;
import dam.code.service.ProductoService;
import dam.code.service.UsuarioService;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ProductoController {

    private Usuario usuario;
    private ProductoService service = new ProductoService();

    @FXML private Label lblUsuario;

    @FXML private TextField txtNombre;
    @FXML private TextField txtDescripcion;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtStock;

    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, Integer> colId;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, String> colDescripcion;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, Integer> colStock;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblUsuario.setText("Usuario: " + usuario.getNombre());
    }

    public void setProductoService(ProductoService service) throws ProductoException {
        this.service = service;
        tablaProductos.setItems(service.obtenerProductos());
    }

    @FXML
    public void initialize() {
        prefWidthColumns();
        colId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colDescripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        colPrecio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrecio()));
        colStock.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getStock()));

    }

    private void prefWidthColumns() {
        tablaProductos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        colId.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.05));
        colNombre.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.35));
        colDescripcion.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.30));
        colPrecio.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.15));
        colStock.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.15));

    }

    @FXML
    public void addProducto() {
        try {
            if (!validarCampos()) throw new ProductoException("Todos los campos son obigatorios");
            Producto producto = new Producto(
                    txtNombre.getText(),
                    txtDescripcion.getText(),
                    Double.parseDouble(txtPrecio.getText()),
                    Integer.parseInt(txtStock.getText())
            );
            service.agregarProducto(producto);
            tablaProductos.setItems(service.obtenerProductos());
            limpiarCampos();
        } catch (ProductoException e) {
            mostrarError(e.getMessage());
        } catch (NumberFormatException e) {
            mostrarError("El precio y el stock deben ser números válidos.");
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtDescripcion.clear();
        txtPrecio.clear();
        txtStock.clear();
    }

    private boolean validarCampos() {
        return !txtNombre.getText().isBlank()
                && !txtDescripcion.getText().isBlank()
                && !txtPrecio.getText().isBlank()
                && !txtStock.getText().isBlank();
    }

    @FXML
    public void cerrarSesion() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar Sesion");
        alert.setHeaderText("¿Seguro que desea cerrar sesion?");
        alert.setContentText("Se cerrará la sesión actual");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Inicio_view.fxml"));
                    Parent root = loader.load();
                    InicioController controller = loader.getController();
                    controller.setUsuarioService(new UsuarioService());

                    Stage stage = (Stage) txtNombre.getScene().getWindow();
                    stage.setResizable(false);
                    stage.setWidth(800);
                    stage.setHeight(600);
                    stage.setScene(new Scene(root));
                } catch (Exception e) {
                    mostrarError(e.getMessage());
                }
            }
        });
    }

    private void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
