import com.healthmarketscience.jackcess.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import tasks.Task;

import java.io.File;
import java.io.IOException;
import java.util.Random;


/**
 * Created by ${DPudov} on 01.04.2016.
 */
public class TestWindowController {
    @FXML
    RadioButton radio1;
    @FXML
    RadioButton radio2;
    @FXML
    RadioButton radio3;
    @FXML
    RadioButton radio4;
    @FXML
    Label textOfTheTask;
    @FXML
    Label labelTask;
    @FXML
    Button checkButton;
    @FXML
    Label labelForChecked;

    private ToggleGroup toggleGroup = new ToggleGroup();
    private Task task;
    private String name;

    @FXML
    public void initialize() throws IOException {
        radio1.setToggleGroup(toggleGroup);
        radio2.setToggleGroup(toggleGroup);
        radio3.setToggleGroup(toggleGroup);
        radio4.setToggleGroup(toggleGroup);
        task = new Task();
        final Database db = DatabaseBuilder.open(new File("C:\\Users\\\u043c\u0432\u0438\u0434\u0435\u043e\\IdeaProjects\\RussianTest\\src\\main\\resources\\database\\tasks.accdb"));
        final Table table = db.getTable("Русский");
        final Row rowAsk = CursorBuilder.findRowByPrimaryKey(table, task.counter);
        if (rowAsk != null) {
            labelTask.setText(rowAsk.getString("Вопрос"));
            textOfTheTask.setText(rowAsk.getString("Текст задания"));
            setRadioText(rowAsk.getString("Ответ к заданию"),
                    rowAsk.getString("Неправильный ответ 1"),
                    rowAsk.getString("Неправильный ответ 2"),
                    rowAsk.getString("Неправильный ответ 3"));
        } else {
            System.out.println("No matching rowAsk was found.");
        }

        checkButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (!checkButton.getText().equals("Далее")) {
                    if (toggleGroup.getSelectedToggle() != null) {
                        checkButton.setText("Далее");
                        RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();

                        Row row = null;
                        try {
                            row = CursorBuilder.findRowByPrimaryKey(table, task.counter);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (row != null) {
                            if (rb.getText().equals(row.getString("Ответ к заданию"))) {
                                task.setRightSolved(true);
                                task.rightSolvedCounter++;
                            } else
                                task.setRightSolved(false);
                            if (task.rightSolved) {
                                labelForChecked.setText("Верно!");
                            } else {
                                labelForChecked.setText("Неверно!");
                            }
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Ничего не выбрано!");
                        alert.setHeaderText("Выберите один из предложенных ответов!");
                        alert.setContentText("Пока без штрафов, впредь будьте осторожнее");
                        alert.show();
                    }
                } else {
                    checkButton.setText("Проверить");
                    labelForChecked.setText("");

                    task.counter++;
                    if (task.counter == 11) {
                        try {
                            new ResultWindow(task.rightSolvedCounter, name);

                            checkButton.getScene().getWindow().hide();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            update(task.counter, table);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private void setRadioText(String s, String wrong1, String wrong2, String wrong3) {
        radio1.setSelected(false);
        radio2.setSelected(false);
        radio3.setSelected(false);
        radio4.setSelected(false);
        int i = new Random().nextInt(4);
        switch (i) {
            case 0:
                radio1.setText(s);
                radio2.setText(wrong1);
                radio3.setText(wrong2);
                radio4.setText(wrong3);
                break;
            case 1:
                radio2.setText(s);
                radio4.setText(wrong1);
                radio1.setText(wrong2);
                radio3.setText(wrong3);
                break;
            case 2:
                radio3.setText(s);
                radio1.setText(wrong1);
                radio2.setText(wrong2);
                radio4.setText(wrong3);
                break;
            case 3:
                radio4.setText(s);
                radio1.setText(wrong1);
                radio2.setText(wrong2);
                radio3.setText(wrong3);
                break;
        }
    }

    private void update(int c, Table table) throws IOException {
        final Row rowAsk = CursorBuilder.findRowByPrimaryKey(table, c);
        if (rowAsk != null) {
            labelTask.setText(rowAsk.getString("Вопрос"));
            textOfTheTask.setText(rowAsk.getString("Текст задания"));
            setRadioText(rowAsk.getString("Ответ к заданию"),
                    rowAsk.getString("Неправильный ответ 1"),
                    rowAsk.getString("Неправильный ответ 2"),
                    rowAsk.getString("Неправильный ответ 3"));
        } else {
            System.out.println("No matching rowAsk was found.");
        }
    }
    public void setName(String name){
        this.name = name;
    }
}

