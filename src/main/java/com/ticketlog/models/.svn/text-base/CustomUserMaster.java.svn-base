package com.ticketlog.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserMaster extends UserMaster implements UserDetails{

	public CustomUserMaster(final UserMaster user) {
		super(user);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
		for(UserRole role: getUserRole()){
			simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getRoleName()));
		}
		
		return simpleGrantedAuthorities;
	}

	@Override
	public String getUsername() {
		
		return super.getUserName();
	}
	
	@Override
	public String getPassword() {
		
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return super.getActive();
	}

}
