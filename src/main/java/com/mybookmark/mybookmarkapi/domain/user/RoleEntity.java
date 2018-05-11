package com.mybookmark.mybookmarkapi.domain.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// TODO: ROLEはDBじゃなくて設定ファイル(設定クラス)などで持たせた方がよさそう。

@Entity
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorityId;
	
	@Column(nullable = false)
	private String role;
	
	@OneToMany(mappedBy = "authority")
	private Set<UserEntity> userEntities;

	
	public RoleEntity() {}
	
	public RoleEntity(String role) {
		this.role = role;
	}
	
	public int getAuthorityId() {
		return authorityId;
	}

	public String getRole() {
		return role;
	}
	
	public Set<UserEntity> getUserEntity() {
		return userEntities;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public void setUserEntity(Set<UserEntity> userEntity) {
		this.userEntities = userEntity;
	}

}
