package com.lagou.edu.controller;

import com.lagou.edu.pojo.Resume;
import com.lagou.edu.pojo.User;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/resume")
public class ResumeController {


    @Autowired
    private ResumeService resumeService;

    @RequestMapping("queryAll")
    public ModelAndView queryAll() throws Exception {
        List<Resume> resumes = resumeService.queryResumeList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("resumes",resumes);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("queryById")
    public ModelAndView queryById(Long id) throws Exception {
        Resume resume = resumeService.queryById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("resume",resume);
        modelAndView.setViewName("resumeInfo");
        return modelAndView;
    }

    @RequestMapping("toSave")
    public String toSave(Long id) throws Exception {
        return "resumeInfo";
    }

    @RequestMapping("save")
    public String save( String id, String name, String address, String phone) throws Exception {
        Resume resume = new Resume();
        if (!StringUtils.isEmpty(id)) {
            resume.setId(Long.parseLong(id));
        }
        resume.setName(name);
        resume.setAddress(address);
        resume.setPhone(phone);
        resumeService.save(resume);
        return "redirect: /resume/queryAll";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam Long id) throws Exception {
        resumeService.deleteById(id);
        return "redirect: /resume/queryAll";
    }

}
