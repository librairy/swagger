package es.upm.oeg.librairy.service;

import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.google.common.base.Optional;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

/**
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 */

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1000)
public class ApiModelPropertyExtendedPlugin implements ModelPropertyBuilderPlugin {

    @Override
    public void apply(ModelPropertyContext context) {

        Optional<BeanPropertyDefinition> optionalDefinition = context.getBeanPropertyDefinition();

        if (optionalDefinition.isPresent()) {

            BeanPropertyDefinition definition = optionalDefinition.get();
            ApiModelPropertyExtended annotation = null;

            if (definition.hasGetter()) {
                annotation = definition.getGetter().getAnnotation(ApiModelPropertyExtended.class);
            }

            if (annotation == null) {
                annotation = definition.getField().getAnnotation(ApiModelPropertyExtended.class);
            }

            if (annotation != null) {
                context.getBuilder()
                        .defaultValue(annotation.defaultValue())
                        .build();
            }
        }
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }
}
