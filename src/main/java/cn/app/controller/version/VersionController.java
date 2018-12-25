package cn.app.controller.version;

import cn.app.pojo.DevUser;
import cn.app.pojo.Version;
import cn.app.service.appinfo.AppInfoService;
import cn.app.service.version.VersionService;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

@Controller
@RequestMapping("version")
public class VersionController {
    @Autowired
    private VersionService versionService;
    @Autowired
    private AppInfoService appInfoService;

    @RequestMapping("addlist")
    public String addv(String id, Model model) {
        model.addAttribute("vlist", versionService.findByIdlist(Integer.parseInt(id)));
        model.addAttribute("appid", Integer.parseInt(id));
        return "versionadd";
    }

    @RequestMapping(value = "addVersion",method = RequestMethod.POST)
    public String add(@ModelAttribute("version") Version version, HttpSession session, HttpServletRequest request, @RequestParam(value = "a_downloadLink",required = false) MultipartFile a_downloadLink) {
        String picPath = null;
        String logoLocPath = null;
        String fileName = null;
        if (!a_downloadLink.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
            fileName = a_downloadLink.getOriginalFilename();//原文件名
            String prefix = FilenameUtils.getExtension(fileName);//原文件后缀名
            if (prefix.equalsIgnoreCase("apk")) {
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                try {
                    a_downloadLink.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("fileUploadError", "上传失败");
                    return "redirect:";
                }
                picPath = request.getContextPath() + "/statics/uploadfiles/" + fileName;
                logoLocPath = path + File.separator + fileName;
            } else {
                request.setAttribute("fileUploadError", "上传文件格式不正确");
                return "redirect:";
            }

        } else {
            request.setAttribute("fileUploadError", "必须上传apk文件 ");
            return "redirect:add";
        }
       DevUser devUser=(DevUser) session.getAttribute("user");

        version.setCreationDate(new Date());
        version.setDownloadLink(logoLocPath);
        version.setApkLocPath(picPath);
        version.setApkFileName(fileName);
        version.setCreatedBy(devUser.getId());
        versionService.add(version);

       if (appInfoService.updVersion(version.getId(),version.getAppId())>0){
            return "redirect:../app/list";
        }else{
            return "redirect:addlist?id="+version.getAppId();
        }

    }


    @RequestMapping("updlist")
    public String updv(String id,String vid, Model model) {
        model.addAttribute("vlist", versionService.findByIdlist(Integer.parseInt(id)));
        model.addAttribute("appid", Integer.parseInt(id));
        model.addAttribute("app",versionService.getById(Integer.parseInt(vid)));
        return "versionupd";
    }

    @RequestMapping("delfile")
    @ResponseBody
    public Object delV(String id,Model model){
        if (versionService.delAKP(Integer.parseInt(id))>0){
               model.addAttribute("result","success");

        }else{
            model.addAttribute("result","failed");
        }
        return JSONArray.toJSONString(model);

    }


    @RequestMapping(value = "updVersion",method = RequestMethod.POST)
    public String upd(@ModelAttribute("version") Version version, HttpSession session, HttpServletRequest request, @RequestParam(value = "attach",required = false) MultipartFile a_downloadLink) {
        String picPath = null;
        String logoLocPath = null;
        String fileName = null;
        if (!a_downloadLink.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
            fileName = a_downloadLink.getOriginalFilename();//原文件名
            String prefix = FilenameUtils.getExtension(fileName);//原文件后缀名
            if (prefix.equalsIgnoreCase("apk")) {
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                try {
                    a_downloadLink.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("fileUploadError", "上传失败");
                    return "redirect:updlist?id="+version.getAppId();
                }
                picPath = request.getContextPath() + "/statics/uploadfiles/" + fileName;
                logoLocPath = path + File.separator + fileName;
            } else {
                request.setAttribute("fileUploadError", "上传文件格式不正确");
                return "redirect:updlist?id="+version.getAppId();
            }

        }
        DevUser devUser=(DevUser) session.getAttribute("user");

        version.setModifyDate(new Date());
        version.setDownloadLink(logoLocPath);
        version.setApkLocPath(picPath);
        version.setApkFileName(fileName);
        version.setModifyBy(devUser.getId());


        if (versionService.updateVersion(version)>0){
            return "redirect:../app/list";
        }else{
            return "redirect:updlist?id="+version.getId()+"&vid="+version.getAppId();
        }

    }
}
