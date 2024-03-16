// /$$
//  $ @Author: tianleiyu 
//  $ @Date: 2024-03-15 16:42:42
//  $ @LastEditTime: 2024-03-15 16:42:43
//  $ @LastEditors: tianleiyu
//  $ @Description: 
//  $ @FilePath: /people/src/api/channel.js
//  $ @可以输入预定的版权声明、个性签名、空行等
//  $/
import request from "@/utils/request";

export const getAllChannel = () => request({ url: '/tlm/people/cha/findAll', method: 'get' });
