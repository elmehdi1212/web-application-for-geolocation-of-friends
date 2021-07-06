package ma.ensa.projetSpring.beans;



import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;

@Entity
public class Friend {
	@EmbeddedId
	private FriendId id;
	
	@ManyToOne
	@MapsId("user1Id")
	@JoinColumn(name = "user1_id")
	private User user1;

	@ManyToOne
	@MapsId("user2Id")
	@JoinColumn(name = "user2_id")
	private User user2;
	
	
	private String date;
	
	private int etat;

	public Friend() {
		super();
	}
	

	public Friend(FriendId id, User user1, User user2, String date, int etat) {
		super();
		this.id = id;
		this.user1 = user1;
		this.user2 = user2;
		this.date = date;
		this.etat = etat;
	}



	public FriendId getId() {
		return id;
	}

	public void setId(FriendId id) {
		this.id = id;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
}

