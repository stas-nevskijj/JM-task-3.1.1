package ru.nevski.JMtask311.dao;

import ru.nevski.JMtask311.models.User;

import java.util.List;

public interface UserDAO {
    List<User> index();
    User show(int id);
    void save(User person);
    void update(int id, User updatedPerson);
    void delete(int id);
}
