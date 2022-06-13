package com.hmx.prog.hdelpg.repository;


import com.hmx.prog.hdelpg.domain.MOVE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface MoveRepository extends JpaRepository<MOVE, String> {

    List<MOVE> findByWrktypAndStatus(String wrktyp, String status);

    @Query(nativeQuery = true, value = "select * from move where MV_SERIAL = :serial")
    MOVE findBySerial(String serial);

    @Query(nativeQuery = true, value = "select * from move where MV_LOADID = :loadid")
    MOVE findByLoadid(String loadid);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value =
            "insert into MOVE(MV_LOADID, MV_SERIAL, MV_WRKTYP, MV_STATUS, MV_ORDTYP, MV_FRSTTN, MV_TOSTTN, MV_PLTSIZ, MV_USERID)"
                    + "values(:loadid, :serial, :wrktyp, :status, :ordtyp, :frsttn, :tosttn, :pltsiz, :userid)")
    int insertWork(@Param("loadid") String loadid,
                   @Param("serial") String serial,
                   @Param("wrktyp") String wrktyp,
                   @Param("status") String status,
                   @Param("ordtyp") String ordtyp,
                   @Param("frsttn") String frsttn,
                   @Param("tosttn") String tosttn,
                   @Param("pltsiz") String pltsiz,
                   @Param("userid") String userid
    );
}
