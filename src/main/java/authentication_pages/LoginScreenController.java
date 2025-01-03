package authentication_pages;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Ecommerce.SqlData;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginScreenController extends SqlData {
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	// Checkbox tag will be implementing soon
//	@FXML
//	CheckBox rememeber_me;

	@FXML
	Label errorMessage;

	public void loginButtonClicked() throws SQLException {
		// Connecting database from where we checking the data
		// All sql data is present inside the SqlData class

		// Connecting through DriverManager using Connection class static method
		// getConnection

		Connection connection = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword);

		// Need a sql editor for writing sql instruction, we can achieve that with the
		// help of Statement class
		Statement statement = connection.createStatement();

		// Sql query
		String query = "Select * from ecom_login.login where username = '" + username.getText() + "'and password = '"
				+ password.getText() + "';";

		// ResultSet were we store data came from the sql
		ResultSet result = statement.executeQuery(query);

		{ // Checking username and password through database, data present inside the
			// result object
			// the next method moves the cursor forward one row from its current position,A
			// ResultSet cursor is initially positioned before the first row
			if (result.next()) {
				// This will be shown on the frontend window
				this.errorMessage.setText("Login Successful");

			} else {
				// followed by this
				this.errorMessage.setText("Login Failed");
			}
		}

		// Ignore this block of code
		// Check the state of the CheckBox
//		if (rememeber_me.isSelected()) {
//			// Logic to skip login for the user in future sessions
//		}
	}
}
