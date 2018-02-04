package com.yy.springbootswagger.exception;

/**
 * @package: com.yy.springbootswagger.exception
 * @Description: 异常处理类
 * @Date: Created in  2018-02-01 16:03
 * @Author: yy
 */
public class MyException extends RuntimeException{
    private static final long serialVersionUID = -957121052092123200L;

    public MyException(Object object) {
        super(object.toString());
    }
}
