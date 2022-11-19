package me.thlshop.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="information")
public class InformationEntity {
	@Id
	@Column(name="info_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer infoId;
	
	@Column(name="screen")
	private String screen;
	
	@Column(name="camera_selfie")
	private String cameraSelfie;
	
	@Column(name="ram")
	private String ram;
	
	@Column(name="camera")
	private String camera;
	
	@Column(name="cpu")
	private String cpu;
	
	@Column(name="memory")
	private String memory;
	
	@Column(name="gpu")
	private String gpu;
	
	@Column(name="cell")
	private String cell;
	
	@Column(name="sim")
	private String sim;
	
	@Column(name="os")
	private String os;
	
	@OneToMany(mappedBy = "infoId", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<ProductEntity> products;

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getCameraSelfie() {
		return cameraSelfie;
	}

	public void setCameraSelfie(String cameraSelfie) {
		this.cameraSelfie = cameraSelfie;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Set<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}

}
