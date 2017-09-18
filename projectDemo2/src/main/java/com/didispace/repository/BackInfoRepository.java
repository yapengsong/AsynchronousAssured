package com.didispace.repository;

import com.didispace.domain.s.BackInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public interface BackInfoRepository extends JpaRepository<BackInfo,Long> {

    @Query(value = "select * from #{#back_info} i where i.msgid=?1 and i.uid=?2", nativeQuery = true)
    List<BackInfo> findByMidAndUid(String mid,String uid);

    @Query(value = "from BackInfo b where b.msgId=:msgId and b.uid=:uid")
    List<BackInfo> findByName1(@Param("msgId") String msgId,@Param("uid") String uid);
}
