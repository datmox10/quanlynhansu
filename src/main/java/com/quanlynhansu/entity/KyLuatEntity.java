package com.quanlynhansu.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="kyluat")
public class KyLuatEntity extends AbstractEntity{
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_nhan_vien")
	private NhanVienEntity nhanvien;
	
	@Column(name="mo_ta",columnDefinition = "TEXT")
	private String moTa;
	
	@Column(name="ngay")
	private Date ngay;
	
	@Column(name="tien_phat")
	private Float tienPhat;

	public NhanVienEntity getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVienEntity nhanvien) {
		this.nhanvien = nhanvien;
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
