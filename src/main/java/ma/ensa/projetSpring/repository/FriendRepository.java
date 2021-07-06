package ma.ensa.projetSpring.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;
import ma.ensa.projetSpring.beans.Friend;
import ma.ensa.projetSpring.beans.FriendId;
import ma.ensa.projetSpring.beans.User;

@Repository
public interface FriendRepository extends JpaRepository<Friend, FriendId>  {
	
	@Query(" SELECT f From Friend  f WHERE f.etat=2 and (f.id.user1Id=:id OR f.id.user2Id=:id )")
	List<Friend> findFriends(@Param("id") int id);
	
	@Query(" SELECT f From Friend  f WHERE f.etat=1 and f.id.user1Id=:id ")
	List<Friend> findFriendsRequeste(@Param("id") int id);
	
	@Query(" SELECT f From Friend  f WHERE f.etat=1 and f.id.user2Id=:id ")
	List<Friend> findRecievedRequests(@Param("id") int id);
	
	
	@Query(" SELECT f From Friend  f WHERE f.etat=1 or f.etat=2 or f.etat=3 and ( f.id.user1Id=:id or f.id.user2Id=:id) ")
	List<Friend> findNoRequests(@Param("id") int id);
	
	@Query("SELECT f FROM Friend f WHERE  f.etat=3 and f.id.user1Id=:id")
	Friend findByIdd(@Param("id") int id);
	
	
}
