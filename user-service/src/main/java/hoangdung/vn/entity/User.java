package hoangdung.vn.entity;

import hoangdung.vn.utils.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Column(nullable = false, length = 36)
    private String userId;

    @Column(nullable = false, length = 36)
    private String friendId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status;
}
