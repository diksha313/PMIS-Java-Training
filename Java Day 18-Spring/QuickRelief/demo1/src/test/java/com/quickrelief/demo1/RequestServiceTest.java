
package com.quickrelief.demo1;

import com.quickrelief.demo1.service.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class RequestServiceTest {

    @Autowired
    private RequestService requestService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void failedRequestShouldNotDeductStock() {
        jdbcTemplate.update("DELETE FROM requests");
        jdbcTemplate.update("DELETE FROM supplies");

        jdbcTemplate.update(
                "INSERT INTO supplies (item_name, quantity) VALUES (?, ?)",
                "Test Kit", 10
        );

        // Make the request insert fail after stock deduction.
        jdbcTemplate.execute(
                "ALTER TABLE requests ADD CONSTRAINT test_invalid_status " +
                        "CHECK (status <> 'APPROVED')"
        );

        SupplyRequest request = new SupplyRequest();
        request.setItemName("Test Kit");
        request.setQuantity(5);
        request.setRequestedBy("Test User");

        assertThrows(RuntimeException.class,
                () -> requestService.processRequest(request));

        int remainingStock = jdbcTemplate.queryForObject(
                "SELECT quantity FROM supplies WHERE item_name = ?",
                Integer.class,
                "Test Kit"
        );

        assertEquals(10, remainingStock);
    }
}
