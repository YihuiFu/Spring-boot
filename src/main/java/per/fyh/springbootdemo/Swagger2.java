package per.fyh.springbootdemo;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Documents")
                .description("接口文档")
                .version("1.0")
                .build();

    }
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("per.fyh.springbootdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
