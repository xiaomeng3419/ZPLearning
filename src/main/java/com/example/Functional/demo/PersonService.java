package com.example.Functional.demo;

/**
 * Created by zhangpan on 2018/11/22.
 */
public class PersonService {

    private ListenCall listenCall=new ListenCall();
    /**
     * 这里模拟根据用户名从数据库查询密码
     * @param name 用户名
     * @param callId 请求调用的id
     */
    public void getPwdFromDb(String name,String callId){
        new  Thread(new Runnable() {

            @Override
            public void run() {
                String sql="select from person where name="+"'"+name+"'";
                String pwd="1111";
                try {
                    //这里等待4秒，模拟毒区数据库的书剑，时间有点夸张
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitForResult(new ParamContext("pwd",pwd),callId);
            }
        }).start();
    }
    public String getCallId(){
        return listenCall.getCallId();
    }

    /**
     *
     * @param p
     * @param callId
     */
    public void waitForResult(ParamContext p,String callId){
        listenCall.waitForResult(p, callId);
    }
    public void listenResult(GofFunction<ParamContext, ParamContext> method,String callId,ParamContext context){
        listenCall.listenResult(method, callId, context);
    }
}
