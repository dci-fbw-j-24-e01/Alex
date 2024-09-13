module dci.j24e01.pokeapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires jdk.httpserver;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;
    requires jorbis;

    opens dci.j24e01.pokeapi to javafx.fxml;
    exports dci.j24e01.pokeapi;
}