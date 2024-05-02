package com.quanlynhansu.dto;

import java.sql.Date;

public class BangLuongDTO extends AbstractDTO<BangLuongDTO>{
	private Long maNhanVien;
	private Date ngayTinhCong;
	private int soNgayCong;
	private float tien;
	private float phuCap;
	private float tamUng;
	private String moTa;
	private float tongTien;
	public Long getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(Long maNhanVien) {
		this.maNhanVien = maNhanVien;
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
	public float getTamUng() {
		return tamUng;
	}
	public void setTamUng(float tamUng) {
		this.tamUng = tamUng;
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
	
}
