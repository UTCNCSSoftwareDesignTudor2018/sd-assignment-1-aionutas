package presentation;

import connection.ConnectionFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.ResultSet;

public class TableController {

    private TableView tableView;

    private final String findAllStatementString = "SELECT * FROM student";


    private ObservableList<ObservableList> data;

    public void buildData() {

        Connection connection;
        data = FXCollections.observableArrayList();
        try {
            connection = ConnectionFactory.getConnection();
            String SQL = "SELECT studentId, name, address, personalNumericalCode, identityCardNumber, username from student";

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


    public void start(Stage stage) throws Exception {
        tableView = new TableView();
        buildData();

        Scene scene = new Scene(tableView);

        stage.setScene(scene);
        stage.show();
    }
}
