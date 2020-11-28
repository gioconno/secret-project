package com.rz.secret.project.service;

import com.rz.secret.project.persistance.model.Address;
import com.rz.secret.project.persistance.model.Store;
import com.rz.secret.project.persistance.repository.StoreRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StoreRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private StoreRepository storeRepository;

    @Before
    public void setUp() {
        Store store1 = new Store();
        store1.setChain("catena1");
        store1.setDescription("descrizione1");

        Store store2 = new Store();
        store2.setChain("catena2");
        store2.setDescription("descrizione1");

        Store store3 = new Store();
        store3.setChain("catena1");
        store3.setDescription("descrizione2");

        testEntityManager.persist(store1);
        testEntityManager.persist(store2);
        testEntityManager.persist(store3);

        testEntityManager.flush();


    }

    @Test
    public void whenFindByCatena_thenReturnStores() {
        // given

        // when
        List<Store> result = storeRepository.findByChain("catena1");

        // then
        assertThat(result).hasSize(2);
    }

    @Test
    public void whenFindByCatenaDescrizione_thenReturnStore() {
        // given
        String catena = "catena1";
        String descrizione = "descrizione1";

        // when
        Optional<Store> result = storeRepository.findByChainAndDescription(catena, descrizione);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result.get().getChain()).isEqualTo(catena);
        assertThat(result.get().getDescription()).isEqualTo(descrizione);
    }

    @Test
    public void whenFindByCatenaDescrizioneNotFound_thenReturnEmpty() {
        // given
        String catena = "catena1";
        String descrizione = "not-found-store";

        // when
        Optional<Store> result = storeRepository.findByChainAndDescription(catena, descrizione);

        // then
        assertThat(result).isEmpty();

    }

    @Test
    public void whenInsertStore_thenInsertAddress(){
        // given
        Store store = new Store();
        store.setChain("catena");
        store.setDescription("descrizione");

        Address address = new Address();
        address.setZipCode("zip");
        address.setProvince("province");
        address.setNumber("number");
        address.setCity("city");
        address.setAddress("address");

        store.setAddress(address);

        // when
       Store result = testEntityManager.persistAndFlush(store);

        // then
        assertThat(store.getAddress().getId()).isNotNull();


    }
}
