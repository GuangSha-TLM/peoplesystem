package com.tlm.people.service.impl;

import com.alibaba.excel.EasyExcel;
import com.tlm.people.dao.FunctionMapper;
import com.tlm.people.entity.Stu;
import com.tlm.people.entity.bo.FunctionExcelBo;
import com.tlm.people.entity.vo.FunctionExcelVo;
import com.tlm.people.entity.vo.ResponseVo;
import com.tlm.people.service.FunctionService;
import com.tlm.people.utils.ExcelListener;
import com.tlm.people.utils.GuiguException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionMapper functionMapper;

    //上传
    @Override
    public void importData(MultipartFile multipartFile) {

        if (multipartFile.isEmpty()) {
            throw new GuiguException("0x500","文件为空");
        }

        ExcelListener<FunctionExcelVo> excelListener = new ExcelListener<>(functionMapper);

        try {
            EasyExcel.read(multipartFile.getInputStream(), FunctionExcelVo.class, excelListener)
                    .sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GuiguException("0x501","文件格式错误");
        }
    }

    //文件导出（下载）
    @Override
    public void exportData(HttpServletResponse response) {
        //1.设置响应头信息和其他信息
        try {
            // 设置响应结果类型
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");

            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("分类数据", "UTF-8");

            //设置响应头
            response.setHeader("Content-disposition","attachment;filename=" + fileName + ".xlsx");
            response.setHeader("Access-Control-Expose-Headers","Content-disposition");
            //查询所有分类，返回list集合
            List<Stu> stuList = functionMapper.findAll();

            //最终数据list集合
            List<FunctionExcelBo> functionExcelBoList = new ArrayList<>();

            for (Stu stu : stuList) {
                FunctionExcelBo functionExcelBo = new FunctionExcelBo();
                BeanUtils.copyProperties(stu, functionExcelBo);
                functionExcelBoList.add(functionExcelBo);
            }

            //写入操作
            EasyExcel.write(response.getOutputStream(), FunctionExcelBo.class)
                    .sheet("数据").doWrite(functionExcelBoList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void exportDataShake(HttpServletResponse response , List<Long> shakeIdList) {
        //1.设置响应头信息和其他信息
        try {
            // 设置响应结果类型
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");

            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("分类数据", "UTF-8");

            //设置响应头
            response.setHeader("Content-disposition","attachment;filename=" + fileName + ".xlsx");
            response.setHeader("Access-Control-Expose-Headers","Content-disposition");

            //查询所有分类，返回list集合
            List<Stu> stuList = functionMapper.findAll();

            //最终数据list集合

            List<FunctionExcelBo> functionExcelBoList = new ArrayList<>();

            for (Stu stu : stuList) {
                FunctionExcelBo functionExcelBo = new FunctionExcelBo();
                BeanUtils.copyProperties(stu, functionExcelBo);
                functionExcelBoList.add(functionExcelBo);
            }

            //写入操作
            EasyExcel.write(response.getOutputStream(), FunctionExcelBo.class)
                    .sheet("数据").doWrite(functionExcelBoList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Stu> shakeList(List<Long> ids) {

        return null;
    }

    public static void main(String[] args) {
        //写操作
        {
            List<FunctionExcelVo> list = new ArrayList<>();
//            list.add(new FunctionExcelVo(12L, 0));
//            list.add(new FunctionExcelVo(13L, 0));
            EasyExcel.write("E://02.xlsx", FunctionExcelVo.class)
                    .sheet("分类数据").doWrite(list);
        }
    }

//    /**
//     * 设置响应结果
//     *
//     * @param response    响应结果对象
//     * @param rawFileName 文件名
//     * @throws UnsupportedEncodingException 不支持编码异常
//     */
//    private void setExcelResponseProp(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
//        //设置内容类型
//        response.setContentType("application/vnd.vnd.ms-excel");
//        //设置编码格式
//        response.setCharacterEncoding("utf-8");
//        //设置导出文件名称（避免乱码）
//        String fileName = URLEncoder.encode(rawFileName.concat(".xlsx"), "UTF-8");
//        // 设置响应头
//        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName);
//    }
//
//    private Date getBirthday(int year, int month, int day){
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, day);
//        return calendar.getTime();
//    }
//
//    /**
//     * 导出数据
//     * */
//    @GetMapping("/export/user")
//    public void exportUserExcel(HttpServletResponse response) throws IOException {
//        OutputStream outputStream=response.getOutputStream();
//        try {
//            this.setExcelResponseProp(response, "用户列表");
//            // 模拟根据条件在数据库查询数据
//            List<UserDO> userList = new ArrayList<>();
//            for(int i=0;i<30;i++){
//                UserDO userDO =new UserDO();
//                userDO.setBirthday(getBirthday(2001,1,i));
//                userDO.setGender(1);
//                userDO.setHeight(Double.valueOf(i));
//                userDO.setId(Long.valueOf(i));
//                userDO.setPhone("138"+i);
//                userDO.setNickname("yuanhaoz");
//                userDO.setPassword("5849"+i);
//                userDO.setUsername("monky"+i);
//                userList.add(userDO);
//            }
//            //这个实现方式非常简单直接，使用EasyExcel的write方法将查询到的数据进行处理，以流的形式写出即可
//            EasyExcel.write(outputStream,UserDO.class)//对应的导出实体类
//                    .excelType(ExcelTypeEnum.XLSX)//excel文件类型，包括CSV、XLS、XLSX
//                    .sheet("用户列表")//导出sheet页名称
//                    .doWrite(userList); //查询获取的数据集合List<T>，转成excel
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }finally {
//            outputStream.flush();
//            outputStream.close();
//        }
//    }


}
