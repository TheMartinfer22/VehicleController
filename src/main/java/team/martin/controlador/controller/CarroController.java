package team.martin.controlador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.martin.controlador.entity.Usuario;
import team.martin.controlador.service.CarroService;
import team.martin.controlador.dto.CarroDTO;
import team.martin.controlador.entity.Carro;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios/{id}/carros")
class CarroController {

    private CarroService carroService;

    @Autowired
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public Carro addCarro(@PathVariable Long id, @RequestBody @Valid CarroDTO carro) {
        return carroService.addCarro(id, carro);
    }

    @GetMapping
    public List<Carro> verCarro(@PathVariable Usuario id){
        return carroService.verCarros(id);
    }

    @DeleteMapping(value = "/delete/{idCarro}")
    public void removeCarro(@PathVariable Long idCarro) {
        carroService.removeCarro(idCarro);
    }
}