package com.imooc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BizException extends RuntimeException {
    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public BizException(Throwable throwable) {
        super(throwable);
    }
}
