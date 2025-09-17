package hoangdung.vn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_user_profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile extends BaseEntity {
    @Column(nullable = false, length = 36)
    private String accountId;

    @Column(nullable = false)
    private String fullName;

    private String avatarUrl;
}
