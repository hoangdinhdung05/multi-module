package hoangdung.vn.service;

import hoangdung.vn.entity.BaseEntity;
import hoangdung.vn.exception.ResourceNotFoundException;
import hoangdung.vn.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Abstract implementation of {@link BaseService} providing common CRUD operations.
 *
 * @param <T> the type of entity extending {@link BaseEntity}
 */
@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    /** Repository instance for entity persistence operations. */
    protected final BaseRepository<T> repository;

    /**
     * Provides the entity name (used in exception messages).
     *
     * @return the entity name
     */
    protected abstract String getEntityName();

    /** {@inheritDoc} */
    @Override
    public T create(T entity) {
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID().toString());
        }
        if (entity.getCreatedAt() == null) {
            entity.setCreatedAt(LocalDateTime.now());
        }
        entity.setUpdatedAt(LocalDateTime.now());
        return repository.save(entity);
    }

    /** {@inheritDoc} */
    @Override
    public T update(String id, T entity) {
        T existingEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getEntityName(), id));

        entity.setId(id);
        entity.setCreatedAt(existingEntity.getCreatedAt());
        entity.setCreatedBy(existingEntity.getCreatedBy());
        entity.setUpdatedAt(LocalDateTime.now());

        return repository.save(entity);
    }

    /** {@inheritDoc} */
    @Override
    public Optional<T> findById(String id) {
        return repository.findById(id);
    }

    /** {@inheritDoc} */
    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    /** {@inheritDoc} */
    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteById(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(getEntityName(), id);
        }
        repository.deleteById(id);
    }

    /** {@inheritDoc} */
    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    /** {@inheritDoc} */
    @Override
    public long count() {
        return repository.count();
    }

    /** {@inheritDoc} */
    @Override
    public List<T> findByCreatedBy(String createdBy) {
        return repository.findByCreatedBy(createdBy);
    }

    /** {@inheritDoc} */
    @Override
    public Page<T> findByCreatedBy(String createdBy, Pageable pageable) {
        return repository.findByCreatedBy(createdBy, pageable);
    }

    /** {@inheritDoc} */
    @Override
    public long countByCreatedBy(String createdBy) {
        return repository.countByCreatedBy(createdBy);
    }

    /** {@inheritDoc} */
    @Override
    public Optional<T> findByIdAndCreatedBy(String id, String createdBy) {
        return repository.findByIdAndCreatedBy(id, createdBy);
    }

    /** {@inheritDoc} */
    @Override
    public boolean existsByIdAndCreatedBy(String id, String createdBy) {
        return repository.existsByIdAndCreatedBy(id, createdBy);
    }
}
