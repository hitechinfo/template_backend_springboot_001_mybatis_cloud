package com.skcc.backend.common.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TEMPLATE_AUTH")
public class TemplateAuth {

	@Id
	@Column(name = "TEMPLATE_USER_ID")
	private String authUserId;

	@Column(name = "TEMPLATE_USER_PW", nullable = false)
	private String authUserPw;

	@Column(name = "TEMPLATE_USER_TYPE", nullable = false)
	private String authUserType;

//	public String getAuthUserId() {
//		return authUserId;
//	}
//
//	public String setAuthUserId(String authUserId) {
//		return this.authUserId = authUserId;
//	}
//
//	public String getAuthUserPw() {
//		return authUserPw;
//	}
//
//	public String setAuthUserPw(String authUserPw) {
//		return this.authUserPw = authUserPw;
//	}
//
//	public String getAuthUserType() {
//		return authUserType;
//	}
//
//	public String setAuthUserType(String authUserType) {
//		return this.authUserType = authUserType;
//	}

}