package br.com.zup.desafios.casadocodigo.localizacao.estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    boolean existsByIdAndPais_Id(Long id, Long idPais);
}
