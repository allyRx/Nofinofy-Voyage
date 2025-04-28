package org.allyrx.dreamtravel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.allyrx.dreamtravel.Enum.EnumRating;
import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "Places")
@Data @AllArgsConstructor
@NoArgsConstructor
public class Places {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String country;
    private String city;
    private String note;
    private boolean visited;
    private EnumRating rating;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "user_id")
    private User user;
}
