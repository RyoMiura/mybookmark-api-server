package com.mybookmark.mybookmarkapi.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mybookmark.mybookmarkapi.common.secure.UserRole;
import com.mybookmark.mybookmarkapi.domain.util.converter.DtoEntityMapper;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private DtoEntityMapper dtoEntityMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByLoginId(loginId);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("not found user");
		}
	}
	
	public void createCommonUser(UserDto dto) {
		UserEntity entity = dtoEntityMapper.fromDtoToEntity(dto, UserEntity.class);
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		entity.setRole(UserRole.USER);
		
		userRepository.save(entity);
	}
}
