package team.martin.controlador.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import team.martin.controlador.domain.repository.UserRepository;
import team.martin.controlador.model.Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CarrosController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<Usuarios> listar(){

        return userRepository.findAll();
    }

    @GetMapping("/users/{userid}")
    public Usuarios buscarID(@PathVariable Long userid){

        Optional<Usuarios> user = userRepository.findById(userid);

        return user.orElse(null);
    }
}
