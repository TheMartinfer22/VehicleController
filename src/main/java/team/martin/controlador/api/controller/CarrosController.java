package team.martin.controlador.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.martin.controlador.domain.repository.UserRepository;
import team.martin.controlador.model.Usuarios;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class CarrosController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Usuarios> listar() {

        return userRepository.findAll();
    }

    @GetMapping("/{userid}")
    public ResponseEntity<Usuarios> buscarID(@PathVariable Long userid) {

        return userRepository.findById(userid)
//                .map(user -> ResponseEntity.ok(user))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

//        if (user.isPresent()){
//            return ResponseEntity.ok(user.get());
//        }
//        return ResponseEntity.notFound().build();
//        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios registro(@Valid @RequestBody Usuarios user){
        return userRepository.save(user);
    }

    @PutMapping("/{userID}")
    public ResponseEntity<Usuarios> atualizar(@PathVariable Long userID, @Valid @RequestBody Usuarios user){

        if (!userRepository.existsById(userID)){
            return ResponseEntity.notFound().build();
        }
        user.setId(userID);
        userRepository.save(user);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<Usuarios> deletar(@PathVariable Long userID){
        if (!userRepository.existsById(userID)){
            return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(userID);
        return ResponseEntity.noContent().build();
    }
}

