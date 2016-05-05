package pl.edu.agh.student.mkasprz.tk.chart3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.util.Random;

public class DemoApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    SimpleTable simpleTable;

    Thread testThread;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(100);
        primaryStage.setHeight(200);

        simpleTable = new SimpleTable();

        Scene scene = new Scene(new ScrollPane(simpleTable));
        primaryStage.setScene(scene);

        primaryStage.show();

        testThread = new Thread(() -> {
            Random random = new Random();
            try {
                while (true) {
                    Platform.runLater(() -> {
                        simpleTable.put("A", String.valueOf(random.nextInt()));
                        simpleTable.put("E", String.valueOf(random.nextLong()));
                        simpleTable.put("B", String.valueOf(random.nextFloat()));
                        simpleTable.put("C", String.valueOf(random.nextDouble()));
                        simpleTable.put("D", String.valueOf(random.nextBoolean()));
                    });

                    if (random.nextBoolean()) {
                        Platform.runLater(() -> simpleTable.put(String.valueOf(random.nextInt(1000)),
                                String.valueOf(random.nextInt())));
                    }

                    Thread.sleep(random.nextInt(1000));
                }
            } catch (InterruptedException e) {
            }
        });
        testThread.start();
    }

    @Override
    public void stop() throws Exception {
        testThread.interrupt();
    }
}
