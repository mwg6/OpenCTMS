package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {
//making this as a way to convert the type LocalDate to a string
	
	//making an easily modified variable that will feed the rest of the class and called imports
	private static final String DATE_PATTERN = "dd.MM.yyyy";
	
	//passing that variable to the method which can use it	
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
	
	//force the date passed to be in expected format
	public static String format(LocalDate date){
		
		if(date==null){
			return null;
		}
		return DATE_FORMATTER.format(date);
	}
	//convert strings to expected date format
	public static LocalDate parse(String dateString){
		
		try{
			//below LocalDate::from means use method from in LocalDate(?)
			return DATE_FORMATTER.parse(dateString,LocalDate::from);
		}
		catch (DateTimeParseException e){
			return null;		
		}
	}
	//method to check if passed strings are acceptable dates
	boolean validDate(String dateString){
		
		if(DateUtil.parse(dateString) != null){
			return true;
		}
		return false;
	}
	
	
	}
	
