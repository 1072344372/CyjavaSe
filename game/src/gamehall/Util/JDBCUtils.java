package gamehall.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @version 1.0 这是一个工具类，完成 mysql的连接和关闭资源
 */
public class JDBCUtils {

	// 可以把几个字符串定义成常量：用户名，密码，URL，驱动类
	private static final String USER = "root";
	private static final String PWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jsp2?useUnicode=true&characterEncoding=UTF-8";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static ThreadLocal<Connection> threadLocalConn =
			new ThreadLocal<>();

	/**
	 * 驱动的注册
	 */
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到数据库的连接
	 * 
	 * @return : 返回数据库的连接
	 * @throws SQLException : SQL的异常
	 */
	public static Connection getConnection() throws SQLException {
		//DriverManager.getConnection(URL, USER, PWD);
		Connection connection = threadLocalConn.get();
		if (connection == null) {//说明当前的threadLocalConn没有连接
			//就注册一个连接放入, threadLocalConn
			try {
				connection = DriverManager.getConnection(URL, USER, PWD);
				//将连接设置为手动提交, 即不要自动提交
				connection.setAutoCommit(false);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
			threadLocalConn.set(connection);
		}
		return connection;
	}
	/**
	 * 提交事务, mysql事务+线程+过滤器机制+ThreadLocal
	 */
	public static  void commit() {

		Connection connection = threadLocalConn.get();
		if(connection != null) {//确保该连接是有效

			try {
				connection.commit();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				try {
					connection.close();//关闭连接
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}

		//老师说明
		//1. 当提交后，需要把connection从 threadLocalConn 清除掉
		//2. 不然，会造成 threadLocalConn 长时间持有该连接, 会影响效率
		//3. 也因为我们Tomcat底层使用的是线程池技术
		threadLocalConn.remove();

	}

	/**
	 * 所谓回滚，是回滚/撤销和 connection管理的操作删掉，修改，添加
	 */
	public static  void rollback() {

		Connection connection = threadLocalConn.get();
		if(connection != null) {//保证当前的连接是有效

			try {
				connection.rollback();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}

		threadLocalConn.remove();
	}
	/**
	 * 关闭所有打开的资源
	 * 
	 * @param connection : 连接的对象
	 * @param statement  : 执行SQL语句的对象
	 * @throws SQLException
	 */
	public static void close(Connection connection, Statement statement) throws SQLException {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
