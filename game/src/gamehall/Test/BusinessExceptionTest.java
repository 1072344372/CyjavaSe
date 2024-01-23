package gamehall.Test;

import gamehall.common.ErrorCode;
import gamehall.exception.BusinessException;

/**
 * 测试异常
 *
 * @author 罗汉
 * @date 2024/01/22
 */
public class BusinessExceptionTest {
    public static void main(String[] args) {
        try {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        } catch (BusinessException exception) {
            exception.printStackTrace();
        }
        System.out.println(1);
    }
}
