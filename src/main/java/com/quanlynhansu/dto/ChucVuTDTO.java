package com.quanlynhansu.dto;

public class ChucVuTDTO extends AbstractDTO<ChucVuTDTO> {
	private String tenChucVu;
	private String moTa;

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
}
