package team.martin.controlador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.martin.controlador.entity.Carro;
import team.martin.controlador.entity.Usuario;

import java.util.List;

@Repository
public interface CarrosRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByUsuario(Usuario id);

    void deleteById(Long idCarro);
}
