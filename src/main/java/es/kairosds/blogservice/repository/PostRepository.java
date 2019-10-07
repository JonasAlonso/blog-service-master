package es.kairosds.blogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.kairosds.blogservice.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
