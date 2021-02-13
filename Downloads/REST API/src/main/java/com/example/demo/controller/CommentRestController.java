package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.service.inter.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CommentRestController
{
    @Autowired
    ICommentService commentService;

    @GetMapping("/comments")
    public List<Comment> findAll()
    {
        return commentService.findAll();
    }

    @GetMapping("/comments/{id}")
    public Comment findById(@PathVariable Long id)
    {
        return commentService.findById(id);
    }

    @PostMapping("/comments/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment newComment(@RequestBody Comment comment)
    {
        return commentService.save(comment);
    }

    @PutMapping("/comments/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "comment updated successfully")
    public Comment editComment(@RequestBody Comment comment)
    {
        return commentService.save(comment);
    }

    @DeleteMapping("/comments/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "comment deleted successfully")
    public void deleteComment(@RequestBody Comment comment)
    {
        commentService.delete(comment);
    }
}
