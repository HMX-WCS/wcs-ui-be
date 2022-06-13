package com.hmx.prog.hdelpg.repository;

import com.hmx.prog.hdelpg.domain.SERL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface SerialRepository extends JpaRepository<SERL, String> {
    @Query("select s.serial from SERL s where s.tblnam = 'MOVE'")
    String findSerial();

    @Query("select s.serial from SERL s where s.tblnam = 'LOAD'")
    String findLoadid();

    @Transactional
    @Modifying
    @Query("update SERL s set s.serial = :serial where s.tblnam = 'MOVE'")
    void changeSerial(@Param("serial") String serial);

    @Transactional
    @Modifying
    @Query("update SERL s set s.serial = :loadid where s.tblnam = 'LOAD'")
    void changeLoadid(@Param("loadid") String loadid);

}

