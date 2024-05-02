package com.quanlynhansu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quanlynhansu.converter.BangLuongConverter;
import com.quanlynhansu.dto.BangLuongDTO;
import com.quanlynhansu.entity.BangLuongEntity;
import com.quanlynhansu.entity.NhanVienEntity;
import com.quanlynhansu.repository.BangLuongRepository;
import com.quanlynhansu.repository.NhanVienRepository;
import com.quanlynhansu.service.IBangLuongService;

@Service
public class BangLuongService implements IBangLuongService{
	
	@Autowired
	private BangLuongConverter bangLuongConverter;
	
	@Autowired
	private BangLuongRepository bangLuongRepository;
	
	@Autowired 
	private NhanVienRepository nhanVienRepository;
	

	@Override
	public List<BangLuongDTO> findAll(Pageable pageable) {
		List<BangLuongEntity> entities = bangLuongRepository.findAll(pageable).getContent();
		List<BangLuongDTO> dto = new ArrayList<>();
		
		for(BangLuongEntity entity: entities) {
			dto.add(bangLuongConverter.toDTO(entity));
		}
		return dto;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) bangLuongRepository.count();
	}

	@Override
	public BangLuongDTO findById(long id) {
		// TODO Auto-generated method stub
		BangLuongEntity entity = bangLuongRepository.findOne(id);
		return bangLuongConverter.toDTO(entity);
	}

	@Override
	public BangLuongDTO save(BangLuongDTO bangLuongDTO) {
		// TODO Auto-generated method stub
		NhanVienEntity nhanVienEntity = nhanVienRepository.findOne(bangLuongDTO.getMaNhanVien());
		// TODO Auto-generated method stub
		BangLuongEntity entity = new BangLuongEntity();
		if(bangLuongDTO.getId() != null) {
			BangLuongEntity oldEntity = bangLuongRepository.findOne(bangLuongDTO.getId());
			entity = bangLuongConverter.toEntity(bangLuongDTO, oldEntity);
			entity.setNhanvien(nhanVienEntity);
		}else {
			entity = bangLuongConverter.toEntity(bangLuongDTO);
			entity.setNhanvien(nhanVienEntity);
			entity.setTien(nhanVienEntity.getLuong());
			entity.setTongTien((nhanVienEntity.getLuong()*entity.getSoNgayCong())+entity.getPhuCap()-entity.getTamUng());
		}
		return bangLuongConverter.toDTO(bangLuongRepository.save(entity));
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		bangLuongRepository.delete(id);
		
	}

	@Override
	public Map<Long, String> findALLMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BangLuongDTO> findAllByNhanVien(NhanVienEntity nventity) {
		// TODO Auto-generated method stub
		List<BangLuongEntity> entities = bangLuongRepository.findAllByNhanvien(nventity);
		List<BangLuongDTO> dto = new ArrayList<>();
		
		for(BangLuongEntity entity: entities) {
			dto.add(bangLuongConverter.toDTO(entity));
		}
		return dto;
	}

}
