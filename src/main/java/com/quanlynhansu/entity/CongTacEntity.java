package com.quanlynhansu.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="congtac")
public class CongTacEntity extends AbstractEntity {
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_nhan_vien")
	private NhanVienEntity nhanvien;
	@Column(name="dia_diem")
	private String diaDiem;
	@Column(name="mo_ta",columnDefinition = "TEXT")
	private String moTa;
	@Column(name="tu_ngay")
	private Date tuNgay;
	@Column(name="den_ngay")
	private Date denNgay;
	public NhanVienEntity getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVienEntity nhanvien) {
		this.nhanvien = nhanvien;
	}
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
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
