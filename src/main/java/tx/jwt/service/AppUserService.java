package tx.jwt.service;

import tx.jwt.domain.AppRole;
import tx.jwt.domain.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser saveUser(AppUser user);
    AppRole saveRole(AppRole role);
    void addRoleToUser(String username,String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
