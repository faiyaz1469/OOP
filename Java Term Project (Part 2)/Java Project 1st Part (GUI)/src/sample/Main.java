package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import java.util.List;
import java.io.IOException;


public class Main extends Application {
    FileIO f = new FileIO();
    Input in = new Input();
    Output out = new Output();
    PlayerList pList = new PlayerList();
    Player plar = new Player();
    List<Player> playerList = pList.getList();

    private TableView<FileChooserSample.Person> table = new TableView<FileChooserSample.Person>();
    private final ObservableList<FileChooserSample.Person> data =
            FXCollections.observableArrayList();
    final HBox hb = new HBox();
    Stage stage;

    public Main() throws Exception {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        showMainMenuPage();
    }

    public void showMainMenuPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MainController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Main Menu:");
        stage.setScene(new Scene(root, 401, 291));
        stage.show();
    }

    public void showPlayerMenuPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("playerMenu.fxml"));
        Parent root = loader.load();

        // Loading the controller
        PlayerController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Player Searching Options:");
        stage.setScene(new Scene(root, 386, 367));
        stage.show();
    }

    public void showClubMenuPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clubMenu.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ClubController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Club Searching Options:");
        stage.setScene(new Scene(root, 531, 327));
        stage.show();
    }

    public void showPlayerInputPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("plrInput.fxml"));
        Parent root = loader.load();

        // Loading the controller
        PlrController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Player Name:");
        stage.setScene(new Scene(root, 449, 241));
        stage.show();
    }

    public void showClubInputPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clubInput.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ClubMaxSalaryController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Club Name:");
        stage.setScene(new Scene(root, 413, 241));
        stage.show();
    }

    public void showClubInputPage2() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clubInput2.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ClubMaxAgeController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Club Name:");
        stage.setScene(new Scene(root, 413, 241));
        stage.show();
    }

    public void showClubInputPage3() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clubInput3.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ClubMaxHeightController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Club Name:");
        stage.setScene(new Scene(root, 413, 241));
        stage.show();
    }

    public void showClubInputPage4() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clubInput4.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ClubTotalSalaryController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Club Name:");
        stage.setScene(new Scene(root, 413, 241));
        stage.show();
    }

    public void showCCInputPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ccInput.fxml"));
        Parent root = loader.load();

        // Loading the controller
        CCController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Club & Country Name:");
        stage.setScene(new Scene(root, 449, 241));
        stage.show();
    }

    public void showPosInputPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("posInput.fxml"));
        Parent root = loader.load();

        // Loading the controller
        PosController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Player Position:");
        stage.setScene(new Scene(root, 449, 241));
        stage.show();
    }

    public void showRangeInputPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("rangeInput.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SalaryController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Maximum & Minimum Salary Range:");
        stage.setScene(new Scene(root, 449, 241));
        stage.show();
    }

    public void showPLayerInfoInputPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addPlayerInfoInput.fxml"));
        Parent root = loader.load();

        // Loading the controller
        AddPlrInfoController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Add Player Information:");
        stage.setScene(new Scene(root, 545, 497));
        stage.show();
    }

    public void showErrorPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("error.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ErrorController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Error:");
        stage.setScene(new Scene(root, 222, 248));
        stage.show();
    }
    public void showPlayerInfoPage(String plname,String cname, int age, double height, String clname, String posname, int nmbr, double salary) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("plrInfo.fxml"));
        Parent root = loader.load();

        // Loading the controller
        PlrInfoController controller = loader.getController();
        controller.init(plname,cname,age,height,clname,posname,nmbr,salary);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Player Info:");
        stage.setScene(new Scene(root, 600, 459));
        stage.show();
    }

    public void showPlayerCountInfo() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("playerCountInfo.fxml"));
        Parent root = loader.load();

        // Loading the controller
        PlayerCountTableController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Player Count Info:");
        stage.setScene(new Scene(root, 175, 519));
        stage.show();
    }

    public void showCCPlayersInfoPageOld (String Country, String Club) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ccPlayersInfo.fxml"));
        Parent root = loader.load();

        // Loading the controller
        CCTableController controller = loader.getController();
        controller.load(Country,Club);
        controller.setMain(this);
        pList.setMain(this);

        // Set the primary stage
        stage.setTitle("Players Info:");
        stage.setScene(new Scene(root, 686, 436));
        stage.show();
    }


    public void showPosPlayerInfoPage(String psName) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("posPlayersInfo.fxml"));
        Parent root = loader.load();

        // Loading the controller
        PosTableController controller = loader.getController();
        controller.load(psName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Players Position Info:");
        stage.setScene(new Scene(root, 686, 436));
        stage.show();
    }
    public void showSalaryInfoPage(double maxRange, double minRange) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("salaryPlayersInfo.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SalaryTableController controller = loader.getController();
        controller.load(maxRange,minRange);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Players Salary Info:");
        stage.setScene(new Scene(root, 686, 436));
        stage.show();
    }

    public void showClubMaxSalaryPlayerInfoPage(String clName) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clubMaxSalaryPlayersInfo.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ClMaxSalPlTableController controller = loader.getController();
        controller.load(clName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Players Salary Info of a Club:");
        stage.setScene(new Scene(root, 686, 436));
        stage.show();
    }

    public void showClubMaxAgePlayerInfoPage(String clName) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clubMaxAgePlayersInfo.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ClMaxAgePlTableController controller = loader.getController();
        controller.load(clName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Players Age Info of a Club:");
        stage.setScene(new Scene(root, 686, 436));
        stage.show();
    }

    public void showClubMaxHeightPlayerInfoPage(String clName) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clubMaxHeightPlayersInfo.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ClMaxHeightPlTableController controller = loader.getController();
        controller.load(clName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Players Height Info of a Club:");
        stage.setScene(new Scene(root, 686, 436));
        stage.show();
    }

    public void showClubTotalSalaryPlayerInfoPage(String clName) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clubTotalSalaryInfo.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ClTotalSalaryController controller = loader.getController();
        controller.init(clName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Total Yearly Salary Info of a Club:");
        stage.setScene(new Scene(root, 546, 249));
        stage.show();
    }

    public void showAddConfirmationPage(String player) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addConfirmation.fxml"));
        Parent root = loader.load();

        // Loading the controller
        AddConfirmationController controller = loader.getController();
        controller.init(player);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Add Player Confirmation:");
        stage.setScene(new Scene(root, 501, 199));
        stage.show();
    }


    public static void main(String[] args) {
        // This will launch the JavaFX application
        launch(args);

    }

    public void closeMainMenuPage() throws Exception {

        stage.close();
       // f.writeToFile(playerList);
    }



}
