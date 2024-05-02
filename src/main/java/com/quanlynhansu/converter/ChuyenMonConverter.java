package com.quanlynhansu.converter;

import org.springframework.stereotype.Component;

import com.quanlynhansu.dto.ChuyenMonDTO;
import com.quanlynhansu.entity.ChuyenMonEntity;
@Component
public class ChuyenMonConverter {
	public ChuyenMonDTO toDTO(ChuyenMonEntity entity) {
		ChuyenMonDTO dto = new ChuyenMonDTO();
		dto.setId(entity.getId());
		dto.setTenChuyenMon(entity.getTenChuyenMon());
		dto.setMoTa(entity.getMoTa());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		
		return dto;
	}
	
	public ChuyenMonEntity toEntity(ChuyenMonDTO dto) {
		ChuyenMonEntity entity = new ChuyenMonEntity();
		entity.setTenChuyenMon(dto.getTenChuyenMon());
		entity.setMoTa(dto.getMoTa());
		
		return entity;
	}
	
	public ChuyenMonEntity toEntity(ChuyenMonDTO dto, ChuyenMonEntity entity) {
		entity.setTenChuyenMon(dto.getTenChuyenMon());
		entity.setMoTa(dto.getMoTa());
		
		
		return entity;
	}
}
