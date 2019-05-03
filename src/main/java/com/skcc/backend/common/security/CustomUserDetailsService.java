package com.skcc.backend.common.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skcc.backend.common.data.jpa.entity.TemplateAuth;
import com.skcc.backend.common.data.jpa.repository.TemplateAuthRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private TemplateAuthRepository templateAuthRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public TemplateAuth createAccount(String userId, String userPw, String userType) {
		TemplateAuth templateAuth = new TemplateAuth();
		templateAuth.setAuthUserId(userId);
		templateAuth.setAuthUserPw(passwordEncoder.encode(userPw));
		templateAuth.setAuthUserType(userType);
		return templateAuthRepository.save(templateAuth);
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		TemplateAuth templateAuthSearch = new TemplateAuth();
		Optional<TemplateAuth> userInfo = templateAuthRepository.findByAuthUserId(userId);
		templateAuthSearch = userInfo.orElseThrow(() -> new UsernameNotFoundException("User not found!"));

		List<GrantedAuthority> grantedAuthority = new ArrayList<GrantedAuthority>();
		grantedAuthority.add(new SimpleGrantedAuthority(templateAuthSearch.getAuthUserType()));

		User secureUser = new User(templateAuthSearch.getAuthUserId(), templateAuthSearch.getAuthUserPw(), grantedAuthority);
		return secureUser;
	}

}




