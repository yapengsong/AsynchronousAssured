package com.didispace.repository;

import com.didispace.domain.p.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Long> {

    /*
    List<User> findByNameAndAddress(String name, String address);

    @Query(value = "from User u where u.name=:name")
    List<User> findByName1(@Param("name") String name);

    @Query(value = "select * from #{#entityName} u where u.name=?1", nativeQuery = true)
    List<User> findByName2(String name);

    List<User> findByName(String name);
    */
    List<Message> findByAreadlydeadAndStatus(String areadlydead, String status);

    //获得所有已经死亡的消息




}
