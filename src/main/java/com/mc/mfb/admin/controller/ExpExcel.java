package com.mc.mfb.admin.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.google.common.collect.Maps;
import com.mc.mfb.admin.dao.BigDataDao;
import com.mc.mfb.admin.entity.ExcelModel.CourseEntity;
import com.mc.mfb.admin.entity.ExcelModel.StudentEntity;
import com.mc.mfb.admin.entity.ExcelModel.TeacherEntity;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/17
 * @Time:9:59
 * easyPoi导出Excel
 **/
@RequestMapping("/exp")
@Controller
public class ExpExcel {

    @Autowired
    private BigDataDao bigDataDao;
    @GetMapping("/simple")
    public void exprotUser(HttpServletResponse response) throws IOException {

        List<StudentEntity> list = new ArrayList<>();
        list.add(new StudentEntity("1","张三",1,new Date(),new Date()));
        list.add(new StudentEntity("2","张三",1,new Date(),new Date()));
        list.add(new StudentEntity("3","张三",1,new Date(),new Date()));
        list.add(new StudentEntity("4","张三",1,new Date(),new Date()));
        list.add(new StudentEntity("5","张三",1,new Date(),new Date()));
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                StudentEntity.class, list);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("简单导出", "UTF-8"));
        workbook.write(response.getOutputStream());
        workbook.close();

    }
    @GetMapping("/ontomany")
    public void export(HttpServletResponse response) throws IOException {
        List<CourseEntity> list = new ArrayList<>();
        List<StudentEntity> lists = new ArrayList<>();
        lists.add(new StudentEntity("1","张三",1,new Date(),new Date()));
        lists.add(new StudentEntity("2","张四",1,new Date(),new Date()));
        lists.add(new StudentEntity("3","张吴",1,new Date(),new Date()));
        lists.add(new StudentEntity("4","张流",1,new Date(),new Date()));
        lists.add(new StudentEntity("5","张器",1,new Date(),new Date()));
        list.add(new CourseEntity("1","人体解刨",new TeacherEntity("1","午休顺",110),lists));
        list.add(new CourseEntity("1","人体解刨",new TeacherEntity("1","青筋",130),lists));

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                CourseEntity.class, list);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("简单导出.xls", "UTF-8"));
        workbook.write(response.getOutputStream());
        workbook.close();

    }

    @RequestMapping("/map")
    public void mapExp(HttpServletResponse response){
        try {
            List<ExcelExportEntity> beanList = new ArrayList<>();
            beanList .add(new ExcelExportEntity("学生姓名", "name"));
            beanList .add(new ExcelExportEntity("学生性别", "sex"));
            beanList .add(new ExcelExportEntity("进校日期", "registrationDate"));
            if(false){
                beanList .add(new ExcelExportEntity("出生日期", "birthday"));
            }
            List<Map<String,Object>> list = new ArrayList<>();
            list.add(beanToMap(new StudentEntity("1","张三",1,new Date(),new Date())));
            list.add(beanToMap(new StudentEntity("2","张三",1,new Date(),new Date())));
            list.add(beanToMap(new StudentEntity("3","张三",1,new Date(),new Date())));
            list.add(beanToMap(new StudentEntity("4","张三",1,new Date(),new Date())));
            list.add(beanToMap(new StudentEntity("5","张三",1,new Date(),new Date())));

            //把我们构造好的bean对象放到params就可以了
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("测试", "测试"), beanList,
               list     );
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("简单导出.xls", "UTF-8"));
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static final String  Const_Type = ".xlsx";


    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

}
