package app.school.administration.auth.custom.service;

import app.school.administration.auth.custom.CustomUserDetails;
import app.school.administration.auth.entity.UserEntity;
import app.school.administration.auth.serviceimpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static app.school.administration.common.constant.CacheConstant.UNLESS_RESULT_IS_NULL;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    public static final String cacheName = "auth_cache";
    private final UserServiceImpl userService;

    @Override
    @Cacheable(value = cacheName, key = "#username", unless = UNLESS_RESULT_IS_NULL)
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findByUsernameIgnoreCase(username);
        return new CustomUserDetails(user);
    }

}
