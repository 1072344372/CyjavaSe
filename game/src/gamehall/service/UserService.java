package gamehall.service;

import gamehall.dao.UserDao;
import gamehall.model.domain.User;


public class UserService {
    private static UserDao userDao = new UserDao();

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return boolean
     */
    public boolean isExists(String username) {
        User[] users = userDao.findAllUser();
        if (users == null) return false;
        boolean res = false;
        User user = null;
        for (int i = 0; i < users.length; i++) {
            user = users[i];
            if (user != null && user.getUsername().equals(username)) {
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * 注册
     *
     * @param user 用户
     * @return boolean
     */
    public boolean register(User user) {
        boolean exists = isExists(user.getUsername());
        if (!exists) {
            return userDao.add(user) != -1;
        }
        return false;
    }

    public User login(User loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        User user=userDao.getByUsername(username);
        if (user==null) return null;
        if (!password.equals(user.getPassword()))return null;
        return user;
    }
}
