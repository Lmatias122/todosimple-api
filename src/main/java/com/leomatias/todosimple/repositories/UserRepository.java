package com.leomatias.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leomatias.todosimple.models.User;
@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

    User findByUsername(String username);

}
