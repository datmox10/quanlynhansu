package com.quanlynhansu.converter;

import org.springframework.stereotype.Component;

import com.quanlynhansu.dto.BangCapDTO;
import com.quanlynhansu.entity.BangCapEntity;

@Component
public class BangCapConverter {
	public BangCapDTO toDTO(BangCapEntity entity) {
		BangCapDTO dto = new BangCapDTO();
		dto.setId(entity.getId());
		dto.setTenBangCap(entity.getTenBangCap());
		dto.setAnh(entity.getAnh());
		dto.setMaNhanVien(entity.getNhanvien().getId());
		
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public BangCapEntity toEntity(BangCapDTO dto) {
		BangCapEntity entity = new BangCapEntity();
		entity.setTenBangCap(dto.getTenBangCap());
		entity.setAnh(dto.getAnh());
		return entity;
	}
	
	public BangCapEntity toEntity(BangCapDTO dto, BangCapEntity entity) {
		entity.setTenBangCap(dto.getTenBangCap());
		entity.setAnh(dto.getAnh());
		return entity;
	}
}
