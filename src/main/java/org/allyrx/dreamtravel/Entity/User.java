package org.allyrx.dreamtravel.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.allyrx.dreamtravel.Enum.EnumUser;

@Entity
@Table(name = "users")
@Data @AllArgsConstructor @NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private EnumUser role;
}
