package es.upm.oeg.librairy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.annotation.*;

/**
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Inherited
@Documented
public @interface ApiModelPropertyExtended {
    String defaultValue() default "";
}