package hoangdung.vn.service;

import hoangdung.vn.entity.Account;
import hoangdung.vn.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseServiceImpl<Account> {

    public AccountService(AccountRepository repository) {
        super(repository);
    }

    @Override
    protected String getEntityName() {
        return "Account";
    }
}