package io.hhplus.tdd.point;

import io.hhplus.tdd.database.UserPointTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointServiceTest {
    @Test
    void 포인트_정상_조회() {
        // Given
        long userId = 1L;
        UserPointTable table = new UserPointTable();
        table.insertOrUpdate(userId, 1000);

        PointService service = new PointService(table);

        // When
        long result = service.getPoint(userId);

        // Then
        assertEquals(1000, result);
    }
}
