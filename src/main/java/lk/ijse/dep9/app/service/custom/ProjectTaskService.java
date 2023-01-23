package lk.ijse.dep9.app.service.custom;

import lk.ijse.dep9.app.dto.ProjectDTO;
import lk.ijse.dep9.app.service.SuperService;

import java.util.List;

public interface ProjectTaskService extends SuperService {
    static ProjectDTO createNewProject(ProjectDTO projectDTO) {
        return null;
    }

    static List<ProjectDTO> getAllProjects(String username) {
        return null;
    }

    ProjectDTO getProjectDetails(String username, int projectId);

    void renameProject(ProjectDTO projectDTO);

    void deleteProject(String username, int projectId);
}
