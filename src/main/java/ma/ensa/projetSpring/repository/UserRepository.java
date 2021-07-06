package ma.ensa.projetSpring.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.ensa.projetSpring.beans.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findById(int id);
	
	

	@Query("SELECT u FROM User u WHERE u.id NOT IN (SELECT f.id.user1Id as userId From Friend f WHERE f.etat=1 or f.etat=2 or f.etat=3 and  f.id.user2Id=:id) AND u.id NOT IN ( SELECT f2.id.user2Id as userId From Friend f2 WHERE f2.etat=1 Or f2.etat=2 or f2.etat=3 and f2.id.user1Id=:id )")
	List<User> findUsers(@Param("id")  int id);


}
