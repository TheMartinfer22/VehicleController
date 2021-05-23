package team.martin.controlador.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.martin.controlador.api.controller.exceptions.DadosEmUso;
import team.martin.controlador.domain.repository.UserRepository;
import team.martin.controlador.model.Usuario;

@Service
public class UsuarioCadastroService {

    @Autowired
    private UserRepository userRepository;

    public UsuarioCadastroService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Usuario criar(Usuario user){
        boolean emailExiste = userRepository.findByEmail(user.getEmail()).stream().anyMatch(c -> !c.equals(user));
        boolean cpfExiste = userRepository.findByCpf(user.getCpf()).stream().anyMatch(b -> !b.equals(user));

        if (emailExiste){
            throw new DadosEmUso("O e-mail utilizado já está em uso.");
        }
        if (cpfExiste){
            throw new DadosEmUso("O CPF utilizado já está em uso.");
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
