module ru.desktop.lib {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.desktop;

    opens ru.desktop.lib to javafx.fxml;
    exports ru.desktop.lib;
}