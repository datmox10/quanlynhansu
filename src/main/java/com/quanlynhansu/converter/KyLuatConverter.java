package com.quanlynhansu.converter;

import org.springframework.stereotype.Component;

import com.quanlynhansu.dto.KyLuatDTO;
import com.quanlynhansu.entity.KyLuatEntity;

@Component
public class KyLuatConverter {
	public KyLuatDTO toDTO(KyLuatEntity entity) {
		KyLuatDTO dto = new KyLuatDTO();
		dto.setId(entity.getId());
		dto.setNgay(entity.getNgay());
		dto.setMoTa(entity.getMoTa());
		dto.setTienPhat(entity.getTienPhat());
		dto.setMaNhanVien(entity.getNhanvien().getId());
		
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public KyLuatEntity toEntity(KyLuatDTO dto) {
		KyLuatEntity entity = new KyLuatEntity();
		entity.setNgay(dto.getNgay());
		entity.setMoTa(dto.getMoTa());
		entity.setTienPhat(dto.getTienPhat());
		return entity;
	}
	
	public KyLuatEntity toEntity(KyLuatDTO dto, KyLuatEntity entity) {
		entity.setNgay(dto.getNgay());
		entity.setMoTa(dto.getMoTa());
		entity.setTienPhat(dto.getTienPhat());
		return entity;
	}
}
