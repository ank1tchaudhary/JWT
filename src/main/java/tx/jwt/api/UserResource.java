package tx.jwt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tx.jwt.domain.AppRole;
import tx.jwt.domain.AppUser;
import tx.jwt.service.AppUserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserResource {

    @Autowired
    private AppUserService userService;

    @GetMapping(path = "/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping(path = "/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping(path = "/role/save")
    public ResponseEntity<AppRole> saveRole(@RequestBody AppRole role){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping(path = "/role/{roleName}/user/{username}")
    public void saveRoleToUser(@PathVariable String username,@PathVariable String roleName){
        userService.addRoleToUser(username,roleName);
    }

}
