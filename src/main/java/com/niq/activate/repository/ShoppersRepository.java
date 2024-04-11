package com.niq.activate.repository;

import com.niq.activate.entities.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppersRepository extends JpaRepository<Shopper, String> {
    Optional<Shopper> findByShopperId(String shopperId);
}
