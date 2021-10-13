package com.ratnikov.HW1.dao;

import com.ratnikov.HW1.SpringConfiguration;
import com.ratnikov.HW1.connection.DataSourceHelper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FibonachiDaoImpl implements FibonachiDao {
    private static final String INSERT_FIBONACHI_SQL = "insert into fibonachi (n, num) values (?, ?)";

    @PostConstruct
    public void truncateFibonachi() {
        try (Statement statement = DataSourceHelper.connection().createStatement()) {
            statement.executeUpdate("truncate table FIBONACHI");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void predestroyFibonachi() {
        System.out.println("----------- PreDestroy ---------------");
    }

    @Override
    @SneakyThrows
    public void createFibonachi(List<Integer> list) {
        try (PreparedStatement statement = DataSourceHelper.connection()
                .prepareStatement(INSERT_FIBONACHI_SQL)) {
            for (int i = 1; i < list.size(); i++) {
                createFibonachiStatement(statement, i, list.get(i - 1));
                statement.execute();
            }
        }
    }

    @Override
    @SneakyThrows
    public List<Integer> getFibonachi(int n) {
        List<Integer> list = new LinkedList<>();
        try (Statement statement = DataSourceHelper.connection().createStatement()) {
            statement.execute("select * from fibonachi where n=" + n);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                statement.execute("select * from fibonachi where n=" + n);
                resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    list.add(resultSet.getInt("num"));
                }
            }
        }
        return list;
    }

    private void createFibonachiStatement(PreparedStatement statement, int n, Integer num) throws SQLException {
        statement.setInt(1, n);
        statement.setInt(2, num);
    }
}
