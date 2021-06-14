package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;
import service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    ICustomerService customerService = new CustomerService();
    @GetMapping("/home")
    public ModelAndView showALl(){
        ModelAndView mav = new ModelAndView("/home");
        mav.addObject("list", customerService.findAll());
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView mav = new ModelAndView("/create");
        mav.addObject("c", new Customer());
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(Customer customer){
        customerService.save(customer);
        return showALl();
    }

    @GetMapping("/edit")
    public ModelAndView showFormEdit(){
        ModelAndView mav = new ModelAndView("/edit");
        mav.addObject("c", new Customer());
        return mav;
    }

    @PostMapping("/edit")
    public ModelAndView editCustomer(Customer customer){
        customerService.update(customer.getId(), customer);
        return showALl();
    }
    @GetMapping("/remove")
    public ModelAndView removeCustomer(int id){
        customerService.remove(id);
        return showALl();
    }
}
