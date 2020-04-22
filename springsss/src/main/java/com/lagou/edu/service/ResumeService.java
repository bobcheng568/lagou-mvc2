package com.lagou.edu.service;

import com.lagou.edu.pojo.Resume;

import java.util.List;

public interface ResumeService {
    List<Resume> queryResumeList() throws Exception;

    Resume save(Resume resume);

    void deleteById(Long id);

    Resume queryById(Long id);
}
