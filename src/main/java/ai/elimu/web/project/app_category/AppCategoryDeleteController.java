package ai.elimu.web.project.app_category;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ai.elimu.dao.AppCategoryDao;
import ai.elimu.model.project.AppCategory;

@Controller
@RequestMapping("/project/{projectId}/app-category/delete")
public class AppCategoryDeleteController {
	
private final Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    private AppCategoryDao appCategoryDao;
    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String handleRequest(Model model, @PathVariable Long projectId, @PathVariable Long id) {
        
		logger.info("handleRequest");
    	logger.info("projectId: " + projectId);
        
        AppCategory appCategory = appCategoryDao.read(id);
		appCategoryDao.delete(appCategory);

        appCategoryDao.delete(appCategory);
        return "redirect:/project/app-category/list";

    }
}
