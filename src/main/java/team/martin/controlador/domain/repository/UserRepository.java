package team.martin.controlador.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.martin.controlador.model.Usuarios;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Usuarios, Long> {
}
