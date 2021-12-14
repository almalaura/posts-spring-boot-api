package com.springboot.posts.apirest.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.posts.apirest.models.entity.Post;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {

}
