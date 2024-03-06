
import request from "@/utils/request";
//例子:
// export const reqGetBannerList = () => request.get('/banner');
// export const reqGetSeachInfo = (params) => requests({ url: '/list', method: "post", data: params })
// export const reqAddOrUpdateShopCart = (skuId,skuNum)=>requests({url:`/cart/addToCart/${ skuId }/${ skuNum }`,method:"post"});

export const resLogin =(user) => request({url:'/tlm/people/user/login',method:'post',data:user});
export const resRegister =(user) => request({url:'/tlm/people/user/userReg',method:'post',data:user});
export const resUserShake =(number) => request({url:'/tlm/people/user/userShake',method:'post',params:number});