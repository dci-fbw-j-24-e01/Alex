module dci.j24e01.pokeapi {
    requires javafx.controls;
    requires javafx.fxml;


    opens dci.j24e01.pokeapi to javafx.fxml;
    exports dci.j24e01.pokeapi;
}