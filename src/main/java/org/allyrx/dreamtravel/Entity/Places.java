package org.allyrx.dreamtravel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.allyrx.dreamtravel.Enum.EnumRating;

import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "Places")
@Data @AllArgsConstructor
@NoArgsConstructor
public class Places {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Name;
    private String country;
    private String city;
    private Integer note;
    private boolean visited;
    private EnumRating rating;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime createdAt = LocalDateTime.now();
}
