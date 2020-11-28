package com.rz.secret.project.persistance.repository;

import com.rz.secret.project.persistance.model.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {
    List<Store> findByChain(String chain);

    Optional<Store> findByChainAndDescription(String chain, String description);
}
