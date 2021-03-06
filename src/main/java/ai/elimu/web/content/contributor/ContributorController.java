package ai.elimu.web.content.contributor;

import ai.elimu.dao.AudioContributionEventDao;
import ai.elimu.dao.ContributorDao;
import ai.elimu.dao.NumberContributionEventDao;
import ai.elimu.dao.StoryBookContributionEventDao;
import ai.elimu.dao.StoryBookPeerReviewEventDao;
import ai.elimu.dao.WordContributionEventDao;
import ai.elimu.model.contributor.Contributor;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/content/contributor/{contributorId}")
public class ContributorController {
    
    private final Logger logger = LogManager.getLogger();
    
    @Autowired
    private ContributorDao contributorDao;
    
    @Autowired
    private StoryBookContributionEventDao storyBookContributionEventDao;
    
    @Autowired
    private StoryBookPeerReviewEventDao storyBookPeerReviewEventDao;
    
    @Autowired
    private AudioContributionEventDao audioContributionEventDao;
    
    @Autowired
    private WordContributionEventDao wordContributionEventDao;
    
    @Autowired
    private NumberContributionEventDao numberContributionEventDao;

    @RequestMapping(method = RequestMethod.GET)
    public String handleRequest(
            @PathVariable Long contributorId,
            Model model
    ) {
    	logger.info("handleRequest");

        return "redirect:/content/contributor/" + contributorId + "/storybooks";
    }
    
    @RequestMapping(value = "/storybooks", method = RequestMethod.GET)
    public String handleStoryBooksRequest(
            @PathVariable Long contributorId,
            Model model
    ) {
    	logger.info("handleStoryBooksRequest");
        
        Contributor contributor = contributorDao.read(contributorId);
        model.addAttribute("contributor2", contributor);
        
        // For contributor-summarized.jsp
        model.addAttribute("storyBookContributionsCount", storyBookContributionEventDao.readCount(contributor));
        model.addAttribute("storyBookPeerReviewsCount", storyBookPeerReviewEventDao.readCount(contributor));
        model.addAttribute("audioContributionsCount", audioContributionEventDao.readCount(contributor));
        model.addAttribute("wordContributionsCount", wordContributionEventDao.readCount(contributor));
        model.addAttribute("numberContributionsCount", numberContributionEventDao.readCount(contributor));
        
        // For contributor-storybooks.jsp
        model.addAttribute("storyBookContributionEvents", storyBookContributionEventDao.readAll(contributor));
        model.addAttribute("storyBookPeerReviewEvents", storyBookPeerReviewEventDao.readAll(contributor));
        
        return "content/contributor/contributor-storybooks";
    }
}
