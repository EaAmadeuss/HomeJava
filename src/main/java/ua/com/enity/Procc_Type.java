package ua.com.enity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(indexes={@Index(columnList = "type")})
public class Procc_Type {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String type;
	
	@OneToMany(mappedBy="proccType")
	private List<Models> goodModels;

	public Procc_Type() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Procc_Type(String type) {
		super();
		this.type = type;
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
		Procc_Type other = (Procc_Type) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Procc_Type [id=" + id + ", type=" + type + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Models> getGoodModels() {
		return goodModels;
	}

	public void setGoodModels(List<Models> goodModels) {
		this.goodModels = goodModels;
	}
	
	
	
	
	
	
	
	
}
