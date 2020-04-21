package app;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.DAO.AppDAOImpl;
import app.config.AppConfig;
import app.model.User;

@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView homepage() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<User> users = new ArrayList<>();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);
		users = DAO.listUsers();
		System.out.println(users);
		modelAndView.addObject("users", users);
		context.close();
		return modelAndView;
	}

	@RequestMapping("/addUser")
	public String addUser(Model model, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "addUser";
		} else {
			if (user.getName() != null && user.getEmail() != null) {
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

				AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);
				DAO.addUser(user);
				context.close();
				return "forward:/";
			} else {
				System.out.println("loading form");
				return "addUser";
			}
		}

	}

	
//@ExceptionHandler(Exception.class)
//public ModelAndView handleError(Exception ex) {
//   ModelAndView mv = new ModelAndView();
//   mv.setViewName("error");
//  return mv;
//}

//	@GetMapping("/userFormView")
//	public ModelAndView insertUser() {
//		ModelAndView modelAndView = new ModelAndView("userFormView");
//		User user = new User();
//		modelAndView.addObject("user", user);
//		return modelAndView;
//
//	}
//
//	@PostMapping("/displayUserInfo")
//	public ModelAndView displayUserInfo(@ModelAttribute("user") @Valid User user, BindingResult result) {
//		ModelAndView modelAndView = new ModelAndView("displayUserInfo");
//		modelAndView.addObject("user", user);
//		if (result.hasErrors()) {
//			ModelAndView repopulatingFormView = new ModelAndView("userFormView", "user", "user");
//			repopulatingFormView.addObject("user", user);
//			System.out.println("Has errors!!");
//			return repopulatingFormView;
//		} else {
//			System.out.println("all good!");
//			return modelAndView;
//		}
//	}

}
