package com.review.databasepool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 */
public class ConnectionPool {

    private static volatile ConnectionPool connectionPool;

    private LinkedList<Connection> pool = new LinkedList<>();

    private ConnectionPool () {
    }

    /**
     * 构造方法初始化
     * @param initialSize
     */
    private ConnectionPool (int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    /**
     * 获取实例
     * @param initialSize
     * @return
     */
    public static ConnectionPool getInstance (int initialSize) {
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                if (connectionPool == null) {
                    connectionPool = new ConnectionPool(initialSize);
                }
            }
        }
        return connectionPool;
    }

    /**
     * 释放连接，放回到连接池
     * @param connection
     */
    public void relaseConnection (Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                // 连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     * 获取链接，若在mills内无法获取到连接，返回null
     * @param mills
     * @return
     */
    public Connection fetchConnection (long mills) throws Exception {
        synchronized (pool) {
            if (mills < 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    //等待超时
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }

                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }

}
