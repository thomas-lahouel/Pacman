module Projet {
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;
    opens launcher;
    opens items;
    //Les 2 lignes en dessous pr le fxml//
    opens Views;
    opens Controllers;

}
