package ua.com.enity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(indexes={@Index(columnList = "color")})
public class Color {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String color; 
	
	@OneToMany(mappedBy="color")
	private List<Models> models;
	 
	public Color() {
		// TODO Auto-generated constructor stub
	}

	public Color(String color) {
		super();
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMadeCountry() {
		return color;
	}

	public void setMadeCountry(String color) {
		this.color = color;
	}

	public List<Models> getGoodModels() {
		return models;
	}

	public void setGoodModels(List<Models> models) {
		this.models = models;
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
		Color other = (Color) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Color [id=" + id + ", color=" + color + "]";
	}
	
	
	






	

	

}
