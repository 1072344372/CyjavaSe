package gamehall.dao;

import gamehall.model.domain.User;

public class UserDao {
    private static User[] users = new User[10];

    static {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setMoney(99999.d);
        users[0] = user;
    }

    public int add(User user) {
        int index = -1;
        if (users==null||users.length==0||user==null) return index;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                index = i;
                break;
            }
        }
        return index;
    }

    public User[] findAllUser() {
        return users;
    }
    public User getByUsername(String username) {
        if (username==null||"".equals(username.trim())) return null;
        if (users==null||users.length==0) return null;
        User user =null;
        for (int i = 0; i < users.length; i++) {
                user=users[i];
                if (user!=null&&username.equals(user.getUsername())) return user;
        }
        return user;
    }
}
