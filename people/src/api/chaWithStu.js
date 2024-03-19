import request from "@/utils/request";

export const addChaWithStu = (chaWithStu) => request({ url: '/tlm/people/chaWithStu/addChaWithStu', method: 'post' ,data:chaWithStu});
