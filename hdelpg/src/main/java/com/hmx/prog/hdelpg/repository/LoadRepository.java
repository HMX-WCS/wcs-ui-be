package com.hmx.prog.hdelpg.repository;

import com.hmx.prog.hdelpg.domain.LOAD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional(readOnly = true)
public interface LoadRepository extends JpaRepository<LOAD, String> {
    @Query(nativeQuery = true, value = "select * from load " +
            "left outer join locn on ld_loadid = lo_loadid " +
            "where ld_status = '정상' and ld_loadst = '정상'" +
            "  and lo_status = '정상' and lo_locked = '허가' ")
    List<LOAD> findEnableList();

    @Transactional
    @Query(nativeQuery = true, value = "select * from load where ld_loadid = :loadid")
    LOAD findByLoadid(@Param("loadid") String loadid);

    @Transactional
    @Query(nativeQuery = true, value = "select * from load where ld_locatn = :locatn")
    List<LOAD> findDataByLocatn(@Param("locatn") String locatn);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into load(ld_loadid, ld_status, ld_loadst, ld_locatn) " +
            "values(:loadid, :status, :loadst, :locatn)")
    void createData(@Param("loadid") String loadid, @Param("status") String status,
                    @Param("loadst") String loadst, @Param("locatn") String locatn);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update load set ld_status = :status, ld_loadst = :loadst " +
            "where ld_loadid = :loadid")
    void updateData(@Param("loadid") String loadid, @Param("status") String status, @Param("loadst") String loadst);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from load where ld_loadid = :loadid")
    void deleteData(@Param("loadid") String loadid);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into load(ld_loadid, ld_serial, ld_status, ld_loadst) " +
            "values(:loadid, :serial, :status, :loadst)")
    void saveCustomIbnd(@Param("loadid") String loadid, @Param("serial") String serial, @Param("status") String status,
                        @Param("loadst") String loadst);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update load set ld_status = :status, ld_loadst = :loadst " +
            "where ld_loadid = :loadid")
    void updateCustomObnd(@Param("loadid") String loadid, @Param("status") String status, @Param("loadst") String loadst);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value =
            "insert into LOAD(LD_LOADID, LD_SERIAL, LD_PLTID, LD_STATUS, LD_LOADST, LD_PLTSIZ)"
                    + "values(:loadid, :serial, :pltid, :status, :loadst, :pltsiz)"
    )
    int saveInbound(@Param("loadid") String loadid,
                    @Param("serial") String serial,
                    @Param("pltid") String pltid,
                    @Param("status") String status,
                    @Param("loadst") String loadst,
                    @Param("pltsiz") String pltsiz
    );
}

