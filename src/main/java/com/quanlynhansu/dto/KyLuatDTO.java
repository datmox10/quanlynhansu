package com.quanlynhansu.dto;

import java.sql.Date;

public class KyLuatDTO extends AbstractDTO<KyLuatDTO>{
	private Long maNhanVien;
	private String moTa;
	private Date ngay;
	private Float tienPhat;
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
	public Float getTienPhat() {
		return tienPhat;
	}
	public void setTienPhat(Float tienPhat) {
		this.tienPhat = tienPhat;
	}
	
}
