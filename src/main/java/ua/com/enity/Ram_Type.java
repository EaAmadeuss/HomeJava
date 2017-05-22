package ua.com.enity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(indexes={@Index(columnList = "ramType")})
public class Ram_Type {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String ramType;
	
	@OneToMany(mappedBy="ramType")
	private List<Models> goodModels;
	

	public Ram_Type() {
		// TODO Auto-generated constructor stub
	}

	public Ram_Type(String ramType) {
		super();
		this.ramType = ramType;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRamType() {
		return ramType;
	}

	public void setRamType(String ramType) {
		this.ramType = ramType;
	}

	public List<Models> getGoodModels() {
		return goodModels;
	}

	public void setGoodModels(List<Models> goodModels) {
		this.goodModels = goodModels;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ram_Type other = (Ram_Type) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ram_Type [id=" + id + ", ramType=" + ramType + "]";
	}
	
	
	
}
