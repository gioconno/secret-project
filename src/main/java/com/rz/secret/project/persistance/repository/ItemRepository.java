package com.rz.secret.project.persistance.repository;

import com.rz.secret.project.persistance.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
