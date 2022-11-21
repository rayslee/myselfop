# 开发日志

## 2022

## 10.10
* 引入 jasypt 解决配置文件中连接信息为明文的问题
````
    # 依赖
    <dependency>
        <groupId>com.github.ulisesbocchio</groupId>
        <artifactId>jasypt-spring-boot-starter</artifactId>
        <version>${jasypt.version}</version>
    </dependency>
    
    # 配置
    jasypt:
      encryptor:
        password: fa7bd4edd42448aea8c9484fbce6e8cd
        algorithm: PBEWITHHMACSHA512ANDAES_256
    
    # 密文生成
    @SpringBootTest
    public class JasyptUtilTest {
    
        @Autowired
        private StringEncryptor encryptor;
    
        @Test
        public void generate() {
            String url = encryptor.encrypt("jdbc:mysql://simwor.com:3306/myselfop?useUnicode=true&characterEncoding=utf8");
            String username = encryptor.encrypt("rayslee");
            String password = encryptor.encrypt("some_password");
            System.out.println(url);
            System.out.println(username);
            System.out.println(password);
        }

    }
    
    # 修改配置文件
    datasource:
      url: ENC(BK3hCv7vLLMuSXoBzTAIVtPGfTDupILAvXEOASnSlNK3YYdTKsP/PV3QR9JgsyIbUegMo7Qq4QnA3hBak78R6SmVKLL8yrC8xO/Sli5ElOgNajj/Wx9OJ+Ih4PW17rKxM1pVvMdDWqJrtvQmUtt1eA==)
      username: ENC(cs55DbDssletd5+yPqYQycAkwKL2KDmZl23/mx/+mtcu0q14UCcMbappv7YHkY1a)
      password: ENC(3nhtjyzL8myUQ1nutaHCEgZVIwl4OqL2Qr+Jctd2NhOLNofDa5CXHlFF6u4DZCMj)
````

* 上传项目到 Gitlab
    1. 新建空白项目
    2. 新建 master 分支

````
    cd myselfop
    git remote add origin https://gitlab.com/rayslee/myselfop.git
    git branch -M master
    git push -uf origin master
````

## 10.9
* 搭建项目雏形
* 安装 Mysql，解决无法连接数据库的问题

````
>> 命令行无法连接

    sudo apt install mysql-client mysql-server
    # 设置 root 密码
    sudo mysql
    alter user 'root'@'localhost' identified with mysql_native_password by 'root_password'
    # 初始化
    mysql_secure_installation
    # 新建用户及数据库
    mysql -uroot -p
    create user 'rayslee'@'%'
    alter user 'rayslee'@'%'  identified with mysql_native_password by 'rayslee_password'
    create database myselfop
    grant all on myselfop.* to 'rayslee'@'%'
    flush privileges
    
>> 项目无法连接数据库

    # 放开防火墙
    sudo ufw allow mysql
    # 找到 /etc/mysql/mysql.conf.d/mysqld.cnf
    bind-address = 127.0.0.1 -> 0.0.0.0
    # 默认只能本地连接，重启数据库
    sudo systemctl restart mysql
````

* 解决 Hibernate 因 toString() 双向引用 StackOverflow 报错

````
    @ToString.Exclude
    private List<Book> books;
````

## 10.8
* 新建 myselfop 项目
* 新建 ubuntu 虚拟机
