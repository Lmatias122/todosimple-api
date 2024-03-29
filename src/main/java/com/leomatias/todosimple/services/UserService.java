package com.leomatias.todosimple.services;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leomatias.todosimple.models.User;
import com.leomatias.todosimple.repositories.TaskRepository;
import com.leomatias.todosimple.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;


    public User findById(Long id){
     
        Optional<User> user = this.userRepository.findById(id);
        

        return user.orElseThrow( ()-> new RuntimeException(
            "Usuário não encontrado! Id:"+ id + ", Tipo: " + User.class.getName()
            ));
    }


    @Transactional
    public User create(User obj){

        obj.setID(null);

        obj = this.userRepository.save(obj);
        this.taskRepository.saveAll(obj.getTasks());

        return obj;
    }

    @Transactional
    public User update(User obj){
        User newObj = findById(obj.getID());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    public void delete (Long id){
        findById(id);

        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir pois ha entidades relacionadas!");
        }
    }

}
