package com.m3itsolution.config.security;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.m3itsolution.dao.UserDAO;
import com.m3itsolution.model.Role;
import com.m3itsolution.model.User;
import com.m3itsolution.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//  @Autowired
//	LoginService loginService;

	@Autowired
	UserService userService;

//	private UserDAO userDao;
//  @Autowired
//	public void setUserDao(UserDAO userDao) {
//	this.userDao = userDao;
//}

	// Inject bean through constructor
	private UserDAO userDao;

	@Autowired
	public UserDetailsServiceImpl(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional(readOnly = true) // Very Important
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			System.out.println("Loading username...");
			System.out.println("Username:" + username);
			// User user = userDao.getUserByName(username);
			String loginUsername = userService.findLoggedInUsername(username);
			System.out.println("LoginUser:" + loginUsername);
			User user = userService.getUserByName(loginUsername);
			if (user == null) {
				// LOGGER.debug("user not found with the provided username");
				System.out.println("Username:" + user.getUsername());
				System.out.println("Password:" + user.getPwd());
				return null;
			}

			System.out.println("Username:" + user.getUsername());
			System.out.println("Password:" + user.getPwd());
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			for (Role role : user.getRoles()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
			}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPwd(),
					getGrantedAuthorities(user));
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found");

		}

	}

//	private Set<grantedauthority> getAuthorities(User user){
//        Set<grantedauthority> authorities = new HashSet<grantedauthority>();
//        for(Role role : user.getRoles()) {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
//            authorities.add(grantedAuthority);
//        }
//        LOGGER.debug("user authorities are " + authorities.toString());
//        return authorities;
//    }
//	
	private Set<GrantedAuthority> getGrantedAuthorities(User user) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		for (Role role : user.getRoles()) {
			// logger.info("UserProfile : {}", userProfile);
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		// logger.info("authorities : {}", authorities);
		return authorities;
	}

}
