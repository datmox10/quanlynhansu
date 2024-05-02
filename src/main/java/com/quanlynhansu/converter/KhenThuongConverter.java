package com.quanlynhansu.converter;

import org.springframework.stereotype.Component;

import com.quanlynhansu.dto.KhenThuongDTO;
import com.quanlynhansu.entity.KhenThuongEntity;
@Component
public class KhenThuongConverter {
	public KhenThuongDTO toDTO(KhenThuongEntity entity) {
		KhenThuongDTO dto = new KhenThuongDTO();
		dto.setId(entity.getId());
		dto.setNgay(entity.getNgay());
		dto.setMoTa(entity.getMoTa());
		dto.setTienThuong(entity.getTienThuong());
		dto.setMaNhanVien(entity.getNhanvien().getId());
		
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public KhenThuongEntity toEntity(KhenThuongDTO dto) {
		KhenThuongEntity entity = new KhenThuongEntity();
		entity.setNgay(dto.getNgay());
		entity.setMoTa(dto.getMoTa());
		entity.setTienThuong(dto.getTienThuong());
		return entity;
	}
	
	public KhenThuongEntity toEntity(KhenThuongDTO dto, KhenThuongEntity entity) {
		entity.setNgay(dto.getNgay());
		entity.setMoTa(dto.getMoTa());
		entity.setTienThuong(dto.getTienThuong());
		return entity;
	}
}
