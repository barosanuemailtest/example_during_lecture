package com.barosanu.view;

import com.barosanu.app.model.AccessLevel;
import com.barosanu.controller.EmployeeManagerDesktop;
import com.barosanu.model.EmployeeBean;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DesktopLauncher extends Application {

	private EmployeeManagerDesktop employeeManagerDesktop = new EmployeeManagerDesktop();
	private final TableView<EmployeeBean> table = new TableView<EmployeeBean>();

	final HBox hb = new HBox();

	public static void main(String[] args) {
		launch(args);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {

		Scene scene = new Scene(new Group());
		stage.setWidth(450);
		stage.setHeight(550);

		TableColumn<EmployeeBean, Integer> idCol = new TableColumn<EmployeeBean, Integer>("id");
		idCol.setMinWidth(100);
		idCol.setCellValueFactory(new PropertyValueFactory<EmployeeBean, Integer>("id"));

		TableColumn<EmployeeBean, Integer> ageCol = new TableColumn<EmployeeBean, Integer>("age");
		ageCol.setMinWidth(100);
		ageCol.setCellValueFactory(new PropertyValueFactory<EmployeeBean, Integer>("age"));

		TableColumn<EmployeeBean, String> nameCol = new TableColumn<EmployeeBean, String>("name");
		nameCol.setMinWidth(100);
		nameCol.setCellValueFactory(new PropertyValueFactory<EmployeeBean, String>("name"));

		TableColumn<EmployeeBean, AccessLevel> accessLevelCol = new TableColumn<EmployeeBean, AccessLevel>(
				"accessLevel");
		accessLevelCol.setMinWidth(100);
		accessLevelCol.setCellValueFactory(new PropertyValueFactory<EmployeeBean, AccessLevel>("accessLevel"));

		table.setItems(employeeManagerDesktop.getEmployeeList());
		table.getColumns().addAll(idCol, ageCol, nameCol, accessLevelCol);

		final TextField idField = new TextField();
		idField.setPromptText("ID");
		idField.setMaxWidth(idCol.getPrefWidth());
		final TextField ageField = new TextField();
		ageField.setPromptText("Age");
		ageField.setMaxWidth(ageCol.getPrefWidth());
		final TextField nameField = new TextField();
		nameField.setPromptText("name");
		nameField.setMaxWidth(nameCol.getPrefWidth());
		final TextField accessLevelField = new TextField();
		accessLevelField.setPromptText("Access Level");
		accessLevelField.setMaxWidth(accessLevelCol.getPrefWidth());

		final Button addButton = new Button("Add");
		addButton.setOnAction((ActionEvent e) -> {
			int id = Integer.parseInt(idField.getText());
			int age = Integer.parseInt(ageField.getText());
			AccessLevel acc = determineAccessLeve(accessLevelField.getText());
			employeeManagerDesktop.addEmployee(new EmployeeBean(id, age, nameField.getText(), acc));
		});

		hb.getChildren().addAll(idField, ageField, nameField, accessLevelField, addButton);
		hb.setSpacing(3);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(table, hb);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();

	}

	private AccessLevel determineAccessLeve(String acc) {
		if (acc.equals("EXTENDED")) {
			return AccessLevel.EXTENDED;
		} else if (acc.equals("ADMIN")) {
			return AccessLevel.ADMIN;
		} else {
			return AccessLevel.NORMAL;
		}
	}

}
