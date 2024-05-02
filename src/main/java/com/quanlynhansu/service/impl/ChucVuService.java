package com.quanlynhansu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quanlynhansu.converter.ChucVuConverter;
import com.quanlynhansu.dto.ChucVuTDTO;
import com.quanlynhansu.entity.ChucVuEntity;
import com.quanlynhansu.repository.ChucVuRepository;
import com.quanlynhansu.service.IChucVuService;

@Service
public class ChucVuService implements IChucVuService{
	
	@Autowired
	private ChucVuRepository chucVuRepository;
	@Autowired
	private ChucVuConverter chucVuConverter;
	

	@Override
	public List<ChucVuTDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<ChucVuTDTO> dto = new ArrayList<>();
		List<ChucVuEntity> entities = chucVuRepository.findAll(pageable).getContent();
		
		for(ChucVuEntity entity: entities) {
			ChucVuTDTO item = chucVuConverter.toDTO(entity);
			dto.add(item);
		}
		return dto;
	}
	
	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) chucVuRepository.count();
	}
	
	@Override
	public ChucVuTDTO findById(long id) {
		// TODO Auto-generated method stub
		ChucVuEntity entity = chucVuRepository.findOne(id);
		return chucVuConverter.toDTO(entity);
	}
	
	@Override
	@Transactional
	public ChucVuTDTO save(ChucVuTDTO dto) {
		// TODO Auto-generated method stub
		ChucVuEntity chucVuEntity = new  ChucVuEntity();
		if(dto.getId() != null) {
			ChucVuEntity oldChucVu = chucVuRepository.findOne(dto.getId());
			chucVuEntity = chucVuConverter.toEntity(dto,oldChucVu);
		}else {
			chucVuEntity = chucVuConverter.toEntity(dto);
		}
		return chucVuConverter.toDTO(chucVuRepository.save(chucVuEntity));
	}
	
	
	@Override
	@Transactional
	public void delete(long id) {
		// TODO Auto-generated method stub
			chucVuRepository.delete(id);
	}
	
	@Override
	public Map<Long, String> findALLMap() {
		// TODO Auto-generated method stub
		Map<Long, String> result = new HashMap<>();
		List<ChucVuEntity> entities = chucVuRepository.findAll();
		for (ChucVuEntity item: entities) {
			result.put(item.getId(), item.getTenChucVu());
		}
		return result;
	}
	
	
}
