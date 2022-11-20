package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Image;
import com.example.devcoiff.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements  Iimage{
    @Autowired
    ImageRepository imageRepository;
    @Override
    public Image ajoutImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void modifierImage(Image image) {
        imageRepository.save(image);

    }

    @Override
    public void supprimerImage(Integer id) {
        imageRepository.deleteById(id);

    }

    @Override
    public Image getImage(Integer id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
}
