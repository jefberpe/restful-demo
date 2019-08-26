package com.demo.demo1.controller;

import com.demo.demo1.dto.AuthorDto;
import com.demo.demo1.dto.BookDto;
import com.demo.demo1.dto.IdDto;
import com.demo.demo1.service.AuthorService;
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
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/authors/{authorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthorDto getAuthor(@PathVariable UUID authorId) {
        return authorService.findOne(authorId);
    }

    @GetMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorDto> getAuthors() {
        return authorService.findAll();
    }

    @PostMapping(path = "/authors", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto savedAuthorDto = authorService.create(authorDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAuthorDto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/authors/{authorId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthorDto updateAuthor(@PathVariable UUID authorId, @RequestBody AuthorDto authorDto) {
        return authorService.update(authorId, authorDto);
    }

    @DeleteMapping(path = "/authors/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable UUID authorId) {
        authorService.delete(authorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/authors/{authorId}/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDto> getBooksByAuthor(@PathVariable UUID authorId) {
        return authorService.findBooksByAuthor(authorId);
    }

    @PostMapping(path = "/authors/{authorId}/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBooks(@PathVariable UUID authorId, @RequestBody List<IdDto> bookIds) {
        authorService.addBooks(authorId, bookIds.stream().map(bookId -> bookId.getId()).collect(Collectors.toList()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/authors/{authorId}/books/{bookId}")
    public ResponseEntity<Void> removeBook(@PathVariable UUID authorId, @PathVariable UUID bookId) {
        authorService.removeBook(authorId, bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}