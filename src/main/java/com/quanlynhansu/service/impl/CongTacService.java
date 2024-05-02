package com.quanlynhansu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quanlynhansu.converter.CongTacConverter;
import com.quanlynhansu.dto.CongTacDTO;
import com.quanlynhansu.entity.CongTacEntity;
import com.quanlynhansu.entity.NhanVienEntity;
import com.quanlynhansu.repository.CongTacRepository;
import com.quanlynhansu.repository.NhanVienRepository;
import com.quanlynhansu.service.ICongTacService;
@Service
public class CongTacService implements ICongTacService{
	@Autowired
	private CongTacRepository congTacRepository;
	
	@Autowired
	private CongTacConverter congTacConverter;
	@Autowired
	private NhanVienRepository nhanVienRepository;

	@Override
	public List<CongTacDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<CongTacEntity> entities = congTacRepository.findAll(pageable).getContent();
		List<CongTacDTO> dto = new ArrayList<>();
		
		for(CongTacEntity entity: entities) {
			dto.add(congTacConverter.toDTO(entity));
		}
		return dto;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) congTacRepository.count();
	}

	@Override
	public CongTacDTO findById(long id) {
		// TODO Auto-generated method stub
		CongTacEntity entity = congTacRepository.findOne(id);
		return congTacConverter.toDTO(entity);
	}

	@Override
	public CongTacDTO save(CongTacDTO congTacDTO) {
		// TODO Auto-generated method stub
		NhanVienEntity nhanVienEntity = nhanVienRepository.findOne(congTacDTO.getMaNhanVien());
		// TODO Auto-generated method stub
		CongTacEntity entity = new CongTacEntity();
		if(congTacDTO.getId() != null) {
			CongTacEntity oldEntity = congTacRepository.findOne(congTacDTO.getId());
			entity = congTacConverter.toEntity(congTacDTO, oldEntity);
			entity.setNhanvien(nhanVienEntity);
		}else {
			entity = congTacConverter.toEntity(congTacDTO);
			entity.setNhanvien(nhanVienEntity);
		}
		return congTacConverter.toDTO(congTacRepository.save(entity));

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		congTacRepository.delete(id);
	}

	@Override
	public Map<Long, String> findALLMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
