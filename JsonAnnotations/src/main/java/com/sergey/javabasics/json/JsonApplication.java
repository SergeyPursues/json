package com.sergey.javabasics.json;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sergey.javabasics.json.model.Car;

@SpringBootApplication
public class JsonApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException  {
		SpringApplication.run(JsonApplication.class, args);
	    
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    Car car = mapper.readValue(new File("src/main/resources/inputfile.json"), Car.class);
	    mapper.writeValue(new File("src/main/resources/outputfile.json"), car);
	    System.out.println(car);
	}
}
	