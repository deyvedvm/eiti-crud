package br.com.befullstack.eiticrud.services;

import br.com.befullstack.eiticrud.models.User;
import br.com.befullstack.eiticrud.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Serviçoes relacionados ao Usuário
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Busca Todos os usuários cadastrados
     *
     * @return lista de Usuários
     */
    public List<User> findAll() {

        LOGGER.info("Buscando todos os usuários");

        return userRepository.findAll();
    }

    /**
     * Busca usuário pelo Id
     *
     * @param id Id do usuário
     * @return Usuário localizado
     */
    public User findById(Integer id) {

        LOGGER.info("Buscando usuário por Id");

        return userRepository.findOne(id);
    }

    /**
     * Salva o novo usuário
     *
     * @param user Novo Usuário
     */
    public void saveUser(User user) {

        LOGGER.info("Salvando novo usuário");

        user.setRegisterDate(LocalDate.now());

        userRepository.save(user);
    }
}