package com.example.fashionshop.repository;

import com.example.fashionshop.model.commons.Image;
import com.example.fashionshop.service.ImageService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
