package src;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Site;

public class MainApp extends Application {

	//declare the fields

private Stage primaryStage;
private BorderPane rootLayout;

//list of sites to be displayed
private ObservableList<Site> siteData = FXCollections.observableArrayList();

	public MainApp(){

		siteData.add(new Site("UCLA","Los Angeles"));
	}

	public ObservableList<Site> getSiteData(){
		return siteData;
	}
	@Override
	public void start(Stage primaryStage) {
		//refer initialized instance

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SimpleCTMS");

		initRootLayout();

		showSiteView();

	}

	public void initRootLayout(){
		try{
			//attempt to load root layout from fxml
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			//show Scene which now contains rootLayout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(IOException e){
			System.out.println("From root");
		}
	}

	//now need to show th main overview within theroot layout
	public void showSiteView(){
		try{
			//load the main app
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("SiteView.fxml"));
			AnchorPane siteView = (AnchorPane) loader.load();

			//set this newly loaded view into the center of the rootLayout
			rootLayout.setCenter(siteView);

			SiteViewController controller = loader.getController();
			controller.setMainApp(this);
		}
		catch (IOException e){
			System.out.println("from main");
		}
	}

	//return the main stage
	public Stage getPrimaryStage(){
		return primaryStage;
	}

	public static void main(String args[]) {
		launch(args);
	}

}