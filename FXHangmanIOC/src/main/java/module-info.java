module dci.j24e01.wordle.fxhangmanioc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens dci.j24e01.fxhangmanioc to javafx.fxml;
    exports dci.j24e01.fxhangmanioc;
}