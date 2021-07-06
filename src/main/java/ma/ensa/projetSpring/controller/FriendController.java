package ma.ensa.projetSpring.controller;

import java.util.Date;
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

import ma.ensa.projetSpring.beans.Friend;
import ma.ensa.projetSpring.beans.FriendId;
import ma.ensa.projetSpring.beans.User;
import ma.ensa.projetSpring.repository.FriendRepository;

@CrossOrigin(origins="*",maxAge=3600)
@RestController
@RequestMapping("friends")
public class FriendController {
	
	@Autowired
	private FriendRepository friendRepository;
	
    @PostMapping("/save")
	public void save(@RequestBody Friend friend) {	
   
   	friendRepository.save(friend);

   	}
   @GetMapping("/all")
	public List<Friend>findAll() {
		return friendRepository.findAll();
		
   }
    @GetMapping("/friend/{id}")
	public List<Friend> findFri(@PathVariable (required = true) String id){
		return  friendRepository.findFriends(Integer.parseInt(id));
		
	}
	
	
//	@GetMapping(value = "/count")
//	public long countPosition() {
//		return friendRepository.count();
//	}
//	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Friend  f= friendRepository.findByIdd(Integer.parseInt(id));
		friendRepository.delete(f);
	}
	
	

}
