package lk.ijse.dep9.app.service.custom.impl;

import lk.ijse.dep9.app.dto.ProjectDTO;
import lk.ijse.dep9.app.service.custom.ProjectTaskService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class ProjectTaskServiceImpl implements ProjectTaskService {
    @Override
    public ProjectDTO getProjectDetails(String username, int projectId) {
        return null;
    }

    @Override
    public void renameProject(ProjectDTO projectDTO) {

    }

    @Override
    public void deleteProject(String username, int projectId) {

    }
}
