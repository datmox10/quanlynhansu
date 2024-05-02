package com.quanlynhansu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bangcap")
public class BangCapEntity extends AbstractEntity{
	@Column(name="ten_bang_cap")
	private String tenBangCap;
	
	@Lob
	@Column(name="anh")
	private String anh;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_nhan_vien")
	private NhanVienEntity nhanvien;

	public String getTenBangCap() {
		return tenBangCap;
	}

	public void setTenBangCap(String tenBangCap) {
		this.tenBangCap = tenBangCap;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public NhanVienEntity getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVienEntity nhanvien) {
		this.nhanvien = nhanvien;
	}
	
	
}
