package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.model.Role;
import com.abseliamov.cinema.model.Viewer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewerDaoImpl extends AbstractDao<Viewer> {

    public ViewerDaoImpl(Connection connection, String tableName) {
        super(connection, tableName);
    }

    @Override
    public Viewer createEntity(ResultSet resultSet) throws SQLException {
        Role role = null;
        for (Role roleItem : Role.values()) {
            if (roleItem.getId() == resultSet.getLong("role_id")) {
                role = roleItem;
            }
        }
        return new Viewer(resultSet.getLong("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("password"),
                role,
                resultSet.getDate("birthday"));
    }

    public Viewer checkUserAuthorization(String name, String password) {
        return getAll().stream()
                .filter(viewer -> viewer.getName().equals(name))
                .filter(viewer -> viewer.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean update(long id, Viewer item) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
