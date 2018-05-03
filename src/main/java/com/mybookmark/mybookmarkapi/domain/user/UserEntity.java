package com.mybookmark.mybookmarkapi.domain.user;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames="loginId"))
public class UserEntity implements UserDetails {

	private static final long serialVersionUID = -138755376204744163L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long userId;
	
	@Column(nullable = false)
	private String loginId;
	
	@JsonIgnore
	@Column(nullable = false)
	private String password;
	
	@ManyToOne(optional = false)
	private RoleEntity authority;

	
	public long getUserId() {
		return userId;
	}
	
	public String getLoginId() {
		return loginId;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public RoleEntity getAuthority() {
		return authority;
	}

		
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAuthority(RoleEntity authority) {
		this.authority = authority;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(authority.getRole()));
		return authorities;
	}

	@Override
	public String getUsername() {
		return loginId;
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
		return true;
	}
		
}
