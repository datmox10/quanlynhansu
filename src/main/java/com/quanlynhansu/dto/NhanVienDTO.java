package com.quanlynhansu.dto;

import java.sql.Date;

public class NhanVienDTO extends AbstractDTO<NhanVienDTO>{
	private String tenNhanVien;
	private Date ngaySinh;
	private String queQuan;
	private int gioiTinh;
	private String danToc;
	private int soDienThoai;
	private float luong;
	private String anh;
	private int trangThai;
	private Long maChucVu;
	private Long maTrinhDo;
	private Long maChuyenMon;
	private Long maPhongBan;
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDanToc() {
		return danToc;
	}
	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}
	public int getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public Long getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(Long maChucVu) {
		this.maChucVu = maChucVu;
	}
	public Long getMaTrinhDo() {
		return maTrinhDo;
	}
	public void setMaTrinhDo(Long maTrinhDo) {
		this.maTrinhDo = maTrinhDo;
	}
	public Long getMaChuyenMon() {
		return maChuyenMon;
	}
	public void setMaChuyenMon(Long maChuyenMon) {
		this.maChuyenMon = maChuyenMon;
	}
	public Long getMaPhongBan() {
		return maPhongBan;
	}
	public void setMaPhongBan(Long maPhongBan) {
		this.maPhongBan = maPhongBan;
	}


	
	
}
