module org.example.atvlpi3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jdk.compiler;
    requires java.sql;
    requires javafx.media;

    opens org.example.atvlpi3 to javafx.fxml;
    exports org.example.atvlpi3;
    exports org.example.atvlpi3.Controllers;
    opens org.example.atvlpi3.Controllers to javafx.fxml;
}