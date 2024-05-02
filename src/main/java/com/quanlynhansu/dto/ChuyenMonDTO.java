package com.quanlynhansu.dto;

public class ChuyenMonDTO extends AbstractDTO<ChuyenMonDTO>{
	private String tenChuyenMon;
	private String moTa;
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
	
}
