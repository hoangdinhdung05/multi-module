package hoangdung.vn.repository;

import hoangdung.vn.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * BaseRepository định nghĩa các phương thức chung cho tất cả Repository trong hệ thống.
 * <p>
 * Sử dụng {@link NoRepositoryBean} để tránh việc Spring Data JPA tạo bean trực tiếp cho interface này.
 * Các repository khác sẽ kế thừa từ đây để có sẵn các method chung.
 *
 * @param <T> Kiểu entity, phải kế thừa từ {@link BaseEntity}.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, String> {

    /**
     * Lấy danh sách entity theo trường {@code createdBy}.
     *
     * @param createdBy Người tạo entity.
     * @return Danh sách entity.
     */
    @Query("SELECT e FROM #{#entityName} e WHERE e.createdBy = :createdBy")
    List<T> findByCreatedBy(@Param("createdBy") String createdBy);

    /**
     * Lấy danh sách entity theo {@code createdBy}, có phân trang.
     *
     * @param createdBy Người tạo entity.
     * @param pageable  Thông tin phân trang.
     * @return Trang kết quả chứa entity.
     */
    @Query("SELECT e FROM #{#entityName} e WHERE e.createdBy = :createdBy")
    Page<T> findByCreatedBy(@Param("createdBy") String createdBy, Pageable pageable);

    /**
     * Lấy danh sách entity được tạo trong khoảng thời gian chỉ định.
     *
     * @param startDate Ngày bắt đầu.
     * @param endDate   Ngày kết thúc.
     * @return Danh sách entity.
     */
    @Query("SELECT e FROM #{#entityName} e WHERE e.createdAt BETWEEN :startDate AND :endDate")
    List<T> findByCreatedAtBetween(@Param("startDate") LocalDateTime startDate,
                                   @Param("endDate") LocalDateTime endDate);

    /**
     * Lấy danh sách entity được tạo sau thời điểm chỉ định.
     *
     * @param date Ngày giờ mốc.
     * @return Danh sách entity.
     */
    @Query("SELECT e FROM #{#entityName} e WHERE e.createdAt >= :date")
    List<T> findByCreatedAtAfter(@Param("date") LocalDateTime date);

    /**
     * Lấy danh sách entity được cập nhật sau thời điểm chỉ định.
     *
     * @param date Ngày giờ mốc.
     * @return Danh sách entity.
     */
    @Query("SELECT e FROM #{#entityName} e WHERE e.updatedAt >= :date")
    List<T> findByUpdatedAtAfter(@Param("date") LocalDateTime date);

    /**
     * Đếm số lượng entity theo {@code createdBy}.
     *
     * @param createdBy Người tạo entity.
     * @return Số lượng entity.
     */
    @Query("SELECT COUNT(e) FROM #{#entityName} e WHERE e.createdBy = :createdBy")
    long countByCreatedBy(@Param("createdBy") String createdBy);

    /**
     * Tìm entity theo id và người tạo.
     *
     * @param id        ID của entity.
     * @param createdBy Người tạo entity.
     * @return Optional chứa entity nếu tồn tại.
     */
    Optional<T> findByIdAndCreatedBy(String id, String createdBy);

    /**
     * Kiểm tra entity có tồn tại với id và người tạo hay không.
     *
     * @param id        ID của entity.
     * @param createdBy Người tạo entity.
     * @return {@code true} nếu tồn tại, ngược lại {@code false}.
     */
    boolean existsByIdAndCreatedBy(String id, String createdBy);
}
