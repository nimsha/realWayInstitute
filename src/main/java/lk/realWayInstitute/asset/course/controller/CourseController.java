package lk.realWayInstitute.asset.course.controller;


import lk.realWayInstitute.asset.course.entity.Course;
import lk.realWayInstitute.asset.course.service.CourseService;
import lk.realWayInstitute.util.interfaces.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/course")
public class CourseController implements AbstractController<Course, Integer> {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "course/course";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("course", new Course());

        model.addAttribute("addStatus",true);
        return "course/addcourse";
    }

    @GetMapping("/view/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        model.addAttribute("courseDetail", courseService.findById(id));
        return "course/course-detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("course", courseService.findById(id));

        model.addAttribute("addStatus",false);
        return "course/addcourse";
    }

    @PostMapping("/save")
    public String persist(@Valid @ModelAttribute Course course, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("course", course);

            model.addAttribute("addStatus",true);
            return "course/addcourse";
        }

        courseService.persist(course);
        return "redirect:/course";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        courseService.delete(id);
        return "redirect:/course";
    }
}
