package io.hhplus.tdd.point;

import io.hhplus.tdd.database.UserPointTable;

public class PointService {

    private final UserPointTable userPointTable;

    public PointService(UserPointTable userPointTable) {
        this.userPointTable = userPointTable;
    }

    public long getPoint(long userId) {
        UserPoint userPoint = userPointTable.selectById(userId);
        return userPoint.point();
    }

    public void charge(long userId, long amount) {
        if(amount <= 0) throw new IllegalArgumentException("충전 금액은 0보다 커야 합니다.");

        UserPoint current = userPointTable.selectById(userId);
        long newPoint = current.point() + amount;

        userPointTable.insertOrUpdate(userId, newPoint);
    }

    public void use(long userId, long amount) {
        UserPoint current = userPointTable.selectById(userId);

        long newPoint = current.point() - amount;
        userPointTable.insertOrUpdate(userId, newPoint);
    }
}
