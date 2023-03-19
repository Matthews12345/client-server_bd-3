package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; // аннотация
import org.springframework.data.repository.query.Param; // привязываем наши параметры к передаче данных из sql запроса
// to give a method parameter a concrete name and bind (закрепить) the name in the query
// to specify the name of the bind (привязать) parameter in the method definition
import org.springframework.stereotype.Controller; //  We specify a class with @Controller to indicate that
// they’re front controllers and responsible to handle user requests
// and return the appropriate response. It is mostly used with REST Web Services.
import org.springframework.ui.Model; // интерфейс, необходимый для взаимодействия контроллера и конфигуратора Model u Controller, а также для добавления всех элементов в веб-интерфейс
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView; // метод, позволяющий указывать названия html страниц, которые мы подвязываем контроллеру
@Controller
public class AppController {
    @Autowired
    private ClientService service;

    @RequestMapping("/") // сразу открывается главная страница. Позволяет нам сопоставлять HTTP-запросы с методами, которые мы хотели бы запустить.
    public String viewHomePage(Model model, @Param("keyword") String keyword) { // метод модели
        List<Client> listClients = service.listAll(keyword);
        model.addAttribute("listClients", listClients); // добавляем переменную, которую будем использовать в веб-интерфейсе
        model.addAttribute("keyword", keyword);
        return "index";
    }
    @RequestMapping("/new") // создаем контроллер по добавлению студента
    public String showNewPerformanceForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "new_client";
    }
    @GetMapping("/god") // is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
    public String showLogin(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "god";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST) // POST submits data to be processed to the identified resource.
    // requests a representation of the specified resource
    public String saveCar(@ModelAttribute("client") Client client) { // метод сохранения студентов
        service.save(client);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}") // контроллер для редактирования студентов по ключу
    public ModelAndView showEditClientForm(@PathVariable(name="id") Long id) { // Annotation which indicates that a method parameter should be bound (связано) to a URI template variable
        ModelAndView mav = new ModelAndView("edit_client");
        Client client = service.get(id);
        mav.addObject("Client", client);
        return mav; // возвращаем страницу с данными о студентах по id
    }
    @RequestMapping("/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}


