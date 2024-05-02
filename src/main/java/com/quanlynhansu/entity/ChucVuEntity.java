package com.quanlynhansu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="chucvu")
public class ChucVuEntity extends AbstractEntity{
		
	@Column(name="ten_chuc_vu")
	private String tenChucVu;
	
	@Column(name ="mo_ta",columnDefinition = "TEXT")
	private String moTa;
	
	@OneToMany(mappedBy = "chucVu")
	private List<NhanVienEntity> listNhanVien = new ArrayList<>();
	
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
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
