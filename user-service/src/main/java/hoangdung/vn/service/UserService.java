package hoangdung.vn.service;

import hoangdung.vn.entity.User;
import hoangdung.vn.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseServiceImpl<User> {

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    /**
     * Provides the entity name (used in exception messages).
     *
     * @return the entity name
     */
    @Override
    protected String getEntityName() {
        return "Core service";
    }
}
