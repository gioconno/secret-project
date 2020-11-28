package com.rz.secret.project.service;

import com.rz.secret.project.persistance.model.Receipt;
import com.rz.secret.project.persistance.repository.ReceiptRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReceiptRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ReceiptRepository receiptRepository;

    @Before
    public void setUp() {


    }

    @Test
    public void whenInsert_thenReturnReceipt() {
        // given
        Receipt given = new Receipt();

        // when
        given = testEntityManager.persist(given);
        testEntityManager.flush();

        // then
        System.out.println(given);
    }

}
