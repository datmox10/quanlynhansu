package com.quanlynhansu.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bangluong")
public class BangLuongEntity extends AbstractEntity{
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_nhan_vien")
	private NhanVienEntity nhanvien;
	
	@Column(name="ngay_tinh_cong")
	private Date ngayTinhCong;
	
	@Column(name="so_ngay_cong")
	private int soNgayCong;
	
	@Column(name="tien")
	private float tien;
	
	@Column(name="phu_cap")
	private float phuCap;
	
	@Column(name="tam_ung")
	private float tamUng;
	
	@Column(name="tong_tien")
	private float tongTien;
	
	@Column(name="mo_ta")
	private String moTa;

	public NhanVienEntity getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVienEntity nhanvien) {
		this.nhanvien = nhanvien;
	}

	public Date getNgayTinhCong() {
		return ngayTinhCong;
	}

	public void setNgayTinhCong(Date ngayTinhCong) {
		this.ngayTinhCong = ngayTinhCong;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public float getTien() {
		return tien;
	}

	public void setTien(float tien) {
		this.tien = tien;
	}

	public float getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(float phuCap) {
		this.phuCap = phuCap;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public float getTamUng() {
		return tamUng;
	}

	public void setTamUng(float tamUng) {
		this.tamUng = tamUng;
	}
	
	
	
}
