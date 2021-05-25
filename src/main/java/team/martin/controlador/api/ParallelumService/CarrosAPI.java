package team.martin.controlador.api.ParallelumService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import team.martin.controlador.entity.carro.ListaModelos;
import team.martin.controlador.entity.carro.Marca;

import java.util.List;

@FeignClient(name = "ParallelumService", url = "https://parallelum.com.br")
public interface CarrosAPI {
    @GetMapping("/fipe/api/v1/carros/marcas")
    List<Marca> marcas();
    @GetMapping("/fipe/api/v1/carros/marcas/{id}/modelos")
    ListaModelos modelosPorCodigoMarca(@PathVariable("id") String id);
}
