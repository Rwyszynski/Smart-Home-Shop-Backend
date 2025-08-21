package com.kodilla.smarthomeshop.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    public UUID uuid = UUID.randomUUID();;

    @CreationTimestamp
    public Instant created;

    @Version
    private Integer version;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BaseEntity that = (BaseEntity) obj;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
