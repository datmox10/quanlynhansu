package com.quanlynhansu.converter;

import org.springframework.stereotype.Component;

import com.quanlynhansu.dto.TaiKhoanDTO;
import com.quanlynhansu.entity.TaiKhoanEntity;
@Component
public class TaiKhoanConverter {
	public TaiKhoanDTO toDTO(TaiKhoanEntity entity) {
		TaiKhoanDTO dto = new TaiKhoanDTO();
		dto.setId(entity.getId());
		dto.setTaiKhoan(entity.getTaiKhoan());
		dto.setMatKhau(entity.getMatKhau());
		dto.setMaNhanVien(entity.getNhanvien().getId());
		
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public TaiKhoanEntity toEntity(TaiKhoanDTO dto) {
		TaiKhoanEntity entity = new TaiKhoanEntity();
		entity.setTaiKhoan(dto.getTaiKhoan());
		entity.setMatKhau(dto.getMatKhau());
		return entity;
	}
	
	public TaiKhoanEntity toEntity(TaiKhoanDTO dto, TaiKhoanEntity entity) {
		entity.setTaiKhoan(dto.getTaiKhoan());
		entity.setMatKhau(dto.getMatKhau());
		return entity;
	}
}
