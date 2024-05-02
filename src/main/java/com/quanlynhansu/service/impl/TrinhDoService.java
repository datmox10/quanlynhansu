package com.quanlynhansu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quanlynhansu.converter.TrinhDoConverter;
import com.quanlynhansu.dto.TrinhDoDTO;
import com.quanlynhansu.entity.TrinhDoEntity;
import com.quanlynhansu.repository.TrinhDoRepository;
import com.quanlynhansu.service.ITrinhDoService;

@Service
public class TrinhDoService implements ITrinhDoService{

	@Autowired
	private TrinhDoRepository trinhDoRepository;
	
	@Autowired
	private TrinhDoConverter trinhDoConverter;
	
	@Override
	public List<TrinhDoDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<TrinhDoDTO> dto = new ArrayList<>();
		List<TrinhDoEntity> entities = trinhDoRepository.findAll(pageable).getContent();
		for(TrinhDoEntity entity: entities) {
			dto.add(trinhDoConverter.toDTO(entity));
		}
		return dto;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) trinhDoRepository.count();
	}

	@Override
	public TrinhDoDTO findById(long id) {
		// TODO Auto-generated method stub
		TrinhDoEntity entity = trinhDoRepository.findOne(id);
		return trinhDoConverter.toDTO(entity);
	}

	@Override
	public TrinhDoDTO save(TrinhDoDTO trinhDoDTO) {
		// TODO Auto-generated method stub
		TrinhDoEntity entity = new TrinhDoEntity();
		if(trinhDoDTO.getId() != null) {
			TrinhDoEntity oldEntity = trinhDoRepository.findOne(trinhDoDTO.getId());
			entity = trinhDoConverter.toEntity(trinhDoDTO,oldEntity);
		}else {
			entity = trinhDoConverter.toEntity(trinhDoDTO);
		}
		return trinhDoConverter.toDTO(trinhDoRepository.save(entity));
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		trinhDoRepository.delete(id);
	}
	
	@Override
	public Map<Long, String> findALLMap() {
		// TODO Auto-generated method stub
		Map<Long, String> result = new HashMap<>();
		List<TrinhDoEntity> entities = trinhDoRepository.findAll();
		for (TrinhDoEntity item: entities) {
			result.put(item.getId(), item.getTenTrinhDo());
		}
		return result;
	}
}
