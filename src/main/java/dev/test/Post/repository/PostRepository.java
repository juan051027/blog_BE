package dev.test.Post.repository;
import dev.test.Post.domain.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    Optional<PostEntity> findByName(String name);
}
