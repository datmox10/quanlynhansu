package com.quanlynhansu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quanlynhansu.converter.KyLuatConverter;
import com.quanlynhansu.dto.KyLuatDTO;
import com.quanlynhansu.entity.KyLuatEntity;
import com.quanlynhansu.entity.NhanVienEntity;
import com.quanlynhansu.repository.KyLuatRepository;
import com.quanlynhansu.repository.NhanVienRepository;
import com.quanlynhansu.service.IKyLuatService;

@Service
public class KyLuatService implements IKyLuatService{
	
	@Autowired
	private KyLuatRepository kyLuatRepository;
	
	@Autowired 
	private KyLuatConverter kyLuatConverter;
	
	@Autowired
	private NhanVienRepository nhanVienRepository;
	
	@Override
	public List<KyLuatDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<KyLuatEntity> entities = kyLuatRepository.findAll(pageable).getContent();
		List<KyLuatDTO> dto = new ArrayList<>();
		
		for(KyLuatEntity entity: entities) {
			dto.add(kyLuatConverter.toDTO(entity));
		}
		return dto;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) kyLuatRepository.count();
	}
	@Override
	public KyLuatDTO findById(long id) {
		// TODO Auto-generated method stub
		KyLuatEntity entity = kyLuatRepository.findOne(id);
		return kyLuatConverter.toDTO(entity);
	}

	@Override
	public KyLuatDTO save(KyLuatDTO kyLuatDTO) {
		// TODO Auto-generated method stub
		NhanVienEntity nhanVienEntity = nhanVienRepository.findOne(kyLuatDTO.getMaNhanVien());
		// TODO Auto-generated method stub
		KyLuatEntity entity = new KyLuatEntity();
		if(kyLuatDTO.getId() != null) {
			KyLuatEntity oldEntity = kyLuatRepository.findOne(kyLuatDTO.getId());
			entity = kyLuatConverter.toEntity(kyLuatDTO, oldEntity);
			entity.setNhanvien(nhanVienEntity);
		}else {
			entity = kyLuatConverter.toEntity(kyLuatDTO);
			entity.setNhanvien(nhanVienEntity);
		}
		return kyLuatConverter.toDTO(kyLuatRepository.save(entity));

	}
	
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		kyLuatRepository.delete(id);
	}

	@Override
	public Map<Long, String> findALLMap() {
		// TODO Auto-generated method stub
		return null;
	}


}
