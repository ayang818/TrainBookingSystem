# 火车订票系统
> 2019 杭州电子科技大学 软件设计与体系架构课程大作业

|姓名|xxx|
|---|---|
|学号|xxx|
|专业|xxx|

## 作业要求的实现    
1. 文件夹结构说明文档
```bash
-- java 
    --com
        --ayang818
            --trainbooking 工程目录文件
                --advice 全局异常处理
                --constpool 常量池
                --controller 控制器
                    --admin 管理员相关
                    --user 用户相关
                --dto 数据传输对象
                --interceptor 前端请求拦截器
                --mapper 数据库操作
                --model  数据库对象映射
                --service 业务逻辑的封装
                    --impl 业务逻辑接口的实现
                --utils 工具类
-- resources
    -- db 数据库版本控制
--webapp
    --static 前端静态文件
        --css 前端css文件
        --js 前端js文件
    --WEB-INF
        -templates 前端html文件
```

## 截图展示

### 登陆界面
![](https://upload-serve.oss-cn-beijing.aliyuncs.com/softwareproject/login.png)

### 管理员界面

- **站点概览**
![](https://upload-serve.oss-cn-beijing.aliyuncs.com/softwareproject/admin.png)

- **路线概览**
![](https://upload-serve.oss-cn-beijing.aliyuncs.com/softwareproject/route.png)

- **添加路线**
![](https://upload-serve.oss-cn-beijing.aliyuncs.com/softwareproject/addroute.png)

- **车次概览**
![](https://upload-serve.oss-cn-beijing.aliyuncs.com/softwareproject/trainnumberpng.png)

- **添加车次**
![](https://upload-serve.oss-cn-beijing.aliyuncs.com/softwareproject/addtrainnumber.png)

### 用户界面
![](https://upload-serve.oss-cn-beijing.aliyuncs.com/softwareproject/search.png)

## 关于数据库
数据库使用了flyway插件，输入以下脚本来执行数据库的自动创建
```bash
mvn flyway:migrate
```
请自行插入数据吧，这里不提供数据库的内容，你可以直接在数据库表```user```中插入一条管理员数据，type为1，然后进入后台管理界面自行插入数据...

