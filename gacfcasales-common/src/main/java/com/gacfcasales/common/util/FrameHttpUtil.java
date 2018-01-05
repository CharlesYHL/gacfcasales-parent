package com.gacfcasales.common.util;



import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gacfcasales.common.exception.UtilException;

import java.net.URLEncoder;

/**
 * @author Charles
 * @Title: FrameHttpUtil
 * @Package
 * @Description: TODO
 * @date 2017/9/28 15:55
 */
public class FrameHttpUtil {
    /**
     * 获取文件名称
     *
     * @author Charles
     * @date 2017年1月2日
     * @param request
     * @param
     * @return
     */
    public static void setExportFileName(HttpServletRequest request, HttpServletResponse response, String fileName) {
        try {
            String userAgent = request.getHeader("user-agent");
            System.out.println(userAgent);
            if (userAgent != null && (userAgent.indexOf("Firefox") >= 0 || userAgent.indexOf("Chrome") >= 0
                    || userAgent.indexOf("Safari") >= 0)) {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } else {
                fileName = URLEncoder.encode(fileName, "UTF8"); // 其他浏览器
            }
            response.setHeader("Content-Disposition", "attachment;filename=\""
                    + fileName+"\"");
            String mineType = new MimetypesFileTypeMap().getContentType(fileName);
            response.setContentType(mineType);

        } catch (Exception e) {
            throw new UtilException("获取导出文件名称失败", e);
        }
    }

}
