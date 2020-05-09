package com.imooc.aspect;

import com.imooc.enums.ExceptionEnum;
import com.imooc.exception.BizException;
import com.imooc.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    public JSONResult bizExceptionHandler(HttpServletRequest req, BizException e){
        log.error("发生业务异常！原因是：{}",e.getMessage());
        return JSONResult.errorMsg(e.getMessage());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    public JSONResult exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        /**
         * todo 添加錯誤信息枚舉
         */
        return JSONResult.errorException(ExceptionEnum.NULL_POINTER_ERROR.getMsg());
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    public JSONResult exceptionHandler(HttpServletRequest req, Exception e){
        log.error("未知异常！原因是:",e);
        /**
         * todo 添加錯誤信息枚舉
         */
        return JSONResult.errorException(ExceptionEnum.INTERNAL_SERVER_ERROR.getMsg());
    }
}

