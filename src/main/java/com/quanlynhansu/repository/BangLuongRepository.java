package com.quanlynhansu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlynhansu.entity.BangLuongEntity;
import com.quanlynhansu.entity.NhanVienEntity;

public interface BangLuongRepository extends JpaRepository<BangLuongEntity, Long>{
	java.util.List<BangLuongEntity> findAllByNhanvien(NhanVienEntity entity);
}
