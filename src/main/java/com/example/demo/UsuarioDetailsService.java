package com.example.demo;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService{
	
	private UserRepository userRepository;
	
	UsuarioDetailsService(UserRepository userRepository){
		this.userRepository=userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=userRepository.findByUsername(username);
		user.orElseThrow(()->new UsernameNotFoundException("Not found: "+username));
		return user.map(MyUserDetails::new).get();
	}

}
