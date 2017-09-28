package com.practice.springcloudlatencydemo.dataservice2;

import java.util.Hashtable;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DataService2Application {

	@Autowired
	private Tracer tracer;


	public static void main(String[] args) {
		SpringApplication.run(DataService2Application.class, args);
	}


	@RequestMapping(value="/customer/{cid}/vehicledetails", method=RequestMethod.GET)
	public @ResponseBody String getCustomerVehicleDetails(@PathVariable Integer cid) throws  InterruptedException{

		String result;

		Span s = this.tracer.createSpan("LookupVehicle");

		try {

			this.tracer.addTag("cutomerid",cid.toString());
			s.logEvent("Database query started");

			Thread.sleep(500);

			Hashtable<Integer, String> vehicles = new Hashtable<Integer, String>();
			vehicles.put(100, "Lincoln Continental; Plate SNUG30");
			vehicles.put(101, "Chevrolet Camaro; Plate R7TYR43");
			vehicles.put(102, "Volkswagen Beetle; Plate 6CVI3E2");

			result = vehicles.get(cid);

			s.logEvent("Database query Finished");

		}finally {
			this.tracer.close(s);
		}

		return result;
	}
}
