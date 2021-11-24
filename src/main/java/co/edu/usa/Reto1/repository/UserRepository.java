package co.edu.usa.Reto1.repository;

import co.edu.usa.Reto1.model.User;
import co.edu.usa.Reto1.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepo;

    public List<User> getAll() {
        return (List<User>) userCrudRepo.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepo.findById(id);
    }

    public User save(User user) {
        return userCrudRepo.save(user);
    }

    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepo.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepo.findByEmailAndPassword(email, password);
    }
}
