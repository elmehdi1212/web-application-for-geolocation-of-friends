package ma.ensa.projetSpring.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.ensa.projetSpring.beans.Friend;
import ma.ensa.projetSpring.beans.Position;



public interface PositionRepository extends JpaRepository<Position, Integer> {
	
	
	@Query(" SELECT p From Position  p WHERE p.id=(SELECT max(p.id) from Position p Where p.user.id=:id2 Order By p.id DESC )")
	Position findById(@Param("id2") int id2);
	
	@Query("SELECT p from Position p where p.user.id=:id AND p.date Between :date1 and :date2")
	Collection<?> findUserPositionBetweenTwoDate(@Param("id") int id,@Param("date1") String date1,@Param("date2") String date2);
	

}
