package tx.jwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tx.jwt.domain.AppRole;
import tx.jwt.domain.AppUser;
import tx.jwt.service.AppUserService;

@SpringBootApplication
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }


	@Bean
    CommandLineRunner runner(AppUserService userService) {
        return args -> {
            userService.saveRole(AppRole.builder().name("ROLE_USER").build());
            userService.saveRole(AppRole.builder().name("ROLE_MANAGER").build());
            userService.saveRole(AppRole.builder().name("ROLE_ADMIN").build());
            userService.saveRole(AppRole.builder().name("ROLE_SUPER_ADMIN").build());

			userService.saveUser(AppUser.builder().name("Ankit").username("ankit").password("ankit").build());
			userService.saveUser(AppUser.builder().name("Krishna").username("krishna").password("krishna").build());

			userService.addRoleToUser("ankit","ROLE_USER");
			userService.addRoleToUser("krishna","ROLE_SUPER_ADMIN");

        };
    }

}
