package com.quanlynhansu.converter;

import org.springframework.stereotype.Component;

import com.quanlynhansu.dto.BangLuongDTO;
import com.quanlynhansu.entity.BangLuongEntity;

@Component
public class BangLuongConverter {
	public BangLuongDTO toDTO(BangLuongEntity entity) {
		BangLuongDTO dto = new BangLuongDTO();
		dto.setId(entity.getId());
		dto.setMaNhanVien(entity.getNhanvien().getId());
		dto.setNgayTinhCong(entity.getNgayTinhCong());
		dto.setTien(entity.getTien());
		dto.setMoTa(entity.getMoTa());
		dto.setPhuCap(entity.getPhuCap());
		dto.setTamUng(entity.getTamUng());
		dto.setTongTien(entity.getTongTien());
		dto.setSoNgayCong(entity.getSoNgayCong());
		
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public BangLuongEntity toEntity(BangLuongDTO dto) {
		BangLuongEntity entity = new BangLuongEntity();
		entity.setNgayTinhCong(dto.getNgayTinhCong());
		entity.setMoTa(dto.getMoTa());
		entity.setPhuCap(dto.getPhuCap());
		entity.setTamUng(dto.getTamUng());
		entity.setSoNgayCong(dto.getSoNgayCong());
		return entity;
	}
	
	public BangLuongEntity toEntity(BangLuongDTO dto, BangLuongEntity entity) {
		entity.setNgayTinhCong(dto.getNgayTinhCong());
		entity.setMoTa(dto.getMoTa());
		entity.setPhuCap(dto.getPhuCap());
		entity.setTamUng(dto.getTamUng());
		entity.setSoNgayCong(dto.getSoNgayCong());
		return entity;
	}
}
