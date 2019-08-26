package com.demo.demo1.controller;

import com.demo.demo1.dto.AuthorDto;
import com.demo.demo1.dto.BookDto;
import com.demo.demo1.dto.IdDto;
import com.demo.demo1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto getBook(@PathVariable UUID bookId) {
        return bookService.findOne(bookId);
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDto> getBooks() {
        return bookService.findAll();
    }

    @PostMapping(path = "/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addBook(@RequestBody BookDto bookDto) {
        BookDto savedBook = bookService.create(bookDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBook.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/books/{bookId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto updateBook(@PathVariable UUID bookId, @RequestBody BookDto bookDto) {
        return bookService.update(bookId, bookDto);
    }

    @DeleteMapping(path = "/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID bookId) {
        bookService.delete(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/books/{bookId}/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorDto> getAuthorsByBook(@PathVariable UUID bookId) {
        return bookService.findAuthorsByBook(bookId);
    }

    @PostMapping(path = "/books/{bookId}/authors", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addAuthors(@PathVariable UUID bookId, @RequestBody List<IdDto> authorIds) {
        bookService.addAuthors(bookId, authorIds.stream().map(authorId -> authorId.getId()).collect(Collectors.toList()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/books/{bookId}/authors/{authorId}")
    public ResponseEntity<Void> removeAuthor(@PathVariable UUID bookId, @PathVariable UUID authorId) {
        bookService.removeAuthor(bookId, authorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}