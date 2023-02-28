# springboot http 请求



在Spring Boot中发起HTTP请求通常使用的是Spring框架中的RestTemplate类。RestTemplate提供了一组用于发送HTTP请求的方法，包括GET、POST、PUT、DELETE等常用的HTTP方法。

使用RestTemplate发送HTTP请求的步骤如下：

1. 在Spring Boot中添加RestTemplate的依赖：

   ```java
   xmlCopy code<dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   ```

2. 在Java代码中创建RestTemplate对象：

   ```java
   javaCopy code
   RestTemplate restTemplate = new RestTemplate();
   ```

3. 调用RestTemplate的方法发送HTTP请求，例如：

   ```java
   javaCopy code// 发送GET请求并获取响应结果
   String result = restTemplate.getForObject("http://example.com/api/get", String.class);
   
   // 发送POST请求并获取响应结果
   Map<String, String> params = new HashMap<>();
   params.put("name", "John");
   params.put("age", "30");
   String result = restTemplate.postForObject("http://example.com/api/post", params, String.class);
   ```

其中，getForObject()和postForObject()方法的第一个参数是请求URL，第二个参数是请求体（对于GET请求而言通常为null），第三个参数是响应的类型。根据具体的需求选择不同的方法即可。