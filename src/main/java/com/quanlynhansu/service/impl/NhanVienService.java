package com.quanlynhansu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quanlynhansu.converter.NhanVienConverter;
import com.quanlynhansu.dto.NhanVienDTO;
import com.quanlynhansu.entity.ChucVuEntity;
import com.quanlynhansu.entity.ChuyenMonEntity;
import com.quanlynhansu.entity.NhanVienEntity;
import com.quanlynhansu.entity.PhongBanEntity;
import com.quanlynhansu.entity.TrinhDoEntity;
import com.quanlynhansu.repository.ChucVuRepository;
import com.quanlynhansu.repository.ChuyenMonRepository;
import com.quanlynhansu.repository.NhanVienRepository;
import com.quanlynhansu.repository.PhongBanRepository;
import com.quanlynhansu.repository.TrinhDoRepository;
import com.quanlynhansu.service.INhanVienService;
@Service
public class NhanVienService implements INhanVienService{
	
	@Autowired
	private NhanVienRepository nhanVienRepository;
	
	@Autowired
	private ChucVuRepository chucVuRepository;
	@Autowired
	private PhongBanRepository phongBanRepository;
	@Autowired
	private ChuyenMonRepository chuyenMonRepository;
	@Autowired
	private TrinhDoRepository trinhDoRepository;
	
	@Autowired
	private NhanVienConverter nhanVienConverter;

	@Override
	public List<NhanVienDTO> findAll(Pageable pageable) {
		List<NhanVienDTO> dto = new ArrayList<>();
		List<NhanVienEntity> entities = nhanVienRepository.findAll(pageable).getContent();
		
		for(NhanVienEntity entity: entities) {
			NhanVienDTO item = nhanVienConverter.toDTO(entity);
			dto.add(item);
		}
		return dto;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) nhanVienRepository.count();
	}

	@Override
	public NhanVienDTO findById(long id) {
		// TODO Auto-generated method stub
		NhanVienEntity entity = nhanVienRepository.findOne(id);
		return nhanVienConverter.toDTO(entity);
	}

	@Override
	public NhanVienDTO save(NhanVienDTO nhanVienDTO) {
		// TODO Auto-generated method stub
		ChucVuEntity chucVuEntity = chucVuRepository.findOne(nhanVienDTO.getMaChucVu());
		ChuyenMonEntity chuyenMonEntity = chuyenMonRepository.findOne(nhanVienDTO.getMaChuyenMon());
		TrinhDoEntity trinhDoEntity = trinhDoRepository.findOne(nhanVienDTO.getMaTrinhDo());
		PhongBanEntity phongBanEntity = phongBanRepository.findOne(nhanVienDTO.getMaPhongBan());
		
		NhanVienEntity nhanVienEntity = new  NhanVienEntity();
		if(nhanVienDTO.getId() != null) {
			NhanVienEntity oldNhanVien = nhanVienRepository.findOne(nhanVienDTO.getId());
			oldNhanVien.setChucVu(chucVuEntity);
			oldNhanVien.setChuyenMon(chuyenMonEntity);
			oldNhanVien.setTrinhDo(trinhDoEntity);
			oldNhanVien.setPhongBan(phongBanEntity);
			nhanVienEntity = nhanVienConverter.toEntity(nhanVienDTO,oldNhanVien);
		}else {
			nhanVienEntity = nhanVienConverter.toEntity(nhanVienDTO);
			nhanVienEntity.setChucVu(chucVuEntity);
			nhanVienEntity.setChuyenMon(chuyenMonEntity);
			nhanVienEntity.setTrinhDo(trinhDoEntity);
			nhanVienEntity.setPhongBan(phongBanEntity);
		}
		return nhanVienConverter.toDTO(nhanVienRepository.save(nhanVienEntity));
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		nhanVienRepository.delete(id);
	}
	
	@Override
	public Map<Long, String> findALLMap() {
		// TODO Auto-generated method stub
		Map<Long, String> result = new HashMap<>();
		List<NhanVienEntity> entities = nhanVienRepository.findAll();
		for (NhanVienEntity item: entities) {
			result.put(item.getId(), item.getTenNhanVien());
		}
		return result;
	}

}
