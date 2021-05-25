package team.martin.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.martin.controlador.domain.repository.UserRepository;

@RestController
public class ClearDatabase {
    private UserRepository userRepository;

    public ClearDatabase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/deleteall")
    public String deleteAll(){
        userRepository.deleteAll();
        return "Todos os dados foram deletados";
    }
}
