#20200501
1.springboot 多yml文件的自动补全？
   安装插件spring assistant
   引入自动配置jar
   ```puml
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
```
2.thymeteaf引用后不生效
  因为在controller类中一直用的是@ResController这个注解，后来查了下资料发现：
  官方文档：
  @RestController is a stereotype annotation that combines @ResponseBody and @Controller.
  意思是：
  @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
  
  1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
  
  例如：本来应该到success.jsp页面的，则其显示success.
  
  2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
  3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
  
  原来，并没有集成失败 ，而是因为注解是 @RestController 配置的视图解析器InternalResourceViewResolver不起作用，所以返回的内容是字符串（就是Return 里的内容），把 @RestController 修改为 @Controller 后，视图解析器InternalResourceViewResolver才能成功调用返回指定页面
  
  修改：修改注解为@Controller
  
  修改后测试成功。
  
3. thymeteaf 官方文档中
~~~java
@Controller
 public class TestCrudController {
 
     @GetMapping("/resuful/success")
     public  String getSuccess(Map<String,String> hsmap){
         hsmap.put("h1","wo shi  h1");
         return "success";
     }
 }
~~~
#20200502
##springboot中config的配置
1.类上增加@ConfigurationProperties(prefix = "person", ignoreUnknownFields = true)
  可以自动扫描到类注释上
  ````java
@Component
@ConfigurationProperties(prefix = "person", ignoreUnknownFields = true)
@Data
public class Person {
    private  String name;
    private  Long age;
    private Map<String,String> dataMap;
}
````
2.value注解,获取配置文件的属性信息
```java
import com.atguigu.springboot.bo.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
    /**
     * @author sunbaojin
     * @date 2020/5/1 6:45
     */
    @Slf4j
    @SpringBootApplication
    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @ActiveProfiles("dev")
    public class TetsConfig {
    
        @Autowired
        private Person person ;
    
        @Value("${spring.profiles.active}")
        private String profilesActive;
    
        @Test
        public void testCongi1(){
            log.info(person.getName());
            log.info(person.toString());
            log.info(profilesActive);
        }
    }
```
3.webmvc的自动化配置
```java
WebMvcAutoConfiguration
```
4.自定义mvc的视图
```java
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sunbaojin
 * @date 2020/5/2 12:00
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/testMyMvc").setViewName("success");
    }
}

```

5.I18N国际化的支持
  自定义的localeResolver不生效
 ```java
@ConditonalOnMissingBean是当容器中没有该bean时，springboot自动配置，判断bean的方式时bean的id，二维我们使用@Bean方式配置Bean,方法就是Bean的id,查看配置类中配置localeResolver的方法,发现方法名不是localeResolver，因此springboot的配置仍然生效
@Bean
    public LocaleResolver localeResolver(){
        log.info("==========我的国际化");
        return new MyLocalComponent();
    }
```
6.自定义异常类和异常参数信息，已完成