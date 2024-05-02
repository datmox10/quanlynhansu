package com.quanlynhansu.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.quanlynhansu.dto.BangLuongDTO;
import com.quanlynhansu.entity.NhanVienEntity;

public interface IBangLuongService {
	List<BangLuongDTO> findAll(Pageable pageable);
	int getTotalItem();
	BangLuongDTO findById(long id);
	BangLuongDTO save(BangLuongDTO bangLuongDTO);
	void delete(long id);
	Map<Long, String> findALLMap();
	List<BangLuongDTO> findAllByNhanVien(NhanVienEntity nventity);
}