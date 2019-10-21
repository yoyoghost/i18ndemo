package com.i18n.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : sihk
 * @version :
 * @date : Created in 上午11:23 2019/10/21
 */
public class I18nConst {
    public static final String BUY_TIP = "buy_tip";

    @AllArgsConstructor
    @Getter
    public enum Msg {
        BUY_TIP("buy_tip","这里展示的是在查询不到的时候的默认数据"),
        LOGIN_ERROR("login_error","默认展示，登录错误"),
        ;

        String key;
        String defaultValue;
    }
}
