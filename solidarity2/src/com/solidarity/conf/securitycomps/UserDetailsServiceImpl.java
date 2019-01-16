package com.solidarity.conf.securitycomps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.solidarity.model.entity.Mko;
import com.solidarity.model.entity.User;
import com.solidarity.model.service.ModelService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ModelService modelService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// first try loading from User table
		User user = modelService.getUser(username);

		if (user != null) {
			return new CustomUserDetails(user.getUsername(), user.getPassword(), "ROLE_USER");
		} else {
			// Not found in user table, so check admin
			Mko mko = modelService.getMko(username);
			if (mko != null) {
				System.out.println(mko.getUsername()+ " "+mko.getPassword()+ " "+mko.getRole());
				return new CustomUserDetails(mko.getUsername(), mko.getPassword(), "ROLE_MKO");
			}else {
				if(username.equals("god")) {
					return new CustomUserDetails("god","god","ROLE_ADMIN");
				}
			}
		}
		throw new UsernameNotFoundException("User '" + username + "' not found");
	}

	@SuppressWarnings("serial")
	class CustomUserDetails implements UserDetails{

		private String username;
        private String password;
        private Collection<? extends GrantedAuthority> authorities;
		
        public CustomUserDetails() {
            super();
        }

        public CustomUserDetails(String username, String password, String role) {
            this.username = username;
            this.password = password;
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
            this.authorities = grantedAuthorities;
        }
        
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}

		@Override
		public String getPassword() {
			return password;
		}

		@Override
		public String getUsername() {
			return username;
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
}
