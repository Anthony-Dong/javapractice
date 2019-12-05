package com.anthony;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 *  SpringbootApplicationBootStrap 启动类
 *
 * @date:2019/9/20 20:20
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

@SpringBootApplication
public class SpringbootApplicationBootStrap {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();

        builder.sources(SpringbootApplicationBootStrap.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
