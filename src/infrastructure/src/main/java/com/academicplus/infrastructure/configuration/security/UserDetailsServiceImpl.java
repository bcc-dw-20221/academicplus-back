package com.academicplus.infrastructure.configuration.security;

import com.academicplus.domain.systemuser.SystemUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
import java.util.List;

@Service
//@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SystemUserRepository systemUserRepository;

    public UserDetailsServiceImpl(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user =  getUser(username);
        return new User(user.username(), user.password(), true, true, true, true, user.authorities());
    }

    private UserEntity getUser(String username) {
        var admin = this.systemUserRepository.findByUsername(username);
        if (admin.isPresent()) {
            final var authorities = admin.get().getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getValue())).toList();
            return new UserEntity(admin.get().getUsername(), admin.get().getPassword(), authorities);
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

    private record UserEntity(
            String username,
            String password,
            List<? extends org.springframework.security.core.GrantedAuthority> authorities
    ) {}
}
