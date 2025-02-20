package Finanzas05.Finanzas.cartera.infrastructure.repositories.jpa;

import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarteraRepository extends JpaRepository<Cartera, Long> {
}
