package com.demo.demo1.service;

import com.demo.demo1.dto.AuthorDto;
import com.demo.demo1.dto.BookDto;
import com.demo.demo1.exception.DataNotFoundException;
import com.demo.demo1.model.jooq.tables.pojos.Author;
import com.demo.demo1.repository.AuthorRepository;
import com.demo.demo1.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;


    public AuthorDto findOne(UUID id) {
        Author author = verifyAuthorExistance(id);
        AuthorDto authorDto = new AuthorDto();
        BeanUtils.copyProperties(author, authorDto);
        authorDto.setBirthDate(author.getBirthDate().toString());
        return authorDto;
    }

    public List<AuthorDto> findAll() {
        return authorRepository.findAll().stream().map(loadedAuthor -> {
            AuthorDto authorDto = new AuthorDto();
            BeanUtils.copyProperties(loadedAuthor, authorDto);
            authorDto.setBirthDate(loadedAuthor.getBirthDate().toString());
            return authorDto;
        }).collect(Collectors.toList());
    }

    public AuthorDto create(AuthorDto authorDto) {
        AuthorDto resultAuthorDto = new AuthorDto();
        authorDto.setId(null);
        Author savedAuthor = authorRepository.save(buildAuthor(authorDto));
        BeanUtils.copyProperties(savedAuthor, resultAuthorDto);
        resultAuthorDto.setBirthDate(savedAuthor.getBirthDate().toString());
        return resultAuthorDto;
    }

    public AuthorDto update(UUID id, AuthorDto authorDto) {
        verifyAuthorExistance(id);
        AuthorDto resultAuthorDto = new AuthorDto();
        authorDto.setId(id);
        Author savedAuthor = authorRepository.save(buildAuthor(authorDto));
        BeanUtils.copyProperties(savedAuthor, resultAuthorDto);
        resultAuthorDto.setBirthDate(savedAuthor.getBirthDate().toString());
        return resultAuthorDto;
    }

    public void delete(UUID id) throws DataNotFoundException {
        authorRepository.delete(verifyAuthorExistance(id));
    }

    public List<BookDto> findBooksByAuthor(UUID authorId) {
        verifyAuthorExistance(authorId);
        return bookRepository.findByAuthor(authorId).stream().map(loadedBook -> {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(loadedBook, bookDto);
            bookDto.setPublishDate(loadedBook.getPublishDate().toString());
            return bookDto;
        }).collect(Collectors.toList());
    }

    public void addBooks(UUID authorId, List<UUID> bookIds) {
        verifyAuthorExistance(authorId);
        bookIds.forEach(bookId -> {
            authorRepository.addBook(authorId, bookId);
        });
    }

    public void removeBook(UUID authorId, UUID bookId) {
        verifyAuthorExistance(authorId);
        authorRepository.deleteBook(authorId, bookId);
    }

    private Author verifyAuthorExistance(UUID id) {
        Author author = authorRepository.findOne(id);
        if (author == null) {
            throw new DataNotFoundException("AUTHOR not found for ID: " + id);
        }
        return author;
    }

    private Author buildAuthor(AuthorDto authorDto) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDto, author);
        author.setBirthDate(Timestamp.valueOf(authorDto.getBirthDate()));
        return author;
    }

}
