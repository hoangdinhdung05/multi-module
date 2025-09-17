package hoangdung.vn.controller;

import hoangdung.vn.entity.Account;
import hoangdung.vn.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController extends BaseController<Account> {

    public AccountController(AccountService service) {
        super(service);
    }

    @Override
    protected String getEntityName() {
        return "Account";
    }
}