
import request from "@/utils/request";
//例子:
// export const reqGetBannerList = () => request.get('/banner');
// export const reqGetSeachInfo = (params) => requests({ url: '/list', method: "post", data: params })
// export const reqAddOrUpdateShopCart = (skuId,skuNum)=>requests({url:`/cart/addToCart/${ skuId }/${ skuNum }`,method:"post"});

export const resLogin = (user) => request({ url: '/tlm/people/user/login', method: 'post', data: user });
export const resRegister = (user) => request({ url: '/tlm/people/user/userReg', method: 'post', data: user });
export const resUserShake = (number) => request({ url: '/tlm/people/user/userShake', method: 'post', params: number });
export const resGetStu = () => request({ url: '/tlm/people/stu/findAll', method: 'get' });
export const resUpdateStatus = (stuIdList) => request({ url: '/tlm/people/stu/updateStatus', method: 'post', data: stuIdList });

export const resUpload = (multipartFile) => request({ url: '/tlm/people/function/importData', method: 'post', data: multipartFile });
export const resDownload = () => request({ url: '/tlm/people/function/exportData', method: 'get', responseType: 'blob' });
export const deleteAll = () => request({ url: '/tlm/people/stu/deleteByAll', method: 'post' });
//下载特加 responseType: 'blob' 
export const download=  (shakeIdList) => {
    const params = new URLSearchParams();
    shakeIdList.forEach(id => {
      params.append('shakeIdList', id);
    });
  
    return request({
      url: '/tlm/people/function/exportDataShake',
      method: 'get',
      params,
      responseType: 'blob'
    });
  };