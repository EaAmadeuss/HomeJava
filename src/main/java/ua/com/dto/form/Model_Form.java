package ua.com.dto.form;

import org.springframework.web.multipart.MultipartFile;

import ua.com.enity.Color;
import ua.com.enity.GPU_Type;
import ua.com.enity.Type;

import ua.com.enity.Memory;
import ua.com.enity.Nvidia;
import ua.com.enity.Procc_Type;
import ua.com.enity.Ram_Type;
import ua.com.enity.Screan;

public class Model_Form {

	private int id;

	private int version;

	private MultipartFile file;

	private String Name;

	private String price;

	private Color color;

	private Type goodType;

	private GPU_Type gpuType;

	private Memory memoryType;

	private Nvidia nvidiaType;

	private Screan screanType;

	private Procc_Type proccType;

	private Ram_Type ramType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Type getGoodType() {
		return goodType;
	}

	public void setGoodType(Type goodType) {
		this.goodType = goodType;
	}

	public GPU_Type getGpuType() {
		return gpuType;
	}

	public void setGpuType(GPU_Type gpuType) {
		this.gpuType = gpuType;
	}

	public Memory getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(Memory memoryType) {
		this.memoryType = memoryType;
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

}
