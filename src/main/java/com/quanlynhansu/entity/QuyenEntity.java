package com.quanlynhansu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name ="quyen")
public class QuyenEntity extends AbstractEntity{
	
	@Column(name="ten_quyen")
	private String tenQuyen;
	
	
	@ManyToMany(mappedBy = "quyens")
    private List<TaiKhoanEntity> taiKhoans = new ArrayList<>();


	public String getTenQuyen() {
		return tenQuyen;
	}


	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}


	public List<TaiKhoanEntity> getTaiKhoans() {
		return taiKhoans;
	}


	public void setTaiKhoans(List<TaiKhoanEntity> taiKhoans) {
		this.taiKhoans = taiKhoans;
	}


	
	
}
