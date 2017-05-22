package ua.com.enity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(indexes = { @Index(columnList = "screan") })
public class Screan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String type;

	@OneToMany(mappedBy = "screanType")
	private List<Models> goodModels;

	public Screan() {
	}

	public Screan(String type) {
		super();
		this.type = type;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((goodModels == null) ? 0 : goodModels.hashCode());
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Screan other = (Screan) obj;
		if (goodModels == null) {
			if (other.goodModels != null)
				return false;
		} else if (!goodModels.equals(other.goodModels))
			return false;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Screan [id=" + id + ", type=" + type + ", goodModels="
				+ goodModels + "]";
	}

}
