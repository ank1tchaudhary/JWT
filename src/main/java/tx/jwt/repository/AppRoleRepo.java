package tx.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tx.jwt.domain.AppRole;

public interface AppRoleRepo extends JpaRepository<AppRole,Long> {

    AppRole findByName(String name);
}
