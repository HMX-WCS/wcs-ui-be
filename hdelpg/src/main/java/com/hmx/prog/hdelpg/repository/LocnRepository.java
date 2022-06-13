package com.hmx.prog.hdelpg.repository;


import com.hmx.prog.hdelpg.domain.LOCN;
import com.hmx.prog.hdelpg.domain.embeded.LocnId;
import com.hmx.prog.hdelpg.domain.status.Locked;
import com.hmx.prog.hdelpg.domain.status.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface LocnRepository extends JpaRepository<LOCN, LocnId> {
    @Query(nativeQuery = true, value = "select * from locn " +
            "left outer join load on lo_loadid = ld_loadid ")
    List<LOCN> findAll();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update Locn set lo_loadid = :loadid, lo_status = :status, lo_locked = :locked " +
            "where lo_locrow = :locrow and lo_locbay = :locbay and lo_loclev = :loclev and lo_saisle = :saisle")
    void createData(@Param("loadid") String loadid, @Param("status") String status, @Param("locked") String locked,
                    @Param("locrow") String locrow, @Param("locbay") String locbay, @Param("loclev") String loclev, @Param("saisle") String saisle);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update Locn set lo_status = :status, lo_locked = :locked " +
            "where lo_loadid = :loadid")
    void updateData(@Param("loadid") String loadid, @Param("status") String status, @Param("locked") String locked);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update Locn set lo_status = :status, lo_locked = :locked, lo_loadid = null " +
            "where lo_loadid = :loadid")
    void deleteData(@Param("loadid") String loadid, @Param("status") String status, @Param("locked") String locked);
}

