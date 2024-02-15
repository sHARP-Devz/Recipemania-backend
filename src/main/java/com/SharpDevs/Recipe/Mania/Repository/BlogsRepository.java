package com.SharpDevs.Recipe.Mania.Repository;

import com.SharpDevs.Recipe.Mania.domain.Entity.BlogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogsRepository extends CrudRepository<BlogsEntity, Long> {
    List<BlogsEntity> findAll();

    boolean existsById(Long id);
}
