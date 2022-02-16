package com.zanchenko.wind.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // класс что отвечает за обработку всех переходов на сайте
public class MainController {
    // каждая функция обрабатывает свою url address

    // обработка главной странички
    // link in browser
    @GetMapping("/") //   / - это главная страничка, при переходе на главную страничку будет вызыватьcя эта функция
    public String home(Model model) { // обязательный параметр
        // передаем данные в шаблону
        model.addAttribute("title", "Главная страница"); // передаем параметр по названию "title" со значение Главная страница
        // вызываем шаблон по названию
        return "home"; // вызов шаблона home
        // page which is returned
    }

//    @GetMapping("/windInfo")
//    public String windInfo(Model model) {
//        model.addAttribute("windInfo", "Информация про втер"); // передаем по имени винд инфо  массив записей
//        return "windInfo";
//    }
}