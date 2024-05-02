package com.quanlynhansu.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.quanlynhansu.dto.PhongBanDTO;

public interface IPhongBanService {
	List<PhongBanDTO> findAll(Pageable pageable);
	int getTotalItem();
	PhongBanDTO findById(long id);
	PhongBanDTO save(PhongBanDTO phongBanDTO);
	void delete(long id);
	Map<Long, String> findALLMap();
}
