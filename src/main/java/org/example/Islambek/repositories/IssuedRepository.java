package org.example.Islambek.repositories;

import org.example.Islambek.model.Issued;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuedRepository extends JpaRepository<Issued, Long> {
}
