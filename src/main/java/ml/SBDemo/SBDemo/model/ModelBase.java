package ml.SBDemo.SBDemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class ModelBase<T> implements Searchable<T>{

    private Integer limit;
    private Integer page;
    private String sort;
    private Sort.Direction dir;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public Specification<T> getSpecification() {
        Specification<T> spec = Specification.where(null);
        // TODO: 26/07/2021 add search by date
        return spec;
    }

    @Override
    public Pageable getPageable() {
        return PageRequest.of(
                (page != null) ? page: 0,
                (limit != null && limit >= 0) ? limit: 10,
                getSort()
        );
    }

    @Override
    public Sort getSort() {
        if (sort == null) return Sort.unsorted();
        return (dir != null && dir == Sort.Direction.DESC) ?
                Sort.by(sort).descending(): Sort.by(sort).ascending();
    }
}
