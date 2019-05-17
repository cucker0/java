class MyHelloWorld {
    // main方法，程序入口E
    public static void main(String[] args) { // String[] args main方法的形参，字符串型的数组，如用于运行 java MyHelloWorld aa bb cc
        System.out.println("Hello Java!");
        System.out.println("args: " + args[0] + " " + args[1] + " " + args[2]); //运行方法：java MyHelloWorld aa bb cc
        // System.out.print("") //打印时不换行
    }
}



/*
 * javac HelloWord.java //当有中文且在windows平台时，javac -encoding utf-8 HelloWorld.java
 * javac 编译时后生成的文件名 类名.class => MyHelloWorld.class
 * java MyHelloWorld
 * java MyHelloWorld.class会报错，错误: 无效的标记: MyHelloWorld.class
 * */
