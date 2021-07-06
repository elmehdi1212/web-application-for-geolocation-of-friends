package ma.ensa.projetSpring.beans;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String imei;
	private String date_naissance;
	private String sexe;
	private boolean isActive;
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Position> positions;
	
	@JsonIgnore
	@OneToMany(mappedBy="user1")
	private List<Friend> friends1;
	
	@JsonIgnore
	@OneToMany(mappedBy="user2")
	private List<Friend> friends2;
	
	public User() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}

	public List<Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public List<Friend> getFriends1() {
		return friends1;
	}
	public void setFriends1(List<Friend> friends1) {
		this.friends1 = friends1;
	}
	public List<Friend> getFriends2() {
		return friends2;
	}
	public void setFriends2(List<Friend> friends2) {
		this.friends2 = friends2;
	}
	
	
	
	
	
	
	
	

}
