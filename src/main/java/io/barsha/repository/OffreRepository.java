package io.barsha.repository;

import io.barsha.models.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;


@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {

    @Query("SELECT o FROM Offre o WHERE o.dateValidite BETWEEN ?1 and ?2")
    List<Offre> findOffreBetweenDate(Instant debutOffre, Instant finOffre);

}


