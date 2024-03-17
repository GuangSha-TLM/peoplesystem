// /$$
//  $ @Author: tianleiyu 
//  $ @Date: 2024-03-17 15:26:43
//  $ @LastEditTime: 2024-03-17 15:26:44
//  $ @LastEditors: tianleiyu
//  $ @Description: 
//  $ @FilePath: /people/src/api/filefunction.js
//  $ @可以输入预定的版权声明、个性签名、空行等
//  $/
import request from "@/utils/request";

//上传文件
export const resUpload = (multipartFile) => request({ url: '/tlm/people/function/importData', method: 'post', data: multipartFile });
//下载所有数据
export const resDownload = () => request({ url: '/tlm/people/function/exportData', method: 'get', responseType: 'blob' });

//下载指定状态数据
export const stateAssignment = (status) => request({ url: `/tlm/people/function/exportStatusData/${status}`, method: 'post', responseType: 'blob' });

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

