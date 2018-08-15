package src;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.DateUtil;
import model.Site;


public class SiteViewController {

	@FXML
	private TableView<Site> siteTable;
	@FXML
	private TableColumn<Site, String> siteNameColumn;
	@FXML
	private TableColumn<Site, String> locationNameColumn;


	@FXML
	private Label siteNameLabel;
	@FXML
	private Label locationNameLabel;
	@FXML
	private Label patientsLabel;
	@FXML
	private Label In_StockLabel;
	@FXML
	private Label Next_Treatment_DateLabel;
	@FXML
	private Label Out_Of_StockLabel;
	@FXML
	private Label Open_AEsLabel;
	@FXML
	private Label Last_Quarterly_ReportLabel;

	private MainApp mainApp;

	public SiteViewController(){

	}

	@FXML
	private void initialize(){
		siteNameColumn.setCellValueFactory(cellData -> cellData.getValue().siteNameProperty());
		locationNameColumn.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
		
		//clear site details
		showSiteDetails(null);
		
		//listen for site selections
		//the advantage here of the lambda expression is that we are adding the listener to the new value without writing the executable code
		siteTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showSiteDetails(newValue));

	}
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;

		siteTable.setItems(mainApp.getSiteData());
	}
	private void showSiteDetails(Site site){

		if(site != null){

			siteNameLabel.setText(site.getSiteName());
			locationNameLabel.setText(site.getLocation());
			patientsLabel.setText(Integer.toString(site.getPatients()));
			Open_AEsLabel.setText(Integer.toString(site.getActiveAEs()));
			In_StockLabel.setText(Integer.toString(site.getStock()));
			Next_Treatment_DateLabel.setText(DateUtil.format(site.getLastTreatment()));
			
		}
		else{
			siteNameLabel.setText(null);
			locationNameLabel.setText(null);
			patientsLabel.setText(null);
			Open_AEsLabel.setText(null);
			In_StockLabel.setText(null);
			Next_Treatment_DateLabel.setText(null);
		}
		}
}
