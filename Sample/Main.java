package Sample;
import java.sql.Date;
import java.util.ArrayList;
import SQL.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sqlStyle.Style;
import java.io.IOException;
import java.sql.*;

/* 
    This class is main driver for the program
*/

public class Main extends Application {
    public static CustomerQuery customerQuery =new CustomerQuery();
    public static AccountQuery accountQuery= new AccountQuery();
    public static EmployeeQuery employeeQuery =new EmployeeQuery();
    public static ManagerQuery managerQuery = new ManagerQuery();
    public static AddressQuery addressQuery =new AddressQuery();
    public static LoanQuery loanQuery = new LoanQuery();
    public static PhoneQuery phoneQuery = new PhoneQuery();
    public static BranchQuery branchQuery = new BranchQuery();
    public static PaymentQuery paymentQuery = new PaymentQuery();
    public static TransactionQuery transactionQuery = new TransactionQuery();
    public static CardQuery cardQuery = new CardQuery();
    public static DepartmentQuery departmentQuery = new DepartmentQuery();
    public static TransactionAccountQuery transactionAccountQuery = new TransactionAccountQuery();
    static Style style = new Style();

    static BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
    static Background background = new Background(c1);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(70, 250, 70, 250));
        pane.setHgap(10.5);
        pane.setVgap(10.5);
        pane.setBackground(background);

        Image img = new Image("TNB.png");
        ImageView v = new ImageView(img);
        v.setFitWidth(150);
        v.setFitHeight(70);

        Button logo = new Button();
        GridPane.setHalignment(logo, HPos.RIGHT);
        logo.setPrefSize(150, 70);
        logo.setGraphic(v);
        logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
        pane.add(logo, 1, 0);

        Label hello = new Label(("Welcome to TNB"));
        hello.setFont(Font.font(17));
        hello.setTextFill(Color.GREY);
        pane.add(hello, 0, 0);

        Label namel = new Label(("Username: "));
        namel.setFont(Font.font(16));
        GridPane.setHalignment(namel, HPos.CENTER);
        namel.setTextFill(Color.DARKSLATEBLUE);
        pane.add(namel, 0, 1);

        TextField name = new TextField();
        name.setPrefSize(200, 30);
        GridPane.setHalignment(name, HPos.CENTER);
        pane.add(name, 1, 1);

        Label passl = new Label(("Password: "));
        passl.setFont(Font.font(16));
        passl.setTextFill(Color.DARKSLATEBLUE);
        GridPane.setHalignment(passl, HPos.CENTER);
        pane.add(passl, 0, 2);

        PasswordField pass = new PasswordField();
        GridPane.setHalignment(pass, HPos.CENTER);
        pass.setPrefSize(200, 30);
        pane.add(pass, 1, 2);

        Button run = style.litButton("Run");
        GridPane.setHalignment(run, HPos.CENTER);
        pane.add(run, 0, 4);
        run.setOnAction(e -> {
            Login login = new Login();
            try {
                if(login.login(name.getText().trim(),pass.getText().trim()) == true) {
                    Stage stage1 = new Stage();
                    GridPane pane1 = style.gridPane();

                    Image img0 = new Image("TNB.png");
                    ImageView v0 = new ImageView(img0);
                    v0.setFitWidth(190);
                    v0.setFitHeight(100);

                    Button logo0 = new Button();
                    GridPane.setHalignment(logo0, HPos.CENTER);
                    logo0.setPrefSize(180, 100);
                    logo0.setGraphic(v0);
                    logo0.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
                    pane1.add(logo0, 1, 0);

                    Button addd = style.bigButton("add.png");
                    pane1.add(addd, 0, 1);
                    addd.setOnAction(k -> {
                        options(0);
                    });

                    Button del = style.bigButton("delete.png");
                    pane1.add(del, 1, 1);
                    del.setOnAction(k -> {
                        options(1);
                    });

                    Button search = style.bigButton("search.png");
                    pane1.add(search, 2, 1);
                    search.setOnAction(k -> {
                        options(2);
                    });

                    Button update = style.bigButton("update.png");
                    pane1.add(update, 0, 2);
                    update.setOnAction(k -> {
                        options(3);
                    });

                    Button view = style.bigButton("view.png");
                    pane1.add(view, 1, 2);
                    view.setOnAction(k -> {
                        options(4);
                    });

                    Button exit = style.bigButton("exit.png");
                    pane1.add(exit, 2, 2);
                    exit.setOnAction(k -> {
                        Platform.exit();
                    });

                    Scene scene1 = new Scene(pane1);
                    stage1.setScene(scene1);
                    stage1.setTitle("The National Bank");
                    stage1.getIcons().add(new Image("TNB.png"));
                    stage1.show();
                }
                else {
                    name.clear();
                    pass.clear();
                    name.setPromptText("Enter the correct Name");
                    pass.setPromptText("Enter the correct password");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        Button cancel = style.litButton("Cancel");
        pane.add(cancel, 1, 4);
        cancel.setOnAction(e -> Platform.exit());

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("The National Bank");
        stage.getIcons().add(new Image("TNB.png"));
        stage.show();
    }

    @SuppressWarnings("deprecation")
    public static void options(int choice) {
        Stage stage1 = new Stage();
        GridPane pane1 = style.gridPane();

        Button logo0 =  style.logo();
        pane1.add(logo0, 1, 0);

        Button employee = style.midButton("employees.png");
        pane1.add(employee, 0, 1);

        //choice 0 add
        if(choice == 0) {
            employee.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = style.gridPane();

                Label hello1 = new Label(("Add a new Employee"));
                hello1.setFont(Font.font(17));
                hello1.setTextFill(Color.GREY);
                pane2.add(hello1, 0, 0);

                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                Label nameC = new Label(("Employee Name: "));
                nameC.setFont(Font.font(16));
                nameC.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(nameC, HPos.CENTER);
                pane2.add(nameC, 0, 1);

                TextField nameC1 = new TextField();
                GridPane.setHalignment(nameC1, HPos.CENTER);
                nameC1.setPrefSize(200, 30);
                nameC1.setPromptText("Noor Saed Hamza");
                pane2.add(nameC1, 1, 1);

                Label phoneE = new Label(("Employee Phone: "));
                phoneE.setFont(Font.font(16));
                phoneE.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(phoneE, HPos.CENTER);
                pane2.add(phoneE, 0, 2);

                TextField phoneE1 = new TextField();
                GridPane.setHalignment(phoneE1, HPos.CENTER);
                phoneE1.setPrefSize(200, 30);
                phoneE1.setPromptText("0595959999");
                pane2.add(phoneE1, 1, 2);

                Label salaryE = new Label(("Employee Salary: "));
                salaryE.setFont(Font.font(16));
                salaryE.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(salaryE, HPos.CENTER);
                pane2.add(salaryE, 0, 3);

                TextField salaryE1 = new TextField();
                GridPane.setHalignment(salaryE1, HPos.CENTER);
                salaryE1.setPrefSize(200, 30);
                salaryE1.setPromptText("2500");
                pane2.add(salaryE1, 1, 3);

                Label departE = new Label(("Employee Department ID: "));
                departE.setFont(Font.font(16));
                departE.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(departE, HPos.CENTER);
                pane2.add(departE, 0, 4);

                ComboBox<String> dep1 = new ComboBox<String>();
                dep1.setBackground(background);
                dep1.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                dep1.setPrefSize(200, 30);
                departmentQuery.comboBox(dep1);
                pane2.add(dep1, 1, 4);

                Label city = new Label(("Address: "));
                city.setFont(Font.font(16));
                city.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(city, HPos.CENTER);
                pane2.add(city, 0, 5);

                ComboBox<String> city1 = new ComboBox<String>();
                city1.setBackground(background);
                city1.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                city1.setPrefSize(200, 30);
                addressQuery.comboBox(city1);
                pane2.add(city1, 1, 5);

                Label address = new Label(("Address ID: "));
                address.setFont(Font.font(16));
                address.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(address, HPos.CENTER);
                pane2.add(address, 0, 6);

                TextField address1 = new TextField();
                GridPane.setHalignment(address1, HPos.CENTER);
                address1.setPrefSize(200, 30);
                pane2.add(address1, 1, 6);

                Label street = new Label(("Street Name: "));
                street.setFont(Font.font(16));
                street.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(street, HPos.CENTER);
                pane2.add(street, 0, 7);

                TextField street1 = new TextField();
                GridPane.setHalignment(street1, HPos.CENTER);
                street1.setPrefSize(200, 30);
                street1.setPromptText("Al-Irsal St.");
                pane2.add(street1, 1, 7);

                Label postal = new Label(("Postal Code: "));
                postal.setFont(Font.font(16));
                postal.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(postal, HPos.CENTER);
                pane2.add(postal, 0, 8);

                TextField postal1 = new TextField();
                GridPane.setHalignment(postal1, HPos.CENTER);
                postal1.setPrefSize(200, 30);
                postal1.setPromptText("P000");
                pane2.add(postal1, 1, 8);

                Label citynam = new Label(("City name: "));
                citynam.setFont(Font.font(16));
                citynam.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(citynam, HPos.CENTER);
                pane2.add(citynam, 0, 9);

                TextField citynameT = new TextField();
                GridPane.setHalignment(street1, HPos.CENTER);
                citynameT.setPrefSize(200, 30);
                citynameT.setPromptText("Ramallah");
                pane2.add(citynameT, 1, 9);

                Label gender = new Label(("Gender: "));
                gender.setFont(Font.font(16));
                gender.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(gender, HPos.CENTER);
                pane2.add(gender, 0, 10);

                ComboBox<String> comboBox = new ComboBox<String>();
                comboBox.getItems().add("F");
                comboBox.getItems().add("M");
                comboBox.getItems().add("Other");
                comboBox.setBackground(background);
                comboBox.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                comboBox.setPrefSize(200, 30);
                comboBox.setValue("Female");
                pane2.add(comboBox, 1, 10);

                Label birth = new Label(("Date of Birth: "));
                birth.setFont(Font.font(16));
                birth.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(birth, HPos.CENTER);
                pane2.add(birth, 0, 11);

                TextField birth1 = new TextField();
                GridPane.setHalignment(birth1, HPos.CENTER);
                birth1.setPrefSize(200, 30);
                birth1.setPromptText("1998-2-15");
                pane2.add(birth1, 1, 11);

                Label email = new Label("Email");
                email.setFont(Font.font(16));
                email.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(email, HPos.CENTER);
                pane2.add(email, 0, 12);

                TextField emailT = new TextField();
                GridPane.setHalignment(emailT, HPos.CENTER);
                emailT.setPrefSize(200, 30);
                emailT.setPromptText("name@gmail.com");
                pane2.add(emailT, 1, 12);

                Button add = style.litButton("Add Employee");
                GridPane.setHalignment(add, HPos.CENTER);
                pane2.add(add, 0, 13);
                add.setOnAction(l -> {
                    if(nameC1.getText().trim().equals("")|| phoneE1.getText().trim().equals("")|| comboBox.getSelectionModel().getSelectedItem().trim().equals("")||birth1.getText().trim().equals("")|| emailT.getText().trim().equals("")||salaryE1.getText().trim().equals("")||dep1.getSelectionModel().getSelectedItem().trim().equals("")) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("Please check if all required fields are filled!");
                        alert.showAndWait();
                    }else {
                        try {
                            String line = "";
                            if (city1.getSelectionModel().isEmpty() == false) {
                                line = city1.getSelectionModel().getSelectedItem();
                                String[] arrayOfAddressInformation = line.split(",");
                                address1.setText(arrayOfAddressInformation[0]);
                                postal1.setText(arrayOfAddressInformation[1]);
                                citynameT.setText(arrayOfAddressInformation[2]);
                                street1.setText(arrayOfAddressInformation[3]);
                                Phone phone = new Phone(Integer.parseInt(phoneE1.getText()));
                                phoneQuery.insertData(phone);
                                Employee employee1 = new Employee(nameC1.getText().trim(), 
                                								Integer.parseInt(phoneE1.getText().trim()), 
                                								comboBox.getSelectionModel().getSelectedItem().trim(), 
                                								Date.valueOf(birth1.getText().trim()), 
                                								emailT.getText().trim(), 
                                								Double.parseDouble(salaryE1.getText().trim()), 
                                								Integer.parseInt(dep1.getSelectionModel().getSelectedItem().trim()),
                                								Integer.parseInt(address1.getText().trim()));
                                employeeQuery.insertData(employee1);
                            } else {
                                address1.setText(addressQuery.data.size() + 1 + "");
                                Address addresss = new Address(Integer.parseInt(postal1.getText().trim()), citynameT.getText().trim(), street1.getText().trim());
                                addressQuery.insertData(addresss);
                                Phone phone = new Phone(Integer.parseInt(phoneE1.getText().trim()));
                                phoneQuery.insertData(phone);
                                Employee employee1 = new Employee(nameC1.getText().trim(),
                                								Integer.parseInt(phoneE1.getText()),
                                								comboBox.getSelectionModel().getSelectedItem().trim(),
                                								Date.valueOf(birth1.getText().trim()), 
                                								emailT.getText().trim(), 
                                								Double.parseDouble(salaryE1.getText().trim()),
                                								Integer.parseInt(dep1.getSelectionModel().getSelectedItem().trim()),
                                								Integer.parseInt(address1.getText().trim()));
                                employeeQuery.insertData(employee1);
                            }
                            Stage stage5 = new Stage();
                            GridPane pane5 = style.gridPane();
                            Label hello54 = new Label("inserted successfully");
                            hello54.setFont(Font.font(17));
                            hello54.setTextFill(Color.GREY);
                            pane5.add(hello54, 0, 0);
                            Button logo5 = style.logo();
                            pane5.add(logo5, 1, 0);
                            //Create Scene
                            Scene scene5 = new Scene(pane5);
                            stage5.setScene(scene5);
                            stage5.setTitle("The National Bank");
                            stage5.getIcons().add(new Image("TNB.png"));
                            stage5.show();
                        } catch (Exception e){
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Warning Dialog");
                            alert.setHeaderText("Look, a Warning Dialog");
                            alert.setContentText("Please Make sure you are inputting the right input");
                            alert.showAndWait();
                        }
                    }
                });
                Button cancel0 = style.litButton("Cancel");
                pane2.add(cancel0, 1, 13);
                GridPane.setHalignment(cancel0, HPos.RIGHT);
                cancel0.setOnAction(i -> stage2.close());

                Scene scene2 = new Scene(pane2);
                stage2.setScene(scene2);
                stage2.setTitle("The National Bank");
                stage2.getIcons().add(new Image("TNB.png"));
                stage2.show();
            });
        }else if(choice == 1) {
            //choice 1 for delete
            style.style(employee,"Deletion options","employee");
        }else if(choice ==2) {
            //choice 2 for search
            style.style(employee,"Search options","employee");
        }else if(choice == 3) {
            //choice 4 for update
            style.style(employee,"Update options","employee");
        }else {
            //view table
            employee.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = new GridPane();
                pane2.setBackground(background);
                pane2.setPadding(new Insets(60, 60, 60, 60));
                pane2.setAlignment(Pos.CENTER);
                pane2.setHgap(10);
                pane2.setVgap(10);
                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);
                try {
                    employeeQuery.getData();

                    //convert data from arraylist to observable arraylist
                    employeeQuery.dataList = FXCollections.observableArrayList(employeeQuery.data);
                    employeeQuery.tableView(stage2,pane2);

                    stage2.setTitle("The National Bank");
                    stage2.getIcons().add(new Image("TNB.png"));
                    stage2.show();
                } catch (SQLException f) {
                    f.printStackTrace();
                } catch (ClassNotFoundException f) {
                    f.printStackTrace();
                }
            });
        }

        Button manager = style.midButton("manager.png");
        pane1.add(manager, 1, 1);
        if(choice == 0) {
            //choice 0 add
            manager.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = style.gridPane();

                Label hello1 = new Label(("Add a new Manager"));
                hello1.setFont(Font.font(17));
                hello1.setTextFill(Color.GREY);
                pane2.add(hello1, 0, 0);

                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                Label nameC = new Label(("Manager Name: "));
                nameC.setFont(Font.font(16));
                nameC.setTextFill(Color.DARKSLATEBLUE);
                pane2.add(nameC, 0, 1);

                TextField nameC1 = new TextField();
                nameC1.setPrefSize(200, 30);
                nameC1.setPromptText("Noor Saed Hamza");
                pane2.add(nameC1, 1, 1);

                Label phoneE = new Label(("Manager Phone: "));
                phoneE.setFont(Font.font(16));
                phoneE.setTextFill(Color.DARKSLATEBLUE);
                pane2.add(phoneE, 0, 2);

                TextField phoneE1 = new TextField();
                phoneE1.setPrefSize(200, 30);
                phoneE1.setPromptText("0595959999");
                pane2.add(phoneE1, 1, 2);

                Label emailE = new Label(("Manager Email: "));
                emailE.setFont(Font.font(16));
                emailE.setTextFill(Color.DARKSLATEBLUE);
                pane2.add(emailE, 0, 3);

                TextField emailE1 = new TextField();
                GridPane.setHalignment(emailE1, HPos.CENTER);
                emailE1.setPrefSize(200, 30);
                pane2.add(emailE1, 1, 3);

                Label salaryE = new Label(("Manager Salary: "));
                salaryE.setFont(Font.font(16));
                salaryE.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(salaryE, HPos.CENTER);
                pane2.add(salaryE, 0, 4);

                TextField salaryE1 = new TextField();
                GridPane.setHalignment(salaryE1, HPos.CENTER);
                salaryE1.setPrefSize(200, 30);
                salaryE1.setPromptText("3500");
                pane2.add(salaryE1, 1, 4);

                Label city = new Label(("Address: "));
                city.setFont(Font.font(16));
                city.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(city, HPos.CENTER);
                pane2.add(city, 0, 5);

                ComboBox<String> city1 = new ComboBox<String>();
                city1.setBackground(background);
                city1.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                city1.setPrefSize(200, 30);
                addressQuery.comboBox(city1);

                pane2.add(city1, 1, 5);
                Label addressL = new Label(("Address ID"));
                addressL.setFont(Font.font(16));
                addressL.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(addressL, HPos.CENTER);
                pane2.add(addressL, 0, 6);

                TextField address1 = new TextField();
                GridPane.setHalignment(address1, HPos.CENTER);
                address1.setPrefSize(200, 30);
                address1.setDisable(true);
                pane2.add(address1, 1, 6);

                Label street = new Label(("Street Name: "));
                street.setFont(Font.font(16));
                street.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(street, HPos.CENTER);
                pane2.add(street, 0, 7);

                TextField street1 = new TextField();
                GridPane.setHalignment(street1, HPos.CENTER);
                street1.setPrefSize(200, 30);
                street1.setPromptText("Al-Irsal St.");
                pane2.add(street1, 1, 7);

                Label postal = new Label(("Postal Code: "));
                postal.setFont(Font.font(16));
                postal.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(postal, HPos.CENTER);
                pane2.add(postal, 0,8);

                TextField postal1 = new TextField();
                GridPane.setHalignment(postal1, HPos.CENTER);
                postal1.setPrefSize(200, 30);
                postal1.setPromptText("P000");
                pane2.add(postal1, 1, 8);

                Label citynam = new Label(("City name: "));
                citynam.setFont(Font.font(16));
                citynam.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(citynam, HPos.CENTER);
                pane2.add(citynam, 0, 9);

                TextField citynameT = new TextField();
                GridPane.setHalignment(street1, HPos.CENTER);
                citynameT.setPrefSize(200, 30);
                citynameT.setPromptText("Ramallah");
                pane2.add(citynameT, 1, 9);

                Label gender = new Label(("Gender: "));
                gender.setFont(Font.font(16));
                gender.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(gender, HPos.CENTER);
                pane2.add(gender, 0, 10);

                ComboBox<String> comboBox = new ComboBox<String>();
                comboBox.getItems().add("Female");
                comboBox.getItems().add("Male");
                comboBox.getItems().add("Other");
                comboBox.setBackground(background);
                comboBox.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                comboBox.setPrefSize(200, 30);
                comboBox.setValue("Female");
                pane2.add(comboBox, 1, 10);

                Label birth = new Label(("Date of Birth: "));
                birth.setFont(Font.font(16));
                birth.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(birth, HPos.CENTER);
                pane2.add(birth, 0, 11);

                TextField birth1 = new TextField();
                GridPane.setHalignment(birth1, HPos.CENTER);
                birth1.setPrefSize(200, 30);
                birth1.setPromptText("1998-2-15");
                pane2.add(birth1, 1, 11);

                Button add = style.litButton("Add Manager");
                GridPane.setHalignment(add, HPos.CENTER);
                pane2.add(add, 0, 12);
                add.setOnAction(l -> {
                    if(nameC1.getText().equals("")|| phoneE1.getText().equals("")|| comboBox.getSelectionModel().getSelectedItem().equals("")||birth1.getText().equals("")|| emailE1.getText().equals("")||salaryE1.getText().equals("")) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("Please check if all required fields are filled!");
                        alert.showAndWait();
                    }else {
                        try {
                            String line ="";
                            if(city1.getSelectionModel().isEmpty()==false) {
                                line = city1.getSelectionModel().getSelectedItem();
                                String[] arrayOfAddressInformation = line.split(",");
                                address1.setText(arrayOfAddressInformation[0]);
                                postal1.setText(arrayOfAddressInformation[1]);
                                citynameT.setText(arrayOfAddressInformation[2]);
                                street1.setText(arrayOfAddressInformation[3]);
                                Phone phone= new Phone(Integer.parseInt(phoneE1.getText()));
                                phoneQuery.insertData(phone);
                                Manager manager1 = new Manager(nameC1.getText().trim(),
                                							Integer.parseInt(phoneE1.getText().trim()),
                                							Date.valueOf(birth1.getText().trim()),
                                							comboBox.getSelectionModel().getSelectedItem().trim(),
                                							emailE1.getText().trim(),
                                							Double.parseDouble(salaryE1.getText().trim()),
                                							Integer.parseInt(address1.getText().trim()));
                                managerQuery.insertData(manager1);
                            }else{
                                address1.setText(addressQuery.data.size()+1+"");
                                Address addresss = new Address(Integer.parseInt(postal1.getText().trim()),citynameT.getText().trim(),street1.getText().trim());
                                addressQuery.insertData(addresss);
                                Phone phone= new Phone(Integer.parseInt(phoneE1.getText()));
                                phoneQuery.insertData(phone);
                                Manager manager1 = new Manager(nameC1.getText().trim(),
                                							Integer.parseInt(phoneE1.getText().trim()),
                                							Date.valueOf(birth1.getText().trim()),
                                							comboBox.getSelectionModel().getSelectedItem().trim(),
                                							emailE1.getText().trim(),
                                							Double.parseDouble(salaryE1.getText().trim()),
                                							Integer.parseInt(address1.getText().trim()));
                                managerQuery.insertData(manager1);
                            }
                            Stage stage5 = new Stage();
                            GridPane pane5 = style.gridPane();
                            Label hello54 = new Label("inserted successfully");
                            hello54.setFont(Font.font(17));
                            hello54.setTextFill(Color.GREY);
                            pane5.add(hello54, 0, 0);
                            Button logo5 = style.logo();
                            pane5.add(logo5, 1, 0);
                            //Create Scene
                            Scene scene5 = new Scene(pane5);
                            stage5.setScene(scene5);
                            stage5.setTitle("The National Bank");
                            stage5.getIcons().add(new Image("TNB.png"));
                            stage5.show();
                        }catch (Exception e){
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Warning Dialog");
                            alert.setHeaderText("Look, a Warning Dialog");
                            alert.setContentText("Please Make sure you are inputting the right input");
                            alert.showAndWait();
                        }
                    }
                });

                //User button to exit
                Button cancel0 = new Button("Cancel");
                cancel0.setFont(Font.font(14));
                cancel0.setTextFill(Color.DARKSLATEBLUE);
                cancel0.setPrefSize(90, 30);
                cancel0.setStyle("-fx-background-radius: 10, 5;-fx-background-color:lightgrey;");
                pane2.add(cancel0, 1, 12);
                GridPane.setHalignment(cancel0, HPos.RIGHT);
                cancel0.setOnAction(i -> stage2.close());

                //Create Scene
                Scene scene2 = new Scene(pane2);
                stage2.setScene(scene2);
                stage2.setTitle("The National Bank");
                stage2.getIcons().add(new Image("TNB.png"));
                stage2.show();
            });
        }else if(choice == 1) {
            //choice 1 for delete
            style.style(manager,"Deletion options","manager");
        }else if(choice ==2) {
            //choice 2 for search
            style.style(manager,"Search options","manager");
        }else if(choice == 3) {
            //choice 4 for update
            style.style(manager,"Update options","manager");
        }else {
            //view table
            manager.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = new GridPane();
                pane2.setBackground(background);
                pane2.setPadding(new Insets(60, 60, 60, 60));
                pane2.setAlignment(Pos.CENTER);
                pane2.setHgap(10);
                pane2.setVgap(10);
                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);
                try {
                    managerQuery.getData();

                    //convert data from arraylist to observable arraylist
                    managerQuery.dataList = FXCollections.observableArrayList(managerQuery.data);
                    managerQuery.tableView(stage2,pane2);

                    stage2.setTitle("The National Bank");
                    stage2.getIcons().add(new Image("TNB.png"));
                    stage2.show();

                } catch (SQLException f) {
                    f.printStackTrace();
                } catch (ClassNotFoundException f) {
                    f.printStackTrace();
                }
            });
        }

        Button customer = style.midButton("customer.png");
        pane1.add(customer, 2, 1);

        if(choice==0) {
            customer.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = style.gridPane();

                Label hello1 = new Label(("Add a new Customer"));
                hello1.setFont(Font.font(17));
                hello1.setTextFill(Color.GREY);
                pane2.add(hello1, 0, 0);

                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                Label nameC = new Label(("Customer Name: "));
                nameC.setFont(Font.font(16));
                nameC.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(nameC, HPos.CENTER);
                pane2.add(nameC, 0, 1);

                TextField nameC1 = new TextField();
                GridPane.setHalignment(nameC1, HPos.CENTER);
                nameC1.setPrefSize(200, 30);
                nameC1.setPromptText("Noor Saed Hamza");
                pane2.add(nameC1, 1, 1);

                Label phoneE = new Label(("Customer Phone: "));
                phoneE.setFont(Font.font(16));
                phoneE.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(phoneE, HPos.CENTER);
                pane2.add(phoneE, 0, 2);

                TextField phoneE1 = new TextField();
                GridPane.setHalignment(phoneE1, HPos.CENTER);
                phoneE1.setPrefSize(200, 30);
                phoneE1.setPromptText("0595959999");
                pane2.add(phoneE1, 1, 2);

                Label city = new Label(("Address: "));
                city.setFont(Font.font(16));
                city.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(city, HPos.CENTER);
                pane2.add(city, 0, 3);

                ComboBox<String> city1 = new ComboBox<String>();
                city1.setBackground(background);
                city1.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                city1.setPrefSize(200, 30);
                addressQuery.comboBox(city1);
                pane2.add(city1, 1, 3);

                Label addressId = new Label("Address ID");
                addressId.setFont(Font.font(16));
                addressId.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(addressId, HPos.CENTER);
                pane2.add(addressId, 0, 4);

                TextField address1 = new TextField();
                GridPane.setHalignment(address1, HPos.CENTER);
                address1.setPrefSize(200, 30);
                address1.setPromptText("Al-Irsal St.");
                pane2.add(address1, 1, 4);

                Label street = new Label(("Street Name: "));
                street.setFont(Font.font(16));
                street.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(street, HPos.CENTER);
                pane2.add(street, 0, 5);

                TextField street1 = new TextField();
                GridPane.setHalignment(street1, HPos.CENTER);
                street1.setPrefSize(200, 30);
                street1.setPromptText("Al-Irsal St.");
                pane2.add(street1, 1, 5);

                Label postal = new Label(("Postal Code: "));
                postal.setFont(Font.font(16));
                postal.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(postal, HPos.CENTER);
                pane2.add(postal, 0, 6);

                TextField postal1 = new TextField();
                GridPane.setHalignment(postal1, HPos.CENTER);
                postal1.setPrefSize(200, 30);
                postal1.setPromptText("P000");
                pane2.add(postal1, 1, 6);

                //Label for City name
                Label citynam = new Label(("City name: "));
                citynam.setFont(Font.font(16));
                citynam.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(citynam, HPos.CENTER);
                pane2.add(citynam, 0, 7);

                TextField citynameT = new TextField();
                GridPane.setHalignment(street1, HPos.CENTER);
                citynameT.setPrefSize(200, 30);
                citynameT.setPromptText("Ramallah");
                pane2.add(citynameT, 1, 7);

                Label gender = new Label(("Gender: "));
                gender.setFont(Font.font(16));
                gender.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(gender, HPos.CENTER);
                pane2.add(gender, 0, 8);

                ComboBox<String> comboBox = new ComboBox<String>();
                comboBox.getItems().add("Female");
                comboBox.getItems().add("Male");
                comboBox.getItems().add("Other");
                comboBox.setBackground(background);
                comboBox.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                comboBox.setPrefSize(200, 30);
                comboBox.setValue("Female");
                pane2.add(comboBox, 1, 8);

                Label birth = new Label(("Date of Birth: "));
                birth.setFont(Font.font(16));
                birth.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(birth, HPos.CENTER);
                pane2.add(birth, 0, 9);

                TextField birth1 = new TextField();
                GridPane.setHalignment(birth1, HPos.CENTER);
                birth1.setPrefSize(200, 30);
                birth1.setPromptText("1998-2-15");
                pane2.add(birth1, 1, 9);

                Button add = style.litButton("Add Customer");
                GridPane.setHalignment(add, HPos.CENTER);
                pane2.add(add, 0, 10);
                add.setOnAction(l -> {
                    if(nameC1.getText().equals("")|| phoneE1.getText().equals("")|| comboBox.getSelectionModel().getSelectedItem().equals("")||birth1.getText().equals("")) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("Please check if all required fields are filled!");
                        alert.showAndWait();
                    }else {
                        try {
                            String line = "";
                            if (city1.getSelectionModel().isEmpty() == false) {
                                line = city1.getSelectionModel().getSelectedItem();
                                String[] arrayOfAddressInformation = line.split(",");
                                address1.setText(arrayOfAddressInformation[0]);
                                postal1.setText(arrayOfAddressInformation[1]);
                                citynameT.setText(arrayOfAddressInformation[2]);
                                street1.setText(arrayOfAddressInformation[3]);
                                Phone phone = new Phone(Integer.parseInt(phoneE1.getText()));
                                phoneQuery.insertData(phone);
                                Customer customers = new Customer(nameC1.getText().trim(),
                                								Integer.parseInt(phoneE1.getText().trim()),
                                								Date.valueOf(birth1.getText().trim()),
                                								comboBox.getSelectionModel().getSelectedItem().trim(),
                                								Integer.parseInt(address1.getText().trim()));
                                customerQuery.insertData(customers);
                            } else {
                                address1.setText(addressQuery.data.size() + 1 + "");
                                Address address = new Address(Integer.parseInt(postal1.getText()), citynameT.getText(), street1.getText());
                                addressQuery.insertData(address);
                                Phone phone = new Phone(Integer.parseInt(phoneE1.getText()));
                                phoneQuery.insertData(phone);
                                Customer customers = new Customer(nameC1.getText().trim(),
						        								Integer.parseInt(phoneE1.getText().trim()),
						        								Date.valueOf(birth1.getText().trim()),
						        								comboBox.getSelectionModel().getSelectedItem().trim(),
						        								addressQuery.data.size() + 1);
                                customerQuery.insertData(customers);
                            }
                            Stage stage5 = new Stage();
                            GridPane pane5 = style.gridPane();
                            Label hello54 = new Label("inserted successfully");
                            hello54.setFont(Font.font(17));
                            hello54.setTextFill(Color.GREY);
                            pane5.add(hello54, 0, 0);
                            Button logo5 = style.logo();
                            pane5.add(logo5, 1, 0);
                            //Create Scene
                            Scene scene5 = new Scene(pane5);
                            stage5.setScene(scene5);
                            stage5.setTitle("The National Bank");
                            stage5.getIcons().add(new Image("TNB.png"));
                            stage5.show();
                        }catch (Exception e){
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Warning Dialog");
                            alert.setHeaderText("Look, a Warning Dialog");
                            alert.setContentText("Please Make sure you are inputting the right input\n"+e.getMessage());
                            alert.showAndWait();
                        }
                    }});

                Button cancel0 = style.litButton("Cancel");
                pane2.add(cancel0, 1, 10);
                GridPane.setHalignment(cancel0, HPos.RIGHT);
                cancel0.setOnAction(i -> stage2.close());

                Scene scene2 = new Scene(pane2);
                stage2.setScene(scene2);
                stage2.setTitle("The National Bank");
                stage2.getIcons().add(new Image("TNB.png"));
                stage2.show();
            });
        }else if(choice == 1) {
            //choice 1 for delete
            customer.setOnAction(k -> {
                //choice 1 for delete
                style.style(customer,"Deletion options","customer");
            });
        }else if(choice ==2) {
            //choice 2 for search
            style.style(customer,"Search options","customer");
        }else if(choice == 3) {
            //choice 4 for update
            style.style(customer,"Update options","customer");
        }else {
            //view table
            customer.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = new GridPane();
                pane2.setBackground(background);
                pane2.setPadding(new Insets(60, 60, 60, 60));
                pane2.setAlignment(Pos.CENTER);
                pane2.setHgap(10);
                pane2.setVgap(10);
                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                try {
                    customerQuery.getData();

                    //convert data from arraylist to observable arraylist
                    customerQuery.dataList = FXCollections.observableArrayList(customerQuery.data);
                    customerQuery.tableView(stage2,pane2);
                    stage2.setTitle("The National Bank");
                    stage2.getIcons().add(new Image("TNB.png"));
                    stage2.show();

                } catch (SQLException f) {
                    f.printStackTrace();
                } catch (ClassNotFoundException f) {
                    f.printStackTrace();
                }
            });
        }

        Button account = style.midButton("bank-account.png");
        pane1.add(account, 0, 2);
        if(choice==0) {
            //choice 0 for add
            account.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = style.gridPane();

                Label hello1 = new Label(("Add a new Account"));
                hello1.setFont(Font.font(17));
                hello1.setTextFill(Color.GREY);
                pane2.add(hello1, 0, 0);

                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                //A label to show the number of power sources
                Label IDC = new Label(("Customer ID: "));
                IDC.setFont(Font.font(16));
                IDC.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(IDC , HPos.CENTER);
                pane2.add(IDC , 0, 1);

                //User textfiled
                ComboBox<String> IDC1 = new ComboBox<String>();
                IDC1.setBackground(background);
                IDC1.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                IDC1.setPrefSize(200, 30);
                customerQuery.comboBox(IDC1);
                pane2.add(IDC1, 1, 1);

                //A label to show the number of power sources
                Label type = new Label(("Account type: "));
                type.setFont(Font.font(16));
                type.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(type , HPos.CENTER);
                pane2.add(type , 0, 2);

                ComboBox<String> comboBox = new ComboBox<String>();
                comboBox.getItems().add("Deposit");
                comboBox.getItems().add("Savings");
                comboBox.getItems().add("Current");
                comboBox.setBackground(background);
                comboBox.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                comboBox.setPrefSize(200, 30);
                comboBox.setValue("Savings");
                pane2.add(comboBox, 1, 2);

                //A label to show the number of power sources
                Label branch = new Label(("Branch ID: "));
                branch.setFont(Font.font(16));
                branch.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(branch , HPos.CENTER);
                pane2.add(branch , 0, 3);

                ComboBox<String> bIDC = new ComboBox<String>();
                bIDC.setBackground(background);
                bIDC.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                bIDC.setPrefSize(200, 30);
                branchQuery.comboBox(bIDC);
                pane2.add(bIDC, 1, 3);

                //User button to create account
                Button add = style.litButton("Create Account");
                GridPane.setHalignment(add, HPos.CENTER);
                pane2.add(add, 0, 4);
                add.setOnAction(l -> {
                    try {
                        long millis = System.currentTimeMillis();
                        Date date = new Date(millis);
                        Date logicalDate = new Date(millis);
                        logicalDate.setDate(logicalDate.getDay() + 23);
                        Account account1 = new Account(Integer.parseInt(IDC1.getSelectionModel().getSelectedItem().trim()),
                        								comboBox.getSelectionModel().getSelectedItem().trim(),
                        								date, 
                        								logicalDate, 
                        								Integer.parseInt(bIDC.getSelectionModel().getSelectedItem().trim()), 0, 0);
                        accountQuery.insertData(account1);
                        Stage stage5 = new Stage();
                        GridPane pane5 = style.gridPane();
                        Label hello54 = new Label("inserted successfully");
                        hello54.setFont(Font.font(17));
                        hello54.setTextFill(Color.GREY);
                        pane5.add(hello54, 0, 0);
                        Button logo5 = style.logo();
                        pane5.add(logo5, 1, 0);
                        //Create Scene
                        Scene scene5 = new Scene(pane5);
                        stage5.setScene(scene5);
                        stage5.setTitle("The National Bank");
                        stage5.getIcons().add(new Image("TNB.png"));
                        stage5.show();
                    }catch (Exception e){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("Please Make sure you are inputting the right input\n"+e.getMessage());
                        alert.showAndWait();
                    }
                });

                //User button to exit
                Button cancel0 = style.litButton("Cancel");
                pane2.add(cancel0, 1, 4);
                GridPane.setHalignment(cancel0, HPos.RIGHT);
                cancel0.setOnAction(i -> stage2.close());

                //Create Scene
                Scene scene2 = new Scene(pane2);
                stage2.setScene(scene2);
                stage2.setTitle("The National Bank");
                stage2.getIcons().add(new Image("TNB.png"));
                stage2.show();
            });
        }else if(choice == 1) {
            //choice 1 for delete
            style.style(account,"Deletion options","account");
        }else if(choice ==2) {
            //choice 2 for search
            style.style(account,"Search options","account");
        }else if(choice == 3) {
            //choice 4 for update
            style.style(account,"Update options","account");
        }else {
            //view table
            account.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = new GridPane();
                pane2.setBackground(background);
                pane2.setPadding(new Insets(60, 60, 60, 60));
                pane2.setAlignment(Pos.CENTER);
                pane2.setHgap(10);
                pane2.setVgap(10);
                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                try {
                    accountQuery.getData();

                    //convert data from arraylist to observable arraylist
                    accountQuery.dataList = FXCollections.observableArrayList(accountQuery.data);
                    accountQuery.tableView(stage2,pane2);

                    stage2.setTitle("The National Bank");
                    stage2.getIcons().add(new Image("TNB.png"));
                    stage2.show();

                } catch (SQLException f) {
                    f.printStackTrace();
                } catch (ClassNotFoundException f) {
                    f.printStackTrace();
                }
            });
        }

        Button loan = style.midButton("loan.png");
        pane1.add(loan, 1, 2);
        if(choice==0) {
            loan.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = style.gridPane();

                Label hello1 = new Label(("Add a new Loan"));
                hello1.setFont(Font.font(17));
                hello1.setTextFill(Color.GREY);
                pane2.add(hello1, 0, 0);

                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                Label amount = new Label(("Loan amount: "));
                amount.setFont(Font.font(16));
                amount.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(amount , HPos.CENTER);
                pane2.add(amount , 0, 1);

                TextField amount1 = new TextField();
                GridPane.setHalignment(amount1, HPos.CENTER);
                amount1.setPrefSize(200, 30);
                amount1.setPromptText("26000");
                pane2.add(amount1, 1, 1);

                Label type = new Label(("Loan type: "));
                type.setFont(Font.font(16));
                type.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(type , HPos.CENTER);
                pane2.add(type , 0, 2);

                ComboBox<String> comboBox = new ComboBox<String>();
                comboBox.getItems().add("Student loan");
                comboBox.getItems().add("Project loan");
                comboBox.getItems().add("House loan");
                comboBox.getItems().add("Car loan");
                comboBox.setBackground(background);
                comboBox.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                comboBox.setPrefSize(200, 30);
                comboBox.setValue("Student loan");
                pane2.add(comboBox, 1, 2);

                Label BIL = new Label(("Branch ID: "));
                BIL.setFont(Font.font(16));
                BIL.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(BIL , HPos.CENTER);
                pane2.add(BIL, 0, 3);

                ComboBox<String> bIDC = new ComboBox<String>();
                bIDC.setBackground(background);
                bIDC.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                bIDC.setPrefSize(200, 30);
                branchQuery.comboBox(bIDC);
                pane2.add(bIDC , 1, 3);

                Label IDC = new Label(("Customer ID: "));
                IDC.setFont(Font.font(16));
                IDC.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(IDC , HPos.CENTER);
                pane2.add(IDC , 0, 4);

                ComboBox<String> IDC1 = new ComboBox<String>();
                IDC1.setBackground(background);
                IDC1.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                IDC1.setPrefSize(200, 30);
                customerQuery.comboBox(IDC1);
                pane2.add(IDC1, 1, 4);

                Button add = style.litButton("Give Loan");
                GridPane.setHalignment(add, HPos.CENTER);
                pane2.add(add, 0, 5);
                add.setOnAction(l -> {
                    try{
                        long millis=System.currentTimeMillis();
                        java.sql.Date date=new java.sql.Date(millis);
                        Loan loan1 = new Loan(Double.parseDouble(amount1.getText().trim()),
                        										comboBox.getSelectionModel().getSelectedItem().trim(),
                        										Integer.parseInt(bIDC.getSelectionModel().getSelectedItem().trim()),
                        										Integer.parseInt(IDC1.getSelectionModel().getSelectedItem().trim()),
                        										date);
                        loanQuery.insertData(loan1);
                        Stage stage5 = new Stage();
                        GridPane pane5 = style.gridPane();
                        Label hello54 = new Label("inserted successfully");
                        hello54.setFont(Font.font(17));
                        hello54.setTextFill(Color.GREY);
                        pane5.add(hello54, 0, 0);
                        Button logo5 = style.logo();
                        pane5.add(logo5, 1, 0);
                        //Create Scene
                        Scene scene5 = new Scene(pane5);
                        stage5.setScene(scene5);
                        stage5.setTitle("The National Bank");
                        stage5.getIcons().add(new Image("TNB.png"));
                        stage5.show();
                    }catch (Exception e){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("Please Make sure you are inputting the right input\n"+e.getMessage());
                        alert.showAndWait();
                    }
                });

                //User button to exit
                Button cancel0 = style.litButton("Cancel");
                pane2.add(cancel0, 1, 5);
                GridPane.setHalignment(cancel0, HPos.RIGHT);
                cancel0.setOnAction(i -> stage2.close());

                //Create Scene
                Scene scene2 = new Scene(pane2);
                stage2.setScene(scene2);
                stage2.setTitle("The National Bank");
                stage2.getIcons().add(new Image("TNB.png"));
                stage2.show();
            });
        }else if(choice == 1) {
            //choice 1 for delete
            style.style(loan,"Deletion options","loan");
        }else if(choice ==2) {
            //choice 2 for search
            style.style(loan,"Search options","loan");
        }else if(choice == 3) {
            //choice 4 for update
            style.style(loan,"Update options","loan");
        }else {
            //view table
            loan.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = new GridPane();
                pane2.setBackground(background);
                pane2.setPadding(new Insets(60, 60, 60, 60));
                pane2.setAlignment(Pos.CENTER);
                pane2.setHgap(10);
                pane2.setVgap(10);
                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);
                try {
                    loanQuery.getData();
                    //convert data from arraylist to observable arraylist
                    loanQuery.dataList = FXCollections.observableArrayList(loanQuery.data);
                    loanQuery.tableView(stage2,pane2);

                    stage2.setTitle("The National Bank");
                    stage2.getIcons().add(new Image("TNB.png"));
                    stage2.show();
                } catch (SQLException f) {
                    f.printStackTrace();
                } catch (ClassNotFoundException f) {
                    f.printStackTrace();
                }
            });
        }
        Button payment = style.midButton("payment.png");
        pane1.add(payment, 2, 2);

        if(choice==0) {
            payment.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = style.gridPane();

                //A label to show the number of power sources
                Label hello1 = new Label(("Add a new Payment"));
                hello1.setFont(Font.font(17));
                hello1.setTextFill(Color.GREY);
                pane2.add(hello1, 0, 0);

                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                //A label to show the number of power sources
                Label amount = new Label(("Payment amount: "));
                amount.setFont(Font.font(16));
                amount.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(amount , HPos.CENTER);
                pane2.add(amount , 0, 1);

                TextField amount1 = new TextField();
                GridPane.setHalignment(amount1, HPos.CENTER);
                amount1.setPrefSize(200, 30);
                amount1.setPromptText("1000");
                pane2.add(amount1, 1, 1);

                Label bIDC = new Label(("Loan ID: "));
                bIDC.setFont(Font.font(16));
                bIDC.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(bIDC , HPos.CENTER);
                pane2.add(bIDC , 0, 2);

                ComboBox<String> bIDC1 = new ComboBox<String>();
                bIDC1.setBackground(background);
                bIDC1.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                bIDC1.setPrefSize(200, 30);
                loanQuery.comboBox(bIDC1);
                pane2.add(bIDC1, 1, 2);

                Button add = style.litButton("Add Payment");
                GridPane.setHalignment(add, HPos.CENTER);
                pane2.add(add, 0, 3);
                add.setOnAction(l -> {
                    try{
                        long millis=System.currentTimeMillis();
                        java.sql.Date date=new java.sql.Date(millis);
                        Payment payment1 = new Payment(Double.parseDouble(amount1.getText().trim()),
                        								date,
                        								Integer.parseInt(bIDC1.getSelectionModel().getSelectedItem().trim()));
                        boolean x = loanQuery.update(Integer.parseInt(bIDC1.getSelectionModel().getSelectedItem()),Double.parseDouble(amount1.getText()));
                        if(x== true) {
                            paymentQuery.insertData(payment1);
                            Stage stage5 = new Stage();
                            GridPane pane5 = style.gridPane();
                            
                            Label hello54 = new Label("inserted successfully");
                            hello54.setFont(Font.font(17));
                            hello54.setTextFill(Color.GREY);
                            pane5.add(hello54, 0, 0);
                            Button logo5 = style.logo();
                            pane5.add(logo5, 1, 0);
                            
                            //Create Scene
                            Scene scene5 = new Scene(pane5);
                            stage5.setScene(scene5);
                            stage5.setTitle("The National Bank");
                            stage5.getIcons().add(new Image("TNB.png"));
                            stage5.show();
                        }
                    }catch (Exception e){
                        e.getMessage();
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("Please Make sure you are inputting the right input\n"+e.getMessage());
                        alert.showAndWait();
                    }
                });

                Button cancel0 = style.litButton("Cancel");
                pane2.add(cancel0, 1, 3);
                GridPane.setHalignment(cancel0, HPos.RIGHT);
                cancel0.setOnAction(i -> stage2.close());

                Scene scene2 = new Scene(pane2);
                stage2.setScene(scene2);
                stage2.setTitle("The National Bank");
                stage2.getIcons().add(new Image("TNB.png"));
                stage2.show();
            });
        }else if(choice == 1) {
            //choice 1 for delete
            style.style(payment,"Deletion options","payment");
        }else if(choice ==2) {
            //choice 2 for search
            style.style(payment,"Search options","payment");
        }else if(choice == 3) {
            //choice 4 for update
            style.style(payment,"Update options","payment");
        }else {
            //view table
            payment.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = new GridPane();
                pane2.setBackground(background);
                pane2.setPadding(new Insets(60, 60, 60, 60));
                pane2.setAlignment(Pos.CENTER);
                pane2.setHgap(10);
                pane2.setVgap(10);
                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                try {
                    paymentQuery.getData();
                    //convert data from arraylist to observable arraylist
                    paymentQuery.dataList = FXCollections.observableArrayList(paymentQuery.data);
                    paymentQuery.tableView(stage2,pane2);

                    stage2.setTitle("The National Bank");
                    stage2.getIcons().add(new Image("TNB.png"));
                    stage2.show();

                } catch (SQLException | ClassNotFoundException f) {
                    f.printStackTrace();
                }
            });
        }

        Button card = style.midButton("card.png");
        pane1.add(card, 0,3);

        if(choice==0) {
            card.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = style.gridPane();

                Label hello1 = new Label(("Add a new card"));
                hello1.setFont(Font.font(17));
                hello1.setTextFill(Color.GREY);
                pane2.add(hello1, 0, 0);

                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                Label IDC = new Label(("Customer ID: "));
                IDC.setFont(Font.font(16));
                IDC.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(IDC , HPos.CENTER);
                pane2.add(IDC , 0, 1);

                ComboBox<String> IDC1 = new ComboBox<String>();
                IDC1.setBackground(background);
                IDC1.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                IDC1.setPrefSize(200, 30);
                customerQuery.comboBox(IDC1);
                pane2.add(IDC1, 1, 1);

                Button add = style.litButton("Add card");
                GridPane.setHalignment(add, HPos.CENTER);
                pane2.add(add, 0, 2);
                add.setOnAction(l -> {
                    try {
                        long millis=System.currentTimeMillis();
                        java.sql.Date date=new java.sql.Date(millis);
                        Card card1 = new Card(4000,
                        					date,
                        					Integer.parseInt(IDC1.getSelectionModel().getSelectedItem().trim()));
                        cardQuery.insertData(card1);
                        Stage stage5 = new Stage();
                        GridPane pane5 = style.gridPane();
                        Label hello54 = new Label("inserted successfully");
                        hello54.setFont(Font.font(17));
                        hello54.setTextFill(Color.GREY);
                        pane5.add(hello54, 0, 0);
                        Button logo5 = style.logo();
                        pane5.add(logo5, 1, 0);
                        //Create Scene
                        Scene scene5 = new Scene(pane5);
                        stage5.setScene(scene5);
                        stage5.setTitle("The National Bank");
                        stage5.getIcons().add(new Image("TNB.png"));
                        stage5.show();
                    }catch (Exception e){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("Please Make sure you are inputting the right input\n"+e.getMessage());
                        alert.showAndWait();
                    }
                });

                Button cancel0 = style.litButton("Cancel");
                pane2.add(cancel0, 1, 2);
                GridPane.setHalignment(cancel0, HPos.RIGHT);
                cancel0.setOnAction(i -> stage2.close());

                Scene scene2 = new Scene(pane2);
                stage2.setScene(scene2);
                stage2.setTitle("The National Bank");
                stage2.getIcons().add(new Image("TNB.png"));
                stage2.show();
            });
        }else if(choice == 1) {
            //choice 1 for delete
            style.style(card,"Deletion options","card");
        }else if(choice ==2) {
            //choice 2 for search
            style.style(card,"Search options","card");
        }else if(choice == 3) {
            //choice 4 for update
            style.style(card,"Update options","card");
        }else {
            //view table
            card.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = new GridPane();
                pane2.setBackground(background);
                pane2.setPadding(new Insets(60, 60, 60, 60));
                pane2.setAlignment(Pos.CENTER);
                pane2.setHgap(10);
                pane2.setVgap(10);
                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                try {
                    cardQuery.getData();
                    //convert data from arraylist to observable arraylist
                    cardQuery.dataList = FXCollections.observableArrayList(cardQuery.data);
                    cardQuery.tableView(stage2,pane2);

                    stage2.setTitle("The National Bank");
                    stage2.getIcons().add(new Image("TNB.png"));
                    stage2.show();
                } catch (SQLException | ClassNotFoundException f) {
                    f.printStackTrace();
                }
            });
        }

        Button transaction = style.midButton("transaction.png");
        pane1.add(transaction, 1,3);

        if(choice==0) {
            transaction.setOnAction(k -> {
                Stage stage2 = new Stage();
                //Creating grid pane
                GridPane pane2 = style.gridPane();

                //A label to show the number of power sources
                Label hello1 = new Label(("Make Transaction"));
                hello1.setFont(Font.font(17));
                hello1.setTextFill(Color.GREY);
                pane2.add(hello1, 0, 0);

                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                //A label to show the number of power sources
                Label IDC = new Label(("Customer ID: "));
                IDC.setFont(Font.font(16));
                IDC.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(IDC , HPos.CENTER);
                pane2.add(IDC , 0, 1);

                ComboBox<String> IDC1 = new ComboBox<String>();
                IDC1.setBackground(background);
                IDC1.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                IDC1.setPrefSize(200, 30);
                customerQuery.comboBox(IDC1);
                pane2.add(IDC1, 1, 1);
                
                //A label to show the number of power sources
                Label IDC2 = new Label(("Account ID: "));
                IDC2.setFont(Font.font(16));
                IDC2.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(IDC2 , HPos.CENTER);
                pane2.add(IDC2 , 0, 2);

                ComboBox<String> IDC12 = new ComboBox<String>();
                IDC12.setBackground(background);
                IDC12.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                IDC12.setPrefSize(200, 30);
                accountQuery.comboBox(IDC12);
                pane2.add(IDC12, 1, 2);

                //A label to show the number of power sources
                Label IDE = new Label(("Employee ID: "));
                IDE.setFont(Font.font(16));
                IDE.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(IDE , HPos.CENTER);
                pane2.add(IDE , 0, 3);

                //User textfiled
                ComboBox<String> IDE1 = new ComboBox<String>();
                IDE1.setBackground(background);
                IDE1.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                IDE1.setPrefSize(200, 30);
                employeeQuery.comboBox(IDE1);
                pane2.add(IDE1, 1, 3);

                //A label to show the number of power sources
                Label type = new Label(("Transaction Type: "));
                type.setFont(Font.font(16));
                type.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(type , HPos.CENTER);
                pane2.add(type , 0, 4);

                ComboBox<String> comboBox = new ComboBox<String>();
                comboBox.getItems().add("Withdraw");
                comboBox.getItems().add("Deposit");
                comboBox.setBackground(background);
                comboBox.setStyle("-fx-border-color: lightblue;-fx-border-width: 1;-fx-background-radius: 0;-fx-background-color: transparent;");
                comboBox.setPrefSize(200, 30);
                comboBox.setValue("Withdraw");
                pane2.add(comboBox, 1, 4);

                Label amount = new Label(("Transaction amount: "));
                amount.setFont(Font.font(16));
                amount.setTextFill(Color.DARKSLATEBLUE);
                GridPane.setHalignment(amount , HPos.CENTER);
                pane2.add(amount , 0, 5);

                TextField amount1 = new TextField();
                GridPane.setHalignment(amount1, HPos.CENTER);
                amount1.setPrefSize(200, 30);
                amount1.setPromptText("1000");
                pane2.add(amount1, 1, 5);

                Button add = style.litButton("Add Transaction");
                GridPane.setHalignment(add, HPos.CENTER);
                pane2.add(add, 0, 6);
                add.setOnAction(l -> {
                	//IDC1-> customer ID
                	//IDC12-> account ID
                    try{
                        long millis=System.currentTimeMillis();
                        Date date =new Date(millis);
                        Transaction transaction1 = new Transaction(date,
                        										comboBox.getSelectionModel().getSelectedItem().trim(),
                        										Double.parseDouble(amount1.getText().trim()),
                        										Integer.parseInt(IDE1.getSelectionModel().getSelectedItem().trim()),
                        										Integer.parseInt(IDC1.getSelectionModel().getSelectedItem().trim()));
                        transactionQuery.insertData(transaction1);

                        ArrayList<Integer> tr = transactionQuery.id();
                        TransactionAccount ta = new TransactionAccount(Integer.parseInt(IDC12.getSelectionModel().getSelectedItem().trim()),
                        		tr.get(tr.size()-1));
                        transactionAccountQuery.insertData(ta);

                        String choicee = comboBox.getSelectionModel().getSelectedItem();
                        String sign="";
                        if(choicee.equalsIgnoreCase("Withdraw")) {
                        	sign ="-";
                        }else {
                        	sign ="+";
                        }
                        
                        boolean x = transactionAccountQuery.update(ta, sign);
                        if(x== true) {
		                    Stage stage5 = new Stage();
		                    GridPane pane5 = style.gridPane();
		                    
		                    Label hello54 = new Label("inserted successfully");
		                    hello54.setFont(Font.font(17));
		                    hello54.setTextFill(Color.GREY);
		                    pane5.add(hello54, 0, 0);
		                    Button logo5 = style.logo();
		                    pane5.add(logo5, 1, 0);
		                    
		                    //Create Scene
		                    Scene scene5 = new Scene(pane5);
		                    stage5.setScene(scene5);
		                    stage5.setTitle("The National Bank");
		                    stage5.getIcons().add(new Image("TNB.png"));
		                    stage5.show();
                        }
                    }catch (Exception e){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("Please Make sure you are inputting the right input\n" +e.getMessage());
                        alert.showAndWait();
                    }
                });

                Button cancel0 = style.litButton("Cancel");
                pane2.add(cancel0, 1, 6);
                GridPane.setHalignment(cancel0, HPos.RIGHT);
                cancel0.setOnAction(i -> stage2.close());

                //Create Scene
                Scene scene2 = new Scene(pane2);
                stage2.setScene(scene2);
                stage2.setTitle("The National Bank");
                stage2.getIcons().add(new Image("TNB.png"));
                stage2.show();
            });
        }else if(choice == 1) {
            //choice 1 for delete
            style.style(transaction,"Deletion options","transaction");
        }else if(choice ==2) {
            //choice 2 for search
            style.style(transaction,"Search options","transaction");
        }else if(choice == 3) {
            //choice 3 for update
            style.style(transaction,"Update options","transaction");
        }else {
            //view table
            transaction.setOnAction(k -> {
                Stage stage2 = new Stage();
                GridPane pane2 = new GridPane();
                pane2.setBackground(background);
                pane2.setPadding(new Insets(60, 60, 60, 60));
                pane2.setAlignment(Pos.CENTER);
                pane2.setHgap(10);
                pane2.setVgap(10);
                Button logo01 = style.logo();
                pane2.add(logo01, 1, 0);

                try {
                    transactionQuery.getData();
                    //convert data from arraylist to observable arraylist
                    transactionQuery.dataList = FXCollections.observableArrayList(transactionQuery.data);
                    transactionQuery.tableView(stage2,pane2);

                    stage2.setTitle("The National Bank");
                    stage2.getIcons().add(new Image("TNB.png"));
                    stage2.show();
                } catch (SQLException | ClassNotFoundException f) {
                    f.printStackTrace();
                }
            });
        }

        Button exit =  style.midButton("close.png");
        pane1.add(exit, 2,3);
        exit.setOnAction(k -> {
            stage1.close();
        });
        Scene scene1 = new Scene(pane1);
        stage1.setScene(scene1);
        stage1.setTitle("The National Bank");
        stage1.getIcons().add(new Image("TNB.png"));
        stage1.show();
    }

}