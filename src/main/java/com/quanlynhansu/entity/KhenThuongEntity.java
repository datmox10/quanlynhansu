package com.quanlynhansu.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="khenthuong")
public class KhenThuongEntity  extends AbstractEntity{
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_nhan_vien")
	private NhanVienEntity nhanvien;
	
	@Column(name="mo_ta",columnDefinition = "TEXT")
	private String moTa;
	
	@Column(name="ngay")
	private Date ngay;
	
	@Column(name="tien_thuong")
	private Float tienThuong;

	public NhanVienEntity getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVienEntity nhanvien) {
		this.nhanvien = nhanvien;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public Float getTienThuong() {
		return tienThuong;
	}

	public void setTienThuong(Float tienThuong) {
		this.tienThuong = tienThuong;
	}
	
}
