package com.quanlynhansu.dto;

public class BangCapDTO extends AbstractDTO<BangCapDTO>{
	private String tenBangCap;
	private String anh;
	private Long maNhanVien;
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
	public Long getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(Long maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	
	
}
