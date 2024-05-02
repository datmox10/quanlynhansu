package com.quanlynhansu.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.quanlynhansu.dto.TaiKhoan;

public class SecurityUtils {
	
	public static TaiKhoan getPrincipal() {
		TaiKhoan taiKhoan = (TaiKhoan) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
        return taiKhoan;
    }

	public static List<String> getAuthorities(){
		List<String> results = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
		return results;
	}
}
