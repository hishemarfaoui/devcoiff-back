package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Créneaux;
import com.example.devcoiff.Entities.Image;

import java.util.List;

public interface Iimage {
    public Image ajoutImage(Image image);
    public void modifierImage(Image image);
    public void supprimerImage(Integer id);
    public Image getImage(Integer id);
    public List<Image> getAllImages();
}
