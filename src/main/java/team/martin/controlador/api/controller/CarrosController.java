package team.martin.controlador.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.martin.controlador.model.Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@RestController
public class CarrosController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/users")
    public List<Usuarios> listar(){

        return manager.createQuery("from usuarios", Usuarios.class).getResultList();
    }
}
