package com.quanlynhansu.converter;

import org.springframework.stereotype.Component;

import com.quanlynhansu.dto.NhanVienDTO;
import com.quanlynhansu.entity.NhanVienEntity;

@Component
public class NhanVienConverter {
	public NhanVienDTO toDTO(NhanVienEntity entity) {
		NhanVienDTO dto = new NhanVienDTO();
		dto.setId(entity.getId());
		dto.setTenNhanVien(entity.getTenNhanVien());
		dto.setNgaySinh(entity.getNgaySinh());
		dto.setQueQuan(entity.getQueQuan());
		dto.setGioiTinh(entity.getGioiTinh());
		dto.setDanToc(entity.getDanToc());
		dto.setSoDienThoai(entity.getSoDienThoai());
		dto.setLuong(entity.getLuong());
		dto.setAnh(entity.getAnh());
		dto.setTrangThai(entity.getTrangThai());
		dto.setMaChucVu(entity.getChucVu().getId());
		dto.setMaChuyenMon(entity.getChuyenMon().getId());
		dto.setMaTrinhDo(entity.getTrinhDo().getId());
		dto.setMaPhongBan(entity.getPhongBan().getId());
		
		dto.setMaChucVu(entity.getChucVu().getId());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		
		return dto;
	}
	
	public NhanVienEntity toEntity(NhanVienDTO dto) {
		NhanVienEntity entity = new NhanVienEntity();
		entity.setId(dto.getId());
		entity.setTenNhanVien(dto.getTenNhanVien());
		entity.setNgaySinh(dto.getNgaySinh());
		entity.setQueQuan(dto.getQueQuan());
		entity.setGioiTinh(dto.getGioiTinh());
		entity.setDanToc(dto.getDanToc());
		entity.setSoDienThoai(dto.getSoDienThoai());
		entity.setLuong(dto.getLuong());
		entity.setAnh(dto.getAnh());
		entity.setTrangThai(dto.getTrangThai());
		
		return entity;
	}
	
	public NhanVienEntity toEntity(NhanVienDTO dto, NhanVienEntity entity) {
		entity.setTenNhanVien(dto.getTenNhanVien());
		entity.setNgaySinh(dto.getNgaySinh());
		entity.setQueQuan(dto.getQueQuan());
		entity.setGioiTinh(dto.getGioiTinh());
		entity.setDanToc(dto.getDanToc());
		entity.setSoDienThoai(dto.getSoDienThoai());
		entity.setLuong(dto.getLuong());
		entity.setAnh(dto.getAnh());
		entity.setTrangThai(dto.getTrangThai());
		
		
		return entity;
	}
}
