#20200501
1.springboot 多yml文件的自动补全？
   安装插件spring assistant
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
~~~
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
2.value注解,获取配置文件的属性信息