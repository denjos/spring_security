package com.example.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{

	private String username;
	private String password;
	private boolean enabled;
	private List<GrantedAuthority> authorities;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3311160006838446489L;
	
	public MyUserDetails(User user) {
		this.username=user.getUsername();
		this.password=user.getPassword();
		this.enabled=user.isEnabled();
		this.authorities=Arrays.stream(user.getRoles().split(","))
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList());
				
	}
	
	public MyUserDetails() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
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
		return this.enabled;
	}


}
