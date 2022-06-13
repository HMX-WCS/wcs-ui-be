package com.hmx.prog.hdelpg;

import com.hmx.prog.hdelpg.domain.QMove;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
public class HdelpgApplicationTests {
    @Autowired
    EntityManager em;

    @Test
    public void Test() {
    }
}

