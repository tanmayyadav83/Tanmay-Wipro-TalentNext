package com.example.springlogin.dao;
import com.example.springlogin.model.User;
import com.example.springlogin.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // row mapper
    private User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setEmployeeNo(rs.getString("employee_no"));
        u.setEmail(rs.getString("email"));
        return u;
    }

    public boolean createUser(User u) {
        String sql = "INSERT INTO users (username, password_hash, employee_no, email) VALUES (?, ?, ?, ?)";
        String hash = HashUtil.sha256(u.getPassword());
        int updated = jdbcTemplate.update(sql, u.getUsername(), hash, u.getEmployeeNo(), u.getEmail());
        return updated == 1;
    }

    public User findByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rn) -> mapRow(rs, rn), username);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public boolean validateLogin(String username, String password) {
        try {
            String sql = "SELECT password_hash FROM users WHERE username = ?";
            String stored = jdbcTemplate.queryForObject(sql, String.class, username);
            if (stored == null) return false;
            return stored.equals(HashUtil.sha256(password));
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
    }
}
