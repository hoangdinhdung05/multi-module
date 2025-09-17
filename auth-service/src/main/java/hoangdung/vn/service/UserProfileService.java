package hoangdung.vn.service;

import hoangdung.vn.entity.UserProfile;
import hoangdung.vn.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends BaseServiceImpl<UserProfile> {

    public UserProfileService(UserProfileRepository repository) {
        super(repository);
    }

    @Override
    protected String getEntityName() {
        return "User profile";
    }
}
