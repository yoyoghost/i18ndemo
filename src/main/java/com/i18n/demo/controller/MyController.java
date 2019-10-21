package com.i18n.demo.controller;

import com.i18n.demo.common.I18nConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author : sihk
 * @version :
 * @date : Created in 上午10:52 2019/10/21
 */
@Slf4j
@RestController
public class MyController {

    /**
     * 获取request的方式有三种
     * 1. requestcontextholder
     * 2. autowired注入
     * 3. 写入方法的参数中使用 getMsg(HttpServletRequest request, String lang)
     */
    @Autowired
    private HttpServletRequest request;

    /**
     * 用来读取国际化的properties文件
     * 只需在application.yml中增加读取的文件路径即可 spring.message.basename=***,**
     * 多个用逗号分隔
     */
    @Autowired
    MessageSource messageSource;

    //@PostMapping("getMsg")
    @GetMapping("getMsg")
    public String getMsg(String lang) {

        Locale locale = RequestContextUtils.getLocale(request);

        log.info("locale is {}", locale.toString());

        /**
         * 使用springboot自带的多语言国际化
         * 通过配置不同国家或语言的配置文件，根据浏览器的第一语言来获取 locale
         */
        String msg = messageSource.getMessage(I18nConst.BUY_TIP, null, locale);

        return msg;
    }

    @GetMapping("getAll")
    public String getAll() {
        Locale[] ls = Locale.getAvailableLocales();
        StringBuilder locals = new StringBuilder();
        for(Locale locale : ls) {
            log.info("locale: {}",locale);
            locals.append(locale.toString()).append(",");
        }
        return locals.toString();
    }
}
