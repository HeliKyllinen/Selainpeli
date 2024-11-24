package op2.ryhmatyo.pelisivusto.web;

import op2.ryhmatyo.pelisivusto.domain.User;
import op2.ryhmatyo.pelisivusto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Hae kaikki käyttäjät
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Hae käyttäjä ID:n perusteella
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404, käyttäjää ei löydy
        }
        return ResponseEntity.ok(user.get()); // 200 OK, käyttäjä löytyi
    }

    // Hae käyttäjä käyttäjänimen perusteella
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build(); // 404, käyttäjää ei löydy
        }
        return ResponseEntity.ok(user); // 200 OK, käyttäjä löytyi
    }

    // Tallenna uusi käyttäjä
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser); // 200 OK, käyttäjä luotiin
    }

    // Poista käyttäjä
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build(); // 204 No Content, käyttäjä poistettiin
    }
}
