package team.martin.controlador.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.martin.controlador.utils.CpfUltis;
import team.martin.controlador.utils.exceptions.DadosEmUso;
import team.martin.controlador.repository.UserRepository;
import team.martin.controlador.entity.Usuario;
import team.martin.controlador.utils.exceptions.DadosInvalidos;

@Service
public class UsuarioService {

    private UserRepository userRepository;

    public UsuarioService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Usuario criar(Usuario user){
        boolean emailExiste = userRepository.findByEmail(user.getEmail()).stream().anyMatch(c -> !c.equals(user));
        boolean cpfExiste = userRepository.findByCpf(user.getCpf()).stream().anyMatch(b -> !b.equals(user));
        boolean cpfValido = CpfUltis.cpfValido(user.getCpf());

        if (emailExiste){
            throw new DadosEmUso("O e-mail utilizado já está em uso.");
        }
        if (cpfExiste){
            throw new DadosEmUso("O CPF utilizado já está em uso.");
        }
        if (!cpfValido){
            throw new DadosInvalidos("O CPF utilizado é invalido.");
        }

        return userRepository.save(user);
    }

    @Transactional
    public void excluir(Long userID){
        userRepository.deleteById(userID);
    }

    @Transactional
    public Usuario atualizar(Usuario user){
        return userRepository.save(user);
    }
}
