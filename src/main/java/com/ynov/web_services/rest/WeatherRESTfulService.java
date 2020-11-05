package com.ynov.web_services.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

public class WeatherRESTfulService {

	
		//
	   // http://localhost:8080/contextPath/rest/weather/{location}/{date}
	   // Example:
	   // http://localhost:8080/contextPath/rest/weather/chicago/2016-09-27
	   // http://localhost:8080/contextPath/rest/weather/hanoi/2016-09-27
	   //
	   @Path("{location}/{date}")
	   @GET
	   @Produces("application/json")
	   public String getWeather_JSON(@PathParam("location") String location,//
	           @PathParam("date") String dateStr) {
	     
	       Date date = null;
    	   DateFormat df = DateFormat.getDateTimeInstance(
    		        DateFormat.FULL,
    		        DateFormat.FULL);;
	       if (dateStr == null || dateStr.length() == 0) {
	           date = new Date();
	       } else {
	           try {
	               date = df.parse(dateStr);
	           } catch (ParseException e) {
	               date = new Date();
	           }
	       }
	       dateStr = df.format(date);
	 
	       String[] weathers = new String[] { "Hot", "Rain", "Cold" };
	       int i = new Random().nextInt(3);
	       String weather = weathers[i];
	 
	       return "{" //
	               + "'date': '" + dateStr + "'," //
	               + "'location': '" + location + "'," //
	               + "'info': '" + weather + "'" //
	               + "}";
	   }
	 
	   //
	   // http://localhost:8080/contextPath/rest/weather/{location}
	   // Example:
	   // http://localhost:8080/contextPath/rest/weather/chicago
	   // http://localhost:8080/contextPath/rest/weather/hanoi
	   //
	   @Path("{location}")
	   @GET
	   @Produces("application/json")
	   public String getWeather_JSON(@PathParam("location") String location) {
	       return getWeather_JSON(location, null);
	   }
	
	
	
}
