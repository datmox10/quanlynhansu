package com.quanlynhansu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quanlynhansu.converter.KhenThuongConverter;
import com.quanlynhansu.dto.KhenThuongDTO;
import com.quanlynhansu.entity.KhenThuongEntity;
import com.quanlynhansu.entity.NhanVienEntity;
import com.quanlynhansu.repository.KhenThuongRepository;
import com.quanlynhansu.repository.NhanVienRepository;
import com.quanlynhansu.service.IKhenThuongService;
@Service
public class KhenThuongService implements IKhenThuongService{

	@Autowired
	private KhenThuongRepository khenThuongRepository;
	
	@Autowired 
	private KhenThuongConverter khenThuongConverter;
	
	@Autowired
	private NhanVienRepository nhanVienRepository;
	
	@Override
	public List<KhenThuongDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<KhenThuongEntity> entities = khenThuongRepository.findAll(pageable).getContent();
		List<KhenThuongDTO> dto = new ArrayList<>();
		
		for(KhenThuongEntity entity: entities) {
			dto.add(khenThuongConverter.toDTO(entity));
		}
		return dto;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) khenThuongRepository.count();
	}
	@Override
	public KhenThuongDTO findById(long id) {
		// TODO Auto-generated method stub
		KhenThuongEntity entity = khenThuongRepository.findOne(id);
		return khenThuongConverter.toDTO(entity);
	}

	@Override
	public KhenThuongDTO save(KhenThuongDTO khenThuongDTO) {
		// TODO Auto-generated method stub
		NhanVienEntity nhanVienEntity = nhanVienRepository.findOne(khenThuongDTO.getMaNhanVien());
		// TODO Auto-generated method stub
		KhenThuongEntity entity = new KhenThuongEntity();
		if(khenThuongDTO.getId() != null) {
			KhenThuongEntity oldEntity = khenThuongRepository.findOne(khenThuongDTO.getId());
			entity = khenThuongConverter.toEntity(khenThuongDTO, oldEntity);
			entity.setNhanvien(nhanVienEntity);
		}else {
			entity = khenThuongConverter.toEntity(khenThuongDTO);
			entity.setNhanvien(nhanVienEntity);
		}
		return khenThuongConverter.toDTO(khenThuongRepository.save(entity));

	}
	
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		khenThuongRepository.delete(id);
	}

	@Override
	public Map<Long, String> findALLMap() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
