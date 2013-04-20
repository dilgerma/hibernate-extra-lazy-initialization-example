package de.effectivetrainings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.effectivetrainings.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
