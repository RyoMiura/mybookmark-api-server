package com.mybookmark.mybookmarkapi.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mybookmark.mybookmarkapi.common.dto.UserDto;
import com.mybookmark.mybookmarkapi.domain.util.converter.DtoEntityMapper;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository authorityRepository;
	
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

		// UserDtoの中だとAutowiredできないから、仕方なくここでパスワード変換
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		RoleEntity auth = authorityRepository.findByRole("USER");
		entity.setAuthority(auth);
		
		userRepository.save(entity);
	}
}
