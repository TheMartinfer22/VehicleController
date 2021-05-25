package team.martin.controlador.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.martin.controlador.entity.Carro;

@Repository
public interface CarrosRepository extends JpaRepository<Carro, Long> {}
