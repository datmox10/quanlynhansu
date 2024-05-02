package com.quanlynhansu.dto;

import java.util.List;

import com.quanlynhansu.entity.QuyenEntity;

public class TaiKhoanDTO extends AbstractDTO<TaiKhoanDTO>{
	private Long maNhanVien;
	private String taiKhoan;
	private String matKhau;
	private List<QuyenEntity> quyens;
	private int trangThai;
	public Long getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(Long maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public List<QuyenEntity> getQuyens() {
		return quyens;
	}
	public void setQuyens(List<QuyenEntity> quyens) {
		this.quyens = quyens;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	
}
