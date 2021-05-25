package team.martin.controlador.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import team.martin.controlador.api.ParallelumService.CarrosAPI;
import team.martin.controlador.entity.carro.ListaModelos;
import team.martin.controlador.entity.carro.Marca;

import java.util.List;

@RestController
public class ModelosMarcaController { //
    final CarrosAPI carros;

    ModelosMarcaController(final CarrosAPI parallelumService) {
        this.carros = parallelumService;
    }

    @GetMapping("/marcas")
    List<Marca> getMarcas() {
        return carros.marcas();
    }

    @GetMapping("/marcas/{id}/modelos")
    ListaModelos getListaDeModelos(@PathVariable String id) {
        return this.carros.modelosPorCodigoMarca(id);
    }
}

