package _07_California_Weather;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 *          
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api 
 */

public class CaliforniaWeather {
	
	void start() {
		CaliforniaWeather weather=new CaliforniaWeather();
		weather.searchConditions();
	}
    
   // void start() {
        HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
        
        // All city keys have the first letter capitalized of each word
     //   String cityName = Utilities.capitalizeWords( "National City" );
       // WeatherData datum = weatherData.get(cityName);
        
       // if( datum == null ) {
           // System.out.println("Unable to find weather data for: " + cityName);
      //  }// else {
            //System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        //}
   // }
    
    void  getTemperature() {
    	String city=JOptionPane.showInputDialog("Search for a California City to get the temperature!");
    	 HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
    	 String formattedCity=Utilities.capitalizeWords(city);
    	 WeatherData data= weatherData.get(formattedCity);
    	 if(data==null) {
    		 JOptionPane.showMessageDialog(null, "Sorry, there is no weather data for: "+formattedCity);
    	 }
    	 else {
    		 JOptionPane.showMessageDialog(null, "The temperature in "+formattedCity+" is "+data.temperatureF+" F");
    	 }
    }
    
    void searchConditions() {
    	String condition=JOptionPane.showInputDialog("Input a weather condition to see all the cities that are that weather");
    	 HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
    	 ArrayList <String> cities=new ArrayList <String>();
    	 for(String city: weatherData.keySet()) {
    		 if(weatherData.get(city).weatherSummary.contains(condition)){
    			 cities.add(city+="\n");
    		 }
    	 }
    	 JOptionPane.showMessageDialog(null, "The list of cities that are "+condition+" are: "+cities);
    }
    void getCity() {
    	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
    	String hello=JOptionPane.showInputDialog("Enter a minimum temperature");
    	Double minimum=Double.parseDouble(hello);
    	String gdat=JOptionPane.showInputDialog("Enter a maximum temperature");
    	Double maximum=Double.parseDouble(gdat);
    	ArrayList <String> cities=new ArrayList <String>();
    	for(String s: weatherData.keySet()) {
    		if(weatherData.get(s).temperatureF>=minimum&&weatherData.get(s).temperatureF<=maximum) {
    			cities.add(s+="\n");
    		}
    		else {
    			JOptionPane.showMessageDialog(null, "No city has that range of temperature");
    		}
    	}
    	JOptionPane.showMessageDialog(null, "The list of cities in that range of temperature are: "+cities);
    }
}
