package com.application.lms.serviceImpl;

import com.application.lms.entity.Author;
import com.application.lms.repo.AuthorRepo;
import com.application.lms.service.AuthorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepo authorRepo;
    
    @Override
    public List<Author> getAuthors(){
        return authorRepo.findAll();
    }
}
