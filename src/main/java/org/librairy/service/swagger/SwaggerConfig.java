package org.librairy.service.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport{


    @Value("#{environment['SWAGGER_BASE_PACKAGE']?:'${swagger.base.package}'}")
    protected String basePackage;

    @Value("#{environment['SWAGGER_TITLE']?:'${swagger.title}'}")
    protected String title;

    @Value("#{environment['SWAGGER_DESCRIPTION']?:'${swagger.description}'}")
    protected String description;

    @Value("#{environment['SWAGGER_CONTACT_NAME']?:'${swagger.contact.name}'}")
    protected String contactName;

    @Value("#{environment['SWAGGER_CONTACT_EMAIL']?:'${swagger.contact.email}'}")
    protected String contactEmail;

    @Value("#{environment['SWAGGER_CONTACT_URL']?:'${swagger.contact.url}'}")
    protected String contactUrl;

    @Value("#{environment['SWAGGER_LICENSE_NAME']?:'${swagger.license.name}'}")
    protected String licenseName;

    @Value("#{environment['SWAGGER_LICENSE_URL']?:'${swagger.license.url}'}")
    protected String licenseUrl;

    @Value("${swagger.version}")
    protected String version;

    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .build()
                .enable(true)
                .apiInfo(metadata())
                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
                ;
    }

    protected ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact(contactName,contactUrl,contactEmail))
                .license(licenseName)
                .licenseUrl(licenseUrl)
                .version(version)
                .build();
    }


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("**").addResourceLocations("classpath:/dist/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
