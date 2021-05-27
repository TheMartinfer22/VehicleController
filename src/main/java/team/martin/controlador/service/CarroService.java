package team.martin.controlador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.martin.controlador.api.CarrosAPI;
import team.martin.controlador.repository.CarrosRepository;
import team.martin.controlador.repository.UserRepository;
import team.martin.controlador.dto.CarroDTO;
import team.martin.controlador.entity.Carro;
import team.martin.controlador.entity.Usuario;

import java.util.List;

@Service
public class CarroService {

    private CarrosAPI carrosAPI;
    private CarrosRepository carrosRepository;
    private UserRepository userRepository;

    @Autowired
    public CarroService(CarrosAPI carrosAPI, CarrosRepository carrosRepository, UserRepository userRepository) {
        this.carrosAPI = carrosAPI;
        this.carrosRepository = carrosRepository;
        this.userRepository = userRepository;
    }

    public Carro addCarro(Long id, CarroDTO dto){
        Usuario u = userRepository.findById(id).orElseThrow();
        Carro carro = carrosAPI.get(dto.getMarca(), dto.getModelo(), dto.getAno());
        carro.setUsuario(u);
        return carrosRepository.save(carro);
    }

    public List<Carro> verCarros(Usuario id){
        return carrosRepository.findByUsuario(id);
    }

    public void removeCarro(Long idCarro){
        carrosRepository.deleteById(idCarro);
    }

}
