package ma.ensa.projetSpring.controller;

import java.util.ArrayList;
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

import ma.ensa.projetSpring.beans.Friend;
import ma.ensa.projetSpring.beans.Position;
import ma.ensa.projetSpring.beans.User;
import ma.ensa.projetSpring.repository.FriendRepository;
import ma.ensa.projetSpring.repository.UserRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FriendRepository friendRepository;
	
	@PostMapping("/save")
	public void save(@RequestBody User user) {
		userRepository.save(user);
	}
	@GetMapping("/all")
	public List<User>findAll() {
		return userRepository.findAll();
	}
	
	@GetMapping(value = "/count")
	public long countPosition() {
		return userRepository.count();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable (required = true) String id){
		User u = userRepository.findById(Integer.parseInt(id));
		return u;
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		User u = userRepository.findById(Integer.parseInt(id));
		userRepository.delete(u);
	}
	
	@GetMapping("/findFriends/{id}")
	public List<User> findFriends(@PathVariable(required = true) String id){
		List<User> users=new ArrayList<User>();
		List<Friend> friends=friendRepository.findFriends(Integer.parseInt(id));
		for(int i=0;i<friends.size();i++) {
			if(Integer.parseInt(id)==friends.get(i).getId().getUser1Id()) {
				users.add(userRepository.findById(friends.get(i).getId().getUser2Id()));
			}
			else
			{
				
			users.add(userRepository.findById(friends.get(i).getId().getUser1Id()));
				
				
			}
		}
		return users;
		
	}
	
	
	@GetMapping("/findRequests/{id}")
	public List<User> findRequests(@PathVariable(required = true) String id){
		List<User> users=new ArrayList<User>();
		List<Friend> friends=friendRepository.findFriendsRequeste(Integer.parseInt(id));
		for(int i=0;i<friends.size();i++) {
			if(Integer.parseInt(id)==friends.get(i).getId().getUser1Id()) {
				users.add(userRepository.findById(friends.get(i).getId().getUser2Id()));
			}
			else
			{
				
			users.add(userRepository.findById(friends.get(i).getId().getUser1Id()));
				
				
			}
		}
		return users;
		
	}
	
	
	@GetMapping("/findRecievdRequests/{id}")
	public List<User> findRecievedRequest(@PathVariable(required = true) String id){
		List<User> users=new ArrayList<User>();
		List<Friend> friends=friendRepository.findRecievedRequests(Integer.parseInt(id));
		for(int i=0;i<friends.size();i++) {
			if(Integer.parseInt(id)==friends.get(i).getId().getUser1Id()) {
				users.add(userRepository.findById(friends.get(i).getId().getUser2Id()));
			}
			else
			{
				
			users.add(userRepository.findById(friends.get(i).getId().getUser1Id()));
				
				
			}
		}
		return users;
		
	}
	
	
	@GetMapping("/findNoRequests/{id}")
	public List<User> findNoRequest(@PathVariable(required = true) String id){
		List<User> users=new ArrayList<User>();
		List<Friend> friends=friendRepository.findNoRequests(Integer.parseInt(id));
		for(int i=0;i<friends.size();i++) {
			if(Integer.parseInt(id)==friends.get(i).getId().getUser1Id()) {
				users.add(userRepository.findById(friends.get(i).getId().getUser2Id()));
			}
			else
			{
				
			users.add(userRepository.findById(friends.get(i).getId().getUser1Id()));
				
				
			}
		}
		return users;
		
	}
	
	
	@GetMapping("/allUsers/{id}")
	public List<User>  findAlll(@PathVariable(required = true) String id) {
		return userRepository.findUsers(Integer.parseInt(id));
	}
	

	


}
