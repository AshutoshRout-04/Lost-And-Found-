package com.lostnfound.lost_and_found_v1.item.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lostnfound.lost_and_found_v1.item.entity.ItemPost;
import com.lostnfound.lost_and_found_v1.item.repository.ItemPostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemPostRepository itemPostRepository;

    @Override
    public ItemPost createItemPost(ItemPost itemPost) {
        return itemPostRepository.save(itemPost);
    }

    @Override
    public ItemPost getItemPostById(Long id) {
        return itemPostRepository.findById(id).orElse(null);
    }

    @Override
    public List<ItemPost> getAllItemPosts() {
        return itemPostRepository.findAll();
    }

    @Override
    public ItemPost updateItemPost(ItemPost itemPost,Long id){
        ItemPost existingItemPost = itemPostRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Item post not found"));

        existingItemPost.setItemType(itemPost.getItemType());
        existingItemPost.setItemName(itemPost.getItemName());
        existingItemPost.setDescription(itemPost.getDescription());
        existingItemPost.setCategory(itemPost.getCategory());
        existingItemPost.setLocation(itemPost.getLocation());
        existingItemPost.setDate(itemPost.getDate());
        existingItemPost.setImageUrl(itemPost.getImageUrl());
        existingItemPost.setItemStatus(itemPost.getItemStatus());

        return itemPostRepository.save(existingItemPost);
    }

    @Override
    public void deleteItemPost(Long id) {
        itemPostRepository.deleteById(id);
    }
}