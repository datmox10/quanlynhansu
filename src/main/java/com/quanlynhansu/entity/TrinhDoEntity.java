package com.quanlynhansu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="trinhdo")
public class TrinhDoEntity extends AbstractEntity{
	@Column(name="ten_trinh_do")
	private String tenTrinhDo;
	
	@Column(name="mo_ta",columnDefinition = "TEXT")
	private String moTa;
	
	@OneToMany(mappedBy = "trinhDo")
	private List<NhanVienEntity> listNhanVien = new ArrayList<>();
	
	public String getTenTrinhDo() {
		return tenTrinhDo;
	}

	public void setTenTrinhDo(String tenTrinhDo) {
		this.tenTrinhDo = tenTrinhDo;
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
