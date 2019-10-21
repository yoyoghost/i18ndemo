package com.i18n.demo.util;

import com.i18n.demo.common.I18nConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Locale;

/**
 * @author : sihk
 * @version :
 * @date : Created in 下午6:12 2019/10/21
 */
@Component
public class I18NUtil {

    @Autowired
    MessageSource messageSource;

    public String getMsg(I18nConst.Msg msg, Locale locale) {

        String message;
        try {
            // 这里可以换成数据库或者缓存读取的逻辑
            message = messageSource.getMessage(msg.getKey(), null, locale);
        } catch (NoSuchMessageException e) {
            message = "";
        }

        if(StringUtils.isEmpty(message)) {
            message = msg.getDefaultValue();
        }

        return message;
    }

}
