package tx.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tx.jwt.domain.AppRole;
import tx.jwt.domain.AppUser;
import tx.jwt.repository.AppRoleRepo;
import tx.jwt.repository.AppUserRepo;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements AppUserService{

    @Autowired
    private AppUserRepo userRepo;

    @Autowired
    private AppRoleRepo roleRepo;



    @Override
    public AppUser saveUser(AppUser user) {
        return userRepo.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        userRepo.findByUsername(username).getRoles().add(roleRepo.findByName(roleName));
    }

    @Override
    public AppUser getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return userRepo.findAll();
    }
}
