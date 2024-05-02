package com.quanlynhansu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quanlynhansu.converter.PhongBanConverter;
import com.quanlynhansu.dto.PhongBanDTO;
import com.quanlynhansu.entity.PhongBanEntity;
import com.quanlynhansu.repository.PhongBanRepository;
import com.quanlynhansu.service.IPhongBanService;

@Service 
public class PhongBanService implements IPhongBanService{

	@Autowired
	private PhongBanRepository phongBanRepository;
	
	
	@Autowired
	private PhongBanConverter phongBanConverter;

	@Override
	public List<PhongBanDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<PhongBanEntity> entities = phongBanRepository.findAll(pageable).getContent();
		List<PhongBanDTO> dto = new ArrayList<>();
		
		for(PhongBanEntity entity: entities) {
			dto.add(phongBanConverter.toDTO(entity));
		}
		return dto;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) phongBanRepository.count();
	}

	@Override
	public PhongBanDTO findById(long id) {
		// TODO Auto-generated method stub
		PhongBanEntity entity = phongBanRepository.findOne(id);
		return phongBanConverter.toDTO(entity);
	}

	@Override
	@Transactional
	public PhongBanDTO save(PhongBanDTO phongBanDTO) {
		// TODO Auto-generated method stub
		PhongBanEntity entity = new PhongBanEntity();
		if(phongBanDTO.getId() != null) {
			PhongBanEntity oldEntity = phongBanRepository.findOne(phongBanDTO.getId());
			entity = phongBanConverter.toEntity(phongBanDTO, oldEntity);
		}else {
			entity = phongBanConverter.toEntity(phongBanDTO);
		}
		return phongBanConverter.toDTO(phongBanRepository.save(entity));
	}

	@Override
	@Transactional
	public void delete(long id) {
		// TODO Auto-generated method stub
		phongBanRepository.delete(id);
		
	}
	
	@Override
	public Map<Long, String> findALLMap() {
		// TODO Auto-generated method stub
		Map<Long, String> result = new HashMap<>();
		List<PhongBanEntity> entities = phongBanRepository.findAll();
		for (PhongBanEntity item: entities) {
			result.put(item.getId(), item.getTenPhongBan());
		}
		return result;
	}
}
