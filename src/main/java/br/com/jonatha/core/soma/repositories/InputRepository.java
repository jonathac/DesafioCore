package br.com.jonatha.core.soma.repositories;

import br.com.jonatha.core.soma.domain.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<Input,Integer> {

}
