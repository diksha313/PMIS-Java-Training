package com.quickrelief.demo1.repository;

import com.quickrelief.demo1.SupplyRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class RequestRepository {

    private final JdbcTemplate jdbcTemplate;

    public RequestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int saveRequest(SupplyRequest request) {

        String sql = "INSERT INTO requests " +
                "(item_name, quantity, status, requested_by) " +
                "VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                request.getItemName(),
                request.getQuantity(),
                request.getStatus(),
                request.getRequestedBy()
        );
    }
    public List<SupplyRequest> findAllRequests() {

        String sql = "SELECT id, item_name, quantity, status, requested_by FROM requests";

        RowMapper<SupplyRequest> rowMapper = (rs, rowNum) -> {
            SupplyRequest request = new SupplyRequest();
            request.setId(rs.getLong("id"));
            request.setItemName(rs.getString("item_name"));
            request.setQuantity(rs.getInt("quantity"));
            request.setStatus(rs.getString("status"));
            request.setRequestedBy(rs.getString("requested_by"));
            return request;
        };

        return jdbcTemplate.query(sql, rowMapper);
    }
}
