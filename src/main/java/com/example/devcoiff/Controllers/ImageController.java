package com.example.devcoiff.Controllers;

import com.example.devcoiff.Entities.Date_de_travail;
import com.example.devcoiff.Entities.Image;
import com.example.devcoiff.Services.Iimage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/images")
public class ImageController {
  @Autowired
    Iimage iimage;
    @PostMapping("/add")
    @ResponseBody
    public Image add_New_Image(@RequestBody Image image) {
        iimage.ajoutImage(image);
        return image ;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Image> all_Image(){
        return iimage.getAllImages();
    }

    @GetMapping("/id/{id}")
    @ResponseBody
    public Image GetImage(@PathVariable("id") Integer id){
        return  iimage.getImage(id);
    }
    @PutMapping("/update")
    @ResponseBody
    public String Mise_A_jours_image(@RequestBody Image image){iimage.modifierImage(image);
        return "updated";}

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String supp_image(@PathVariable("id") Integer id){iimage.supprimerImage(id);
        return "removed";}


}
