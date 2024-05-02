package com.quanlynhansu.dto;

import java.sql.Date;

public class KhenThuongDTO extends AbstractDTO<KhenThuongDTO>{
	private Long maNhanVien;
	private String moTa;
	private Date ngay;
	private Float tienThuong;
	public Long getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(Long maNhanVien) {
		this.maNhanVien = maNhanVien;
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
