package presentation;

import connection.ConnectionFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.ResultSet;

public class EnrollmentTable {

    private TableView tableView;

    private final String findAllStatementString = "SELECT s.name, c.course FROM student AS s INNER JOIN enrollment AS en on s.studentId = en.studentId INNER JOIN courses AS c on en.courseId = c.courseId";


    private ObservableList<ObservableList> data;

    public void buildEnrollmentData() {

        Connection connection;
        data = FXCollections.observableArrayList();
        try {
            connection = ConnectionFactory.getConnection();
            String SQL =  "SELECT s.name, c.course, c.examLevel FROM student s INNER JOIN enrollment en on s.studentId = en.studentId INNER JOIN courses c on en.courseId = c.courseId";

            ResultSet rs = connection.createStatement().executeQuery(SQL);

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }

            while (rs.next()) {

                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                data.add(row);

            }
            tableView.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void startEnrollmentTable(Stage stage) throws Exception {
        tableView = new TableView();
        buildEnrollmentData();

        Scene scene = new Scene(tableView, 301, 323);

        stage.setScene(scene);
        stage.show();
    }
}
