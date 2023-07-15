package com.Mvc.springMvc.ServiceImpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Mvc.springMvc.Exception.VehicleException;
import com.Mvc.springMvc.Module.Vehicle;
import com.Mvc.springMvc.Repo.VehicleRepo;
import com.Mvc.springMvc.Sevice.VehicleService;

@Service
public class VehicleImpl implements VehicleService{

	@Autowired
	VehicleRepo repo;
	
	@Override
	public Vehicle addVehicle(Vehicle v) {
		return  repo.save(v);
		
	}

	@Override
	public void deleteVehicle(Integer id) {
		Vehicle v=repo.findById(id).orElse(null);
		if(v!=null)
		{
			System.out.println("Vehicle details deleted...!!!");
			repo.deleteById(id);
		}
		else {
//			throw new VehicleException();
			System.out.println("data not present... or already deleted...!!!");
		}
		
	}

	@Override
	public List<Vehicle> getAllvehicle() {
		return repo.getAlldetails();
	}

	@Override
	public Vehicle basedOnId(Integer id) {
		
		return repo.findById(id).orElseThrow(()->new VehicleException());

	}

	@Override
	public List<Vehicle> basedOnColor(String color) {
		return repo.basedOnColor(color);
	}

	@Override
	public List<Vehicle> basedOnPrice(Double price) {
		return repo.basedOnPrice(price);
	}

	@Override
	public List<Vehicle> priceFilter() {
		return repo.priceFilter();
	}

	@Override
	public List<Vehicle> Sortprice() {
		return repo.sortByPrice();
	}
	
	@Override
	public Vehicle UpdateVehicle(Vehicle v) {
    
		Vehicle v1=repo.findById(v.getVid()).orElse(null);
		if(v1!=null)
		{
			v1.setVname(v.getVname());
			v1.setVcolor(v.getVcolor());
			v1.setVmodel(v.getVmodel());
			v1.setVprice(v.getVprice());
			return repo.save(v1);
		}
		else {
			throw new VehicleException();
			//System.out.println("data not present... or already deleted...!!!");
		}
		
	}

}
