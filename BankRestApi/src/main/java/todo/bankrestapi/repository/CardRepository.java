package todo.bankrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.bankrestapi.entity.Card;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByUserId(Long userId, Pageable pageable);
    List<Card> findByUserId(Long userId);
    List<Card> findAll(Pageable pageable);
}
