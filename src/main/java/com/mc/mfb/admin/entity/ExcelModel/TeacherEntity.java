package com.mc.mfb.admin.entity.ExcelModel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/17
 * @Time:15:53
 **/
@ExcelTarget("teacherEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherEntity implements java.io.Serializable {
    private String id;
    /**
     * name
     */
    @Excel(name = "主讲老师_major,代课老师_absent", orderNum = "1", isImportField = "true_major,true_absent",needMerge = true)
    private String name;

    @Excel(name="购机吧",orderNum="1",needMerge = true)
    private Integer length;


}
