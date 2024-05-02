package com.quanlynhansu.dto;

public class TrinhDoDTO extends AbstractDTO<TrinhDoDTO> {
	private String tenTrinhDo;
	private String moTa;
	public String getTenTrinhDo() {
		return tenTrinhDo;
	}
	public void setTenTrinhDo(String tenTrinhDo) {
		this.tenTrinhDo = tenTrinhDo;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}
