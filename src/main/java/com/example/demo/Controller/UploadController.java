package com.example.demo.Controller;

import com.example.demo.Model.Stock;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
public class UploadController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload") 
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        if(file.isEmpty()) {
            model.addAtrribute("message","Select csv file");
            model.addAtrribute("status",false);
        } else {
            try(Reader reader = new BufferedReader(new InputStreamReader(file.getInuputStream()))){
                CsvToBean<Stock> csvToBean = new CsvToBeanBuilder(reader).withtype(Stock.class).withIgnoreLeadingWhieSpace(True).build();

                List<Stock> stocks = csvToBean.parse();

                model.addAttribute("stocks",stocks);
                model.addAttribute("status",true);

            } catch (Exception ex) {
                model.addAtrribute("message","Error");
                model.addAtrribute("status,false");
            }
        }

        return "file-status";

    }

}