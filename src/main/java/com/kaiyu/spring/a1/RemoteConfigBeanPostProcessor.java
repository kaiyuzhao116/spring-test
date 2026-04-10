package com.kaiyu.spring.a1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

//@Component
@Slf4j
public class RemoteConfigBeanPostProcessor implements BeanPostProcessor {


    // 注入配置中心客户端（实际项目中替换为真实的配置中心SDK）
    @Autowired
    private  ConfigCenterClient configCenterClient;
    @Override
    public Object postProcessBeforeInitialization(Object bean,String beanName){
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            RemoteConfig annotation = field.getAnnotation(RemoteConfig.class);
            if (annotation == null){
                continue;
            }
            // 从配置中心拉取配置值
            String configValue = configCenterClient.getConfig(annotation.key(), annotation.defaultValue());
            if (!StringUtils.hasText(configValue)) {
                log.warn("Bean【{}】的字段【{}】配置值为空，key={}", beanName, field.getName(), annotation.key());
                continue;
            }

            // 通过反射给字段赋值
            try {
                field.setAccessible(true); // 打破private访问限制
                Object convertedValue = convertValue(field.getType(), configValue);
                ReflectionUtils.setField(field, bean, convertedValue);
                log.info("Bean【{}】的字段【{}】配置注入成功，key={}, value={}",
                        beanName, field.getName(), annotation.key(), configValue);
            } catch (Exception e) {
                log.error("Bean【{}】的字段【{}】配置注入失败", beanName, field.getName(), e);
            }
        }
        return bean; // 必须返回原Bean，否则会覆盖原始Bean
    }

    /**
     * 简单的类型转换（支持String、Integer、Long、Boolean）
     * 实际项目中可使用Spring的ConversionService做更完善的转换
     */
    private Object convertValue(Class<?> fieldType, String value) {
        if (fieldType == String.class) {
            return value;
        } else if (fieldType == Integer.class || fieldType == int.class) {
            return Integer.parseInt(value);
        } else if (fieldType == Long.class || fieldType == long.class) {
            return Long.parseLong(value);
        } else if (fieldType == Boolean.class || fieldType == boolean.class) {
            return Boolean.parseBoolean(value);
        }
        // 其他类型可自行扩展
        return value;

    }
}
