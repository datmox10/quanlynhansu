package com.quanlynhansu.converter;

import org.springframework.stereotype.Component;

import com.quanlynhansu.dto.TrinhDoDTO;
import com.quanlynhansu.entity.TrinhDoEntity;

@Component
public class TrinhDoConverter {
	public TrinhDoDTO toDTO(TrinhDoEntity entity) {
		TrinhDoDTO dto = new TrinhDoDTO();
		dto.setId(entity.getId());
		dto.setTenTrinhDo(entity.getTenTrinhDo());
		dto.setMoTa(entity.getMoTa());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		
		return dto;
	}
	
	public TrinhDoEntity toEntity(TrinhDoDTO dto) {
		TrinhDoEntity entity = new TrinhDoEntity();
		entity.setTenTrinhDo(dto.getTenTrinhDo());
		entity.setMoTa(dto.getMoTa());
		
		return entity;
	}
	
	public TrinhDoEntity toEntity(TrinhDoDTO dto, TrinhDoEntity entity) {
		entity.setTenTrinhDo(dto.getTenTrinhDo());
		entity.setMoTa(dto.getMoTa());
		
		return entity;
	}
}
