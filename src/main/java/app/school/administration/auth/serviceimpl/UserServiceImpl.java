package app.school.administration.auth.serviceimpl;

import app.school.administration.auth.entity.UserEntity;
import app.school.administration.auth.projection.UserProjectionDTO;
import app.school.administration.auth.repository.UserRepository;
import app.school.administration.auth.service.UserService;
import app.school.administration.common.base.repository.AppBaseRepository;
import app.school.administration.common.base.service.AppBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AppBaseService<UserEntity, UUID> implements UserService {

    private final UserRepository userRepository;

    @Override
    protected AppBaseRepository<UserEntity, UUID> getJpaRepository() {
        return this.userRepository;
    }

    /**
     * @param userName
     * @return
     */
    @Override
    public UserEntity findByUsernameIgnoreCase(String userName) {
        return userRepository.findByUsernameIgnoreCase(userName).orElseThrow(() -> new UsernameNotFoundException("User not founded"));
    }

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public Optional<UserEntity> findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }


    @Override
    public UserProjectionDTO findByIdProjection(UUID id) {
        return appFindByIdProjection(id, UserProjectionDTO.class);
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public UserEntity deActivate(UUID uuid) {
        return appDeActivate(uuid);
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public UserEntity activate(UUID uuid) {
        return appActivate(uuid);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public UserEntity save(UserEntity user) {
        return appSave(user);
    }

    /**
     * @param dto
     * @param uuid
     * @return
     */
    @Override
    public UserEntity update(UserProjectionDTO dto, UUID uuid) {
        UserEntity user = appFindByIdWithDirtyCheck(uuid);
        BeanUtils.copyProperties(dto, user);
        return user;
    }

}
