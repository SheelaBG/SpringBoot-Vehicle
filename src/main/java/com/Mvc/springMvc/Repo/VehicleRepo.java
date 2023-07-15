package com.Mvc.springMvc.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Mvc.springMvc.Module.Vehicle;

public interface VehicleRepo extends CrudRepository<Vehicle, Integer>{
	
	@Query(value="select * from vehicle ",nativeQuery=true)
	List<Vehicle> getAlldetails();
	
	@Query(value="select * from vehicle where vcolor=?1 ",nativeQuery=true)
	List<Vehicle> basedOnColor(String color);
	
	@Query(value="select * from vehicle where vprice>=?1 order by vprice,vcolor asc",nativeQuery=true)
	List<Vehicle> basedOnPrice(double price);
	
	@Query(value="select * from vehicle where vprice>=100000 ",nativeQuery=true)
	List<Vehicle> priceFilter();
	
	@Query(value="select * from vehicle order by vprice asc ",nativeQuery=true)
	List<Vehicle> sortByPrice();

}
