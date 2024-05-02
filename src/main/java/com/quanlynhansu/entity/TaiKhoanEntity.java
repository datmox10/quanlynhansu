package com.quanlynhansu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="taikhoan")
public class TaiKhoanEntity extends AbstractEntity{
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_nhan_vien")
	private NhanVienEntity nhanvien;
	@Column(name="tai_khoan")
	private String taiKhoan;
	@Column(name="mat_khau")
	private String matKhau;
	@Column(name="trang_thai")
	private int trangThai;
	
	 
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "quyen_tk", joinColumns = @JoinColumn(name = "ma_tai_khoan"), 
								  inverseJoinColumns = @JoinColumn(name = "ma_quyen"))
	private List<QuyenEntity> quyens = new ArrayList<>();

	public NhanVienEntity getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVienEntity nhanvien) {
		this.nhanvien = nhanvien;
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

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public List<QuyenEntity> getQuyens() {
		return quyens;
	}

	public void setQuyens(List<QuyenEntity> quyens) {
		this.quyens = quyens;
	}


	
	
}
