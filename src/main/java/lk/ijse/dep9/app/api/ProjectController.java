package lk.ijse.dep9.app.api;

import lk.ijse.dep9.app.dto.ProjectDTO;
import lk.ijse.dep9.app.service.custom.ProjectTaskService;
import lk.ijse.dep9.app.util.ValidationGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/projects")
@RestController
@CrossOrigin
public class ProjectController {



    private final ProjectTaskService projectTaskService;


    @Autowired
    public ProjectController(ProjectTaskService projectTaskService) {
        this.projectTaskService = projectTaskService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    private ProjectDTO createNewProject(@Validated(ValidationGroups.Create.class) ProjectDTO projectDTO, @RequestAttribute String username){
        projectDTO.setUsername(username);
        return ProjectTaskService.createNewProject(projectDTO);
    }

    @GetMapping(produces = "application/json")
    private List<ProjectDTO> getAllProjects(@RequestAttribute String username){
        return ProjectTaskService.getAllProjects(username);
    }

    @GetMapping(value = "/{application:\\d+}",produces = "application/json")
    private ProjectDTO getProject(@PathVariable int projectId, @RequestAttribute String username, @PathVariable String application){
        return projectTaskService.getProjectDetails(username,projectId);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{application:\\d+}", consumes = "application/json")
    private void renameProject(@PathVariable int projectId, @RequestBody ProjectDTO projectDTO , @RequestAttribute String username ){
        projectTaskService.renameProject(projectDTO);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{projectId:\\d+}")
    private void deleteProject(@PathVariable int projectId, @RequestAttribute String username){
        projectTaskService.deleteProject(username,projectId);
    }


}
