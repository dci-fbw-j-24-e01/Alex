module dci.j24e01.javafxbasicdemo.fxdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens dci.j24e01.javafxbasicdemo.fxdemo to javafx.fxml;
    exports dci.j24e01.javafxbasicdemo.fxdemo;
}