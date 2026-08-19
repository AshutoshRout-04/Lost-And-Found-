package com.lostnfound.lost_and_found_v1.item.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lostnfound.lost_and_found_v1.item.entity.ItemPost;
import com.lostnfound.lost_and_found_v1.item.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("item")
public class ItemPostController {

    private final ItemService itemService;

    @PostMapping("post")
    public ItemPost createPost(@RequestBody ItemPost itemPost){
        return itemService.createItemPost(itemPost);
    }

    @GetMapping("getAllPosts")
    public List<ItemPost> getAllPosts(){
        return itemService.getAllItemPosts();
    }

    @GetMapping("getPost/{id}")
    public ItemPost getPostById(@PathVariable Long id){
        return itemService.getItemPostById(id);
    }

    @PutMapping("update/{id}")
    public ItemPost updatePost(@PathVariable Long id, @RequestBody ItemPost itemPost){
        return itemService.updateItemPost(itemPost, id);
    }

    @DeleteMapping("delete/{id}")
    public String deletePost(Long id){
        itemService.deleteItemPost(id);
        return "Post Deleted Sucessfully";
    }
}
