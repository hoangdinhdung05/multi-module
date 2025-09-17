package hoangdung.vn.repository;

import hoangdung.vn.entity.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends BaseRepository<UserProfile> {
    Optional<UserProfile> findByAccountId(String accountId);

    @Query("SELECT u FROM UserProfile u WHERE u.fullName LIKE %:name%")
    List<UserProfile> findByFullNameContaining(@Param("name") String name);

    @Query("SELECT u FROM UserProfile u WHERE u.avatarUrl IS NOT NULL")
    List<UserProfile> findUsersWithAvatar();

    boolean existsByAccountId(String accountId);
}
