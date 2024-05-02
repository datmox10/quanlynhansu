package com.quanlynhansu.converter;

import org.springframework.stereotype.Component;

import com.quanlynhansu.dto.CongTacDTO;
import com.quanlynhansu.entity.CongTacEntity;

@Component
public class CongTacConverter {
	public CongTacDTO toDTO(CongTacEntity entity) {
		CongTacDTO dto = new CongTacDTO();
		dto.setId(entity.getId());
		dto.setDenNgay(entity.getDenNgay());
		dto.setTuNgay(entity.getTuNgay());
		dto.setDiaDiem(entity.getDiaDiem());
		dto.setMoTa(entity.getMoTa());
		dto.setMaNhanVien(entity.getNhanvien().getId());
		
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public CongTacEntity toEntity(CongTacDTO dto) {
		CongTacEntity entity = new CongTacEntity();
		entity.setDenNgay(dto.getDenNgay());
		entity.setTuNgay(dto.getTuNgay());
		entity.setDiaDiem(dto.getDiaDiem());
		entity.setMoTa(dto.getMoTa());
		return entity;
	}
	
	public CongTacEntity toEntity(CongTacDTO dto, CongTacEntity entity) {
		entity.setDenNgay(dto.getDenNgay());
		entity.setTuNgay(dto.getTuNgay());
		entity.setDiaDiem(dto.getDiaDiem());
		entity.setMoTa(dto.getMoTa());
		return entity;
	}
}
