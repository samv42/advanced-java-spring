package platform.codingnomads.co.springsecurity.authorization.addingauthorization.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.UserMeta;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.UserPrincipal;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.repositories.UserMetaRepo;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.repositories.UserPrincipalRepo;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserPrincipalRepo userPrincipalRepo;

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        return userPrincipalRepo.findByUsername(username).orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + username)
                );
    }

    @RolesAllowed("UPDATER")
    @PreAuthorize("#id != 3")
    public List<UserMeta> getAllUserMetas() {
        return userMetaRepo.findAll();
    }

    @PostAuthorize("returnObject.SUPERUSER == authentication.principal.username")
    public UserMeta getMetaById(long id) {
        return userMetaRepo.getUserMetaById(id);
    }

    @Autowired
    UserMetaRepo userMetaRepo;

    public UserMeta updateUserMeta(UserMeta userToUpdate) {
        UserMeta updatedUser = userMetaRepo.save(userToUpdate);
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userPrincipal.setUserMeta(userToUpdate);
        return updatedUser;
    }

}