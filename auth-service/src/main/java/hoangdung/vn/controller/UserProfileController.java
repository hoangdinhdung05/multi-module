package hoangdung.vn.controller;

import hoangdung.vn.entity.UserProfile;
import hoangdung.vn.service.UserProfileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-profiles")
public class UserProfileController extends BaseController<UserProfile> {

    public UserProfileController(UserProfileService service) {
        super(service);
    }

    @Override
    protected String getEntityName() {
        return "User profile controller";
    }
}
