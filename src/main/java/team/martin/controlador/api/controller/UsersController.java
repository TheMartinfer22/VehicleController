package team.martin.controlador.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.martin.controlador.domain.repository.UserRepository;
import team.martin.controlador.domain.service.UsuarioCadastroService;
import team.martin.controlador.dto.UserDTO;
import team.martin.controlador.entity.Usuario;

import javax.validation.Valid;
import java.util.stream.Stream;

@RestController
@RequestMapping("/usuarios")
public class UsersController {

    @Autowired
    private UserRepository userRepository;
    private UsuarioCadastroService usuarioCadastroService;

    public UsersController(UserRepository userRepository, UsuarioCadastroService usuarioCadastroService) {
        this.userRepository = userRepository;
        this.usuarioCadastroService = usuarioCadastroService;
    }

    @GetMapping
    Stream<UserDTO> listar() {

        return userRepository.findAll()
                .stream()
                .map(u -> new UserDTO(u.getId(), u.getEmail(), u.getCpf()));
    }

    @GetMapping("/{userid}")
    public ResponseEntity<Usuario> buscarID(@PathVariable Long userid) {

        return userRepository.findById(userid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario registro(@Valid @RequestBody Usuario user){
        return usuarioCadastroService.criar(user);
    }

    @PutMapping("/{userID}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long userID, @Valid @RequestBody Usuario user){

        if (!userRepository.existsById(userID)){
            return ResponseEntity.notFound().build();
        }
        user.setId(userID);
        usuarioCadastroService.atualizar(user);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<Usuario> deletar(@PathVariable Long userID){
        if (!userRepository.existsById(userID)){
            return ResponseEntity.notFound().build();
        }

        usuarioCadastroService.excluir(userID);
        return ResponseEntity.noContent().build();
    }
}

