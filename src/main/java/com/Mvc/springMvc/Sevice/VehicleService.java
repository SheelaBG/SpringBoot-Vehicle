package com.Mvc.springMvc.Sevice;

import java.util.List;

import com.Mvc.springMvc.Module.Vehicle;

public interface VehicleService {
	
	Vehicle addVehicle(Vehicle v);
	
	void deleteVehicle(Integer id);
	
	List<Vehicle> getAllvehicle();
	
	Vehicle basedOnId(Integer id);
	
	List<Vehicle> basedOnColor(String color);
	
	List<Vehicle> basedOnPrice(Double price);
	
	List<Vehicle> priceFilter();
	
	List<Vehicle> Sortprice();
	
	Vehicle UpdateVehicle(Vehicle v);
	
	

}
