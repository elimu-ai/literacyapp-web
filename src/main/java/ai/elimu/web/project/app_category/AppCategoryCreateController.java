package ai.elimu.web.project.app_category;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import ai.elimu.dao.project.AppCategoryDao;
import ai.elimu.dao.project.ProjectDao;
import ai.elimu.model.project.AppCategory;
import ai.elimu.model.project.Project;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/project/{projectId}/app-category/create")
public class AppCategoryCreateController {
    
    private final Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    private ProjectDao projectDao;
    
    @Autowired
    private AppCategoryDao appCategoryDao;

    @RequestMapping(method = RequestMethod.GET)
    public String handleRequest(@PathVariable Long projectId, Model model, HttpSession session) {
    	logger.info("handleRequest");
        
        // Needed by breadcrumbs
        Project project = projectDao.read(projectId);
        model.addAttribute("project", project);
        
        AppCategory appCategory = new AppCategory();
        appCategory.setProject(project);
        model.addAttribute("appCategory", appCategory);

        return "project/app-category/create";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String handleSubmit(
            HttpSession session,
            @PathVariable Long projectId,
            @Valid AppCategory appCategory,
            BindingResult result,
            Model model) {
    	logger.info("handleSubmit");
        
        // Disallow app categories with identical name
        Project project = projectDao.read(projectId);
        List<AppCategory> existingAppCategories = project.getAppCategories();
        for (AppCategory existingAppCategory : existingAppCategories) {
            if (existingAppCategory.getName().equals(appCategory.getName())) {
                result.rejectValue("name", "NonUnique");
                break;
            }
        }
        
        if (result.hasErrors()) {
            model.addAttribute("project", project);
            model.addAttribute("appCategory", appCategory);
            return "project/app-category/create";
        } else {
            appCategoryDao.create(appCategory);
            project.getAppCategories().add(appCategory);
            projectDao.update(project);
            
            return "redirect:/project/" + project.getId() + "/app-category/list#" + appCategory.getId();
        }
    }
}