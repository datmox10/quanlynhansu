package com.quanlynhansu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quanlynhansu.converter.ChuyenMonConverter;
import com.quanlynhansu.dto.ChuyenMonDTO;
import com.quanlynhansu.entity.ChuyenMonEntity;
import com.quanlynhansu.repository.ChuyenMonRepository;
import com.quanlynhansu.service.IChuyenMonService;

@Service
public class ChuyenMonService implements IChuyenMonService{
	
	@Autowired
	private ChuyenMonRepository chuyenMonRepository;
	
	
	@Autowired
	private ChuyenMonConverter chuyenMonConverter;

	@Override
	public List<ChuyenMonDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<ChuyenMonEntity> entities = chuyenMonRepository.findAll(pageable).getContent();
		List<ChuyenMonDTO> dto = new ArrayList<>();
		
		for(ChuyenMonEntity entity: entities) {
			dto.add(chuyenMonConverter.toDTO(entity));
		}
		return dto;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) chuyenMonRepository.count();
	}

	@Override
	public ChuyenMonDTO findById(long id) {
		// TODO Auto-generated method stub
		ChuyenMonEntity entity = chuyenMonRepository.findOne(id);
		return chuyenMonConverter.toDTO(entity);
	}

	@Override
	@Transactional
	public ChuyenMonDTO save(ChuyenMonDTO chuyenMonDTO) {
		// TODO Auto-generated method stub
		ChuyenMonEntity entity = new ChuyenMonEntity();
		if(chuyenMonDTO.getId() != null) {
			ChuyenMonEntity oldEntity = chuyenMonRepository.findOne(chuyenMonDTO.getId());
			entity = chuyenMonConverter.toEntity(chuyenMonDTO, oldEntity);
		}else {
			entity = chuyenMonConverter.toEntity(chuyenMonDTO);
		}
		return chuyenMonConverter.toDTO(chuyenMonRepository.save(entity));
	}

	@Override
	@Transactional
	public void delete(long id) {
		// TODO Auto-generated method stub
		chuyenMonRepository.delete(id);
		
	}
	
	@Override
	public Map<Long, String> findALLMap() {
		// TODO Auto-generated method stub
		Map<Long, String> result = new HashMap<>();
		List<ChuyenMonEntity> entities = chuyenMonRepository.findAll();
		for (ChuyenMonEntity item: entities) {
			result.put(item.getId(), item.getTenChuyenMon());
		}
		return result;
	}

}
