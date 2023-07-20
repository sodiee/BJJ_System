package GUI;

import Application.Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {

    @Override
    public void init() {
        Controller controller = new Controller();
        controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Jiu Jitsu System");

        BorderPane pane = new BorderPane();

        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        //stage.setHeight(700);
        //stage.setWidth(650);

    }

    private void initContent(BorderPane pane) {
        TrainingTab trainingTab = new TrainingTab();
        InfoTab infoTab = new InfoTab();

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Tab tabCreate = new Tab("Training", new Label("Training"));
        Tab tabInfo = new Tab("Info", new Label("Info"));

        tabCreate.setContent(trainingTab);
        tabPane.getTabs().add(tabCreate);

        tabInfo.setContent(infoTab);
        tabPane.getTabs().add(tabInfo);

        pane.setCenter(tabPane);
    }
}
