package com.example.store.Reporistory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.store.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
Optional<Store> findById(Integer storeid);
	
}
