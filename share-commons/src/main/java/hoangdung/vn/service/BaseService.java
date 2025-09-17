package hoangdung.vn.service;

import hoangdung.vn.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * BaseService định nghĩa các thao tác CRUD chung cho tất cả service.
 *
 * @param <T> Kiểu entity, phải kế thừa từ {@link BaseEntity}.
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * Tạo mới một entity.
     *
     * @param entity Thông tin entity cần tạo.
     * @return Entity sau khi được lưu.
     */
    T create(T entity);

    /**
     * Cập nhật entity theo id.
     *
     * @param id     ID của entity cần cập nhật.
     * @param entity Thông tin cập nhật.
     * @return Entity sau khi được cập nhật.
     */
    T update(String id, T entity);

    /**
     * Tìm entity theo id.
     *
     * @param id ID của entity.
     * @return Optional chứa entity nếu tồn tại.
     */
    Optional<T> findById(String id);

    /**
     * Lấy toàn bộ danh sách entity.
     *
     * @return Danh sách entity.
     */
    List<T> findAll();

    /**
     * Lấy danh sách entity có phân trang.
     *
     * @param pageable Thông tin phân trang.
     * @return Trang kết quả chứa entity.
     */
    Page<T> findAll(Pageable pageable);

    /**
     * Xóa entity theo id.
     *
     * @param id ID của entity cần xóa.
     */
    void deleteById(String id);

    /**
     * Kiểm tra entity có tồn tại theo id không.
     *
     * @param id ID của entity.
     * @return {@code true} nếu tồn tại, ngược lại {@code false}.
     */
    boolean existsById(String id);

    /**
     * Đếm tổng số entity.
     *
     * @return Số lượng entity.
     */
    long count();

    /**
     * Lấy danh sách entity theo {@code createdBy}.
     *
     * @param createdBy Người tạo entity.
     * @return Danh sách entity.
     */
    List<T> findByCreatedBy(String createdBy);

    /**
     * Lấy danh sách entity theo {@code createdBy}, có phân trang.
     *
     * @param createdBy Người tạo entity.
     * @param pageable  Thông tin phân trang.
     * @return Trang kết quả chứa entity.
     */
    Page<T> findByCreatedBy(String createdBy, Pageable pageable);

    /**
     * Đếm số entity theo {@code createdBy}.
     *
     * @param createdBy Người tạo entity.
     * @return Số lượng entity.
     */
    long countByCreatedBy(String createdBy);

    /**
     * Tìm entity theo id và {@code createdBy}.
     *
     * @param id        ID của entity.
     * @param createdBy Người tạo entity.
     * @return Optional chứa entity nếu tồn tại.
     */
    Optional<T> findByIdAndCreatedBy(String id, String createdBy);

    /**
     * Kiểm tra entity có tồn tại theo id và {@code createdBy} không.
     *
     * @param id        ID của entity.
     * @param createdBy Người tạo entity.
     * @return {@code true} nếu tồn tại, ngược lại {@code false}.
     */
    boolean existsByIdAndCreatedBy(String id, String createdBy);
}
