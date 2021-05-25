package team.martin.controlador.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.martin.controlador.domain.repository.CarrosRepository;
import team.martin.controlador.domain.repository.UserRepository;
import team.martin.controlador.entity.Carro;

import javax.validation.Valid;

@RestController
class CarroController {
    final UserRepository userRepository;
    final CarrosRepository carrosRepository;
    public CarroController(
            final UserRepository userRepository,
            final CarrosRepository carrosRepository
    ) {
        this.userRepository = userRepository;
        this.carrosRepository = carrosRepository;
    }

    @GetMapping(path = "/usuarios/{usuarioId}/carros")
    ResponseEntity<?> listarCarros(@PathVariable Long usuarioId) {
        final var usuarioRef = this.userRepository.findById(usuarioId);
        if (usuarioRef.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioRef.get().getCarros());
    }

    @PostMapping(path = "/usuarios/{usuarioId}/carros")
    ResponseEntity<?> adicionarCarro(@PathVariable Long usuarioId, @RequestBody @Valid Carro carro) {
        final var usuarioRef = this.userRepository.findById(usuarioId);
        if (usuarioRef.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var usuario = usuarioRef.get();
        carro.setId(null); // garantir que o carro será novo
        this.carrosRepository.save(carro);
        usuario.getCarros().add(carro);
        this.userRepository.save(usuario);
        return ResponseEntity.ok(usuario.getCarros());
    }
}