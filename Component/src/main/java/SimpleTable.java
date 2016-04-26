import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Map;

public class SimpleTable extends GridPane {

    private Map<String, Label> labelsMap = new HashMap<>();

    public SimpleTable() {
        this(10, 10);
    }

    public SimpleTable(double verticalGapSize, double horizontalGapSize) {
        setVgap(verticalGapSize);
        setHgap(horizontalGapSize);
    }

    public void put(String name, String value) {
        Label label = labelsMap.get(name);
        if (label == null) {
            label = new Label(value);
            addRow(labelsMap.size(), new Label(name), label);
            labelsMap.put(name, label);
        } else {
            label.setText(value);
        }
    }

}
