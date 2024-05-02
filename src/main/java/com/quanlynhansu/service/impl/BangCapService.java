package com.quanlynhansu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quanlynhansu.converter.BangCapConverter;
import com.quanlynhansu.dto.BangCapDTO;
import com.quanlynhansu.entity.BangCapEntity;
import com.quanlynhansu.entity.NhanVienEntity;
import com.quanlynhansu.repository.BangCapRepository;
import com.quanlynhansu.repository.NhanVienRepository;
import com.quanlynhansu.service.IBangCapService;

@Service
public class BangCapService implements IBangCapService{
	
	@Autowired
	private BangCapRepository bangCapRepository;
	
	@Autowired 
	private BangCapConverter bangCapConverter;
	
	@Autowired
	private NhanVienRepository nhanVienRepository;

	@Override
	public List<BangCapDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<BangCapEntity> entities = bangCapRepository.findAll(pageable).getContent();
		List<BangCapDTO> dto = new ArrayList<>();
		
		for(BangCapEntity entity: entities) {
			dto.add(bangCapConverter.toDTO(entity));
		}
		return dto;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) bangCapRepository.count();
	}

	@Override
	public BangCapDTO findById(long id) {
		// TODO Auto-generated method stub
		BangCapEntity entity = bangCapRepository.findOne(id);
		return bangCapConverter.toDTO(entity);
	}

	@Override
	public BangCapDTO save(BangCapDTO bangCapDTO) {
		
		NhanVienEntity nhanVienEntity = nhanVienRepository.findOne(bangCapDTO.getMaNhanVien());
		// TODO Auto-generated method stub
		BangCapEntity entity = new BangCapEntity();
		if(bangCapDTO.getId() != null) {
			BangCapEntity oldEntity = bangCapRepository.findOne(bangCapDTO.getId());
			entity = bangCapConverter.toEntity(bangCapDTO, oldEntity);
			entity.setNhanvien(nhanVienEntity);
		}else {
			entity = bangCapConverter.toEntity(bangCapDTO);
			entity.setNhanvien(nhanVienEntity);
		}
		return bangCapConverter.toDTO(bangCapRepository.save(entity));
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		bangCapRepository.delete(id);
		
	}

	@Override
	public Map<Long, String> findALLMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
