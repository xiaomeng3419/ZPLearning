package com.example.Functional.demo;

/**
 * Created by zhangpan on 2018/11/22.
 */
public class PersonManager {
    PersonService personService=new PersonService();


    public static void main(String[] args) {
        PersonManager callTest=new PersonManager();
        callTest.seePwd();

    }
    /**
     * 假设用户想查看一下密码
     */
    private void seePwd(){
        String name="1111";
        String time=String.valueOf(System.currentTimeMillis());
        //获取一个uuid
        String callId=personService.getCallId();
        //
        personService.getPwdFromDb(name,callId);
        personService.listenResult(this::getPwd,callId,new ParamContext("time",time));
        System.out.println("数据库读取数据，可能有点耗时，这里做成异步操作，我先做其他事情。。。。。。。。。");
    }

    /**
     * 获取到了密码
     * @param result
     * @param context
     */
    private void getPwd(ParamContext result,ParamContext context){
        String pwd=result.get("pwd");
        long sed=(System.currentTimeMillis()-Long.valueOf(context.get("time")))/1000;
        System.out.println("经过"+sed+"秒"+"查询用户密码的调用终于返回了");
        System.out.println("得到密码:"+pwd);
    }

}
