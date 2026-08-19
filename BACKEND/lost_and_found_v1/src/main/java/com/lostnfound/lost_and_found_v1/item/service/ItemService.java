package com.lostnfound.lost_and_found_v1.item.service;

import java.util.List;

import com.lostnfound.lost_and_found_v1.item.entity.ItemPost;

public interface ItemService {

    public ItemPost createItemPost(ItemPost itemPost);
    public ItemPost getItemPostById(Long id);
    public List<ItemPost> getAllItemPosts();
    public ItemPost updateItemPost(ItemPost itemPost,Long id);
    public void deleteItemPost(Long id);

}
