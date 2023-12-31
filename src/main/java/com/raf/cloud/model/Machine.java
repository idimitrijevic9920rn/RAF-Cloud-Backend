package com.raf.cloud.model;


import com.raf.cloud.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "_machine")
public class Machine {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;

    private boolean active;

    @Version
    private Integer version = 0;

    @Column(updatable = false)
    private LocalDate creationDate;

    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDate.now();
    }

}
