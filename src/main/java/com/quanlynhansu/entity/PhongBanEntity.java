package com.quanlynhansu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="phongban")
public class PhongBanEntity extends AbstractEntity {

	@Column(name="ten_phong_ban")
	private String tenPhongBan;
	
	@Column(name="mo_ta",columnDefinition = "TEXT")
	private String moTa;
	
	@OneToMany(mappedBy = "phongBan")
	private List<NhanVienEntity> listNhanVien = new ArrayList<>();
	
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public List<NhanVienEntity> getListNhanVien() {
		return listNhanVien;
	}
	public void setListNhanVien(List<NhanVienEntity> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}
	
	
}
