package com.kaiyu.spring.a1;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RemoteConfig {
    /**
 * 配置中心的配置key
 */
    String key();

    /**
     * 默认值，配置中心未获取到时使用
     */
    String defaultValue() default "";

}
