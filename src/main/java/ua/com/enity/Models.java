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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*@NamedQueries({

// @NamedQuery(name = "findAll", query = "from Good_Models"),
@NamedQuery(name = "findByModelName", query = "select a from Good_Models a where a.modelName =:param")

})*/
@Entity
@Table(indexes = { @Index(columnList = "modelName"),
		@Index(columnList = "price") })
public class Models {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String Name;

	private int price;

	private int version;

	@ManyToOne(fetch = FetchType.LAZY)
	private Color color;

	@ManyToOne(fetch = FetchType.LAZY)
	private Type Type;

	@ManyToOne(fetch = FetchType.LAZY)
	private GPU_Type gpuType;

	@ManyToOne(fetch = FetchType.LAZY)
	private Memory memoryType;

	@ManyToOne(fetch = FetchType.LAZY)
	private Nvidia nvidiaType;

	@ManyToOne(fetch = FetchType.LAZY)
	private Screan screanType;

	@ManyToOne(fetch = FetchType.LAZY)
	private Procc_Type proccType;

	@ManyToOne(fetch = FetchType.LAZY)
	private Ram_Type ramType;

	@ManyToMany
	@JoinTable(name = "user_models", joinColumns = @JoinColumn(name = "id_goodModel"), inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> users;

	public Models() {
		// TODO Auto-generated constructor stub
	}

	public Models(String Name) {
		super();
		this.Name = Name;
	}

	public Models(String Name, int price) {
		super();
		this.Name = Name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String modelName) {
		this.Name = modelName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color good) {
		this.color = good;
	}

	public Type getType() {
		return Type;
	}

	public void setType(Type goodType) {
		this.Type = goodType;
	}

	public GPU_Type getGpuType() {
		return gpuType;
	}

	public void setGpuType(GPU_Type gpuType) {
		this.gpuType = gpuType;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Memory getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(Memory memoryType) {
		this.memoryType = memoryType;
	}

	public Procc_Type getProccType() {
		return proccType;
	}

	public void setProccType(Procc_Type proccType) {
		this.proccType = proccType;
	}

	public Ram_Type getRamType() {
		return ramType;
	}

	public void setRamType(Ram_Type ramType) {
		this.ramType = ramType;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Nvidia getNvidiaType() {
		return nvidiaType;
	}

	public void setNvidiaType(Nvidia nvidiaType) {
		this.nvidiaType = nvidiaType;
	}

	public Screan getScreanType() {
		return screanType;
	}

	public void setScreanType(Screan screanType) {
		this.screanType = screanType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Type == null) ? 0 : Type.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((gpuType == null) ? 0 : gpuType.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((memoryType == null) ? 0 : memoryType.hashCode());
		result = prime * result
				+ ((nvidiaType == null) ? 0 : nvidiaType.hashCode());
		result = prime * result + price;
		result = prime * result
				+ ((proccType == null) ? 0 : proccType.hashCode());
		result = prime * result + ((ramType == null) ? 0 : ramType.hashCode());
		result = prime * result
				+ ((screanType == null) ? 0 : screanType.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + version;
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
		Models other = (Models) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Type == null) {
			if (other.Type != null)
				return false;
		} else if (!Type.equals(other.Type))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (gpuType == null) {
			if (other.gpuType != null)
				return false;
		} else if (!gpuType.equals(other.gpuType))
			return false;
		if (id != other.id)
			return false;
		if (memoryType == null) {
			if (other.memoryType != null)
				return false;
		} else if (!memoryType.equals(other.memoryType))
			return false;
		if (nvidiaType == null) {
			if (other.nvidiaType != null)
				return false;
		} else if (!nvidiaType.equals(other.nvidiaType))
			return false;
		if (price != other.price)
			return false;
		if (proccType == null) {
			if (other.proccType != null)
				return false;
		} else if (!proccType.equals(other.proccType))
			return false;
		if (ramType == null) {
			if (other.ramType != null)
				return false;
		} else if (!ramType.equals(other.ramType))
			return false;
		if (screanType == null) {
			if (other.screanType != null)
				return false;
		} else if (!screanType.equals(other.screanType))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Models [id=" + id + ", Name=" + Name + ", price=" + price
				+ ", version=" + version + ", color=" + color + ", Type="
				+ Type + ", gpuType=" + gpuType + ", memoryType=" + memoryType
				+ ", nvidiaType=" + nvidiaType + ", screanType=" + screanType
				+ ", proccType=" + proccType + ", ramType=" + ramType
				+ ", users=" + users + "]";
	}

}
