package com.lagou.edu.service.impl;

import com.lagou.edu.mapper.ResumeDao;
import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;


    @Override
    public List<Resume> queryResumeList() throws Exception {
        return resumeDao.findAll();
    }

    @Override
    public Resume save(Resume resume) {
        return resumeDao.save(resume);
    }

    @Override
    public void deleteById(Long id) {
        resumeDao.deleteById(id);
    }

    @Override
    public Resume queryById(Long id) {
        return resumeDao.findById(id).orElse(null);
    }
}
