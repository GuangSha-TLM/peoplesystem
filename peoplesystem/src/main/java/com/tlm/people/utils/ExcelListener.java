package com.tlm.people.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.tlm.people.dao.FunctionMapper;
import com.tlm.people.entity.vo.FunctionExcelVo;

import java.util.List;

//监听器
public class ExcelListener<T> implements ReadListener<T> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;

    /**
     * 缓存的数据
     */
    private List<T> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    //构造传递mapper，操作数据库
    private FunctionMapper functionMapper;

    public ExcelListener(FunctionMapper functionMapper) {
        this.functionMapper = functionMapper;
    }
    public List<T> getCachedDataList() {
        return cachedDataList;
    }
    public ExcelListener() {

    }

    /**
     * 解析数据
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context analysis context
     */
    @Override
    public void invoke(T data, AnalysisContext context) {
        //把每行数据放到集合中
        cachedDataList.add(data);
        //达到临界值，就去存储依次，防止数据库内存溢出
        if(cachedDataList.size() >= BATCH_COUNT) {
            //批量把数据添加到数据库
            saveData();
            //清理集合
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //保存数据
        saveData();
    }

    //保存的方法
    void saveData() {
        functionMapper.saveData((List<FunctionExcelVo>)cachedDataList);
    }

}
