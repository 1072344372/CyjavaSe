package gamehall.controller;

import gamehall.model.domain.User;
import gamehall.service.UserService;

import java.util.Scanner;

/**
 * 用户控制器
 *
 */
public class UserController {
    private Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserService();
    public static boolean isLogin=false;
    public static boolean flag = true;
    public static String UserName;
    // 显示窗口
    public void show() {
        while (flag) {
            System.out.println("--------欢迎来到趣玩中心--------");
            System.out.println("请输入您的选择: 1.登录  2.注册  3.退出  ");
            String next = scanner.next();
            switch (next) {
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    flag = false;
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入");
            }
        }
    }

    /**
     * 注册
     */
    private void register() {
        registerOrLogin(true);
    }

    /**
     * 登录
     */
    private void login() {
        registerOrLogin(false);

    }

    /**
     * 注册或登录
     *
     * @param isRegister true 表示注册，false 表示登录
     */
    private void registerOrLogin(boolean isRegister) {
        System.out.println("请输入账户和密码进行" + (isRegister ? "注册" : "登录") + "~");
        String userName = isRegister ? inputRegisterUserName() : inputLoginUserName();
        if ("-1".equals(userName)) {
            return;
        }
        String userPassword = inputStr("密码");
        if ("-1".equals(userPassword)) {
            return;
        }
        User user = new User();
        user.setUsername(userName);
        user.setPassword(userPassword);
        if (isRegister) {
            userService.register(user);
        } else {
            User login = userService.login(user);
            if (login==null){
                System.out.println("登录失败~密码错误");
            }else {
                System.out.println("登录成功 欢迎您"+user.getUsername()+"~");
                UserName=user.getUsername();
                isLogin=true;
                flag=false;
            }
        }
    }


    /**
     * 输入正确的用户名 输入-1返回
     *
     * @param isRegister true 表示注册，false 表示登录
     * @return {@link String}
     */
    private String inputUserName(boolean isRegister) {
        String userName = "-1";
        String userInput;
        while (true) {
            System.out.println("请输入要输入的用户账号 输入-1返回");
            userInput = scanner.next();
            if ("-1".equals(userInput)) {
                break;
            }
            boolean exists = userService.isExists(userInput);
            if ((isRegister && exists) || (!isRegister && !exists)) {
                System.out.println("您输入的用户名" + (isRegister ? "已存在" : "不存在") + "，请重新输入");
            } else {
                userName = userInput;
                break;
            }
        }
        return userName;
    }

    /**
     * 输入正确的登录用户名 输入-1返回
     *
     * @return {@link String}
     */
    private String inputRegisterUserName() {
        return inputUserName(true);
    }

    /**
     * 输入正确的登录用户名 输入-1返回
     *
     * @return {@link String}
     */
    private String inputLoginUserName() {
        return inputUserName(false);
    }

    /**
     * 得到用户输入的字符串 输入-1返回
     *
     * @param msg 传入的提示信息
     * @return {@link String}
     */
    private String inputStr(String msg) {
        System.out.println("请输入要输入的" + msg + " 输入-1返回");
        return scanner.next();
    }
}
