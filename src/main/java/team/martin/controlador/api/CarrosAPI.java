package team.martin.controlador.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import team.martin.controlador.entity.Carro;

@FeignClient(name = "ParallelumService", url = "https://parallelum.com.br")
public interface CarrosAPI {

    @GetMapping("/fipe/api/v1/carros/marcas/{marcaID}/modelos/{modeloID}/anos/{anoID}")
    Carro get(@PathVariable Integer marcaID, @PathVariable Integer modeloID, @PathVariable String anoID);

}
