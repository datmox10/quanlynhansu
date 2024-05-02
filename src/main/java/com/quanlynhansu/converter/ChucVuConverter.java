package com.quanlynhansu.converter;

import org.springframework.stereotype.Component;

import com.quanlynhansu.dto.ChucVuTDTO;
import com.quanlynhansu.entity.ChucVuEntity;
@Component
public class ChucVuConverter {
	public ChucVuTDTO toDTO(ChucVuEntity entity) {
		ChucVuTDTO dto = new ChucVuTDTO();
		dto.setId(entity.getId());
		dto.setTenChucVu(entity.getTenChucVu());
		dto.setMoTa(entity.getMoTa());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		
		return dto;
	}
	
	public ChucVuEntity toEntity(ChucVuTDTO dto) {
		ChucVuEntity entity = new ChucVuEntity();
		entity.setTenChucVu(dto.getTenChucVu());
		entity.setMoTa(dto.getMoTa());
		
		return entity;
	}
	
	public ChucVuEntity toEntity(ChucVuTDTO dto, ChucVuEntity entity) {
		entity.setTenChucVu(dto.getTenChucVu());
		entity.setMoTa(dto.getMoTa());
		
		return entity;
	}
	
	
}
