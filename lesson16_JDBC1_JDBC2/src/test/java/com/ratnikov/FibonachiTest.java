package com.ratnikov;

import com.ratnikov.HW.Calculator;
import com.ratnikov.HW.dao.FibonachiDao;
import com.ratnikov.HW.dao.FibonachiDaoImpl;
import com.ratnikov.HW.connection.DataSourceHelper;
import org.h2.tools.Server;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

public class FibonachiTest {

    private static FibonachiDao fibonachiDao;

    @BeforeAll
    public static void createDao() throws SQLException {
        DataSourceHelper.createDb();

        fibonachiDao = new FibonachiDaoImpl();

        Server.createTcpServer().start();
    }

    @BeforeEach
    public void beforeEachTest() {
        try (Statement statement = DataSourceHelper.connection().createStatement()) {
            statement.executeUpdate("truncate table FIBONACHI");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void insertFibonachi() {
        Calculator calculator = new Calculator();
        List<Integer> list = calculator.fibonachi(17);
        fibonachiDao.createFibonachi(list);

        System.out.println("Фибоначи: ");
        list.forEach(System.out::println);
    }

    @Test
    public void fibonachiCursorAvailability() {
        try (Connection connection = DataSourceHelper.connection()) {
            DatabaseMetaData metaData = connection.getMetaData();

            System.out.println("Движение курсора");
            System.out.println(metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
            System.out.println(metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println(metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

            System.out.println("Движение курсора с конкурентным доступом");
            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY));
            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE));

            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));

            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY));
            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));

            System.out.println("Действия с курсором после коммита");
            System.out.println(metaData.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));
            System.out.println(metaData.supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Test
    public void getFibonachi() {
        Calculator calculator = new Calculator();
        List<Integer> list = calculator.fibonachi(17);
        fibonachiDao.createFibonachi(list);
        List<Integer> fibonachi = fibonachiDao.getFibonachi(16);

        Assertions.assertEquals(fibonachi.get(0), list.get(15));
        System.out.println(fibonachi.get(0) + " = "+list.get(15));
    }
}

