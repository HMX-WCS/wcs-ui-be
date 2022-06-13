package com.hmx.prog.hdelpg.RestfulApiResponse;

import org.springframework.context.annotation.Bean;
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
public class SwaggerConfig {
    //Swagger-ui에서 메인으로 보여질 정보를 설정
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("hmx-prog-hdelpg")
                .description("API EXAMPLE")
                .build();
    }

    //api의 그룹명, 이동경로, 보여질api가 속한 패키지 등의 자세한 정보
    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("example")
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.hmx.prog.hdelpg"))
                .paths(PathSelectors.ant("/**"))
                .build();
    }

}