package com.Mvc.springMvc.vehicleController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.Mvc.springMvc.Module.Vehicle;
import com.Mvc.springMvc.Sevice.VehicleService;

@RestController
public class Controller {
	
	@Autowired
	VehicleService ser;
	
	@PostMapping("/addvehicle")
    ResponseEntity<Vehicle> AddVehicle(@RequestBody Vehicle v)
    {
      return  new ResponseEntity<Vehicle>(ser.addVehicle(v),HttpStatus.CREATED);
    }
	
	@DeleteMapping("/deletevehicle")
    void deleteVehicle(@RequestHeader Integer id)
    {
      ser.deleteVehicle(id);
    }
	
	@GetMapping("/getAll")
    ResponseEntity <List<Vehicle>> getAll()
    {
      return  new ResponseEntity<List<Vehicle>>(ser.getAllvehicle(),HttpStatus.FOUND);
    }
	
	@GetMapping("/getById")
    ResponseEntity<Vehicle> getById( @RequestHeader Integer id)
    {
      return  new ResponseEntity<Vehicle>(ser.basedOnId(id),HttpStatus.FOUND);
    }
	
	@GetMapping("/getByColor")
    ResponseEntity<List<Vehicle>> getByColor( @RequestHeader String color)
    {
      return  new ResponseEntity<List<Vehicle>>(ser.basedOnColor(color),HttpStatus.FOUND);
    }
	
	@GetMapping("/getByPrice")
    ResponseEntity<List<Vehicle>> getByPrice( @RequestHeader double price)
    {
      return  new ResponseEntity<List<Vehicle>>(ser.basedOnPrice(price),HttpStatus.FOUND);
    }
	
	@GetMapping("/above1lac")
    ResponseEntity<List<Vehicle>> above1lac()
    {
      return  new ResponseEntity<List<Vehicle>>(ser.priceFilter(),HttpStatus.FOUND);
    }
	
	@GetMapping("/sortByPrice")
    ResponseEntity<List<Vehicle>> sortByPrice()
    {
      return  new ResponseEntity<List<Vehicle>>(ser.Sortprice(),HttpStatus.FOUND);
    }
	
	@PutMapping("/updateVehicle")
    ResponseEntity<Vehicle> Update(@RequestBody Vehicle v)
    {
      return  new ResponseEntity<Vehicle>(ser.UpdateVehicle(v),HttpStatus.ACCEPTED);
    }
    
	

	
}
