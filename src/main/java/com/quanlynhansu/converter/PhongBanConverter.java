package com.quanlynhansu.converter;

import org.springframework.stereotype.Component;

import com.quanlynhansu.dto.PhongBanDTO;
import com.quanlynhansu.entity.PhongBanEntity;
@Component
public class PhongBanConverter {
	public PhongBanDTO toDTO(PhongBanEntity entity) {
		PhongBanDTO dto = new PhongBanDTO();
		dto.setId(entity.getId());
		dto.setTenPhongBan(entity.getTenPhongBan());
		dto.setMoTa(entity.getMoTa());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		
		return dto;
	}
	
	public PhongBanEntity toEntity(PhongBanDTO dto) {
		PhongBanEntity entity = new PhongBanEntity();
		entity.setTenPhongBan(dto.getTenPhongBan());
		entity.setMoTa(dto.getMoTa());
		
		return entity;
	}
	
	public PhongBanEntity toEntity(PhongBanDTO dto, PhongBanEntity entity) {
		entity.setTenPhongBan(dto.getTenPhongBan());
		entity.setMoTa(dto.getMoTa());
		
		
		return entity;
	}
}
