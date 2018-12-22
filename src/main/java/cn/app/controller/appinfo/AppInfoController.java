package cn.app.controller.appinfo;

import cn.app.pojo.AppInfo;
import cn.app.pojo.Category;
import cn.app.pojo.DevUser;
import cn.app.pojo.Dictionary;
import cn.app.service.CategoryService.CategoryService;
import cn.app.service.Dictionary.DictionaryService;
import cn.app.service.appinfo.AppInfoService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("app")
public class AppInfoController {
    @Autowired
    private AppInfoService appInfoService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("list")
    public String page(String softwareName,String status,
                       String flatformId, String categoryLevel1,
                       String categoryLevel2,String categoryLevel3, String pageNo, HttpSession session, Model model) {
        session.getAttribute("user");
        if (pageNo == null) {
            pageNo = "1";
        }
        Integer pageSize = 3;
        Integer danqian = (Integer.parseInt(pageNo) - 1) * pageSize;
        if (flatformId==null){
            flatformId="0";
        }
        if (status==null){
            status="0";
        }
        if (categoryLevel1==null){
            categoryLevel1="0";
        }
        if (categoryLevel2==null){
            categoryLevel2="0";
        }
        if (categoryLevel3==null){
            categoryLevel3="0";
        }
        Integer flatformIds=Integer.parseInt(flatformId);
        Integer statuss=Integer.parseInt(status);
        Integer categoryLevel1s=Integer.parseInt(categoryLevel1);
        Integer categoryLevel2s=Integer.parseInt(categoryLevel2);
        Integer categoryLevel3s=Integer.parseInt(categoryLevel3);

        int count=appInfoService.getCount(softwareName,statuss,flatformIds,categoryLevel1s,categoryLevel2s,categoryLevel3s);


        int yeSize=count%pageSize==0?
                (count/pageSize):(count/pageSize)+1;
        session.setAttribute("appInfoList", appInfoService.findPageAll(softwareName,statuss,flatformIds,categoryLevel1s,categoryLevel2s,categoryLevel3s,danqian,pageSize));

        model.addAttribute("count",count);
        model.addAttribute("yeSize",yeSize);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("softwareName",softwareName);
        model.addAttribute("flatformIds",flatformIds);
        model.addAttribute("statuss",statuss);
        model.addAttribute("categoryLevel1s",categoryLevel1s);
        model.addAttribute("categoryLevel2s",categoryLevel2s);
        model.addAttribute("categoryLevel3s",categoryLevel3s);
        session.setAttribute("dictionaryList", dictionaryService.getAll()); //app状态
        session.setAttribute("dictionaryList2", dictionaryService.getfla()); //所属平台
        session.setAttribute("categoryList",categoryService.getById(flatformIds));//一级分类
        return "appInfoList";
    }

    @RequestMapping(value="categorylevellist",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object categorylevellist(String id){
        List<Category> list=categoryService.getById(Integer.parseInt(id));
        String js= JSON.toJSONString(list);
        return js;
    }
    @RequestMapping(value="datadictionarylist",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object datadictionarylist(String id){
        List<Dictionary> list=dictionaryService.getfla();
        String js= JSON.toJSONString(list);
        return js;
    }


    @RequestMapping(value = "add")
    public String add( AppInfo appInfo){

        return "appInfoAdd";
    }

    @RequestMapping(value = "addApp",method = RequestMethod.POST)
    public String addAppInfo(AppInfo appInfo, HttpSession session, HttpServletRequest request,@RequestParam(value="a_logoPicPath",required = false) MultipartFile at){
        String picPath=null;
            String logoLocPath=null;
        if(!at.isEmpty()){
            String path=request.getSession().getServletContext().getRealPath("statics"+ File.separator+"images");
            String fileName=at.getOriginalFilename();//原文件名
            String prefix= FilenameUtils.getExtension(fileName);//原文件后缀名
            int filesize=500000;
            if (at.getSize()>filesize){
                request.setAttribute("fileUploadError","*上传的文件大小不能大于500KB");
                return "";
            }else if(prefix.equalsIgnoreCase("jpg")||prefix.equalsIgnoreCase("png")||prefix.equalsIgnoreCase("jpeg")||prefix.equalsIgnoreCase("pneg")){
                File targetFile=new File(path,fileName);
                if (!targetFile.exists()){
                    targetFile.mkdirs();
                }
                try {
                    at.transferTo(targetFile);
                }catch (Exception e){
                    e.printStackTrace();
                    request.setAttribute("fileUploadError","上传失败");
                    return "redirect:add";
                }
                picPath = request.getContextPath()+"/statics/uploadfiles/"+fileName;
                logoLocPath=path+File.separator+fileName;
            }else{
                request.setAttribute("fileUploadError","上传图片格式不正确");
                return "redirect:add";
            }

        }else{
            request.setAttribute("fileUploadError","必须上传文件 ");
            return "redirect:add";
        }
        DevUser devUser=(DevUser) session.getAttribute("user");
        appInfo.setDevId(devUser.getId());
        appInfo.setCreatedBy(devUser.getId());
        appInfo.setCreationDate(new Date());
        appInfo.setLogoPicPath(picPath);
        appInfo.setLogoLocPath(logoLocPath);
        appInfo.setStatus(1);
        appInfoService.add(appInfo);
        return "redirect:list";
    }

    @RequestMapping("apk")
    @ResponseBody
    public Object apk(String APKName){
        Map<String,String> map=new HashMap<String, String>();
        if(StringUtils.isNullOrEmpty(APKName)){
             map.put("APKName","empty");
        }else{
            AppInfo appInfo=appInfoService.getByAPKName(APKName);
            if (appInfo==null){
                map.put("APKName","noexist");
            }else{
                map.put("APKName","exist");
            }
        }
        return JSONArray.toJSONString(map);
    }

    @RequestMapping("upd")
    public String upd(String id,Model model){
        model.addAttribute("appInfo",appInfoService.getById(Integer.parseInt(id)));
        return "appInfoUpd";
    }

}
