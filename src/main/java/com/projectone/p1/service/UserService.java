package com.projectone.p1.service;

import com.projectone.p1.model.User;

import java.util.List;

public interface UserService {
    public boolean addUser(User user);
    public boolean deleteUser(int userId);
    public boolean updateUser(User user);
    public int getUserId(int userId);

   public User getUserById(int userId);

    public boolean isUserExists(int userId);
    public User getUserByUsername(String username);
    public List<User> getUsers();
    public boolean isUsernameAndPasswordCorrect(String username, String password);

    boolean isUsernameExist(String username);
    User login (String username, String password);
    void logout();


}
