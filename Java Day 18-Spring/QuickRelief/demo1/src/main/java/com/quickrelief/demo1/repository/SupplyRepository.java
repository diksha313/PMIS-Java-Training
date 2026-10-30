
package com.quickrelief.demo1.repository;

import com.quickrelief.demo1.Supply;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplyRepository {

    private final JdbcTemplate jdbcTemplate;

    public SupplyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Supply> supplyRowMapper = (rs, rowNum) -> {
        Supply supply = new Supply();
        supply.setId(rs.getLong("id"));
        supply.setItemName(rs.getString("item_name"));
        supply.setQuantity(rs.getInt("quantity"));
        return supply;
    };

    public List<Supply> findAll() {
        String sql = "SELECT id, item_name, quantity FROM supplies";
        return jdbcTemplate.query(sql, supplyRowMapper);
    }

    public int addOrRestock(Supply supply) {
        String updateSql =
                "UPDATE supplies SET quantity = quantity + ? WHERE item_name = ?";

        int updated = jdbcTemplate.update(
                updateSql, supply.getQuantity(), supply.getItemName());

        if (updated == 0) {
            String insertSql =
                    "INSERT INTO supplies (item_name, quantity) VALUES (?, ?)";

            jdbcTemplate.update(
                    insertSql, supply.getItemName(), supply.getQuantity());
        }
        return 1;
    }
    public int getAvailableQuantity(String itemName) {

        String sql = "SELECT quantity FROM supplies WHERE item_name = ?";

        List<Integer> result = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> rs.getInt("quantity"),
                itemName
        );

        if (result.isEmpty()) {
            return 0;
        }

        return result.get(0);
    }
    public int deductStock(String itemName, int quantity) {

        String sql = "UPDATE supplies " +
                "SET quantity = quantity - ? " +
                "WHERE item_name = ? AND quantity >= ?";

        return jdbcTemplate.update(
                sql,
                quantity,
                itemName,
                quantity
        );
    }

}
