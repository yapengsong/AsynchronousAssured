package com.didispace.repository;

import com.didispace.domain.p.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {


}
