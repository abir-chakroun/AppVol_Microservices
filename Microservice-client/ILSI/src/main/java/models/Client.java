package models;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Table
@Entity(name = "Client")
public class Client   {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Num;
	
	@NotNull(message = "Name exactly the same as in your passeport.")
    private String FullName;
	@NotNull(message = "Gender cannot be null or empty.")
    private String Gender;
    @NotNull(message = "Adress cannot be null or empty.")
    private City Adress;
    @Column(length = 20)
    @NotNull(message = "Email cannot be null or empty.")
    private String Email;
    @NotNull(message = "Tel cannot be null or empty.")
    private Long Tel;
    @NotNull(message = "idNumber cannot be null or empty.")
    private Long idNumber;
    @NotNull(message = "passeportNumber cannot be null or empty.")
    private Long passeportNumber;


    public Client() {
    }

    public Long getId() {
        return Num;
    }


	public Long getNum() {
		return Num;
	}

	public void setNum(Long num) {
		Num = num;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String n) {
		FullName = n;
	}
	
	public String getGender() {
		return Gender;
	}

	public void setGender(String n) {
		Gender = n;
	}
	

	public City getAdress() {
		return Adress;
	}

	public void setAdress(City c) {
		Adress = c;
	}

	public String getEmail() {
		return FullName;
	}

	public void setEmail(String n) {
		Email = n;
	}
	public Long getTel() {
		return Tel;
	}

	public void setTel(Long n) {
		Tel = n;
	}
	public Long getIdnumber() {
		return idNumber;
	}

	public void setIdnumber(Long n) {
		idNumber = n;
	}
	
	public Long getPasseportnumber() {
		return passeportNumber;
	}

	public void setPasseportnumber(Long n) {
		passeportNumber = n;
	}

}
