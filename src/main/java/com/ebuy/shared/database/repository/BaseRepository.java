package com.ebuy.shared.database.repository;

import com.ebuy.shared.database.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
/**
 * @created 11/12/2020 - 6:36 PM
 * @project ebuy
 * @author Abdur Rahim Nishad
 */
@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long> {
    Optional<E> findByIdAndIsDeleted(long id, boolean isDeleted);
    Page<E> findAllByIdAndIsDeleted(long id, boolean isDeleted, Pageable pageable);
    List<E> findAllByIdAndIsDeleted(long id, boolean isDeleted);
    Page<E> findByIdInAndIsDeleted(Set<Long> oid, boolean isDeleted, Pageable pageable);

    Optional<E> findByCreatedAtAndIsDeleted(LocalDateTime createdAt, boolean isDeleted);
    Page<E> findByCreatedAtDateBetween(LocalDateTime startDate, LocalDateTime endDate,Pageable pageable);
    Page<E> findByCreatedAtDateAfter(LocalDateTime date, Pageable pageable);
    Page<E> findByCreatedAtDateBefore(LocalDateTime date,Pageable pageable);
    Page<E> findByModifiedAtDateBetween(LocalDateTime startDate, LocalDateTime endDate,Pageable pageable);
    Page<E> findByModifiedAtDateAfter(LocalDateTime date,Pageable pageable);
    Page<E> findByModifiedAtDateBefore(LocalDateTime date,Pageable pageable);

    Optional<E> findByModifiedByAndIsDeleted(String name,boolean isDeleted);
    Page<E> findAllByModifiedByAndIsDeleted(String name,boolean isDeleted,Pageable pageable);

    Optional<E> findByCreatedByAndIsDeleted(String name,boolean isDeleted);
    Page<E> findAllByCreatedByAndIsDeleted(String name,boolean isDeleted,Pageable pageable);

    List<E> findAllByIsDeletedFalse();
    Page<E> findAllByIsDeletedFalse(Pageable pageable);
}
