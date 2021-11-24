package co.edu.usa.Reto1.service;

import co.edu.usa.Reto1.model.User;
import co.edu.usa.Reto1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> getAll() {
        return userRepo.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepo.getUser(id);
    }

    public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepo.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return userRepo.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepo.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
