package com.demo.demo1.service;

import com.demo.demo1.dto.AuthorDto;
import com.demo.demo1.dto.BookDto;
import com.demo.demo1.exception.DataNotFoundException;
import com.demo.demo1.model.jooq.tables.pojos.Book;
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
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public BookDto findOne(UUID id) {
        Book book = verifyBookExistance(id);
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book, bookDto);
        bookDto.setPublishDate(book.getPublishDate().toString());
        return bookDto;
    }

    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(loadedBook -> {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(loadedBook, bookDto);
            bookDto.setPublishDate(loadedBook.getPublishDate().toString());
            return bookDto;
        }).collect(Collectors.toList());
    }

    public BookDto create(BookDto bookDto) {
        BookDto resultBookDto = new BookDto();
        bookDto.setId(null);
        Book savedBook = bookRepository.save(buildBook(bookDto));
        BeanUtils.copyProperties(savedBook, resultBookDto);
        resultBookDto.setPublishDate(savedBook.getPublishDate().toString());
        return resultBookDto;
    }

    public BookDto update(UUID id, BookDto bookDto) {
        verifyBookExistance(id);
        BookDto resultBookDto = new BookDto();
        bookDto.setId(id);
        Book savedBook = bookRepository.save(buildBook(bookDto));
        BeanUtils.copyProperties(savedBook, resultBookDto);
        resultBookDto.setPublishDate(savedBook.getPublishDate().toString());
        return resultBookDto;
    }

    public void delete(UUID id) throws DataNotFoundException {
        bookRepository.delete(verifyBookExistance(id));
    }

    public List<AuthorDto> findAuthorsByBook(UUID bookId) {
        verifyBookExistance(bookId);
        return authorRepository.findByBook(bookId).stream().map(loadedAuthor -> {
            AuthorDto authorDto = new AuthorDto();
            BeanUtils.copyProperties(loadedAuthor, authorDto);
            authorDto.setBirthDate(loadedAuthor.getBirthDate().toString());
            return authorDto;
        }).collect(Collectors.toList());
    }

    public void addAuthors(UUID bookId, List<UUID> authorIds) {
        verifyBookExistance(bookId);
        authorIds.forEach(authorId -> {
            bookRepository.addAuthor(bookId, authorId);
        });
    }

    public void removeAuthor(UUID bookId, UUID authorId) {
        verifyBookExistance(bookId);
        bookRepository.deleteAuthor(bookId, authorId);
    }

    private Book verifyBookExistance(UUID id) {
        Book book = bookRepository.findOne(id);
        if (book == null) {
            throw new DataNotFoundException("BOOK not found for ID: " + id);
        }
        return book;
    }

    private Book buildBook(BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        book.setPublishDate(Timestamp.valueOf(bookDto.getPublishDate()));
        return book;
    }

}
