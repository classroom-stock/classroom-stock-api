package com.tally.domain.account.application;

import com.tally.domain.account.application.model.AccountCommand;
import com.tally.domain.account.application.model.AccountQuery;
import com.tally.domain.account.domain.AccountRepository;
import com.tally.domain.account.domain.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.tally.domain.account.domain.entity.Account.registered;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountQuery.RegisterAccount signUp(final AccountCommand.RegisterAccount command) {
        final Account account = accountRepository.save(registered(command.getEmail(), command.getPassword()));
        return AccountQuery.RegisterAccount.toQuery(account);
    }
}
