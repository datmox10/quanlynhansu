package com.quanlynhansu.dto;

import java.sql.Date;

public class CongTacDTO extends AbstractDTO<CongTacDTO>{
	private Long maNhanVien;
	private String moTa;
	private String diaDiem;
	private Date tuNgay;
	private Date denNgay;
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
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	public Date getTuNgay() {
		return tuNgay;
	}
	public void setTuNgay(Date tuNgay) {
		this.tuNgay = tuNgay;
	}
	public Date getDenNgay() {
		return denNgay;
	}
	public void setDenNgay(Date denNgay) {
		this.denNgay = denNgay;
	}
	
}
