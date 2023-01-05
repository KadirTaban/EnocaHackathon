package koza.dev.customerAddress.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private LocalDateTime createdTime = LocalDateTime.now();
    private LocalDateTime updatedTime = LocalDateTime.now();

}
