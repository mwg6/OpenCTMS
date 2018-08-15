package model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Site {

	private final StringProperty siteName;
	private final StringProperty location;
	private final IntegerProperty patients;
	private final IntegerProperty activeAEs;
	private final IntegerProperty stock;
	private final ObjectProperty<LocalDate> lastTreatment;
	private final ObjectProperty<LocalDate> restockDate;

	/*
	 public Site(String string, String string2){
		this(null,null);
	}
	 */
	public Site(String siteName, String location){

		this.siteName = new SimpleStringProperty(siteName);
		this.location = new SimpleStringProperty(location);

		this.patients = new SimpleIntegerProperty(-1);
		this.activeAEs = new SimpleIntegerProperty(-1);
		this.stock = new SimpleIntegerProperty(-1);
		this.lastTreatment = new SimpleObjectProperty<LocalDate>(LocalDate.of(2001,12,21));
		this.restockDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(2001,12,21));

	}
	//sitename getters and setters
	public String getSiteName(){
		return siteName.get();
	}
	public void setSiteName(String siteName){
		this.siteName.set(siteName);
	}
	public StringProperty siteNameProperty(){
		return siteName;
	}

	//location setters and getters
	public String getLocation(){
		return location.get();
	}
	public void setLocation(String location){
		this.location.set(location);
	}
	public StringProperty locationProperty(){
		return location;
	}

	//patient setters and getters
	public int getPatients(){
		return patients.get();
	}
	public void setPatients(int patients){
		this.patients.set(patients);
	}
	public IntegerProperty patientsProperty(){
		return patients;
	}

	//activeAEs getters and setters
	public int getActiveAEs(){
		return activeAEs.get();
	}
	public void setActiveAEs(int activeAEs){
		this.activeAEs.set(activeAEs);
	}
	public IntegerProperty activeAEsProperty(){
		return activeAEs;
	}

	//stock getters and setters
		public int getStock(){
			return stock.get();
		}
		public void setStock(int stock){
			this.stock.set(stock);
		}
		public IntegerProperty stockProperty(){
			return stock;
		}

	//lastTreatment getters and setters
		public LocalDate getLastTreatment(){
			return lastTreatment.get();
		}
		public void setLastTreatment(LocalDate lastTreatment){
			this.lastTreatment.set(lastTreatment);
		}
		public ObjectProperty<LocalDate> lastTreatmentProperty(){
			return lastTreatment;
		}

	//lastTreatment getters and setters
		public LocalDate getRestockDate(){
			return restockDate.get();
		}
		public void setRestockDate(LocalDate restockDate){
			this.restockDate.set(restockDate);
		}
		public ObjectProperty<LocalDate> restockDateProperty(){
			return restockDate;
		}

}