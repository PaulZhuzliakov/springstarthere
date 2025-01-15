package org.example.demo666.repository;

import org.example.demo666.mapper.AccountRowMapper;
import org.example.demo666.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

//@Repository
public class AccountRepository0 {
    private final JdbcTemplate jdbcTemplate;

    public AccountRepository0(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account getAccountById(long id) {
        String sql = "select * from account where id = ?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "update account set amount = ? where id = ?";
        jdbcTemplate.update(sql, amount, id);
    }

    public List<Account> getAllAccounts() {
        String sql = "select * from account";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }
}
