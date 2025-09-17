package hoangdung.vn.controller;

import hoangdung.vn.entity.User;
import hoangdung.vn.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends BaseController<User> {

    public UserController(UserService service) {
        super(service);
    }

    @Override
    protected String getEntityName() {
        return "Friendship";
    }
}