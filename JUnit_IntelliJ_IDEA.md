JUnit单元测试 -- InterliJ IDEA
==

# 环境配置
* 安装JUnit插件
>File > Settings > Plugins  
搜索框中输入 JUnit，  
在搜索结果中选择JUnitGenerator V2.0 点击进行安装

* 使用JUnit插件
>在需要进行单元测试的类中，使用快捷键 Alt + Insert，选择JUnit test，选择JUnit 4

# 单元测试
```java
    @Test
    public void testAdd() {
        assetEquals(1, new UserDao().add(1, 1));
    
    }

```
## 注意事项
* 测试方法上面必须使用@Test注解进行修饰
* 测试方法必须使用public void修饰，不能带有任何参数
* 新建一个源代码目录用来存放测试代码
* 测试类的包应该与被测试类的在同一个包中
* 测试单元中的第一个方法必须独立测试，每个测试方法之间不能有依赖
* 测试类使用Test做为类名的后缀（非必须）
* 测试方法使用test作为访求名的前缀（非必须）

## 错误解析
* Failure 一般是单元测试使用的断言方法判断失败引起，说明预期结果和程序运行结果不一致。
* error 是有代码异常引起的，他产生于测试代码本身中的Bug。
* 测试用例是不是用来证明你是对的，而是用来证明你没有错。
    
## 测试流程
代码demo
```java
@BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }
    @AfterClass
    public static void setUpAfterClass() throws Exception {

    }

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {

    }

```
* @BeforeClass所修饰的方法在所有方法加载前执行，而且他是静态的在类加载后就会执行该方法，在内存中只有一份实例，适合用来加载配置文件。
* @AfterClass所修饰的方法在所有方法执行完毕之后执行，通常用来进行资源清理，例如关闭数据库连接。
* @Before和@After在每个测试方法执行前都会执行一次。

## 常用注解
* @Test(excepted=XX.class) 在运行时忽略某个异常。
* @Test(timeout=毫秒) 允许程序运行的时间。
* @Ignore 所修饰的方法被测试器忽略。
* RunWith 可以修改测试运行器 org.junit.runner.Runner

## 测试套件
测试套件是组织测试类一起运行的测试类

代码demo
```java
    @RunWith(Suite.class)
    @Suite.SuiteClasses({UserTest1, UserTest2, UserTest3})
    public class SuiteTest{
        
    }

```
注意事项
* 作为测试套件的入口类，类中不能包含任何方法
* 更改测试运行器Suite.class
* 将需要运行的测试类放入Suite.SuiteClasses({ })的数组中

## 参数化设置
需要测试的仅仅是测试数据，代码结构是不变的，只需要更改测试数据

代码demo
```java
@RunWith(Parameterized.class)
public class parameterTest {
    int expected = 0;
    int input1 = 0;
    int input2 = 0;

    @Parameters
    public static Collection<Object[]> t() {
        return Arrays.asList(new Object[][]{
                {3, 1, 2},
                {5, 2, 3}
        });
    }

    public parameterTest(int expected, int input1, int input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void testAdd() {
        assertEquals(expected, UserDao.add(input1, input2));
    }

}

```

具体步骤
* 更改默认的测试运行器为@RunWith(Parameterized.class)
* 声明变量来存放预期值和测试值
* 声明一个返回值为Collection的公共静态方法，并用@Parameters修饰
* 为测试类声明一个带有参数的公共构造函数，并在其中为他声明变量赋值