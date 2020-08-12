package edu.cuit.loop.titlejudge.exception;

import edu.cuit.loop.titlejudge.utils.Msg;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: qiuzp
 * @Date: 2019/1/13 0013 1:18
 * @Description:
 */
public class ExceptionAdvice {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler({DuplicateKeyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Msg DuplicateKeyException(DuplicateKeyException e) {
        String erorr = e.toString();
        logger.error(erorr);
//        e.printStackTrace();
        return Msg.fail().add("msg", "插入重复数据").add("error",erorr);
    }

    @ExceptionHandler({NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Msg NumberFormatException(NumberFormatException e) {
        String erorr = e.toString();
        logger.error(erorr);
//        e.printStackTrace();
        return Msg.fail().add("msg", "请注意插入的数据类型").add("error",erorr);
    }

    @ExceptionHandler({IndexOutOfBoundsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Msg IndexOutOfBoundsException(IndexOutOfBoundsException e) {
        String erorr = e.toString();
        logger.error(erorr);
//        e.printStackTrace();
        return Msg.fail().add("msg", "导入失败,请确认表结构是否正确").add("error",erorr);
    }
}
