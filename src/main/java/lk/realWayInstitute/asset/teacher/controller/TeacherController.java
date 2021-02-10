package lk.realWayInstitute.asset.teacher.controller;
import lk.realWayInstitute.asset.batch.service.BatchService;
import lk.realWayInstitute.asset.commonAsset.model.Enum.Gender;
import lk.realWayInstitute.asset.course.service.CourseService;
import lk.realWayInstitute.asset.teacher.entity.Teacher;
import lk.realWayInstitute.asset.teacher.service.TeacherService;
import lk.realWayInstitute.util.interfaces.AbstractController;
import lk.realWayInstitute.util.service.MakeAutoGenerateNumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/teacher")
public class TeacherController implements AbstractController< Teacher, Integer> {
    private final TeacherService teacherService;
    private final CourseService courseService;
    private final BatchService batchService;
    private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;


    public TeacherController(TeacherService teacherService, CourseService courseService, BatchService batchService, MakeAutoGenerateNumberService makeAutoGenerateNumberService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
        this.batchService = batchService;
        this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teacher/teacher";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("gender", Gender.values());
        model.addAttribute("addStatus",true);
        model.addAttribute("batches",batchService.findAll());
        model.addAttribute("subjects", courseService.findAll());
        return "teacher/addTeacher";
    }

    @GetMapping("/view/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        model.addAttribute("teacherDetail", teacherService.findById(id));
        return "teacher/teacher-detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("teacher", teacherService.findById(id));
        model.addAttribute("gender", Gender.values());
        model.addAttribute("addStatus",false);
        model.addAttribute("batches",batchService.findAll());
        model.addAttribute("subjects", courseService.findAll());
        return "teacher/addTeacher";
    }

    @PostMapping("/save")
    public String persist(@Valid @ModelAttribute Teacher teacher, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("teacher", teacher);
            model.addAttribute("gender", Gender.values());
            model.addAttribute("addStatus",true);
            model.addAttribute("batches",batchService.findAll());
            model.addAttribute("subjects", courseService.findAll());
            return "teacher/addTeacher";
        }

        //there are two different situation
        //1. new Teacher -> need to generate new number
        //2. update Teacher -> no required to generate number
        if ( teacher.getId() == null ) {

            // need to create auto generated registration number
            Teacher lastTeacher = teacherService.lastTeacherOnDB();
            //registration number format => ST200001
            if ( lastTeacher != null ) {
                String lastNumber = lastTeacher.getRegistrationId().substring(2);
                teacher.setRegistrationId("ST" + makeAutoGenerateNumberService.numberAutoGen(lastNumber));
            } else {
                teacher.setRegistrationId("ST" + makeAutoGenerateNumberService.numberAutoGen(null
            ));
            }

        }

//todo-> teacher registration number need make
        teacherService.persist(teacher);
        return "redirect:/teacher";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        teacherService.delete(id);
        return "redirect:/teacher";
    }
}
