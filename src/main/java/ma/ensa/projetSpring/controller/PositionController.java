package ma.ensa.projetSpring.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ensa.projetSpring.beans.Position;
import ma.ensa.projetSpring.beans.User;
import ma.ensa.projetSpring.repository.PositionRepository;
@CrossOrigin(origins="*",maxAge=3600)
@RestController
@RequestMapping("positions")
public class PositionController {
	@Autowired
	private PositionRepository positionRepository;
	
	@PostMapping("/save")
	public  void save(@RequestBody Position position){
		positionRepository.save(position);
	}
	@GetMapping("/all")
	public List<Position>findAll(){
		return positionRepository.findAll();
	}
	@GetMapping(value = "/count")
	public long countPosition() {
		return positionRepository.count();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Position p = positionRepository.findById(Integer.parseInt(id));
		 positionRepository.delete(p);
	}
	
	@GetMapping("/user/{id}")
	public Position getPositionByUser(@PathVariable (required = true) String id){
		Position u = positionRepository.findById(Integer.parseInt(id));
		return u;
	}
	
	@GetMapping("/userPositionsBetweenTwoDates/{id}/{date1}/{date2}")
	public Collection<?> getPositionsBetweenTwoDate(@PathVariable (required = true) String id,@PathVariable (required = true) String date1,@PathVariable (required = true) String date2){
		Collection<?> u = positionRepository.findUserPositionBetweenTwoDate(Integer.parseInt(id),date1,date2);
		return u;
	}


	
	

	

	

}
