package com.quanlynhansu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="chuyenmon")
public class ChuyenMonEntity extends AbstractEntity {
	@Column(name="ten_chuyen_mon")
	private String tenChuyenMon;
	
	@Column(name="mo_ta",columnDefinition = "TEXT")
	private String moTa;

	@OneToMany(mappedBy = "chuyenMon")
	private List<NhanVienEntity> listNhanVien = new ArrayList<>();
	
	public String getTenChuyenMon() {
		return tenChuyenMon;
	}

	public void setTenChuyenMon(String tenChuyenMon) {
		this.tenChuyenMon = tenChuyenMon;
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
