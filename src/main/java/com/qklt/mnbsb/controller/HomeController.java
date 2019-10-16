package com.qklt.mnbsb.controller;

import com.qklt.mnbsb.domain.User;
import com.qklt.mnbsb.service.HomeService;
import com.qklt.mnbsb.util.ServiceUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
//@SessionAttributes("user")
public class HomeController{

    private HomeService hs;

    @Autowired
    public HomeController(HomeService hs) {
        this.hs = hs;
    }

    // 修改信息
    @GetMapping(value = "/html/setting")
    public String setting(String sex, String age, HttpSession session) {

        //sex = new String (sex.getBytes("iso8859-1"),"UTF-8");
        //age = new String (age.getBytes("iso8859-1"),"UTF-8");

        User user = (User)session.getAttribute("user");
        user.setSex(sex);
        user.setAge(age);

        if(hs.updateInformation(user)) {
            return "redirect:/html/home";
        } else {
            System.out.println("error");
            return "redirect:/html/home";
        }

    }

    // 注销用户
    @GetMapping(value = "/html/logout")
    @ResponseBody
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }

    // 上传图片
    @PostMapping(value = "/html/uploadImg")
    @ResponseBody
    public void uploadImg(@RequestParam("imgToUpload")MultipartFile file, HttpSession session) {

        if (file.isEmpty()) {
            return;
        }

        // 文件存储目录
        String dir = "img";
        // 文件存储目录绝对路径(暂时使用自定义位置)
        String uploadPath = "C:\\Project\\IDProject\\mnbsb\\" +
                "src\\main\\resources\\static\\img\\";
                //req.getServletContext().getRealPath("/") + dir + "/";

        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // 防重名八位字符
        String randomStr = ServiceUtils.getRandomString(8);
        String fileName = randomStr + file.getOriginalFilename();

        File dest = new File(uploadPath + fileName);

        boolean isStore = false;
        try {
            file.transferTo(dest);
            isStore = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(isStore) {
            // 数据库变更头像
            User user = (User)session.getAttribute("user");
            String oldName = user.getPortrait();
            // 先删除旧头像
            if(hs.delOldPortrait(uploadPath + oldName, oldName)) {
                // 换新头像
                user = hs.uploadPortrait(user, fileName);
                session.setAttribute("user", user);
            }
        }


    }




}