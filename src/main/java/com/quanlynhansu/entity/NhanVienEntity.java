package com.quanlynhansu.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="nhanvien")
public class NhanVienEntity extends AbstractEntity{
	@Column(name="ten_nhan_vien")
	private String tenNhanVien;
	
	@Column(name="ngay_sinh")
	private Date ngaySinh;
	
	@Column(name="que_quan")
	private String queQuan;
	
	@Column(name="gioi_tinh")
	private int gioiTinh;
	
	@Column(name="dan_toc")
	private String danToc;
	
	@Column(name="so_dien_thoai")
	private int soDienThoai;
	
	@Column(name="luong")
	private Float luong;
	
	@Lob
	@Column(name="anh")
	private String anh;
	
	@Column(name="trang_thai")
	private int trangThai;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_chuc_vu")
	private ChucVuEntity chucVu;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_chuyen_mon")
	private ChuyenMonEntity chuyenMon;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_trinh_do")
	private TrinhDoEntity trinhDo;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_phong_ban")
	private PhongBanEntity phongBan;
	
	@OneToOne(mappedBy = "nhanvien")
    private BangCapEntity bangCap;
	
	@OneToMany(mappedBy = "nhanvien")
	private List<BangLuongEntity> listBangLuong = new ArrayList<>();
	
	@OneToMany(mappedBy = "nhanvien")
	private List<CongTacEntity> listCongTac = new ArrayList<>();
	
	@OneToMany(mappedBy = "nhanvien")
	private List<KhenThuongEntity> listKhenThuong = new ArrayList<>();
	
	@OneToMany(mappedBy = "nhanvien")
	private List<KyLuatEntity> listKyLuat = new ArrayList<>();
	
	@OneToOne(mappedBy = "nhanvien")
    private TaiKhoanEntity taiKhoan;
	
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

	public Float getLuong() {
		return luong;
	}

	public void setLuong(Float luong) {
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

	public ChucVuEntity getChucVu() {
		return chucVu;
	}

	public void setChucVu(ChucVuEntity chucVu) {
		this.chucVu = chucVu;
	}

	public ChuyenMonEntity getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(ChuyenMonEntity chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	public TrinhDoEntity getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(TrinhDoEntity trinhDo) {
		this.trinhDo = trinhDo;
	}

	public PhongBanEntity getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBanEntity phongBan) {
		this.phongBan = phongBan;
	}
	

	public BangCapEntity getBangCap() {
		return bangCap;
	}

	public void setBangCap(BangCapEntity bangCap) {
		this.bangCap = bangCap;
	}



	public List<BangLuongEntity> getListBangLuong() {
		return listBangLuong;
	}

	public void setListBangLuong(List<BangLuongEntity> listBangLuong) {
		this.listBangLuong = listBangLuong;
	}


	public TaiKhoanEntity getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoanEntity taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public List<CongTacEntity> getListCongTac() {
		return listCongTac;
	}

	public void setListCongTac(List<CongTacEntity> listCongTac) {
		this.listCongTac = listCongTac;
	}

	public List<KhenThuongEntity> getListKhenThuong() {
		return listKhenThuong;
	}

	public void setListKhenThuong(List<KhenThuongEntity> listKhenThuong) {
		this.listKhenThuong = listKhenThuong;
	}

	public List<KyLuatEntity> getListKyLuat() {
		return listKyLuat;
	}

	public void setListKyLuat(List<KyLuatEntity> listKyLuat) {
		this.listKyLuat = listKyLuat;
	}


	
	
}
