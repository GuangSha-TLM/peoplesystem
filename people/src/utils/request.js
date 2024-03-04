import axios  from "axios";
const request = axios.create({
    baseURL:'/api',
    timeout:5000,
});

request.interceptors.request.use(
    (config)=>{
      //config:发送请求的配置项(请求地址URL,请求方式method,请求头headers,请求参数)
      //作用: 携带公共请求参数 - token
  
      return config
    },
    // ()=>{}
  )
//响应拦截器
request.interceptors.response.use((res)=>{
    return res.data
},(error)=>{
    //响应失败
    return Promise.reject(new Error('faile'));
})
request.interceptors.response.use(

    (response)=>{
      //只能说明响应成功,并不说明请求成功
      //此时看response.data.code 200 功能成功否则失败
      if (response.data.code===200){
        //一旦没有报错,或没有返回失败的状态promise,即是成功状态
        // return Promise.resolve(response.data.data)
        return response.data.data
      }else {
        console.log(JSON.stringify(response))
        return Promise.reject(response.data.message)
      }
    },
    (error)=>{
      return Promise.reject(error.message)
    }
  )

//对外暴露
export default request;
