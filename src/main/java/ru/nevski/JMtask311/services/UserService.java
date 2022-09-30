package ru.nevski.JMtask311.services;

import ru.nevski.JMtask311.models.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(int id);
    void save(User person);
    void update(int id, User updatedPerson);
    void delete(int id);
}
