package com.mc.mfb.admin.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/17
 * @Time:10:05 导出POI工具类
 **/
public class EasyPoiUtils {
    private EasyPoiUtils() {
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> void defaultExport(List<T> dataList, Class<?> clz, String fileName, HttpServletResponse response, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, clz, dataList);
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }
    }

    /**
     * 导出Excel
     * @param dataList 数据源
     * @param title Excel内标题
     * @param sheetName sheet页名称
     * @param clz  数据源实体类映射
     * @param fileName  文件名称
     * @param isCreateHeader  是否创建Title
     * @param response 响应
     * @param type 导出xls 或xlsx
     * @param <T>
     */
    public static <T> void exportExcel(List<T> dataList, String title, String sheetName, Class<?> clz, String fileName, boolean isCreateHeader, HttpServletResponse response,ExcelType type) {
        ExportParams exportParams = new ExportParams(title, sheetName,type);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(dataList, clz, fileName, response, exportParams);
    }

    public static <T> void exportExcel(List<T> dataList, String title, String sheetName, Class<?> clz, String fileName, HttpServletResponse response) {
        defaultExport(dataList, clz, fileName, response, new ExportParams(title, sheetName));
    }

    private static void defaultExport(List<Map<String, Object>> dataList, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(dataList, ExcelType.HSSF);
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }
    }

    public static void exportExcel(List<Map<String, Object>> dataList, String fileName, HttpServletResponse response) {
        defaultExport(dataList, fileName, response);
    }

    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> clz) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }

        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);

        try {
            return ExcelImportUtil.importExcel(new File(filePath), clz, params);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> clz) {
        if (file == null) {
            return null;
        }

        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);

        try {
            return ExcelImportUtil.importExcel(file.getInputStream(), clz, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<T> importExcel(MultipartFile file, Class<T> clz) {
        if (file == null) {
            return null;
        }

        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        try {
            return ExcelImportUtil.importExcel(file.getInputStream(), clz, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}