package tx.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tx.jwt.domain.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    AppUser findByUsername(String username);
}
